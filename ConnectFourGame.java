
import java.util.Observable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *All the information in the connect four game
 * @author vijay
 */
public class ConnectFourGame extends Observable {
    /**
     * Dimensions of Grid
     */
    private int nRows, nColumns;
    /**
     * Number of adjacent checkers to be a winner (Must be less than dimensions)
     */
    private int numToWin;
    /**
     * // EMPTY, X or O
     */
    private ConnectFourEnum grid[][];
    /**
     * // X or O
     */
    private ConnectFourEnum turn;
    /**
     * In progress, red, black or draw
     */
    private ConnectFourEnum gameState;
    /**
     * Number of plays made. Used to detect full grid
     */
    private int nMarks;
    
    /**
     * Default Constructor rows and columns equals 8, numtowin equals 4
     * @param initialTurn determines if red or black starts
     */
    public ConnectFourGame(ConnectFourEnum initialTurn) {
        this.nRows = 8;
        this.nColumns = 8;
        this.numToWin = 4;
        this.grid = new ConnectFourEnum [this.nRows][this.nColumns];
        reset(ConnectFourEnum.BLACK);
    }
    /**
     * Another constructor
     * @param nRows rows of board
     * @param nColumns columns of board
     * @param numToWin number of tiles in a row to win
     * @param initialTurn determines if red or black starts
     */
    public ConnectFourGame(int nRows, int nColumns, int numToWin, ConnectFourEnum initialTurn) {
        if (nRows < 0 || nColumns < 0) 
            throw new IllegalArgumentException("Grid must be a positive size");
        if (numToWin > nRows || numToWin > nColumns) 
            throw new IllegalArgumentException("sizeToWin must be less than dimensions");
        this.nRows = nRows;
        this.nColumns = nColumns;
        this.numToWin = numToWin;
        this.grid = new ConnectFourEnum[nRows][nColumns];
        reset(initialTurn);
    }
    
    /**
     * Resets the board
     * @param initialTurn determines if red or black starts
     */
    public void reset(ConnectFourEnum initialTurn) {
        for (int r=0;r<nRows; r++) {
            for (int c=0; c<nColumns; c++) {
                this.grid[r][c] = ConnectFourEnum.EMPTY;
            }
        }
        this.turn = initialTurn;
        this.nMarks = 0;
        this.gameState = ConnectFourEnum.IN_PROGRESS;
    }
    
    /**
     * Determines if turn can be taken and takes turn if possible
     * @param    row      Where checker is to be added
     * @param    column   Where checker is to be added
     * @return   gateState = {IN_PROGRESS, RED, BLACK, DRAW} 
     * @throws   IllegalArgumentException is the <row,column> is out of range,
     *           or if the location is not adjacent to a filled lower spot
     */
    public ConnectFourEnum takeTurn(int row, int column)  {
        if (this.gameState != ConnectFourEnum.IN_PROGRESS) 
            throw new IllegalArgumentException("Game Over. No more plays");
        if (row < 0 || row > this.nRows) 
            throw new IllegalArgumentException("Grid is " + this.nRows + " by " + this.nColumns);
        if (column < 0 || column > this.nColumns) 
            throw new IllegalArgumentException("Grid is " + this.nRows + " by " + this.nColumns);        
        if (this.grid[row][column] != ConnectFourEnum.EMPTY) 
            throw new IllegalArgumentException("Location is already full");
        if ((row != 0) && (this.grid[row - 1][column] == ConnectFourEnum.EMPTY)) 
            throw new IllegalArgumentException("Location is not occupied underneath");
        this.grid[row][column] = this.turn;
        this.setChanged();
        this.notifyObservers(new ConnectMove(row, column, this.turn));
        this.nMarks++;
        
        if (this.turn == ConnectFourEnum.BLACK)
            this.turn = ConnectFourEnum.RED;
        else
            this.turn = ConnectFourEnum.BLACK;
        
        this.gameState = findWinner(row, column);
        return this.gameState;
        
    }
    
    /**
     * Tries to find the winner if there is one
     * @param row row from which the method searches
     * @param column column from which the method searches
     * @return winner draw or in progress
     */
    private ConnectFourEnum findWinner(int row, int column) {
        ConnectFourEnum newGameState;
        if (grid[row][column] != ConnectFourEnum.EMPTY) {
            newGameState = findWinnerFrom(row,column);
            if (newGameState != ConnectFourEnum.IN_PROGRESS) 
                return newGameState;
        }
        if (nMarks == this.nRows * this.nColumns) {
            return ConnectFourEnum.DRAW;
        }  
        return ConnectFourEnum.IN_PROGRESS;
    }
    
    /** An internal (private) method that looks for the winner, starting
     *  from a given location.  A winner is a horizontal or vertical row
     *  starting from the given location. Diagonals are not implemented.
     *  Interested students are encouraged to complete it.
     * 
     * Hence the method being made private. The method is used for readability.
     * @param    row      Where to start search
     * @param    column   Where to start search
     * @return   IN_PROGRESS, X_WON, 0_WON, DRAW 
     */
    private ConnectFourEnum findWinnerFrom(int row, int column) {
       
        // Look horizontally - left than right
        
        int count;
        
        count = 1;
        for (int c = column-1; c > 0; c--) {
            if (this.grid[row][column] == this.grid[row][c]) {
                count++;
                if (count == this.numToWin) {
                    return grid[row][column];
                }
            } // else, look in another direction
        }
        
        count = 1;
        for (int c = column+1; c < this.nColumns; c++) {
            if (this.grid[row][column] == this.grid[row][c]) {
                count++;
                if (count == this.numToWin) {
                    return grid[row][column];
                }
            } // else, look in another direction
        }
    
        // Look vertically - up then down
        count = 1;
        for (int r = row-1; r > 0; r--) {
            if (this.grid[r][column] == this.grid[row][column]) {
                count++;
                if (count == this.numToWin) {
                     return grid[row][column];
                }
            } // else, look in another direction
        }
        
        count = 1;
        for (int r = row+1; r < this.nRows; r++) {
            if (this.grid[row][column] == this.grid[r][column]) {
                count++;
                if (count == this.numToWin) {
                    return grid[row][column];
                }
            } // else, look in another direction
        }        
        
        // Look diagonally - Left-down - TBD
        
        // Look diagonally - Right-down - TBD
      
        return ConnectFourEnum.IN_PROGRESS;
    }
    
    /**
     * finds out who's turn it is
     * @return black or red
     */
    public ConnectFourEnum getTurn() {
        return this.turn;
    }
    /**
     * finds out the state of the game
     * @return black, red, draw or in progress
     */
    public ConnectFourEnum getGameState() {
        return this.gameState;
    }
    
    /**
     * returns the value of the specified point on the grid
     * @param i index value 1
     * @param j index value 2
     * @return 
     */
    public ConnectFourEnum getGridValue(int i, int j) {
        return grid[i][j];
    }
    
    /**
     * prints out the board
     * @return string of the current board
     */
    public String toString() {
        String s = "";
        for (int r = nRows-1;r >= 0; r--) {
            for (int c=0; c < nColumns; c++) {
                s += grid[r][c] + " | ";
            }
            s += "\n";
        }
        return s;
    }
}