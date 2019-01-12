
import java.util.Scanner;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Client for language flash cards
 * @author vijayramalingom
 */
public class LanguageFlashCardApplication {
    
    public static void main(String args[]) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the filename containing your flashcards? Excact Letters!");
        String filename = scanner.next();
        LanguageFlashCards game = new LanguageFlashCards(filename);
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
