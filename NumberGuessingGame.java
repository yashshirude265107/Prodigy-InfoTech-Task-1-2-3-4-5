// A simple Guess the Number game built in Java, where the user tries to guess a randomly generated number between 1 and 100. The game provides hints after each guess and keeps track of the number of attempts.

/* Guess the Number Game in Java */

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        // Generate a random number between 1 and 100
        Random random = new Random();
        int targetNumber = random.nextInt(100) + 1;

        // Initialize variables
        int userGuess;
        int attempts = 0;

        // Create Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Guessing Game!");
        System.out.println("Try to guess the number between 1 and 100.");

        // Main game loop
        do {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > targetNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number!");
                System.out.println("Number of attempts: " + attempts);
            }
        } while (userGuess != targetNumber);

        // Close the scanner
        scanner.close();
    }
}
