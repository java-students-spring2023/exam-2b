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

public class StringsQuestionTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule();

    @Test
    public void testCountMacaroni() {
        String[] mockInputs = {
            "macaroni foo bar Macaronimacaroni macaROnibomb",
            "macaroni blacaroni ther Macaroni fa ther father macAronifather blathermacaroni",
            "foo bar baz macaron bar foo bar oni focaroni",
            "macaroni, foo macaroni\nmacaroni foo"
        };
        int[] expecteds = {
            4,
            4,
            0,
            3
        };
        for (int i=0; i<mockInputs.length; i++) {
            try {
                String mockInput = mockInputs[i];
                int expected = expecteds[i];
                int actual = StringsQuestion.countMacaroni(mockInput);
                boolean isSame = (expected == actual);
                if (!isSame) {
                    assertEquals(String.format("Expected to find %d case-insensitive 'macaroni' occurrences in '%s'.", expected, mockInput), String.format("The function returned %d occurrences of 'macaroni' instead.", actual));
                }
            }
            catch (Exception e) {
                assertEquals("Expected the program not to crash when trying to find 'macaroni'!", "The program crashed: " + e);
            }
        }
    }

    @Test
    public void testMain() {
        systemOutRule.enableLog(); // start capturing System.out
        String[] args = {};
        try {
            StringsQuestion.main(args);
            String actual = systemOutRule.getLogWithNormalizedLineSeparator().trim();
            Pattern p = Pattern.compile("Found '(.*)' ([0-9]+) times!");
            Matcher m = p.matcher(actual);
            if (m.find()) {
                // the output matched the pattern
                // String searchTerm = m.group(1); // should be 'macaroni'
                // String number = m.group(2); // should be 4
            }
            else {
                assertEquals("Expected the main method to print output in the format, 'Found 'macaroni' 4 times!'", String.format("The main method output '%s' instead.", actual));
            }
        }
        catch (Exception e) {
            assertEquals("Expected the program not to crash.", "The program crashed in the main method: " + e); // fail the test if any exception occurs
        }

    }

}
