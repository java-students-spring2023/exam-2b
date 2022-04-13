package edu.nyu.cs;

/**
 * @author Your Name and Net ID Here
 * @version 0.1

 * Create a class named AudioBook that inherits from the Book class.  Whereas the Book 
 * class represents a printed paper book with chapters as String objects, the AudioBook 
 * represents each chapter as a byte array of audio data.
 * 
 * Check the UML diagram for this class located in this repository's 'images' directory.
 * This diagram shows all inherited properties and methods (indicated with ^) as well as 
 * those that must be added or overridden.  Anything not indicated in the diagram or these 
 * instructions is left to your discretion.  You are free to add additional properties 
 * and/or methods, as necessary to meet the requirements.
 * 
 * Your code must include a constructor that accepts as arguments the values to assign to
 * each of the instance properties indicated in the UML diagram.  The order of the 
 * constructor's parameter must match the order in which the properties are listed in the 
 * UML diagram.
 * 
 * Your code must follow object-oriented best-practices:
 *  - all properties should be private, unless there is good reason otherwise.
 *  - getters and setters should be provided for access from external classes.
 *  - setters should perform meaningful validation to prevent nonsensical values.
 */
public class AudioBook extends Book {

  // -----------------------------------
  // complete the class definition
  // -----------------------------------

  /**
   * Constructor
   * @param author The author of the audiobook
   * @param title The title of the audiobook
   * @param year The year the audiobook was written.
   * @param chapters The chapters of the audiobook.
   */
  public AudioBook(String author, String title, int year, String[] chapters) {
    // use the super class's constructor, rather than redundantly repeat that code.
    super(author, title, year, chapters);
  }

  /**
   * Print all the chapters, one after the other, starting from the first.
   */
  public void playAll() {
    int counter = 0;
    this.setCurrentChapter(counter);
    while (this.hasNextChapter()) {
      String chapter = this.getChapter(counter);
      System.out.println(chapter);
      counter++;
    }
  }

}
