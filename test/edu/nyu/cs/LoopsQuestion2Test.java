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

public class LoopsQuestion2Test {

    @ClassRule
    public static final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule();

    String[] mockQuestions = {
        "What's the name of the game?",
        "Where in the world is that?!",
        "How on G-d's name did that happen?!",
    };
    String[] mockResponseOptions = {
        "cheetos",
        "carrots",
        "kale",
        "beef jerky"
    };
    String[][] mockResponses = {
        {"foo", "bar", "cheetos potatoes", "cheetos"},
        {"foo bar", "baz bum", "kale"},
        {"foo", "bar", "baz", "bum", "beetle", "bugle", "beef jerky"},
    };
    int[] expectedQuestionCount = {
        4,
        3,
        7
    };
        
    @Before
    public void setupLogging() {
        systemOutRule.enableLog(); // start capturing System.out
    }

    @Test
    public void testGetResponseReturnValue() {
        for (int i=0; i<mockQuestions.length; i++) {
            String mockQuestion = mockQuestions[i];
            String[] mockResponse = mockResponses[i];
            systemInMock.provideLines(mockResponse); // provide mock input
            systemOutRule.clearLog(); // clear any previous output
            try {
                String actual = LoopsQuestion2.getResponse(mockQuestion, mockResponseOptions);
                String expected = mockResponse[mockResponse.length - 1]; // the last response in the array is the one that we assume terminated the loop
                boolean isSame = (actual.equals(expected));
                if (!isSame) assertEquals(String.format("Expected the getResponse method to return '%s' after the user entered a series of responses like this: %s.", expected, Arrays.toString(mockResponse)), String.format("In fact, the getResponse method returned '%s'.", actual));
            }
            catch (Exception e) {
                assertEquals("Expected the program not to crash when running the getResponse method.", "The program crashed. " + e);
            }
        }
    }

    @Test
    public void testGetResponseIterations() {
        for (int i=0; i<mockQuestions.length; i++) {
            String mockQuestion = mockQuestions[i];
            String[] mockResponse = mockResponses[i];
            systemInMock.provideLines(mockResponse); // provide mock input
            systemOutRule.clearLog(); // clear any previous output
            try {
                String actual = LoopsQuestion2.getResponse(mockQuestion, mockResponseOptions);
                String output = systemOutRule.getLogWithNormalizedLineSeparator().trim().toLowerCase();
                int actualCount = StringUtils.countMatches(output, mockQuestion.trim().toLowerCase()); // how many times the question was printed
                int expectedCount = expectedQuestionCount[i]; // how many times we expect the question to have been asked
                boolean isSame = (actualCount == expectedCount);
                if (!isSame) assertEquals(String.format("Expected the question '%s' to have been printed %d times, given the following user responses: %s, assuming the acceptable responses were: %s.", mockQuestion, expectedCount, Arrays.toString(mockResponse), Arrays.toString(mockResponseOptions)), String.format("In fact, the question was asked %d times.", actualCount));
            }
            catch (Exception e) {
                assertEquals("Expected the program not to crash when running the getResponse method.", "The program crashed. " + e);
            }
        }
    }

    @Test
    public void testMainThankYouMessage() {
        for (int i=0; i<mockQuestions.length; i++) {
            String mockQuestion = mockQuestions[i];
            String[] mockResponse = mockResponses[i];
            systemInMock.provideLines(mockResponse); // provide mock input
            systemOutRule.clearLog(); // clear any previous output
            try {
                String[] args = {};
                LoopsQuestion2.main(args);
                String output = systemOutRule.getLogWithNormalizedLineSeparator().trim().toLowerCase();
                String expectedOutput = "Thank".toLowerCase(); // we expect a thank you message with at least the word thanks
                String[] lines = output.split("\n"); // the lines of printed output
                String lastLine = lines[lines.length - 1]; // the last line printed
                boolean isPresent = (lastLine.indexOf(expectedOutput) >= 0); // was the message we expect actually there
                if (!isPresent) assertEquals("Expected the main method to output a thank you message in the last line.", String.format("In fact, the main method had the following as the last line: '%s'", lastLine));
            }
            catch (Exception e) {
                assertEquals("Expected the program not to crash when running the getResponse method.", "The program crashed. " + e);
            }
        }
    }

    @Test
    public void testMainNumPrintedLines() {
        for (int i=0; i<mockQuestions.length; i++) {
            String mockQuestion = mockQuestions[i];
            String[] mockResponse = mockResponses[i];
            systemInMock.provideLines(mockResponse); // provide mock input
            systemOutRule.clearLog(); // clear any previous output
            try {
                String[] args = {};
                LoopsQuestion2.main(args);
                String output = systemOutRule.getLogWithNormalizedLineSeparator().trim().toLowerCase();
                String[] lines = output.split("\n");
                int actualNumLines = lines.length;
                int expectedNumLines = mockResponse.length + 1; // the number of responses plus the thank you message
                boolean isSame = (actualNumLines == expectedNumLines);
                if (!isSame) assertEquals(String.format("Expected the main method to output %d lines of text, given the user responses: %s, assuming %s are acceptable responses.", expectedNumLines, Arrays.toString(mockResponse), Arrays.toString(mockResponseOptions)), String.format("In fact, %d lines of text were output.", actualNumLines));
            }
            catch (Exception e) {
                assertEquals("Expected the program not to crash when running the getResponse method.", "The program crashed. " + e);
            }
        }
    }    
}
