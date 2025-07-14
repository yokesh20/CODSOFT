import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 5; // Number of attempts allowed per round
        int attempts = 0;
        int score = 0; // Count of rounds won
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between " + lowerBound + " and " + upperBound + ".");
        
        boolean playAgain = true;
        
        while (playAgain) {
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            attempts = 0;
            
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess < lowerBound || userGuess > upperBound) {
                    System.out.println("Please enter a number between " + lowerBound + " and " + upperBound + ".");
                    continue;
                }
                
                if (userGuess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else if (userGuess > targetNumber) {
                    System.out.println("Too high. Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number " + targetNumber + " correctly in " + attempts + " attempts.");
                    score++;
                    break;
                }
                
                if (attempts == maxAttempts) {
                    System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNumber);
                }
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            
            if (!playAgainResponse.equals("yes")) {
                playAgain = false;
            }
        }
        
        System.out.println("\nGame over. You won " + score + " round(s).");
        scanner.close();
    }
}

