//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (ASCII Art)
// Files: (DrawingStackIterator.java, DrawingStack.java, DrawingChange.java, 
// Canvas.java, AsciiTest.java, AsciiArt.java)
// Course: (CS300, Fall, 2018)
//
// Author: (Tony Schulz & Robert Bremer)
// Email: (schulz22@wisc.edu)
// Lecturer's Name: (Gary Dahl)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner: Robert Bremer
// Partner Email: rbremer@wis.edu
// Partner Lecturer's Name: Mouna Kacem
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X_ Write-up states that pair programming is allowed for this assignment.
// _X_ We have both read and understand the course Pair Programming Policy.
// _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////


/**
 * 
 * This class is for making changes to an existing ASCII art image
 * stored in a Canvas object.
 * 
 *
 */
public class DrawingChange {
  public final int x; // x coordinate for a change
  public final int y; // y coordinate for a change
  public final char prevChar; // previous character in the (x,y)
  public final char newChar; // new character in the (x,y)
  
  
  /**
   * constructs an new DrawingChange object.
   * @param x the x position of the character in the ASCII image
   * @param y the y position of the character in the ASCII image
   * @param prevChar the previous character in the designated position
   * @param newChar the character to replace the prevChar
   */
  public DrawingChange(int x, int y, char prevChar, char newChar) {
    this.x = x;
    this.y = y;
    this.prevChar = prevChar;
    this.newChar = newChar;
  }
}
