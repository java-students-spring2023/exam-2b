// DO NOT TOUCH THIS FILE!
package edu.nyu.cs;

// import junit 4 testing framework
import org.junit.Test;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import static org.junit.Assert.*;
import org.junit.contrib.java.lang.system.SystemOutRule; // system rules lib - useful for capturing system output
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;
// import static org.mockito.Mockito.*;

import java.util.Arrays;

public class Test_Array_Test {

    @ClassRule
    public static final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule();
    
    @Test 
    public void testDoesNotCrash() {
        try {
            // run the Book_Test main() method
            String[] args = {};
            Array_Test.main(args);

        }
        catch (Exception e) {
            assertEquals("Expected the main method of Array_Test.java not to crash.", "The program crashed.");
        }
    }

    @Test 
    public void testDetectAudioBook() {
        systemOutRule.enableLog(); // start capturing System.out
        try {
            // run the Book_Test main() method
            String[] args = {};
            Array_Test.main(args);
            String output = systemOutRule.getLogWithNormalizedLineSeparator().trim();
            // check that one audiobook was found
            int occurrences = StringUtils.countMatches(output.toLowerCase(), "found an audiobook");
            assertTrue("Expected code to output 'Found an AudioBook!' once.", occurrences == 1);
        }
        catch (Exception e) {
            assertEquals("Expected the main method of Array_Test.java not to crash.", "The program crashed.");
        }
    }


}
