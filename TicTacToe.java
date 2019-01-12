/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vijayramalingom
 */
import java.util.Scanner;

public class TicTacToe {
    
    private int nRows;
    private int nColumns;
    private int numToWin;
    private char grid[][];
    private char turn;
    private TicTacToeEnum gameState;
    private int nMarks;
    
    public TicTacToe(char initialTurn) {
        this.nRows = 3;
        this.nColumns = 3;
        this.numToWin = 3;
        this.grid = new char[3][3];
        reset(initialTurn);
    }
    public TicTacToe(int nRows, int nColumns, int numToWin, char initialTurn) {
        if (nRows < 0 || nColumns < 0 || numToWin < 0) {
            throw new IllegalArgumentException("Cannot have inputs that are less than one.");
        }
        if (nRows < numToWin || nColumns < numToWin) {
            throw new IllegalArgumentException("Cannot have inputs that are less than one.");
        }
        this.nRows = nRows;
        this.nColumns = nColumns;
        this.numToWin = numToWin;
        this.grid = new char[nRows][nColumns];
        reset(initialTurn);
    }
    public void reset(char initialTurn){
        for(int i = 0; i < this.nRows; i++){
            for (int j = 0; j < this.nColumns; j++){
                this.grid[i][j] = ' ';
            }
        }
        this.turn = initialTurn;
        this.gameState = TicTacToeEnum.IN_PROGRESS;
        this.nMarks = 0;
    }
    
    public int getTurn() {
       return this.turn;
    }
   
    public TicTacToeEnum getGameState(){
        return this.gameState;
    }
    
    private TicTacToeEnum charToEnum(char player){
        if (player == 'X'){
            return TicTacToeEnum.X_WON;
        }
        if (player == 'O'){
            return TicTacToeEnum.O_WON;
        }
        throw new IllegalArgumentException("charToEnum("+player+"): player must be either X or O");
    }
    
    public TicTacToeEnum takeTurn(int row, int column) {
        if (this.gameState != TicTacToeEnum.IN_PROGRESS) 
            throw new IllegalArgumentException("Game is not in progress.");
        if (row < 0 || row > this.nRows || column < 0 || column > this.nColumns) 
            throw new IllegalArgumentException("Out of bounds");       
        if (this.grid[row][column] != ' ') 
            throw new IllegalArgumentException("Spot is already taken");
        this.grid[row][column] = this.turn;
        this.nMarks++;
        this.gameState = findWinner();
        return this.gameState;
    }
    private TicTacToeEnum findWinner() {
        for (int q = 0; q < this.nRows; q++) {
            for (int r = 0; r < this.nColumns; r++) {
                if (grid[q][r] != ' ') {
                     int winCounter = 1;
                     for (int s = r - 1; s > 0; s--) {
                        if (this.grid[q][r] == this.grid[q][s]) {
                            winCounter++;
                            if (winCounter == this.numToWin) {
                                return charToEnum(grid[q][r]);
                            }
                        } 
                    }
                    winCounter = 1;
                     for (int t = r + 1; t < this.nColumns; t++) {
                        if (this.grid[q][r] == this.grid[q][t]) {
                            winCounter++;
                            if (winCounter == this.numToWin) {
                                return charToEnum(grid[q][r]);
                            }
                        } 
                    }
                    winCounter = 1;
                    for (int u = q - 1; r > 0; r--) {
                        if (this.grid[q][r] == this.grid[u][r]) {
                            winCounter++;
                            if (winCounter == this.numToWin) {
                                return charToEnum(grid[q][r]);
                            }
                        } 
                    }
                    winCounter = 1;
                    for (int v = q + 1; v < this.nRows; v++) {
                        if (this.grid[q][r] == this.grid[v][r]) {
                            winCounter++;
                            if (winCounter == this.numToWin) {
                                return charToEnum(grid[q][r]);
                            }
                        } 
                    }
                }
            }
        }
        if (nMarks == this.nRows * this.nColumns) {
            return TicTacToeEnum.DRAW;
        }  
        return TicTacToeEnum.IN_PROGRESS;
    }
    
    public String toString() {
        String board = "";
        for (int o = 0;o < nRows; o++ ) {
            for (int p = 0; p < nColumns; p++) {
                board += grid[o][p] + " | ";
            }
            board += "\n";
        }
        return board;
    }
    
    public static void main(String args[]) {
        TicTacToe game = new TicTacToe('X');
        Scanner scanner = new Scanner(System.in);
        do {
        System.out.println(game.toString());
        System.out.println(game.getTurn() +
        ": Where do you want to mark? Enter row column");
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        scanner.nextLine();
        game.takeTurn(row, column);
        } 
        while (game.getGameState() == TicTacToeEnum.IN_PROGRESS);
        System.out.println( game.getGameState());

    }
    
}
