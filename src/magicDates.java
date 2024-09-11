// Challenge 02 - Daniel Gutierrez - KEA418 - 09/08/24

// import required for JOptionPane
import javax.swing.JOptionPane;

public class magicDates
{
    public static void main(String[] args) // Define main method
    {
        // User input for month.
        String monthDate = JOptionPane.showInputDialog("Please enter a month in numeric format: ");
        int month = Integer.parseInt(monthDate);         // Converts string to integer.

        // User input for day.
        String dayDate = JOptionPane.showInputDialog("Please enter a day: ");
        int day = Integer.parseInt(dayDate);            // Converts string to integer.

        // User input for year
        String yearDate = JOptionPane.showInputDialog("Please enter a year: ");
        int year = Integer.parseInt(yearDate);              // Converts string to integer.

        // Displays results in an if else statement.
        String message;
        if (month * day == year)            // Multiples month and day then compares it equal to the year.
        {
            message = "The number is a  date! Wow!";
        }
        else
        {
            message = "The date is not a magic date.";
        }

        // Displays the results
        JOptionPane.showMessageDialog(null, message);

        // Ends the program
        System.exit(0);
    }

}
