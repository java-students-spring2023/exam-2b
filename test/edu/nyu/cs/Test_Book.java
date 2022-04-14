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

public class Test_Book {

    @ClassRule
    public static final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule();

    Book[] testBooks; // will hold test books

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
        testBooks = new Book[mockTitles.length];
        for (int i=0; i< mockTitles.length; i++) {
            testBooks[i] =  new Book(mockAuthors[i], mockTitles[i], mockYears[i], mockChapters[i]);
        }
    }
    
    @Test 
    public void testConstructor1() {
        try {
            // loop through all books
            for (Book book : testBooks) {
                assertNotNull("Book object should not be null", book);
            }
        }
        catch (Exception e) {
            assertEquals("Expected the program not to crash when constructing a Book object with arguments for all properties.", "The program crashed.");
        }
    }

    @Test 
    public void testConstructor2() {
        try {
            // loop through all books
            for (int i=0; i<mockAuthors.length; i++) {
                Book book = new Book(mockAuthors[i], mockTitles[i], mockYears[i]);
            }
        }
        catch (Exception e) {
            assertEquals("Expected the program not to crash when constructing a Book object with arguments for all but the chapters property.", "The program crashed.");
        }
    }

    // GETTERS
    public void testGetAuthor() {
        try {
            // loop through all books
            for (int i=0; i<testBooks.length; i++) {
                Book book = testBooks[i];
                assertEquals("getAuthor() should return the author of the book.", mockAuthors[i], book.getAuthor());
            }
        }
        catch (Exception e) {
            assertEquals("Expected the getAuthor() method not to crash.", "The getAuthor() method crashed.");
        }
    }
    public void testGetTitle() {
        try {
            // loop through all books
            for (int i=0; i<testBooks.length; i++) {
                Book book = testBooks[i];
                assertEquals("getTitle() should return the title of the book.", mockTitles[i], book.getTitle());
            }
        }
        catch (Exception e) {
            assertEquals("Expected the getTitle() method not to crash.", "The getTitle() method crashed.");
        }
    }
    public void testGetYear() {
        try {
            // loop through all books
            for (int i=0; i<testBooks.length; i++) {
                Book book = testBooks[i];
                assertEquals("getYear() should return the year of the book.", mockTitles[i], book.getTitle());
            }
        }
        catch (Exception e) {
            assertEquals("Expected the getYear() method not to crash.", "The getYear() method crashed.");
        }
    }
    @Test
    public void testBasicGetters() {
        testGetAuthor();
        testGetTitle();
        testGetYear();
    }
    @Test
    public void testGetChapters() {
        try {
            // loop through all books
            for (int i=0; i<testBooks.length; i++) {
                Book book = testBooks[i];
                boolean isSame = Arrays.deepEquals(mockChapters[i], book.getChapters());
                assertEquals("getChapters() should return an array of chapters of the book.", true, isSame);
            }
        }
        catch (Exception e) {
            assertEquals("Expected the getChapters() method not to crash.", "The getChapters() method crashed.");
        }
    }

    // SETTERS
    public void testSetAuthor() {
        try {
            // loop through all books
            for (int i=0; i<testBooks.length; i++) {
                Book book = testBooks[i];
                String newAuthor = "Foo Barstein";
                book.setAuthor(newAuthor);
                assertEquals(newAuthor, book.getAuthor());
            }
        }
        catch (Exception e) {
            assertEquals("Expected the setAuthor() method not to crash.", "The setAuthor() method crashed.");
        }
    }
    public void testSetTitle() {
        try {
            // loop through all books
            for (int i=0; i<testBooks.length; i++) {
                Book book = testBooks[i];
                String newTitle = "War and Peace";
                book.setTitle(newTitle);
                assertEquals(newTitle, book.getTitle());
            }
        }
        catch (Exception e) {
            assertEquals("Expected the setTitle() method not to crash.", "The setTitle() method crashed.");
        }
    }
    public void testSetYear() {
        try {
            // loop through all books
            for (int i=0; i<testBooks.length; i++) {
                Book book = testBooks[i];
                int newYear = 2022;
                book.setYear(newYear);
                assertEquals(newYear, book.getYear());
            }
        }
        catch (Exception e) {
            assertEquals("Expected the setYear() method not to crash.", "The setYear() method crashed.");
        }
    }
    @Test
    public void testBasicSetters() {
        testSetAuthor();
        testSetTitle();
        testSetYear();
    }
    @Test
    public void testSetChapters() {
        try {
            // loop through all books
            for (int i=0; i<testBooks.length; i++) {
                Book book = testBooks[i];
                String[] newChapters = {"foo", "bar", "baz"};
                book.setChapters(newChapters);
                assertArrayEquals("Expected the setChapters() method to modify the chapters.", newChapters, book.getChapters());
            }
        }
        catch (Exception e) {
            assertEquals("Expected the setChapters(chapters : String[]) method not to crash.", "The setChapters(chapters : String[]) method crashed.");
        }
    }

    // SETTER VALIDATION
    public void testSetAuthorValidation() {
        try {
            // loop through all books
            for (int i=0; i<testBooks.length; i++) {
                Book book = testBooks[i];
                book.setAuthor(""); // invalid
                assertEquals(mockAuthors[i], book.getAuthor());
            }
        }
        catch (Exception e) {
            assertEquals("Expected the setAuthor() method not to crash.", "The setAuthor() method crashed.");
        }
    }
    public void testSetTitleValidation() {
        try {
            // loop through all books
            for (int i=0; i<testBooks.length; i++) {
                Book book = testBooks[i];
                book.setTitle(""); // invalid
                assertEquals(mockTitles[i], book.getTitle());
            }
        }
        catch (Exception e) {
            assertEquals("Expected the setTitle() method not to crash.", "The setTitle() method crashed.");
        }
    }
    @Test
    public void testBasicSettersValidation() {
        testSetAuthorValidation();
        testSetTitleValidation();
    }
    @Test
    public void testSetChaptersValidation() {
        try {
            // loop through all books
            for (int i=0; i<testBooks.length; i++) {
                Book book = testBooks[i];
                String[] newChapters = {};
                book.setChapters(newChapters);
                assertArrayEquals("Expected the setChapters() method to validate the chapters.", mockChapters[i], book.getChapters());
            }
        }
        catch (Exception e) {
            assertEquals("Expected the setYear() method not to crash.", "The setYear() method crashed.");
        }
    }

    @Test 
    public void testGetSpecificChapterInRange() {
        try {
            // loop through all books
            for (int i=0; i<testBooks.length; i++) {
                Book book = testBooks[i];
                String[] expectedChapters = mockChapters[i];
                // loop through this book's chapters
                for (int j=0; j<expectedChapters.length; j++) {
                    assertEquals("getChapter(n : int) : String should return the correct chapter at the given index.", expectedChapters[j], book.getChapter(j));
                }
            }
        }
        catch (Exception e) {
            assertEquals("Expected the getChapter(n : int) : String method not to crash.", "The getChapter(n : int) : String method crashed.");
        }
    }

    @Test 
    public void testGetSpecificChapterOutOfRange() {
        try {
            // loop through all books
            for (int i=0; i<testBooks.length; i++) {
                Book book = testBooks[i];
                String[] expectedChapters = mockChapters[i];
                // get a chapter that does not exist
                assertEquals("getChapter(n : int) : String should return a blank String for a chapter out of range.", "", book.getChapter(expectedChapters.length+1));
            }
        }
        catch (Exception e) {
            assertEquals("Expected the getChapter(n : int) : String method not to crash.", "The getChapter(n : int) : String method crashed.");
        }
    }

    // CHAPTER PAGINATION
    @Test
    public void testHasNextChapterPositive() {
        try {
            // loop through all books
            for (int i=0; i<testBooks.length; i++) {
                Book book = testBooks[i];
                int expectedNumChapters = mockChapters[i].length;
                // loop through this book's chapters
                for (int j=0; j<expectedNumChapters; j++) {
                    // System.out.println("Current chapter index: " + j);
                    // all but the last chapter should have a next chapter available
                    if (j < expectedNumChapters - 1) {
                        assertEquals("Expected book to have a next chapter available.", true, book.hasNextChapter());
                    }
                    else {
                        // do nothing in this test
                    }
                    book.getChapter(j+1); // move internal pointer to next chapter
                }
                // after all chapters accessed, no more chapters should be available
                assertEquals("Expected book to not have a next chapter available after accessing all chapters.", false, book.hasNextChapter());
            }
        }
        catch (Exception e) {
            assertEquals("Expected the hasNextChapter() : boolean method not to crash.", "The hasNextChapter() : boolean method crashed.");
        }
    }

    @Test
    public void testHasNextChapterNegative() {
        try {
            // loop through all books
            for (int i=0; i<testBooks.length; i++) {
                Book book = testBooks[i];
                int expectedNumChapters = mockChapters[i].length;
                // loop through this book's chapters
                for (int j=0; j<expectedNumChapters; j++) {
                    // System.out.println("Current chapter index: " + j);
                    // all but the last chapter should have a next chapter available
                    if (j < expectedNumChapters - 1) {
                        // do nothing in this test
                    }
                    else {
                        assertEquals("Expected book to not have a next chapter available after accessing the last chapter.", false, book.hasNextChapter());
                    }
                    book.getChapter(j+1); // move internal pointer to next chapter
                }
                // after all chapters accessed, no more chapters should be available
                assertEquals("Expected book to not have a next chapter available after accessing all chapters.", false, book.hasNextChapter());
            }
        }
        catch (Exception e) {
            assertEquals("Expected the hasNextChapter() : boolean method not to crash.", "The hasNextChapter() : boolean method crashed.");
        }
    }

    @Test
    public void testGetNextChapterInRange() {
        try {
            // loop through all books
            for (int i=0; i<testBooks.length; i++) {
                Book book = testBooks[i];
                int expectedNumChapters = mockChapters[i].length;
                // loop through this book's chapters
                for (int j=0; j<expectedNumChapters; j++) {
                    assertEquals("Expected getNextChapter() to return next available chapter", mockChapters[i][j], book.getNextChapter());
                }
            }
        }
        catch (Exception e) {
            assertEquals("Expected the getNextChapter() : String method not to crash.", "The getNextChapter() : String method crashed.");
        }
    }    

    @Test
    public void testGetNextChapterOutOfRange() {
        try {
            // loop through all books
            for (int i=0; i<testBooks.length; i++) {
                Book book = testBooks[i];
                int expectedNumChapters = mockChapters[i].length;
                // loop through this book's chapters
                for (int j=0; j<expectedNumChapters; j++) {
                    String chapter = book.getNextChapter(); // move the internal pointer
                }
                // make sure blank string returned from now on
                assertEquals("Expect the getNextChapter() method to return blank string after accessing all chapters.", "", book.getNextChapter());
            }
        }
        catch (Exception e) {
            assertEquals("Expected the getNextChapter() : String method not to crash.", "The getNextChapter() : String method crashed.");
        }
    }    

    @Test
    public void testEqualsPositive() {
        try {
            for (int i=0; i<testBooks.length; i++) {
                // compare two of the same book
                Book book1 = testBooks[i];
                Book book2 = new Book(book1.getAuthor(), book1.getTitle(), book1.getYear(), book1.getChapters().clone());
                assertEquals("Expected two books with the same property values to be equals.", true, book1.equals(book2));
            }
        }
        catch (Exception e) {
            assertEquals("Expected the equals() : boolean method not to crash.", "The equals() : boolean method crashed.");
        }
    }    

    @Test
    public void testEqualsNegative() {
        try {
            for (int i=0; i<testBooks.length; i++) {
                // compare two different books
                Book book1 = testBooks[i];
                String[] book2Chapters = {"foo", "bar", "baz"};
                Book book2 = new Book("Foo", "Bar", 1920, book2Chapters);
                assertEquals("Expected two books with different property values to be unequals.", false, book1.equals(book2));
            }
        }
        catch (Exception e) {
            assertEquals("Expected the equals() : boolean method not to crash.", "The equals() : boolean method crashed.");
        }
    }

}
