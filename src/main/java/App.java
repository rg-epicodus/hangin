import game.Hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Guest on 8/2/17.
 */
public class App {
    public static void main(String[] args) {
        boolean gameRunning =true;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            Hangman hangman = new Hangman();
            hangman.pickFirstWord();
            hangman.getDashed();
            System.out.println("Select difficulty: easy, medium, hard");
            int tries = 0;
            String turns = bufferedReader.readLine().toLowerCase();
            System.out.println(hangman.getDashedWord());
            System.out.println("Let's play Hangman, please enter a letter.");
            String usedletters = bufferedReader.readLine().toLowerCase();
            hangman.searchLetter(usedletters);
            System.out.println(hangman.getDashedWord());
            if(turns.equals("hard")){
                tries = 5;
            }else if(turns.equals("medium")){
                tries = 10;
            }else if(turns.equals("easy")){
                tries = 15;
            }
            int guess= 1;
            System.out.println("How many Guesses Left: "+(tries-guess));


            while (gameRunning){

                if(hangman.solvedGame(hangman.getDashedWord())){
                  System.out.println("Congratulations, you've solved it. The word is "+ hangman.getDashedWord()+"!");
                  gameRunning = false;
              }else if (guess == tries){
                  System.out.println("Your guessing skills are hot garbage!");
                  gameRunning = false;
              }else{
                  System.out.println("Please enter another letter.");
                  String usedletters2 = bufferedReader.readLine().toLowerCase();
                  hangman.searchLetter(usedletters2);
                  System.out.println(hangman.getDashedWord());
                    guess ++;
                    System.out.println("How many Guesses Left: "+(tries-guess));

              }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
