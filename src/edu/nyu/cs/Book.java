package edu.nyu.cs;

/**
 * @author Your Name and Net ID Here
 * @version 0.1
 * 
 * Create a class that represents a Book, including some basic information about the book 
 * and an array of chapters of text, where each chapter is a String object.
 * 
 * Check the UML diagram for this class located in this repository's 'images' directory.
 * Your code must include the properties and methods indicated there.  Anything not 
 * indicated in the diagram or these instructions is left to your discretion.  You are free 
 * to add additional properties and/or methods, as necessary to meet the requirements.
 * 
 * Your code must include two overloaded constructors: one that accepts as arguments the 
 * values to assign to each of the instance properties indicated in the UML diagram.  The 
 * other that accepts values for each of the instance properties except the chapters array.
 * The order of both constructors' parameters must match the order in which the properties 
 * are listed in the UML diagram.
 * 
 * Your code must follow object-oriented best-practices:
 *  - all properties should be private, unless there is good reason otherwise.
 *  - getters and setters should be provided for access from external classes.
 *  - setters should perform meaningful validation to prevent nonsensical values.
 * 
 * In addition to defining the class here, complete the main method in the Book_Test class.
 */
public class Book {

  // -----------------------------------
  // complete the class definition
  // -----------------------------------
  
  private String author;
  private String title;
  private int year;
  private String[] chapters;
  private int currentChapter = 0;
  
  public Book(String author, String title, int year) {
    this.setAuthor(author);
    this.setTitle(title);
    this.setYear(year);
  }

  public Book(String author, String title, int year, String[] chapters) {
    this(author, title, year);
    this.setChapters(chapters);
  }

  /**
   * @return The value of the author property.
   */
  public String getAuthor() {
    return this.author;
  }

  /**
   * @param author The new value to use for the author property.
   */
  public void setAuthor(String author) {
    if (!author.isEmpty()) {
      this.author = author;
    }
  }

  /**
   * @return The value of the title property.
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * @param title The new value to use for the title property.
   */
  public void setTitle(String title) {
    if (!title.isEmpty()) {
      this.title = title;
    }
  }

  /**
   * @return The value of the year property.
   */
  public int getYear() {
    return this.year;
  }

  /**
   * @param title The new value to use for the year property.
   */
  public void setYear(int year) {
    this.year = year;
  }

  /**
   * @return The value of the chapters property.
   */
  public String[] getChapters() {
    return this.chapters;
  }

  /**
   * @param chapters The new value to use for the chapters property.
   */
  public void setChapters(String[] chapters) {
    if (chapters.length > 0) {
      this.chapters = chapters;
    }
  }

  /**
   * @return The value of the currentChapter property.
   */
  public int getCurrentChapter() {
    return this.currentChapter;
  }

  /**
   * @param chapters The new value to use for the currentChapter property.
   */
  public void setCurrentChapter(int n) {
    if (isChapter(n)) {
      this.currentChapter = n;
    }
  }

  /**
   * 
   * @param n The index of the chapter to investigate.
   * @return true if the chapter exists in the chapters array, false otherwise.
   */
  private boolean isChapter(int n) {
    return this.chapters.length > 0 && n >= 0 && n < this.chapters.length;
  }

  /**
   * 
   * @param n The index of the chapter to investigate.
   * @return The text of the chapter, if it exists; a blank string otherwise.
   */
  public String getChapter(int n) {
    if (this.isChapter(n)) {
      this.setCurrentChapter(n);
      return this.chapters[n];
    }
    else {
      // no such chapter exists
      return "";
    }
  }

  /**
   * @return true if there is another chapter available, false otherwise.
   */
  public boolean hasNextChapter() {
    return this.isChapter(this.currentChapter+1);
  }

  /**
   * @return true if there is a previous chapter available, false otherwise.
   */
  public boolean hasPreviousChapter() {
    return this.isChapter(this.currentChapter-1);
  }

  /**
   * @return The next available chapter, if any; a blank string otherwise.
   */
  public String getNextChapter() {
    int n = this.getCurrentChapter() + 1;
    if (isChapter(n)) {
      return this.getChapter(n);
    }
    else {
      return null; // there is no further chapter
    }
  }

  /**
   * @return The previously available chapter, if any; a blank string otherwise.
   */
  public String getPreviousChapter() {
    int n = this.getCurrentChapter() - 1;
    if (isChapter(n)) {
      return this.getChapter(n);
    }
    else {
      return null; // there is no previous chapter
    }
  }

  public boolean equals(Book other) {
    boolean sameTitle = this.title.equals(other.title);
    boolean sameAuthor = this.author.equals(other.author);
    boolean sameYear = this.year == other.year;
    boolean sameChapters = this.chapters.length == other.chapters.length;
    if (sameChapters) {
      for (int i=0; i<this.chapters.length; i++) {
        if (!this.chapters[i].equals(other.chapters[i])) {
          sameChapters = false;
          break;
        }
      }
    }
    return sameTitle && sameAuthor && sameYear && sameChapters;
  }

}
