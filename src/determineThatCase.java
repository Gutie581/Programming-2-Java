// Challenge 03 - Daniel Gutierrez - KEA418 - 09/15/24

// import required for JOptionPane
import javax.swing.JOptionPane;

public class determineThatCase
{
    public static void main(String[] args)
    {
        // Get input from user.
        String input = JOptionPane.showInputDialog("Please enter an alphabetical character: ");

        //The variable letter will hold the character inputted.
        char letter = input.charAt(0);

        //Uses the string comparison method to determine character values.
        if (Character.isUpperCase(letter))
        {
            JOptionPane.showMessageDialog(null,"The letter is UPPERCASE.");
        }
        else if (Character.isLowerCase(letter))
        {
            JOptionPane.showMessageDialog(null,"The letter is lowercase.");
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Invalid input. I cannot determine the case of " +
                    "a value other than an alphabetical character. Please try again.");
        }

        // Ends the program
        System.exit(0);
    }
}
