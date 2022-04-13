package edu.nyu.cs;

/**
 * @author Your Name and Net ID Here
 * @version 0.1
 * 
 * Complete the main method according to the comments.
 */
public class Book_Test {

  /**
   * Do the following:
   * - Instantiate two Book objects with all properties set with dummy data of your choosing.  
   * - Show how to loop through and print out each of the chapters of the first book.
   * - Show how to compare the two books using the equals() method and print out, 
   *   "They are the same book!" if the method returns true, and "They are different books!"
   *   if the method returns false.
   *  
   * @param args An array of any command-line arguments.
   */
  public static void main(String[] args) throws Exception {

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

    // instantiate two books - in this case the same
    Book b1 = new Book(author, title, year, chapters);
    System.out.printf("\n'%s' (%d) by %s\n\n", b1.getTitle(), b1.getYear(), b1.getAuthor());
    Book b2 = new Book(author, title, year, chapters);
    System.out.printf("\n'%s' (%d) by %s\n\n", b2.getTitle(), b2.getYear(), b2.getAuthor());

    // loop through and output each chapter
    for (String chapter : b1.getChapters()) {
      System.out.println(chapter);
    }

    // compare the two books
    if (b1.equals(b2)) {
      System.out.println("They are the same book!");
    }
    else {
      System.out.println("They are different books!");
    }
  }
    
}
