/*
 * Ant.java
 */

package Critters;

import java.util.Random;

/**
 * CS5004 Assignment 7: Problem 1 - Organism
 * This class serves to define Ant
 *
 * @author Xiaowei Lu
 * @since 2020-06-28
 */
public class Ant extends Organism{

    // constructor with three arguments
    public Ant(Organism[][] board, int row, int col) {
        super(board, row, col);
    }

    // default constructor
    public Ant() {
        super();
    }

    // copy constructor
    public Ant(Organism other) {
        super(other);
    }

    @Override
    public void move() {
        Organism[][] board = getBoard();
        int row = getRow();
        int col = getCol();

        // generate random number
        Random rand = new Random();
        int direction = rand.nextInt(4) + 1;

        // 1 for north, 2 for east, 3 for west, 4 for south
        switch (direction) {
            case 1:
                // top row = 0, bottom row = 19
                if (row != 0 && board[row - 1][col] == null) {
                    board[row - 1][col] = this;
                    board[row][col] = null;
                    setRow(row - 1);
                }
                break;

            case 2:
                // top col = 0, bottom col = 19
                if (col != 19 && board[row][col + 1] == null) {
                    board[row][col + 1] = this;
                    board[row][col] = null;
                    setCol(col + 1);
                }
                break;

            case 3:
                // top col = 0, bottom col = 19
                if (col != 0 && board[row][col - 1] == null) {
                    board[row][col - 1] = this;
                    board[row][col] = null;
                    setCol(col - 1);
                }
                break;

            case 4:
                // top row = 0, bottom row = 19
                if (row != 19 && board[row + 1][col] == null) {
                    board[row + 1][col] = this;
                    board[row][col] = null;
                    setRow(row + 1);
                }
                break;
        }

        // add one step whatever it moved or not
        addTimeStep();
        setCanMove(false);

        // ready to bleed when timeStep = 3
        if (getTimeStep() >= 3 && getNumOfBleed() <= 10)
            breed();
    }


    @Override
    public void breed() {
        Organism[][] board = getBoard();
        int row = getRow();
        int col = getCol();

        // generate random number
        Random rand = new Random();
        int direction = rand.nextInt(4) + 1;

        // 1 for north, 2 for east, 3 for west, 4 for south
        switch (direction) {
            case 1:
                // top row = 0, bottom row = 19
                if (row != 0 && board[row - 1][col] == null) {
                    board[row - 1][col] = new Ant(board, row - 1, col);
                    addNumOfBleed();
                    resetTimeStep();
                }
                break;

            case 2:
                // top col = 0, bottom col = 19
                if (col != 19 && board[row][col + 1] == null) {
                    board[row][col + 1] = new Ant(board, row, col + 1);
                    addNumOfBleed();
                    resetTimeStep();
                }
                break;

            case 3:
                // top col = 0, bottom col = 19
                if (col != 0 && board[row][col - 1] == null) {
                    board[row][col - 1] = new Ant(board, row, col - 1);
                    addNumOfBleed();
                    resetTimeStep();
                }
                break;

            case 4:
                // top row = 0, bottom row = 19
                if (row != 19 && board[row + 1][col] == null) {
                    board[row + 1][col] = new Ant(board, row + 1, col);
                    addNumOfBleed();
                    resetTimeStep();
                }
                break;
        }
    }
}
