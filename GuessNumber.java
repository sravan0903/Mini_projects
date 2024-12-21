import java.util.Scanner;
import java.util.Random;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 5;
        int totalAttempts = 0;
        int rounds = 0;
	int win=0;
	int lose=0;

        boolean playAgain = true;

        while (playAgain) {
            System.out.println("===== New Round =====");
            int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;

            while (attempts < maxAttempts) {
                System.out.printf("Guess the number between %d and %d: ", lowerBound, upperBound);
                int guess = scanner.nextInt();
                scanner.nextLine(); // consume newline

                attempts++;

                if (guess < lowerBound || guess > upperBound) {
                    System.out.println("Please enter a number within the specified range.");
                    continue;
                }

                if (guess == secretNumber) {
                    System.out.printf("Congratulations! You've guessed the number %d correctly in %d attempts!\n",
                            secretNumber, attempts);
                    totalAttempts += attempts;
			win=win+1;
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (attempts >= maxAttempts) {
                System.out.printf("Sorry, you've exhausted all attempts. The number was %d.\n", secretNumber);
		lose=lose+1;
            }

            rounds++;

            System.out.print("Do you want to play again? (yes/no): ");
            String play = scanner.nextLine().toLowerCase();

            if (!play.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.printf("Thank you for playing! You played %d round(s) and took %d attempts in total.\n", rounds,
                totalAttempts);
	System.out.printf("Total rounds won=%d\n",win);
	System.out.printf("Total rounds lose=%d\n",lose);
        scanner.close();
    }
}
