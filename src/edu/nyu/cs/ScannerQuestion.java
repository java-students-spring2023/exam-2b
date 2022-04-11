package edu.nyu.cs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Complete the methods within this class according to the instructions in the comments.
 */
public class ScannerQuestion {
    
    /**
     * getLinesFromFile
     * Complete a method named getLinesFromFile, such that it opens up a text file and returns the
     * lines therein as an array of Strings, with all line-breaks removed.
     * 
     * Requirements:
     * - the method must return an array, not an ArrayList or other type
     * - the first line of the file is assumed to have column headings, and should not be included in the array that is returned
     * - otherwise, you are free to complete this method any way you wish.
     * 
     * @param filepath The path to the file to open, e.g. "data/artists.csv"
     * @return String array of the lines in the file, excluding the first line, with the line break removed from each line.
     * @throws FileNotFoundException
     */
    // -----------------------------------
    // write the getLinesFromFile method here
    // -----------------------------------


    /**
     * getAgesFromLines
     * Complete a method named getAgesFromLines which accepts an array of Strings 
     * representing lines from a text file containing artists' names, birth countries, and birth years
     * and returns an array of just those artists' ages.
     * 
     * Requirements:
     * - assume each line in the argument array contains comma-separated values with an artist's name, birth country, and birth year - see the data/artists.csv file for example lines
     * - you should use the following function from the Calendar class to get the current year programmatically: Calendar.getInstance().get(Calendar.YEAR)
     * - subtract each artist's birth year from the current year to calcualte their age
     * 
     * @param lines A String array of lines from a text file containing data about artists
     * @return An int array representing the artists' current ages.
     */
    // -----------------------------------
    // write the getAgesFromLines method here
    // -----------------------------------


    /**
     * getAverageAge
     * Complete a function named getAverageAge which accepts an array of artists' ages and calculates and returns the average age.
     * 
     * @param ages An int array containing artists' ages.
     * @return The average age calculated from the ages in the array, rounded to the nearest int.
     */
    // -----------------------------------
    // write the getAverageAge method here
    // -----------------------------------

     
    /**
     * main
     * Complete this main method such that this program opens a text file 
     * containing information about globally-renowned artists, extracts the
     * lines of data from that file, calculates the current age of each artist,
     * and prints out the average of all artists in the file.
     * 
     * Requirements:
     * - use the getLinesFromFile function to extract the lines of data from the data/artists.csv file
     * - use the getAgesFromLines function to calculate the current age of each artist
     * - use the getAverageAge function to calculate the average age of all artists
     * - this program must work with any data file with any number of lines of artists' information, as long as it follows the same general format as the given data file
     * - the program must print out a message showing the calculated ages in exactly the following format (the numbers shown here are for example only and are not correct):
     *      The average age of all 4 artists in the file is 59.
     * 
     * @param args An array of any command-line arguments.
     */
    public static void main(String[] args) throws Exception {

        // -----------------------------------
        // complete the main method here
        // -----------------------------------

    }

}
