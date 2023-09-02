import javax.swing.*;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 3;
        int rounds = 3;
        int totalScore = 0;

        for (int round = 1; round <= rounds; round++) {
            int targetNumber = generateRandomNumber(lowerBound, upperBound);
            int attempts = 0;
            boolean guessedCorrectly = false;

            JOptionPane.showMessageDialog(null, "Welcome to Round " + round + " of Number Guessing Game!" +
                    "\nYou have " + maxAttempts + " attempts to guess the number between " + lowerBound + " and " + upperBound + ".");

            while (attempts < maxAttempts) {
                String input = JOptionPane.showInputDialog("Attempt " + (attempts + 1) + "/" + maxAttempts +
                        "\nEnter your guess:");
                try {
                    int userGuess = Integer.parseInt(input);

                    if (userGuess < lowerBound || userGuess > upperBound) {
                        JOptionPane.showMessageDialog(null, "Please enter a number between " + lowerBound + " and " + upperBound + ".");
                        continue;
                    }

                    if (userGuess == targetNumber) {
                        guessedCorrectly = true;
                        break;
                    } else if (userGuess < targetNumber) {
                        JOptionPane.showMessageDialog(null, "Try a higher number.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Try a lower number.");
                    }

                    attempts++;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                }
            }

            if (guessedCorrectly) {
                int roundScore = maxAttempts - attempts;
                totalScore += roundScore;
                JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number " + targetNumber + " correctly in " + (attempts + 1) + " attempts." +
                        "\nRound " + round + " Score: " + roundScore);
            } else {
                JOptionPane.showMessageDialog(null, "Sorry, you've run out of attempts. The correct number was " + targetNumber + "." +
                        "\nRound " + round + " Score: 0");
            }
        }

        JOptionPane.showMessageDialog(null, "Game Over!\nTotal Score: " + totalScore);
    }

    private static int generateRandomNumber(int lowerBound, int upperBound) {
        Random random = new Random();
        return random.nextInt(upperBound - lowerBound + 1) + lowerBound;
    }
}
