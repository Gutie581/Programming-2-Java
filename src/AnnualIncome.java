// Challenge 01 - Daniel Gutierrez - KEA418

// import required for JOptionPane
import javax.swing.JOptionPane;

// Public class matches file name
public class AnnualIncome
{

    public static void main(String[] args) // Define main method
    {
        String name = "";             // Used for name input
        String ageStr, annualPayStr;  // Used for age input and annual pay input as string
        int age;                      // Data type integer for age
        double annualPay;             // Data type double for the annual pay

        // User input for name.
        name = JOptionPane.showInputDialog("Please enter your first and last name: ");

        // User input for age.
        ageStr = JOptionPane.showInputDialog("Please enter your age: ");
        age = Integer.parseInt(ageStr);            // Converts string to integer.

        // User input for annual pay
        annualPayStr = JOptionPane.showInputDialog("Please enter your desired annual salary: ");
        annualPay = Double.parseDouble(annualPayStr);              // Converts string to double

        // Displays the results
        JOptionPane.showMessageDialog(null, "My name is " + name + "," + " my age is " + age +
                " and I hope to earn " + "$" + annualPay + " per year.");
        // Ends the program
        System.exit(0);

    }

}