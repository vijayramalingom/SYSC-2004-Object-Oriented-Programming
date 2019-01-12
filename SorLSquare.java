/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * A class representing a square with a snake or ladder
 * @author vijay
 */
public class SorLSquare extends SnLSquare {
    /**
     * The number of the square that the snake or ladder ends on
     */
    private int endSquare;
    
     /**
     * Constructor initializing the board number to number and the endsquare to
     * endsquare
     */
    public SorLSquare(int number, int endSquare) {
        super(number);
        this.endSquare = endSquare;
        if (number == endSquare)
            throw new IllegalArgumentException("The number is the same as the end square.");
    }
     /**
     * Returns the square that the player will land on after hitting the snake or ladder
     * @return  an int value representing the board number
     */
    public int getEndSquare() {
        return this.endSquare;
    }
     /**
     * Returns the square that the player will land on after hitting the snake
     * @return  an int value representing the board number
     */
    public int landOn() {
        return this.endSquare;
    }
     /**
     * returns a string that shows the number of square with the ladder or snake and
     * the end square
     * @return a string value that represents number and endsquare
     */
    public String toString() {
        return super.toString() + ":" + this.endSquare;
    }
     /**
     * determines if two objects are equal
     * @return true if equal false if not 
     */
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        SorLSquare c = (SorLSquare)o;
        return (super.equals(c) && (this.endSquare == c.endSquare));
    }
}
