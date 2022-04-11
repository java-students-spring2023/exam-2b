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

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// import Java patches from Apache Commons
import org.apache.commons.lang3.StringUtils; 

import org.junit.contrib.java.lang.system.SystemOutRule; // system rules lib - useful for capturing system output
// import static org.mockito.Mockito.*; // for mocking, stubbing, and spying
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

public class MethodsQuestionTest {

    @ClassRule
    public static final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule();

    String[][] mockInputs = {
        {"66", "156"},
        {"88", "120"},
        {"74", "190"},
        {"74", "240"}
    };
    String[] expecteds = {
        "overweight",
        "underweight",
        "normal weight",
        "obese"
    };
        
    @Before
    public void setupLogging() {
        systemOutRule.enableLog(); // start capturing System.out
    }

    @Test
    public void testBmiCalc() {
        for (int i=0; i<mockInputs.length; i++) {
            String[] mockInput = mockInputs[i];
            String expected = expecteds[i];
            systemInMock.provideLines(mockInput); // provide mock input
            systemOutRule.clearLog(); // clear any previous output
            try {
                int height = Integer.parseInt(mockInput[0]);
                int weight = Integer.parseInt(mockInput[1]);
                String actual = MethodsQuestion.bmiCalc(height, weight);
                String output = systemOutRule.getLogWithNormalizedLineSeparator().trim().toLowerCase();
                boolean isSame = (expected == actual);
                if (!isSame) assertEquals(String.format("Expected the bmiCalc method to return '%s' when provided height=%d and weight=%d", expected, height, weight), String.format("In fact, the bmiCalc method returned %s.", actual));
            }
            catch (Exception e) {
                assertEquals("Expected the program not to crash when running the bmiCalc method.", "The program crashed: " + e);
            }
        }
    }

    @Test
    public void testMainOutputFormat() {
        for (int i=0; i<mockInputs.length; i++) {
            String[] mockInput = mockInputs[i];
            String expected = expecteds[i];
            systemInMock.provideLines(mockInput); // provide mock input
            systemOutRule.clearLog(); // clear any previous output
            try {
                int height = Integer.parseInt(mockInput[0]);
                int weight = Integer.parseInt(mockInput[1]);
                String[] args = {};
                MethodsQuestion.main(args);
                String output = systemOutRule.getLogWithNormalizedLineSeparator().trim();
                String[] lines = output.split("\n");
                String lastLine = lines[lines.length-1];
                String expectedLastLine = String.format("The CDC thinks you are %s!", expected);
                // loop through all possible outcomes, including those we don't expect
                for (String possibleOutcome : expecteds) {
                    if (possibleOutcome.equals(expected)) {
                        // check for the positive presence of the outcome we expecrted
                        boolean isContains = (lastLine.indexOf(expected) >= 0);           
                        if (!isContains) assertEquals(String.format("Expected the main method to print a final line, '%s', when provided height=%d and weight=%d", expectedLastLine, height, weight), String.format("In fact, the main method printed a final line, '%s'", lastLine));
                    }
                    else {
                        // check for lack of the outcomes we don't expect
                        boolean isContains = (lastLine.indexOf(possibleOutcome) >= 0);           
                        if (isContains) assertEquals(String.format("Did not expect the main method to print a final line containing, '%s', when provided height=%d and weight=%d", possibleOutcome, height, weight), String.format("In fact, the main method printed a final line, '%s'", lastLine));
                    }
                }
            }
            catch (Exception e) {
                assertEquals("Expected the program not to crash when running the main method.", "The program crashed: " + e);
            }
        }
    }    
}
