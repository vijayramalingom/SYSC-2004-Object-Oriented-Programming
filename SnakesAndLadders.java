/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * A class representing a game of snakes and ladders
 * @author vijay
 */
import java.util.Scanner; 
public class SnakesAndLadders {
     /**
     * The number of players playing
     */
    public static int NUM_PLAYERS;
     /**
     * The number of the squares on the board
     */
    public static final int NUM_SQUARES = 100;
     /**
     *The types of squares on each board number
     */
    private SnLSquare[] board;
     /**
     * The position of each player
     */
    private int[] players;
     /**
     * The dice
     */
    private Dice dice;
    /**
     * Default constructor initializing the board with 100 squares, 2 players
     * starting at 1 and 2 dice
     */
    public SnakesAndLadders() {
        this.board = new SnLSquare[100];
        for(int i = 0; i < 100; i++)
            this.board[i] = new SnLSquare(i + 1);
        this.board[3] = new LadderSquare(4, 14);
        this.board[8] = new LadderSquare(9, 31);
        this.board[19] = new LadderSquare(20, 38);
        this.board[27] = new LadderSquare(28, 84);
        this.board[39] = new LadderSquare(40, 59);
        this.board[62] = new LadderSquare(63, 81);
        this.board[70] = new LadderSquare(71, 91);
        this.board[16] = new SnakeSquare(17, 7);
        this.board[53] = new SnakeSquare(54, 34);
        this.board[61] = new SnakeSquare(62, 18);
        this.board[63] = new SnakeSquare(64, 60);
        this.board[86] = new SnakeSquare(87, 24);
        this.board[92] = new SnakeSquare(93, 73);
        this.board[94] = new SnakeSquare(95, 75);
        this.board[98] = new SnakeSquare(99, 78);
        NUM_PLAYERS = 2;
        this.players = new int[NUM_PLAYERS];
        this.players[0] = 1;
        this.players[1] = 1;
        this.dice = new Dice();
    }
     /**
     * Constructor initializing the board with 100 squares, nPlayers players
     * starting at 1 and 2 dice
     */
    public SnakesAndLadders(int nPlayers) {
        this.board = new SnLSquare[100];
        for(int i = 0; i < 100; i++)
            this.board[i] = new SnLSquare(i + 1);
               this.board[3] = new LadderSquare(4, 14);
        this.board[8] = new LadderSquare(9, 31);
        this.board[19] = new LadderSquare(20, 38);
        this.board[27] = new LadderSquare(28, 84);
        this.board[39] = new LadderSquare(40, 59);
        this.board[62] = new LadderSquare(63, 81);
        this.board[70] = new LadderSquare(71, 91);
        this.board[16] = new SnakeSquare(17, 7);
        this.board[53] = new SnakeSquare(54, 34);
        this.board[61] = new SnakeSquare(62, 18);
        this.board[63] = new SnakeSquare(64, 60);
        this.board[86] = new SnakeSquare(87, 24);
        this.board[92] = new SnakeSquare(93, 73);
        this.board[94] = new SnakeSquare(95, 75);
        this.board[98] = new SnakeSquare(99, 78);
        NUM_PLAYERS = nPlayers;
        this.players = new int[NUM_PLAYERS];
        for (int i = 0; i < NUM_PLAYERS; i++)
            players[i] = 1;
        this.dice = new Dice();
    }
    /**
     * Makes player taker their turn
     * @return true if double was rolled false if not
     */
    public boolean takeTurn(int player) {
        this.players[player] = this.players[player] + this.dice.roll();
        System.out.println("Player " + player + " has rolled " + this.dice.toString());
        if (this. players[player] > 100)
            this. players[player] = 100 - (this.players[player] - 100);
        this.players[player] = this.board[this.players[player] - 1].landOn();
        int [] dieArray = this.dice.getDieValues();
        if ((dieArray[0] == dieArray[1]) && (this.players[player] != 100))
            return true;
        return false;
    }
    /**
     * checks if player is the winner
     * @return  true if player is on square 100 false if not
     */
    public boolean isPlayerWinner(int player) {
        if (this.players[player] == 100)
            return true;
        return false;
    }
    /**
     * Finds which player has won
     * @return  an int value representing the players who has won or -1 if no
     * players have won
     */
    public int getWinner() {
        for(int i = 0; i < NUM_PLAYERS; i++) {
            if (this.players[i] == 100)
                return i;
        }
        return -1;
    }
    /**
     * Returns player's position
     * @return  an int value representing the player's position
     */
    public int getPlayerPosition(int player) {
        return this.players[player];
    }
    /**
     * Prints the board
     * @return  a string representing the board
     */
    public String toString(){
        String c = "";
        for (int i = 0; i < 100; i++) {
            c = c + "| " + this.board[i].toString() + " ";
            if (this.board[i].getNumber() % 10 == 0)
                c = c + '\n';
        }
        return c;
    }
    /**
     * prints the players current positions 
     * @return  an string value representing the player's positions
     */
    public String toStringCurrentPositions() {
        String currentPositions = "";
        for (int i = 0; i < NUM_PLAYERS; i++)
            currentPositions = currentPositions + i + ":" + this.players[i] + " ";
        return currentPositions;
    }
    /**
     * Simulates a game 
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the amount of players playing");
        int nPlayers = sc.nextInt();
        SnakesAndLadders game = new SnakesAndLadders(nPlayers);
        System.out.println(game.toString());
        int i = 0;
        while(i > -1) {
            System.out.println("Player " + i + " turn");
            System.out.println("Player " + i + " current position: " + game.getPlayerPosition(i));
            while (game.takeTurn(i)){
                System.out.println("Player " + i + " moved to: " + game.getPlayerPosition(i));
                System.out.println("Player " + i + " rolled a double. Take another turn");
            }
            System.out.println("Player " + i + " moved to: " + game.getPlayerPosition(i));
            System.out.println(game.toStringCurrentPositions());
            if(game.isPlayerWinner(i)){
                System.out.println("Player " + game.getWinner() + " has won!");
                i = -1;
            }
            else {
                if (i == nPlayers - 1)
                    i = 0;
                else
                    i++;
            }
        }
    }
}

