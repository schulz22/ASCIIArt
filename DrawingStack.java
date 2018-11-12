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
 * This class is a stack ADT for holding Node objects containing DrawingChange objects 
 * 
 */
public class DrawingStack<DrawingChange> implements StackADT<DrawingChange>{
  private Node<DrawingChange> first;
  
  
  /**
   * Add an element to this stack
   * @param element an element to be added
   * @throws IllegalArgumentException if the input element is null
   */
  public void push(DrawingChange element) throws IllegalArgumentException {
    if (element == null) throw new IllegalArgumentException();
    if (this.first == null) this.first = new Node<DrawingChange>(element, null);  
    else {
      Node<DrawingChange> n = this.first;
      while (n.getNext() != null) {
        n = n.getNext();
      }
      n.setNext(new Node<DrawingChange>(element, null));
    }
  }
  /**
   * Remove the element on the stack top and return it
   * @return the element removed from the stack top
   */
  public DrawingChange pop() {
    
    if (this.first == null) return null;
    
    if(this.first.getNext() == null) {
      DrawingChange dc = this.first.getData();
      this.first = null;
      return dc;
    }
    
    Node<DrawingChange> n;
    n = this.first;
    int i = 0;
    while(n.getNext() != null) {
      n = n.getNext();
      i++;
      
    }
    
    DrawingChange dc = n.getData();
    n = this.first;
    for (int j = 0; j < i - 1; j++) {
      n = n.getNext();
    }
    n.setNext(null);
    return dc;
  }
 
  /**
   * Get the element on the stack top
   * @return the element on the stack top
   */
  public DrawingChange peek() {
    
    if (this.first == null) return null;
    
    Node<DrawingChange> n = this.first;
    while (n.getNext() != null) {
      n = n.getNext();
    }
    return n.getData();
  }
 
  /**
   * Returns true if this stack contains no elements.
   * @return true if this stack contains no elements, otherwise false
   */
  public boolean isEmpty() {
    return (first == null);
  }
 
  /**
   * Get the number of elements in the stack
   * @return the size of the stack
   */
  public int size() {
    int size = 0;
    Node<DrawingChange> n = this.first;
    if(n == null) return 0;
    size++;
    while (n.getNext() != null) {
      n = n.getNext();
      size++;
    }
    
    
    return size;
  }
 
  /**
   * 
   * @return iterator of the stack
   */
  public Iterator<DrawingChange> iterator(){
    return (Iterator<DrawingChange>)(new DrawingStackIterator(this.first));
  }
}


