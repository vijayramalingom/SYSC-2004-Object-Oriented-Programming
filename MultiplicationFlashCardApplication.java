import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Client for multiplication flash cards
 * @author vijayramalingom
 */
public class MultiplicationFlashCardApplication {
    
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[4];
        System.out.println("Which times tables would you like to test? (Between 1 and 12 inclusive)");
        array[0] = scanner.nextInt();
        array[1] = scanner.nextInt();
        array[2] = scanner.nextInt();
        array[3] = scanner.nextInt();
        MultiplicationFlashCards game = new MultiplicationFlashCards(array);
        String userInput = "y";
        while (userInput.equals("y")) {
            if(game.nextCard()){
                game.getScore();
                System.out.println("Next? (Y or N)");
                userInput = scanner.next();
            }
            else {
                System.out.println("You have answered all the cards!");
                userInput = "n";
            }
        }
        game.getScore();
    }
}