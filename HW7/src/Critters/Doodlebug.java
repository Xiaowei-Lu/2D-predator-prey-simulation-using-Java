/*
 * Doodlebug.java
 */

package Critters;

import java.util.Random;

/**
 * CS5004 Assignment 7: Problem 1 - Organism
 * This class serves to define Doodlebug
 *
 * @author Xiaowei Lu
 * @since 2020-06-28
 */
public class Doodlebug extends Organism{

    // declare an instance variable of Doodlebug to count starve steps
    private int starveTurns;

    // constructor with three arguments
    public Doodlebug(Organism[][] board, int row, int col) {
        super(board, row, col);
        starveTurns = 0;
    }

    // default constructor
    public Doodlebug() {
        super();
        starveTurns = 0;
    }

    // copy constructor
    public Doodlebug(Organism other) {
        super(other);
        starveTurns = 0;
    }

    @Override
    public void move() {
        Organism[][] board = getBoard();
        int row = getRow();
        int col = getCol();

        // mark whether bug had eaten an Ant
        boolean eaten = false;

        // generate random number
        Random rand = new Random();
        int direction = rand.nextInt(4) + 1;

        // 1 for north, 2 for east, 3 for west, 4 for south
        switch (direction) {
            case 1:
                // top row = 0, bottom row = 19
                if (row != 0 && !(board[row - 1][col] instanceof Doodlebug)) {
                    if (board[row - 1][col] instanceof Ant)
                        eaten = true;
                    board[row - 1][col] = this;
                    board[row][col] = null;
                    //board = null;
                    setRow(row - 1);
                    row--;
                }
                break;

            case 2:
                // top col = 0, bottom col = 19
                if (col != 19 && !(board[row][col + 1] instanceof Doodlebug)) {
                    if (board[row][col + 1] instanceof Ant)
                        eaten = true;
                    board[row][col + 1] = this;
                    board[row][col] = null;
                    setCol(col + 1);
                    col++;
                }
                break;

            case 3:
                // top col = 0, bottom col = 19
                if (col != 0 && !(board[row][col - 1] instanceof Doodlebug)) {
                    if (board[row][col - 1] instanceof Ant)
                        eaten = true;
                    board[row][col - 1] = this;
                    board[row][col] = null;
                    setCol(col - 1);
                    col--;
                }
                break;

            case 4:
                // top row = 0, bottom row = 19
                if (row != 19 && !(board[row + 1][col] instanceof Doodlebug)) {
                    if (board[row + 1][col] instanceof Ant)
                        eaten = true;
                    board[row + 1][col] = this;
                    board[row][col] = null;
                    setRow(row + 1);
                    row++;
                }
                break;
        }

        // add one step whatever it moved or not
        addTimeStep();
        setCanMove(false);

        // ready to bleed when timeStep = 8
        if (getTimeStep() >= 8 && getNumOfBleed() <= 10)
            breed();

        // rest to 0 if bug had eaten
        if (!eaten)
            starveTurns++;
        else
            starveTurns = 0;

        // die if starveTurns = 3
        if (starveTurns >= 3)
            board[row][col] = null;
            //board = null;
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
                    board[row - 1][col] = new Doodlebug(board, row - 1, col);
                    addNumOfBleed();
                    resetTimeStep();
                }
                break;

            case 2:
                // top col = 0, bottom col = 19
                if (col != 19 && board[row][col + 1] == null) {
                    board[row][col + 1] = new Doodlebug(board, row, col + 1);
                    addNumOfBleed();
                    resetTimeStep();
                }
                break;

            case 3:
                // top col = 0, bottom col = 19
                if (col != 0 && board[row][col - 1] == null) {
                    board[row][col - 1] = new Doodlebug(board, row, col - 1);
                    addNumOfBleed();
                    resetTimeStep();
                }
                break;

            case 4:
                // top row = 0, bottom row = 19
                if (row != 19 && board[row + 1][col] == null) {
                    board[row + 1][col] = new Doodlebug(board, row + 1, col);
                    addNumOfBleed();
                    resetTimeStep();
                }
                break;
        }
    }
}
