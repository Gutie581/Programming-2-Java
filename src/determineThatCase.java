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

        // Displays output message in an if, else-if, else statement.
        String message;

        //Uses relational operators to determine relationship between multiple character values.
        if (letter >= 'A' && letter <= 'Z')
        {
            message = "You entered an UPPERCASE letter!";
        }
        else if (letter >= 'a' && letter <= 'z')
        {
            message = "You entered a lowercase letter!";
        }
        else
        {
            message = "Invalid input. I cannot determine the case of a value other than an alphabetical " +
                    "character. Please try again";
        }

        // Displays the results
        JOptionPane.showMessageDialog(null, message);

        // Ends the program
        System.exit(0);
    }
}
