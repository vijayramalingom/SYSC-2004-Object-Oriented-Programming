/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * A class representing a square with a snake
 * @author vijay
 */
public class SnakeSquare extends SorLSquare {
    /**
     * Constructor initializing the board number to number and the end square to
     * endsquare
     */
    public SnakeSquare(int number, int endsquare) {
        super(number, endsquare);
        if (super.getEndSquare() > super.getNumber())
            throw new IllegalArgumentException("The end square is higher than the number.");
    }
    /**
     * Returns the square that the player will land on after hitting the snake
     * @return  an int value representing the board number
     */
    public int landOn(){
        System.out.println("Oh no!");
        return super.landOn();
    }
    /**
     * returns a string that shows the number of square with the ladder and
     * the end square
     * @return a string value that represents number and endsquare
     */
    public String toString(){
        return "" + super.getNumber() + "-" + super.getEndSquare();
    }
}
/**
*Does not need an equals method because no new instance variables have been added
*Will be the same equals method as SorLSquare 
*/
