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

public class Test_AudioBook {

    @ClassRule
    public static final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule();

    AudioBook[] testBooks; // will hold test books

    // make an array of test books
    String[] mockTitles = {
        "Lying in a Hammock at William Duffy's Farm in Pine Island, Minnesota",
        "The Jumblies"
    };
    String[] mockAuthors = {
        "James Wright",
        "Edward Lear"
    };
    int[] mockYears = {
        1990,
        1910
    };
    String[][] mockChapters = {
        { "Over my head, I see the bronze butterfly,", "Asleep on the black trunk,", "Blowing like a leaf in green shadow.", "Down the ravine behind the empty house,", "The cowbells follow one another", "Into the distances of the afternoon.", "To my right,", "In a field of sunlight between two pines,", "The droppings of last year's horses", "Blaze up into golden stones.", "I lean back, as the evening darkens and comes on.", "A chicken hawk floats over, looking for home.", "I have wasted my life." },
        {"They went to sea in a Sieve, they did, In a Sieve they went to sea: In spite of all their friends could say, On a winter’s morn, on a stormy day, In a Sieve they went to sea! And when the Sieve turned round and round, And every one cried, ‘You’ll all be drowned!’ They called aloud, ‘Our Sieve ain’t big, But we don’t care a button! we don’t care a fig! In a Sieve we’ll go to sea!’ Far and few, far and few, Are the lands where the Jumblies live; Their heads are green, and their hands are blue, And they went to sea in a Sieve.", "They sailed away in a Sieve, they did, In a Sieve they sailed so fast, With only a beautiful pea-green veil Tied with a riband by way of a sail, To a small tobacco-pipe mast; And every one said, who saw them go, ‘O won’t they be soon upset, you know! For the sky is dark, and the voyage is long, And happen what may, it’s extremely wrong In a Sieve to sail so fast!’ Far and few, far and few, Are the lands where the Jumblies live; Their heads are green, and their hands are blue, And they went to sea in a Sieve.", "The water it soon came in, it did, The water it soon came in; So to keep them dry, they wrapped their feet In a pinky paper all folded neat, And they fastened it down with a pin. And they passed the night in a crockery-jar, And each of them said, ‘How wise we are! Though the sky be dark, and the voyage be long, Yet we never can think we were rash or wrong, While round in our Sieve we spin!’ Far and few, far and few, Are the lands where the Jumblies live; Their heads are green, and their hands are blue, And they went to sea in a Sieve.", "And all night long they sailed away; And when the sun went down, They whistled and warbled a moony song To the echoing sound of a coppery gong, In the shade of the mountains brown. ‘O Timballo! How happy we are, When we live in a sieve and a crockery-jar, And all night long in the moonlight pale, We sail away with a pea-green sail, In the shade of the mountains brown!’ Far and few, far and few, Are the lands where the Jumblies live; Their heads are green, and their hands are blue, And they went to sea in a Sieve.", "They sailed to the Western Sea, they did, To a land all covered with trees, And they bought an Owl, and a useful Cart, And a pound of Rice, and a Cranberry Tart, And a hive of silvery Bees. And they bought a Pig, and some green Jack-daws, And a lovely Monkey with lollipop paws, And forty bottles of Ring-Bo-Ree, And no end of Stilton Cheese. Far and few, far and few, Are the lands where the Jumblies live; Their heads are green, and their hands are blue, And they went to sea in a Sieve.", "And in twenty years they all came back, In twenty years or more, And every one said, ‘How tall they’ve grown!’ For they’ve been to the Lakes, and the Torrible Zone, And the hills of the Chankly Bore; And they drank their health, and gave them a feast Of dumplings made of beautiful yeast; And everyone said, ‘If we only live, We too will go to sea in a Sieve,— To the hills of the Chankly Bore!’ Far and few, far and few, Are the lands where the Jumblies live; Their heads are green, and their hands are blue, And they went to sea in a Sieve."}
    };

    @Before
    public void init() {
        // instantiate an array of test books before each test is run
        testBooks = new AudioBook[mockTitles.length];
        for (int i=0; i< mockTitles.length; i++) {
            testBooks[i] =  new AudioBook(mockAuthors[i], mockTitles[i], mockYears[i], mockChapters[i]);
        }
    }
    
    @Test 
    public void testConstructor1() {
        try {
            // loop through all books
            for (AudioBook book : testBooks) {
                assertNotNull("Book object should not be null", book);
            }
        }
        catch (Exception e) {
            assertEquals("Expected the program not to crash when constructing a Book object with arguments for all properties.", "The program crashed.");
        }
    }

    // INHERITANCE
    @Test 
    public void testInstanceOf() {
        try {
            // loop through all books
            for (AudioBook book : testBooks) {
                assertEquals("AudioBook should inherit from Book.", true, book instanceof Book);
            }
        }
        catch (Exception e) {
            assertEquals("Expected the program not to crash when checking the type of the AudioBook object.", "The program crashed.");
        }
    }

    @Test 
    public void testPlayAll() {
        systemOutRule.enableLog(); // start capturing System.out
        try {
            // loop through all books
            for (int i=0; i<testBooks.length; i++) {
                systemOutRule.clearLog(); // clean slate logging output for each book
                AudioBook book = testBooks[i];
                book.playAll(); // prints all chapters of this book
                String output = systemOutRule.getLogWithNormalizedLineSeparator().trim();
                for (int j=0; j<mockChapters[i].length; j++) {
                    String expectedChapter = mockChapters[i][j]; // get the current chapter from mock data
                    assertTrue(String.format("Output should include the chapter: '%s'.", expectedChapter), output.contains(expectedChapter.trim()));
                }
            }
        }
        catch (Exception e) {
            assertEquals("Expected the program not to crash when playAll() is run on an AudioBook.", "The program crashed.");
        }
    }

}
