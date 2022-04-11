// DO NOT TOUCH THIS FILE!
package edu.nyu.cs;

// import junit 4 testing framework
import org.junit.Test;
import org.junit.Rule;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.contrib.java.lang.system.SystemOutRule; // system rules lib - useful for capturing system output
// import static org.mockito.Mockito.*; // for mocking, stubbing, and spying

public class ArraysQuestionTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule();

    @Test
    public void testMaxFinder() {
        int[][] mockInputs = {
            {10, 5, 4145, 5, 249, 41},
            {30, 10, 20},
            {-24, 66, 52985, 4},
        };
        int[] expecteds = {
            4145,
            30,
            52985
        };
        for (int i=0; i<mockInputs.length; i++) {
            try {
                int[] mockInput = mockInputs[i];
                int expected = expecteds[i];
                int actual = ArraysQuestion.maxFinder(mockInput);
                boolean isSame = (expected == actual);
                if (!isSame) {
                    assertEquals(String.format("Expected the max value in %s to be %d.", Arrays.toString(mockInput), expected), String.format("The function returned %d as the max value.", actual));
                }
            }
            catch (Exception e) {
                assertEquals("Expected the program not to crash when finding the max value in an array.", "The program crashed.");
            }
        }
    }

    @Test
    public void testMain() {
        systemOutRule.enableLog(); // start capturing System.out
        String[] args = {};
        try {
            ArraysQuestion.main(args);
            String actual = systemOutRule.getLogWithNormalizedLineSeparator().trim();
            Pattern p = Pattern.compile("The maximum value in \\[(.*)\\] is ([0-9]+).*");
            Matcher m = p.matcher(actual);
            if (m.find()) {
                // the output matched the pattern
                String arrayString = m.group(1);
                String maxString = m.group(2);
            }
            else {
                assertEquals("Expected printed output of the main function to follow the example, 'The maximum value in [10, 5, 4145, 5, 249, 41] is 4145.' (displayed numbers are for example only)", String.format("Actual printed output of the main function was '%s' instead.", actual));
            }
        }
        catch (Exception e) {
            assertEquals("Expected the program not to crash.", "The program crashd in the main method."); // fail the test if any exception occurs
        }

    }

}
