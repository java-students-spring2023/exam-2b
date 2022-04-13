package edu.nyu.cs;

/**
 * @author Your Name and Net ID Here
 * @version 0.1
 * 
 * Complete the main method according to the comments.
 */
public class Array_Test {

    /**
     * Write a main method that instantiates two Book objects, one AudioBook object 
     * and stores all three objects in a single array.  Iterate through the items in that 
     * array using a loop and retrieve and print out the data in each object's first 
     * chapter from within the loop.  Within the loop, programmatically detect whether
     * any of the objects is an AudioBook, and if so, call that AudioBook object's playAll() 
     * method.
     */
    public static void main(String[] args) {

        // -----------------------------------
        // complete the main method
        // -----------------------------------

        String[] chapters = {
            "Over my head, I see the bronze butterfly,",
            "Asleep on the black trunk,",
            "Blowing like a leaf in green shadow.",
            "Down the ravine behind the empty house,",
            "The cowbells follow one another",
            "Into the distances of the afternoon.",
            "To my right,",
            "In a field of sunlight between two pines,",
            "The droppings of last year's horses",
            "Blaze up into golden stones.",
            "I lean back, as the evening darkens and comes on.",
            "A chicken hawk floats over, looking for home.",
            "I have wasted my life."
        };
        String author = "James Wright";
        String title = "Lying in a Hammock at William Duffy's Farm in Pine Island, Minnesota";
        int year = 1990;

        // instantiate two books and one audiobook - in this case the same data in each
        Book b1 = new Book(author, title, year, chapters);
        System.out.printf("\n'%s' (%d) by %s\n\n", b1.getTitle(), b1.getYear(), b1.getAuthor());
        Book b2 = new Book(author, title, year, chapters);
        System.out.printf("\n'%s' (%d) by %s\n\n", b2.getTitle(), b2.getYear(), b2.getAuthor());
        AudioBook b3 = new AudioBook(author, title, year, chapters);
        System.out.printf("\n'%s' (%d) by %s\n\n", b3.getTitle(), b3.getYear(), b3.getAuthor());

        // an array to hold all three
        Book[] books = {b1, b2, b3};

        // loop through array
        for (Book b : books) {
            // print first chapter
            System.out.println(b.getChapter(0));

            // detect whether it's an audiobook
            if (b instanceof AudioBook) {
                // if so, cast to AudioBook and play all chapters
                ((AudioBook) b).playAll();
            }
        }


    }
    
}
