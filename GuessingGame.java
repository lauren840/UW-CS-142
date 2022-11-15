/* Lauren Kim, 07/23/2021
Assignment #5 Guessing Game: This program runs a number guessing game. It generates a random integer 
and accepts guesses from the user, giving hints of "higher" or "lower". It then displays the game's results. */
import java.util.*;
public class GuessingGame { 
   public static final int MAX = 100;
    
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      Random rand = new Random();
      int guess1 = 0;  //number of guesses for one game
      boolean test = true;
      int gameTotal = 0; 
      int guessTotal = 0; 
      int currentBestGame = -1; 
      haiku();
      
      /* While the test is true (if user inputs a string starting with a "y", regardless of 
      capitals, then another game will begin. */
      while (test) {
         guess1 = game1(console, rand);
         test = repeat(console);
         gameTotal++;
         guessTotal = guessTotal + guess1;
         currentBestGame = bestGame(guess1, currentBestGame);
      } 
      results (gameTotal, guessTotal, currentBestGame);
   }
   
   // Method for haiku intro message 
   public static void haiku() {
      System.out.println("A mystery lies");
      System.out.println("in this game. What's the number?"); 
      System.out.println("Guess to discover.");
      System.out.println();
   }
   
   /* Method to play one game with the user. Creates a random number and prompts user to guess.
   Returns int counter, which keeps track of the number of guesses during the game. */   
   public static int game1(Scanner console, Random rand) {
      int n = rand.nextInt(MAX) + 1; 
      int counter = 0; 
      System.out.println("I'm thinking of a number between 1 and " + MAX + "..."); 
      System.out.print("*** HINT: The answer is " + n); 
      int guess = -1;
      
      /* While guess is wrong, prompt user for another guess. If statements hint user based on if 
      guess was higher or lower than the generated random number. */ 
      while (guess != n) {
         System.out.println();
         System.out.print("Your guess? "); 
         guess = console.nextInt();
         if (guess < n) {
            System.out.print("It's higher."); 
         } 
         if (guess > n) {
            System.out.print("It's lower."); 
         } 
         counter++; 
      } 
          
      if (counter == 1) {
         System.out.println("You got it right in " + counter + " guess!");   
      } else { 
         System.out.println("You got it right in " + counter + " guesses!"); 
      }
      return counter;
   }
   
   /* Method to return boolean depending on user input. If recieved a string that starts with a 
   "y" regardless of capitals, boolean will return true. */
   public static boolean repeat(Scanner console) {
      System.out.print("Do you want to play again? "); 
      String newGame = console.next(); 
      newGame = newGame.toLowerCase();
      System.out.println(); 
      return (newGame.startsWith("y")); 
  }
   
   /* Method to calculate the best game (fewest guesses needed to solve any one game). Returns int 
   currentBestGame to be passed as a parameter in results method. */
   public static int bestGame(int guess1, int currentBestGame) {
   
      // if currentBestGame is -1 or currentBestGame is greater than counter, then reassign currentBestGame to counter. 
      if (currentBestGame == -1 || currentBestGame > guess1) {      
         currentBestGame = guess1; 
      }
      return currentBestGame;  
   }

  /* Method passes int gameNum, guessNum, and currentBestGame as parameters (initialized in main) to calculate and display 
   the number of games, total guesses made in all games, average number of gueses per game, and the best game. */
   public static void results(int gameTotal, int guessTotal, int currentBestGame) {
      double avg = guessTotal / gameTotal;
      System.out.println("Overall results:");
      System.out.println("Total games   = " + gameTotal); 
      System.out.println("Total guesses = " + guessTotal);
      System.out.printf("Guesses/game  = %.1f ", avg); 
      System.out.println();
      System.out.println("Best Game     = " + currentBestGame);
   }   
}