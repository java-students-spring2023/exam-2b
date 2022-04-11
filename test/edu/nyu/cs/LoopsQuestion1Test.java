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

import org.junit.contrib.java.lang.system.SystemOutRule; // system rules lib - useful for capturing system output
// import static org.mockito.Mockito.*; // for mocking, stubbing, and spying
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

public class LoopsQuestion1Test {

    // @Rule
    // public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @ClassRule
    public static final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule();

    String[][] mockInputs = {
        {"5", "5", "5", "5", "5", "5", "5"},
        {"2", "2", "2", "2", "2", "2", "2"},
        {"1", "2", "3", "4", "5", "6", "7"},
    };
    int[] expecteds = {
        35,
        14,
        28
    };
        
    @Before
    public void setupLogging() {
        systemOutRule.enableLog(); // start capturing System.out
    }

    @Test
    public void testNumberOfLinesOutput() {
        for (int i=0; i<mockInputs.length; i++) {
            try {
                String[] mockInput = mockInputs[i];
                int expected = expecteds[i];
                systemInMock.provideLines(mockInput); // provide mock input
                systemOutRule.clearLog(); // clear any previous output
                LoopsQuestion1.studyManager(); // call the method we're testing
                String output = systemOutRule.getLogWithNormalizedLineSeparator().trim();

                // check that the output has the correct number of lines
                String[] lines = output.split("\n");
                boolean correctNumLines = (lines.length == 8);
                if (!correctNumLines) assertEquals("Expected 8 lines of output.", String.format("In fact, only %d lines of text were printed.", lines.length));
            }
            catch (Exception e) {
                assertEquals("Expected the program not to crash when running the studyManager method.", "The program crashed.");
            }
        }
    }

    @Test
    public void testEachDayWasOutput() {
        for (int i=0; i<mockInputs.length; i++) {
            try {
                String[] mockInput = mockInputs[i];
                int expected = expecteds[i];
                systemInMock.provideLines(mockInput); // provide mock input
                systemOutRule.clearLog(); // clear any previous output
                LoopsQuestion1.studyManager(); // call the method we're testing
                String output = systemOutRule.getLogWithNormalizedLineSeparator().trim().toLowerCase();

                // check that the user was asked to enter hours for each day
                boolean isMonday = (output.indexOf("on mon") >= 0);
                boolean isTuesday = (output.indexOf("on tues") >= 0);
                boolean isWednesday = (output.indexOf("on wed") >= 0);
                boolean isThursday = (output.indexOf("on thur") >= 0);
                boolean isFriday = (output.indexOf("on fri") >= 0);
                boolean isSaturday = (output.indexOf("on sat") >= 0);
                boolean isSunday = (output.indexOf("on sun") >= 0);
                if (!(isMonday && isTuesday && isWednesday && isThursday && isFriday && isSaturday && isSunday)) {
                    assertEquals("Expected the program to prompt the user to enter hours for each day of the week.", "In fact, the program did not prompt for some of the days of the week.");
                }
            }
            catch (Exception e) {
                assertEquals("Expected the program not to crash when running the studyManager method.", "The program crashed.");
            }
        }
    }
    
    @Test
    public void testForCorrectTotal() {
        for (int i=0; i<mockInputs.length; i++) {
            try {
                String[] mockInput = mockInputs[i];
                int expected = expecteds[i];
                systemInMock.provideLines(mockInput); // provide mock input
                systemOutRule.clearLog(); // clear any previous output
                LoopsQuestion1.studyManager(); // call the method we're testing
                String output = systemOutRule.getLogWithNormalizedLineSeparator().trim().toLowerCase();
                String[] lines = output.split("\n");
                // check the total
                String lastLine = lines[lines.length-1];
                boolean correctTotal = (lastLine.indexOf(Integer.toString(expected) + " hours") >= 0);
                if (!correctTotal) assertEquals(String.format("Expected the last printed line to contain the correct total, %d hours.", expected), String.format("In fact, the last line contained the text, '%s'", lastLine));
            }
            catch (Exception e) {
                assertEquals("Expected the program not to crash when running the studyManager method.", "The program crashed.");
            }
        }
    }
    
    @Test
    public void testMain() {
        // check that the main method results in the same printed output as the studyManager method, since it should simply call the studyManager method
        for (int i=0; i<mockInputs.length; i++) {
            try {
                String[] mockInput = mockInputs[i];
                int expected = expecteds[i];
                systemInMock.provideLines(mockInput); // provide mock input
                systemOutRule.clearLog(); // clear any previous output
                String[] args = {};
                LoopsQuestion1.main(args); // call the method we're testing
                String output = systemOutRule.getLogWithNormalizedLineSeparator().trim().toLowerCase();
                String[] lines = output.split("\n");

                // check the number of output lines
                boolean correctNumLines = (lines.length == 8);
                if (!correctNumLines) assertEquals("Expected the main method to call the studyManager method, which should have output 8 lines of text.", String.format("In fact, only %d lines of text were printed.", lines.length));

                // check the total
                String lastLine = lines[lines.length-1];
                boolean correctTotal = (lastLine.indexOf(Integer.toString(expected) + " hours") >= 0);
                if (!correctTotal) assertEquals(String.format("Expected the main method to call the studyManager method, which should have printed the last line with the correct total, %d hours.", expected), String.format("In fact, the last line contained the text, '%s'", lastLine));
            }
            catch (Exception e) {
                assertEquals("Expected the program not to crash when running the main method.", "The program crashed.");
            }
        }
    }

}
