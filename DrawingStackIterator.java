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

import java.util.Iterator;

/**
 * a class for iterating through a DrawingStack object
 * 
 */
public class DrawingStackIterator implements Iterator<DrawingChange>{
  private Node<DrawingChange> first;
  private Node<DrawingChange> current;
  private int count;
  
  /**
   * constructs a new DrawingStackIterator
   * @param first sets the node at the top of the stack to be iterated
   */
  public DrawingStackIterator(Node first) {
    this.first = first;
    this.count = 1;
  }
  /**
   * returns whether or not there is another Node in the stack
   */
  public boolean hasNext() {
    if (this.current == null) return false;
    if (this.current.getNext() == null) return false;
    else return true;
  }
  /**
   * returns the data held by the next object in the stack and iterates forward by one node.
   */
  public DrawingChange next() {
   Node<DrawingChange> n = this.first;
   
   for (int i = 1; i < this.count; i++) {
     n = n.getNext();
   }
   this.count++;
   return n.getData();
   
   
  }
  /**
   * 
   * @return the current count of the iterator
   */
  public int getCount() {
    return this.count;
  }

}
