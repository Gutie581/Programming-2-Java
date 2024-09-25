/*
Rock, Paper, Scissor Game

Write a program that lets the user play the game of Rock, Paper, Scissors against the computer.  The program should work as follows:

1. When the program begins, a random number in the range of 1 through 3 is generated.  If the number is 1, then the computer has chosen rock.  If the number is 2, then the computer has chosen paper.  If the number is 3, then the computer has chosen scissors.  (DO NOT DISPLAY THE COMPUTERS CHOICES YET).

2. The user enters their choice of "rock", "paper", or "scissors" at the keyboard.  (You can use a menu if you prefer).

3. The computer's choice is displayed.

4. A winner is selected according to the following rules:

If one player chooses rock and the other player chooses scissors, then rock wins.
If one player chooses scissors and the other chooses paper, then scissors wins.
If one player chooses paper and the other chooses rock, then paper wins.
If both players make the same decision, then the game must be played again to determine the winner.
Be sure to divide the program into methods that perform each major task




 */

import javax.swing.*;
import java.util.*;

public class RockPaperScissorGame
{
    public static void main(String[] args)
    {
        while (true);
        {
         int computerChoice = getComputerChoice();
         String userChoice = getUserChoice();


         String results = winner();





        }






    }

    // Method to get the computers random choice from 1 to 3
    public static int getComputerChoice()
    {
        Random randomNumber = new Random();

        return random = randomNumber.nextInt(3) + 1;

    }

    public static String getUserChoice()
    {
        while (true)
        {
            String choice;
            choice = JOptionPane.showInputDialog("Select an option: Rock, Paper, or Scissors");

            if (choice.equals("Rock") || choice.equals("Paper") || choice.equals("Scissors"))
            {
                break;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Invalid choice, please try again.");
            }

        }
        return choice;

    }

    public static String convertChoices(int choice)
    {





    }




    public static String winner(String x, String y)
    {









    }












}
