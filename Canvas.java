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
 * Canvas is a class that controls the canvas that the user is altering through its size, adding
 * characters and redoing and undoing those additions.
 */
public class Canvas {
  private final int width; // width of the canvas
  private final int height; // height of the canvas

  private char[][] drawingArray; // 2D character array to store the drawing

  private final DrawingStack<DrawingChange> undoStack; // store previous changes for undo
  private final DrawingStack<DrawingChange> redoStack; // store undone changes for redo

  /**
   * @param height The height of the canvas
   * @param width  The width of the canvas The canvas constructor contains the height, width, and
   *               undos and redos of the canvas.
   */
  public Canvas(int height, int width) {
    if (width <= 0 || height <= 0)
      throw new IllegalArgumentException();
    this.width = height;
    this.height = width;
    this.undoStack = new DrawingStack<DrawingChange>();
    this.redoStack = new DrawingStack<DrawingChange>();
    this.drawingArray = new char[width][height];
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        this.drawingArray[i][j] = ' ';
      }
    }
  }

  /**
   * @param row: the row at which the character is being drawn
   * @param col: the column at which the character is being drawn
   * @param c: The character that is being drawn. The draw method draws a user specified character
   *        at a user specified width and height.
   */
  public void draw(int row, int col, char c) {
    if (col >= this.height || row >= this.width)
      throw new IllegalArgumentException();
    this.undoStack.push(new DrawingChange(row, col, c, this.drawingArray[row][col]));
    this.drawingArray[row][col] = c;
    return;
  } // Draw a character at the given position
    // This method should throw an IllegalArgumentException if the drawing position is outside the
    // canvas
    // If that position is already marked with a different character, overwrite it.
    // After making a new change, add a matching DrawingChange to the undoStack so that we can undo
    // if needed.
    // After making a new change, the redoStack should be empty.

  /**
   * @return Whether or not the undo was successful. The undo method undoes the most recent draw and
   *         stores that undo in the possibilities to be redone.
   */
  public boolean undo() {
    DrawingChange dc = this.undoStack.pop();
    if (this.drawingArray[dc.x][dc.y] != dc.prevChar) {
      return false;
    }
    this.drawingArray[dc.x][dc.y] = dc.newChar;
    this.redoStack.push(new DrawingChange(dc.x, dc.y, dc.newChar, dc.prevChar));
    return true;
  } // Undo the most recent drawing change. Return true if successful. False otherwise.
    // An undone DrawingChange should be added to the redoStack so that we can redo if needed.

  /**
   * @return Whether or not the redo was successful. The redo method redoes the most recently undone
   *         draw. It stores this in the possibilities to be undone.
   */
  public boolean redo() {
    DrawingChange dc = this.redoStack.pop();
    if (this.drawingArray[dc.x][dc.y] != dc.prevChar) {
      return false;
    }
    this.drawingArray[dc.x][dc.y] = dc.newChar;
    this.undoStack.push(new DrawingChange(dc.x, dc.y, dc.newChar, dc.prevChar));
    return true;
  } // Redo the most recent undone drawing change. Return true if successful. False otherwise.
    // A redone DrawingChange should be added (back) to the undoStack so that we can undo again if
    // needed.

  /**
   * Provides a string input comprised of the contents of the canvas.
   */
  public String toString() {

    String[] strs = new String[this.width];
    for (int i = 0; i < this.width; i++) {
      strs[i] = "";
    }
    String result = "";
    for (int i = 0; i < this.width; i++) {
      for (int j = 0; j < this.height; j++) {
        strs[i] += this.drawingArray[i][j];
      }
    }
    for (int i = 0; i < this.width; i++) {
      result += strs[i] + "\n";
    }
    // System.out.println(result);
    return result;
  } // Return a printable string version of the Canvas.
  /*
   * Format example: [_ is blank. Use System.lineSeparator() to put a newline character between
   * rows] X___X _X_X_ __X__ _X_X_ X___X
   */

  /**
   * @return: returns the height of the canvas
   */
  public int getHeight() {
    return this.height;
  }

  /**
   * @return: Returns the width of the canvas.
   */
  public int getWidth() {
    return this.width;
  }
}
