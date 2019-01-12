/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Multiplication flash card class
 * @author vijayramalingom
 */
public class MultiplicationFlashCards extends AbstractFlashCards {
    /**
     * constructor for only one multiplication table
     * @param multiplier 
     */
    public MultiplicationFlashCards(int multiplier) {
        super();
        for (int i = 1; i <= 12; i++) {
            int product = multiplier * i;
            String question = multiplier + " * " + i;
            String answer = "" + product;
            this.addCard(question, answer);
        }
    }
    /**
     * constructor for multiple multiplication tables
     * @param multipliers 
     */
    public MultiplicationFlashCards(int[] multipliers) {
        super();
        for (int j = 0; j < multipliers.length; j++) {
            for (int i = 1; i <= 12; i++) {
                int product = multipliers[j] * i;
                String question = multipliers[j] + " * " + i;
                String answer = "" + product;
                this.addCard(question, answer);
            }
        }
    }
    
}
