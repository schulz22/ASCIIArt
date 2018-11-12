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

import java.util.Scanner;


/**
 * 
 *  This class runs the main() for an ASCII art generation program.
 *  It is a test-based driver which allows users to perform various
 *  tasks related to creating an ASCII image.
 *
 */
public class AsciiArt {
  private Canvas current;

  public static void main(String args[]) {
    AsciiArt aa = new AsciiArt();
    Scanner scnr = new Scanner(System.in);
    Canvas test = new Canvas(10, 10);
    while (true) {
      System.out.println("======== MENU ========");
      System.out.println("[1] Create a new canvas");
      System.out.println("[2] Draw a character");
      System.out.println("[3] Undo drawing");
      System.out.println("[4] Redo drawing");
      System.out.println("[5] Show current canvas");
      System.out.println("[6] Exit");
      System.out.print("> ");

      String userInput = scnr.nextLine().trim();
      System.out.println();
      switch (userInput) {
        case "1":
          int wid = -1;
          int hei = -1;
          String width = "";
          String height = "";

          while (wid <= 0) {
            try {

              System.out.print("Width > ");
              width = scnr.nextLine().trim();
              wid = Integer.parseInt(width);

            } catch (NumberFormatException e) {
              System.out.println("Invalid input. Please enter a positive integer for width.");
            }
            if (wid <= 0)
              System.out.println("Invalid input. Please enter a positive integer for width.");

          }
          while (hei <= 0) {
            try {

              System.out.print("Height > ");
              height = scnr.nextLine().trim();
              hei = Integer.parseInt(height);
            } catch (NumberFormatException e) {
              System.out.println("Invalid input. Please enter a positive integer for height.");
            }
            if (hei <= 0)
              System.out.println("Invalid input. Please enter a positive integer for height.");

          }

          aa.current = new Canvas(wid, hei);
          break;

        case "2":
          int row = -1;
          int col = -1;
          String rowstr = "";
          String colstr = "";

          while (row >= aa.current.getHeight() || row < 0) {
            try {
              System.out.print("Row > ");
              rowstr = scnr.nextLine().trim();
              row = Integer.parseInt(rowstr);
            } catch (NumberFormatException e) {
              System.out.println("Invalid input. Please enter a positive integer within the canvas size for row.");
            }
            if (row >= aa.current.getWidth() || row < 0) {
              System.out.println("Invalid input. Please enter a positive integer within the canvas size for row.");
            }
          }

          while (col >= aa.current.getWidth() || col < 0) {
            try {
              System.out.print("Col > ");
              colstr = scnr.nextLine().trim();
              col = Integer.parseInt(colstr);
            } catch (NumberFormatException e) {
              System.out.println("Invalid input. Please enter a positive integer within the canvas size for column.");
            }
            if (col >= aa.current.getWidth() || col < 0) {
              System.out.println("Invalid input. Please enter a positive integer within the canvas size for column.");
            }
          }
          
          
          char inChar;
          
          System.out.print("Character > ");
          inChar = scnr.nextLine().charAt(0);
          System.out.println();
          
          aa.current.draw(row, col, inChar);
          
          break;

        case "3":
          aa.current.undo();
          // System.out.println("> ");
          break;

        case "4":
          aa.current.redo();
          // System.out.println("> ");
          break;

        case "5":
          System.out.println(aa.current.toString());
          // System.out.println("> ");
          break;

        case "6":
          System.exit(0);
          break;
        default:
          System.out.println("Invalid input. Enter a single number from the list.");
      }
    }
  }
}
