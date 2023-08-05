import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 5; // Maximum number of attempts allowed
    private static final int RANGE_MIN = 1; // Minimum range for the random number
    private static final int RANGE_MAX = 100; // Maximum range for the random number

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int secretNumber = random.nextInt(RANGE_MAX - RANGE_MIN + 1) + RANGE_MIN;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between " + RANGE_MIN + " and " + RANGE_MAX + ".");

        boolean gameWon = false;
        int attempts = 0;

        while (!gameWon && attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            scanner.nextLine();

            attempts++;

            if (guess == secretNumber) {
                gameWon = true;
                score = MAX_ATTEMPTS - attempts + 1;
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
            } else if (guess < secretNumber) {
                System.out.println("Wrong guess! The secret number is higher.");
            } else {
                System.out.println("Wrong guess! The secret number is lower.");
            }
        }

        if (!gameWon) {
            System.out.println("Game over! You have used all your attempts.");
            System.out.println("The secret number was: " + secretNumber);
        }

        System.out.println("Your score: " + score);

        scanner.close();
    }
}
