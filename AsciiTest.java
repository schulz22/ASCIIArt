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
 * AsciiTest is a class that contains test methods to ensure that the methods with which we adapt
 * our Canvas function properly.
 */
public class AsciiTest {
  /**
   * @return: Whether or not the test was successful. testStackPushPeek tests whether the push and
   *          peek methods work correctly on the stack by implementing both methods and checking the
   *          result.
   */
  public static boolean testStackPushPeek() {
    DrawingStack<DrawingChange> ds = new DrawingStack<DrawingChange>();
    DrawingChange dc1 = new DrawingChange(1, 1, '1', 'b');
    DrawingChange dc2 = new DrawingChange(1, 1, '2', 'b');
    DrawingChange dc3 = new DrawingChange(1, 1, '3', 'b');
    DrawingChange dc4 = new DrawingChange(1, 1, '4', 'b');
    DrawingChange dc5 = new DrawingChange(1, 1, '5', 'b');
    ds.push(dc1);
    ds.push(dc2);
    ds.push(dc3);
    ds.push(dc4);
    ds.push(dc5);
    if (ds.peek() != dc5) {
      return false;
    }
    return true;
  }

  /**
   * 
   * @return: Whether or not the test was successful. testToString checks whether the toString works
   *          properly.
   */
  public static boolean testToString() {
    char[] chr = {'1', '2', '3', '4'};
    Canvas can = new Canvas(4, 4);
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        can.draw(i, j, chr[j]);
      }
    }
    if (can.toString().equals("1234\n1234\n1234\n1234\n"))
      return true;
    else
      return false;
  }

  /**
   * 
   * @return: Returns whether the test was successful or not. testStackPushPopIsEmpty checks whether
   *          push, pop and is empty functions work correctly
   */
  public static boolean testStackPushPopIsEmpty() {
    DrawingStack<DrawingChange> test = new DrawingStack<DrawingChange>();
    DrawingChange dc1 = new DrawingChange(1, 1, 'a', 'b');
    test.push(dc1);
    test.pop();
    return test.isEmpty();
  }

  /**
   * 
   * @return: Whether the test was successful or not. testStackSize checks whether the size function
   *          works correctly.
   */
  public static boolean testStackSize() {
    DrawingStack<DrawingChange> test = new DrawingStack<DrawingChange>();
    DrawingChange dc1 = new DrawingChange(1, 1, 'a', 'b');
    DrawingChange dc2 = new DrawingChange(1, 2, 'a', 'b');
    DrawingChange dc3 = new DrawingChange(1, 3, 'a', 'b');
    test.push(dc1);
    test.push(dc2);
    test.push(dc3);
    if (test.size() == 3) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * 
   * @return: Whether all tests ran without errors or not. StackTestSuite checks that each other
   *          test returned true.
   */
  public static boolean runStackTestSuite() {
    boolean test = true;
    if (testStackPushPeek() != true) {
      test = false;
    }
    if (testToString() != true) {
      test = false;
    }
    if (testStackPushPopIsEmpty() != true) {
      test = false;
    }
    if (testStackSize() != true) {
      test = false;
    }
    return test;
  }

  /**
   * 
   * @param args Prints out the result of each tests.
   */
  public static void main(String[] args) {
    System.out.println("testStackPushPeek(): " + testStackPushPeek());
    System.out.println("testToString(): " + testToString());
    System.out.println("testStackPushPopIsEmpty(): " + testStackPushPopIsEmpty());
    System.out.println("testStackSize(): " + testStackSize());
    System.out.println("All tests passed: " + runStackTestSuite());


  }
}
