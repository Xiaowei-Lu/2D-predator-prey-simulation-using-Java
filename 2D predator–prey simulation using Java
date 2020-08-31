/*
 * Organism.java
 */

package Critters;

/**
 * CS5004 Assignment 7: Problem 1 - Organism
 * This class serves to define Organism, Ant and Doodlebug
 *
 * @author Xiaowei Lu
 * @since 2020-06-28
 */
public abstract class Organism {

    // declare instance variables
    private Organism[][] board;
    private int row;
    private int col;
    private int timeStep;
    private int numOfBleed;
    private boolean canMove;
    private boolean ableMove;
    private boolean ableBleed;


    // constructor with three arguments
    public Organism(Organism[][] board, int row, int col) {
        this.board = board;
        this.row = row;
        this.col = col;
        timeStep = 0;
        numOfBleed = 0;
        canMove = false;
        ableMove = false;
        ableBleed = false;
    }

    // default constructor
    public Organism() {
        this.board = null;
        this.row = -1;
        this.col = -1;
        timeStep = 0;
        numOfBleed = 0;
        canMove = false;
        ableMove = false;
        ableBleed = false;
    }

    // copy constructor
    public Organism(Organism other) {
        this.board = other.board;
        this.row = other.row;
        this.col = other.col;
        timeStep = 0;
        numOfBleed = 0;
        canMove = false;
        ableMove = false;
        ableBleed = false;
    }

    public Organism[][] getBoard() {
        return board;
    }
    public void setBoard(Organism[][] board) {
        this.board = board;
    }
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    }

    // add timeStep
    public void addTimeStep() {
        timeStep ++;
    }
    // reset timeStep
    public void resetTimeStep() {
        timeStep = 0;
    }
    public int getTimeStep() {
        return timeStep;
    }
    public void setTimeStep(int timeStep) {
        this.timeStep = timeStep;
    }

    public int getNumOfBleed() {
        return numOfBleed;
    }
    public void setNumOfBleed(int numOfBleed) {
        this.numOfBleed = numOfBleed;
    }
    public void addNumOfBleed() {
        numOfBleed ++;
    }

    public boolean isCanMove() {
        return canMove;
    }
    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }

    public boolean isAbleMove() {
        return ableMove;
    }
    public void setAbleMove(boolean ableMove) {
        this.ableMove = ableMove;
    }
    public boolean isAbleBleed() {
        return ableBleed;
    }
    public void setAbleBleed(boolean ableBleed) {
        this.ableBleed = ableBleed;
    }

    //abstract methods vary between Ant and Doodlebug
    public abstract void move();
    public abstract void breed();
}
