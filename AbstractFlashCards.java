
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This is an abstract class that represents any type of flash card
 * @author vijayramalingom
 */
public abstract class AbstractFlashCards {
    /**
     * stores all the inputed flash cards questions and answers
     */
    private HashMap<String, String> flashCards;
    /**
     * stores all the unanswered questions
     */
    private ArrayList<String> unansweredCards;
    /**
     * stores the players score
     */
    private int score;
    /**
     * used for user inputs
     */
    private Scanner scanner;
    /**
     * used to generate random integers
     */
    private Random random;
    
    /**
     * Default constructor
     */
    public AbstractFlashCards() {
        this.flashCards = new HashMap<>();
        this.unansweredCards = new ArrayList<>();
        this.score = 0;
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }
    /**
     * Adds a card with the question and answer
     * @param question
     * @param answer 
     */
    protected void addCard(String question, String answer) {
        this.flashCards.put(question, answer);
        this.unansweredCards.add(question);
        this.reset();
    }
    /**
     * resets the order of unanswered questions
     */
    public void reset() {
        String array[] = this.unansweredCards.toArray(new String[this.unansweredCards.size()]);
        this.unansweredCards.clear();
        for(int i = 0; i < array.length; i++){
            String temp = array[i];
            int randomIndex = this.random.nextInt((array.length));
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
        for (int i = 0; i < array.length; i++)
            this.unansweredCards.add(array[i]);
    }
    /**
     * returns true if there is an unanswered question false if not
     * @return 
     */
    public boolean hasNext() {
        if(this.unansweredCards.isEmpty())
            return false;
        return true;
    }
    /**
     * determines if the players answer was correct returns hasnext
     * @return 
     */
    public boolean nextCard() {
        System.out.println(this.unansweredCards.toString());
        if(this.hasNext()) {
            System.out.println(this.unansweredCards.get(0));
            String answer = this.scanner.next();
            if(answer.equals(this.flashCards.get(this.unansweredCards.get(0)))) {
                System.out.println("You're correct!");
                this.unansweredCards.remove(0);
                this.score++;
            }
            else {
                System.out.println("Sorry, please try again");
                this.unansweredCards.add(random.nextInt(this.unansweredCards.size() - 1), this.unansweredCards.get(0));
                this.unansweredCards.remove(0);
            }
        }
        
        return this.hasNext();
    }
    /**
     * returns the players score
     * @return 
     */
    public int getScore() {
        System.out.println("Score = " + this.score);
        return this.score;
    }
}
