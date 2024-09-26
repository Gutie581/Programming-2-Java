// Challenge 05 - Daniel Gutierrez - KEA418 - 9/26/2024

import javax.swing.*;
import java.util.*;


public class RockPaperScissorGame {
    public static void main(String[] args)
    {
        // While loop in the main method to process other methods.
        while (true)
        {
            // Calls other methods as int and strings. Passes the computerChoice integer argument to convertChoice
            // method to convert the computer's random number selection to a string. Each stored as variables.
            int computerChoice = getComputerChoice();
            String userChoice = getUserChoice();
            String computerChoiceAsString = convertChoices(computerChoice);

            // Computers option is displayed after the user's choice.
            JOptionPane.showMessageDialog(null, "Computer selected: " + computerChoiceAsString);

            // Passes 2 arguments to the determineWinner method to compare choices and assigned 'results' variable.
            String results = determineWinner(userChoice, computerChoiceAsString);

            // Displays what the determineWinner method returned to the results variable.
            JOptionPane.showMessageDialog(null, results);

            // If the results don't equal each other, then breaks out of the while loop and ends the game.
            // If they do equal each other, displays message. Ends game.
            if (!results.equals("It's a draw! Try again to see who wins!"))
            {
                break;
            }
        }
    }

    // Method to get the computers random choice from 1 to 3.
    public static int getComputerChoice() {
        Random randomNumber = new Random();
        return randomNumber.nextInt(3) + 1;
    }

    // Request users input and converts input to lowercase.
    // Compares if input is valid. If invalid, asks for user input again.
    public static String getUserChoice() {
        String choice;
        while (true) {
            choice = JOptionPane.showInputDialog("Select an option: Rock, Paper, or Scissors");
            choice = choice.toLowerCase();

            // Uses logical operator OR to allow each option.
            if (choice.equals("rock") || choice.equals("paper") || choice.equals("scissors")) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid option, please try again.");
            }
        }
        // Returns choice user input to main method that calls it which stores it as 'userChoice' variable.
        return choice;
    }
    // Uses an enhanced switch statement to convert computer's random number to a string option.
    // Uses an integer parameter named choice to hold the value. Then returns the corresponding string.
    public static String convertChoices(int choice) {
        return switch (choice) {
            case 1 -> "rock";
            case 2 -> "paper";
            case 3 -> "scissors";
            default -> "";
        };
    }

    // Method to compare the strings userChoice and computerChoice as the parameters.
    public static String determineWinner(String userChoice, String computerChoice)
    {
        // If the choices are equals, displays the tie message.
        if (userChoice.equals(computerChoice))
        {
            return "It's a tie! Both chose: " + computerChoice;
        }
        // If the userChoice selects a certain option, using the logical operator AND the computerChoice
        // equals a specific option then it will display the user as the winner.
        else if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
        (userChoice.equals("scissors")) && computerChoice.equals("paper") ||
        (userChoice.equals("paper") && computerChoice.equals("rock")))
        {
            return userChoice + " beats " + computerChoice + "\nYou win! Congratulations!";
        }
        // If other than tie or user as winner options appear, then returns the computer as the winner.
        else
        {
            return computerChoice + " beats " + userChoice + "\nYou lose!";
        }
    }
}



