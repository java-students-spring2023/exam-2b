// DO NOT TOUCH THIS FILE!
package edu.nyu.cs;

// import junit 4 testing framework
import org.junit.Test;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import static org.junit.Assert.*;
import org.junit.contrib.java.lang.system.SystemOutRule; // system rules lib - useful for capturing system output
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;
// import static org.mockito.Mockito.*;

import java.io.File;
import java.util.Arrays;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// import Java patches from Apache Commons
import org.apache.commons.lang3.StringUtils; 

import org.junit.contrib.java.lang.system.SystemOutRule; // system rules lib - useful for capturing system output
// import static org.mockito.Mockito.*; // for mocking, stubbing, and spying
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

public class ScannerQuestionTest {

    @ClassRule
    public static final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule();

    int currentYear = Calendar.getInstance().get(Calendar.YEAR); // the current year

    String[][] mockInputs = {
        { "Marina Abramovich,Serbia,1946", "Tomma Abts,Germany,1967", "Ai Weiwei,China,1957", "Ai Xuan,China,1947", "Allora & Calzadilla,Cuba,1971", "Will Alsop RA,England,1947" },
        { "Marina Abramovich,Serbia,2000", "Tomma Abts,Germany,2000", "Ai Weiwei,China,2000", "Ai Xuan,China,2000", "Allora & Calzadilla,Cuba,2000", "Will Alsop RA,England,2000" },
        { "Marina Abramovich,Serbia,1000", "Tomma Abts,Germany,0", "Ai Weiwei,China,450", "Ai Xuan,China,550", "Allora & Calzadilla,Cuba,200", "Will Alsop RA,England,800" },
    };
    int[][] expectedAges = {
        { 76, 55, 65, 75, 51, 75 },
        { currentYear - 2000, currentYear - 2000, currentYear - 2000, currentYear - 2000, currentYear - 2000, currentYear - 2000 },
        { currentYear - 1000, currentYear - 0, currentYear - 450, currentYear - 550, currentYear - 200, currentYear - 800 },
    };
    int[] expectedAverages = {
        66,
        22,
        1522
    };

    private static void getAllFiles(File curDir) {

        File[] filesList = curDir.listFiles();
        for(File f : filesList){
            if(f.isDirectory())
                System.out.println(f.getName() + "/");
                getAllFiles(f);
            if(f.isFile()){
                System.out.println(f.getName());
            }
        }

    }    
        
    @Before
    public void setupLogging() {
        systemOutRule.enableLog(); // start capturing System.out
    }

    @Test
    public void testGetAgesFromLines() {
        for (int i=0; i<mockInputs.length; i++) {
            String[] mockInput = mockInputs[i];
            int[] expected = expectedAges[i];
            try {
                int[] actual = ScannerQuestion.getAgesFromLines(mockInput);
                boolean isSame = Arrays.equals(expected, actual); // are the arrays the same values?
                if (!isSame) assertEquals(String.format("Expected the getAgesFromLines method to return '%s' when provided the array of lines, ", Arrays.toString(expected), Arrays.toString(mockInput)), String.format("In fact, the getAgesFromLines method returned %s.", Arrays.toString(actual)));
            }
            catch (Exception e) {
                assertEquals("Expected the program not to crash when running the getAgesFromLines method.", "The program crashed: " + e);
            }
        }
    }

    @Test
    public void testGetAverageAge() {
        for (int i=0; i<expectedAges.length; i++) {
            int[] mockAges = expectedAges[i];
            int expected = expectedAverages[i];
            try {
                int actual = ScannerQuestion.getAverageAge(mockAges);
                boolean isSame = (expected == actual); // are the average ages the same?
                if (!isSame) assertEquals(String.format("Expected the getAverageAge method to return '%d' when provided the array of ages, ", expected, Arrays.toString(mockAges)), String.format("In fact, the getAverageAge method returned %d.", actual));
            }
            catch (Exception e) {
                assertEquals("Expected the program not to crash when running the getAverageAge method.", "The program crashed: " + e);
            }
        }
    }

    // @Test
    // public void testGetLinesFromFile() {
    //     systemOutRule.clearLog(); // clear any previous output
    //     String filepath = System.getProperty("user.dir") + "/bin/data/artists.csv";
    //     // File curDir = new File(".");
    //     // getAllFiles(curDir);
    //     try {
    //         String[] actual = ScannerQuestion.getLinesFromFile(filepath);
    //         String[] expected = mockInputs[0];
    //         boolean isSame = (Arrays.equals(expected, actual));
    //         if (!isSame) assertEquals(String.format("Expected the getLinesFromFile method to return, '%s'.", Arrays.toString(expected)), String.format("In fact, the getLinesFromFile method returned the following: '%s'", Arrays.toString(actual)));
    //     }
    //     catch (Exception e) {
    //         assertEquals("Expected the program not to crash when running the getLinesFromFile method.", "The program crashed: " + e);
    //     }
    // }    

    // @Test
    // public void testMain() {
    //     systemOutRule.clearLog(); // clear any previous output
    //     try {
    //         String[] args = {};
    //         ScannerQuestion.main(args);
    //         String actual = systemOutRule.getLogWithNormalizedLineSeparator().trim().toLowerCase();
    //         String expected = "The average age of all %d artists in the file is %d.\n".trim().toLowerCase();
    //         boolean isSame = (actual.equals(expected));
    //         if (!isSame) assertEquals(String.format("Expected the main method to output the text, '%s'.", expected), String.format("In fact, the main method output the following text: '%s'", actual));
    //     }
    //     catch (Exception e) {
    //         assertEquals("Expected the program not to crash when running the main method.", "The program crashed: " + e);
    //     }
    // }    

}
