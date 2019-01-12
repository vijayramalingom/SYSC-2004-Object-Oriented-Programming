/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * A class representing a square with neither a snake or ladder
 * @author vijay
 */
public class SnLSquare {
    /**
     * The number of the square
     */
     private int number;
     
     /**
     * Constructor initializing the square's number to number
     */
     public SnLSquare(int number) {
         this.number = number;
     }
     /**
     * Returns the square's number
     * @return  an int value representing the square's number
     */
     public int getNumber() {
         return this.number;
     }
     /**
     * Returns the square that the player will land 
     * @return  an int value representing the board number
     */
     public int landOn() {
         return this.number;
     }
     /**
     * returns a string that shows the number of the square
     * @return a string value that represents number and endsquare
     */
     @Override
     public String toString() {
         return "" + number;
     }
     /**
     * determines if two objects are equal
     * @return true if equal false if not 
     */
     @Override
     public boolean equals(Object o){
         if (o == this)
             return true;
         if (o == null)
             return false;
         if (this.getClass() != o.getClass())
             return false;
         SnLSquare c = (SnLSquare)o;
         return (this.number == c.number);
     }
}
