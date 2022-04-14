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

public class Test_Book_Test {

    @ClassRule
    public static final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule();
    
    @Test 
    public void testDoesNotCrash() {
        try {
            // run the Book_Test main() method
            String[] args = {};
            Book_Test.main(args);

        }
        catch (Exception e) {
            assertEquals("Expected the main method of Book_Test.java not to crash.", "The program crashed.");
        }
    }

    @Test 
    public void testComparisonOutput() {
        systemOutRule.enableLog(); // start capturing System.out
        try {
            // run the Book_Test main() method
            String[] args = {};
            Book_Test.main(args);
            String output = systemOutRule.getLogWithNormalizedLineSeparator().trim();
            // check that either of the expected results are output
            boolean isSameBook = output.toLowerCase().contains("they are the same book");
            boolean isDifferentBook = output.toLowerCase().contains("they are different book");
            assertTrue("Expected to see 'They are the same book!' or 'They are different books!' to be output.", isSameBook || isDifferentBook);
            assertFalse("Expected to see either 'They are the same book!' or 'They are different books!' to be output, but not both!.", isSameBook && isDifferentBook);

        }
        catch (Exception e) {
            assertEquals("Expected the main method of Book_test.java not to crash.", "The program crashed.");
        }
    }

}
