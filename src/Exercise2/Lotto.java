package Exercise2;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;


//Vanessa Victorino - 301201653
//COMP228 - Lab #2 - Exercise 2
public class Lotto {
    /*
     * Design a Lotto class with one array instance variable to hold three random
     * integer values (from 1 to 9). Include a constructor that randomly populates
     * the array for a lotto object. Also, include a method in the class to return
     * the array.
     *
     * Use this class to simulate a simple lotto game in which the user chooses a
     * number between 3 and 27. The user runs the lotto up to 5 times and each time
     * the sum of lotto numbers is calculated. If the number chosen by the user
     * matches the sum, the user wins and the game ends. If the number does not
     * match the sum within five rolls, the computer wins.
     */

    public Lotto() {

        Random random = new Random();

        List<Integer> winningNumbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            while (true) {
                int winningNumber = random.nextInt();
                if (winningNumber >= 3 && winningNumber <= 27) {
                    if (!winningNumbers.contains(winningNumber)) {
                        winningNumbers.add(winningNumber);
                        break;
                    }
                }
            }
            //System.out.println(winningNumbers);
        }

        List<Integer> guessedNumbers = new ArrayList<>();
        int guessSum = 0;

        for (int num = 0; num < 5; num++) {
            int total = 5;
            while (true) {
                try {
                    String userInput = JOptionPane.showInputDialog(null, "Match 3 winning numbers between 3 and 27.\n  You have " + (total -= num) + " try! \n Matched number: " + guessedNumbers);
                    int number = Integer.parseInt(userInput);
                    if (number >= 3 && number <= 27) {
                        if (!guessedNumbers.contains(number))//remove duplicate in the list
                            guessedNumbers.add(number);
                        guessedNumbers.retainAll(winningNumbers);
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Sorry! " + number + " is not between 3 and 27. Please try again.");
                    }

                } catch (NumberFormatException nfe) {

                    JOptionPane.showMessageDialog(null, "It has to be a number or cannot be empty field. Please try again.");
                }
                int quitGame = JOptionPane.showConfirmDialog(null, "Do you want to close the application?");
                if (quitGame == 0) {
                    System.exit(0);
                }
            }

            guessSum = 0;
            for (Integer guessedNumber : guessedNumbers) {
                guessSum += guessedNumber;
            }
        }
        JOptionPane.showMessageDialog(null, "The winning numbers: " + winningNumbers + "\n Your numbers: " + guessedNumbers);
        guessedNumbers.retainAll(winningNumbers);

        int winSum = 0;
        for (Integer winningNumber : winningNumbers) {
            winSum += winningNumber;
        }
        if (guessSum < winSum) {
            JOptionPane.showInternalMessageDialog(null, "How unfortunate!");
        }
        JOptionPane.showMessageDialog(null, "Your matched numbers: " + guessedNumbers + "\n\n Total sum for winning numbers: " + winSum + "\n Total sum for your number: " + guessSum);

        if ((guessedNumbers).containsAll(winningNumbers)) {
            JOptionPane.showMessageDialog(null, "You won! That's amazing!");
        }else {
            JOptionPane.showMessageDialog(null, "You lost! Better luck next time.");
        }
    }
}
