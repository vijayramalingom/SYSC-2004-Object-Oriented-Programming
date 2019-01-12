/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vijayramalingom
 */
public class DiceClient {
    
    public static void main (String[] args) {
        
        Dice dice = new Dice();
        int[] counter = {0, 0, 0, 0, 0, 0};
        String[] histogram = {"", "", "", "", "", ""};
        double averageRoll;
        double standardDeviation = 0;
        
        for(int i = 0; i < 2000; i++) {
            dice.roll();
            counter[(dice.getDieValues()[0]) - 1]++;
            if((counter[(dice.getDieValues()[0]) - 1]) % 10 == 0) {
                histogram[(dice.getDieValues()[0]) - 1] = histogram[(dice.getDieValues()[0]) - 1] + "*";
            }
            counter[(dice.getDieValues()[1]) - 1]++;
            if((counter[(dice.getDieValues()[1]) - 1]) % 10 == 0) {
                histogram[(dice.getDieValues()[1]) - 1] = histogram[(dice.getDieValues()[1]) - 1] + "*";
            }
        }
        averageRoll = ((double)((counter[0] * 1) + (counter[1] * 2) + (counter[2] * 3) + (counter[3] * 4) + (counter[4] * 5) + (counter[5] * 6)))/(double)(4000);
        double squareDiffSum = 0;
        for(int k = 0; k < 6; k++) {
        double diff = (k+1) - averageRoll;
        squareDiffSum += diff * diff * counter[k];
        }
        standardDeviation = squareDiffSum/4000;
        System.out.println("The average roll was " + averageRoll);
        System.out.println("The standard deviation of the rolls was " + standardDeviation);
        for(int j = 0; j < 6; j++){
            System.out.println(j + 1 + " (" + counter[j] + ") :" + histogram[j]);
        }
 }
    
}
