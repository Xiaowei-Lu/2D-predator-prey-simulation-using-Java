/*
 * Simulate.java
 */

import Critters.*;
import java.util.*;

/**
 *
 * CS5004 Assignment 7: Problem 1 - Organism
 * This class serves to have a test
 *
 * @author Xiaowei Lu
 * @since 2020-06-28
 */
public class Simulate {

    /**
     * This function serves to test Organism
     *
     * @param args (unused)
     */
    public static void main(String[] args) {

        // initializeBoard, create Organism objects 2d array
        Organism[][] board = new Organism[20][20];

        //Place Ants in field
        int i = 0;
        while (i < 100) {
            // generate random number
            Random rand = new Random();
            int row = rand.nextInt(20);
            int col = rand.nextInt(20);
            while (board[row][col] != null) {
                row = rand.nextInt(20);
                col = rand.nextInt(20);
            }
            board[row][col] = new Ant(board, row, col);
            i = i + 1;
        }
        //Place Doodlebugs in field
        i = 0;
        while (i < 5) {
            // generate random number
            Random rand = new Random();
            int row = rand.nextInt(20);
            int col = rand.nextInt(20);
            while (board[row][col] != null) {
                row = rand.nextInt(20);
                col = rand.nextInt(20);
            }
            board[row][col] = new Doodlebug(board, row, col);
            i = i + 1;
        }

        // input from user
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Press enter to continue: ");
        String stop;
        stop = keyboard.nextLine();

        // try again
        while (!(stop.equals("END") || (stop.equals("")))) {
            System.out.println("Type again! Press enter to continue: ");
            stop = keyboard.nextLine();
        }

        // End if END is input
        while (!stop.equals("END")) {
            newTurn(board);
            // assess Doodlebug element in board
            for(Organism[] rows: board) {
                for(Organism bug: rows) {
                    // able element in board
                    if (bug != null && bug.isCanMove() && bug instanceof Doodlebug)
                        bug.move();
                }
            }
            // assess Ant element in board
            for(Organism[] rows: board) {
                for(Organism bug: rows) {
                    // able element in board
                    if (bug != null && bug.isCanMove() && bug instanceof Ant)
                        bug.move();
                }
            }
            // print the board
            printBoard(board);
            System.out.println();
            System.out.println("Press enter to continue again: ");
            stop = keyboard.nextLine();
            // continue again
            while (!(stop.equals("END") || (stop.equals("")))) {
                System.out.println("Come on and type again! Press enter to continue: ");
                stop = keyboard.nextLine();
            }
        }
    }

    // new turn
    public static void newTurn(Organism[][] board) {
        // check every spot in board is empty or not, able canMove to true if not empty
        for(int row = 0; row < 20; row++) {
            for(int col = 0; col < 20; col++) {
                //Print whitespace if empty cell
                if (board[row][col] != null)
                    board[row][col].setCanMove(true);
            }
        }
    }

    // “o” for an ant and “X” for a doodlebug
    public static void printBoard(Organism[][] board) {
        // print every board element
        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 20; col++) {
                //Print whitespace if empty cell
                if (board[row][col] instanceof Doodlebug)
                    System.out.print("X");
                else if (board[row][col] instanceof Ant)
                    System.out.print("o");
                else
                    System.out.print(" ");
            }
            // move to next line
            System.out.println();
        }
    }
}
