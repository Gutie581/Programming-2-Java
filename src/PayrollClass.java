// Challenge 07 - Daniel Gutierrez - KEA418 - 10/11/24

import javax.swing.*;

public class PayrollClass{

    // Creates a payroll object from the PayRoll class.
    private static final PayRoll payroll = new PayRoll();

    // Creates infinite loop until user chooses to exit.
    public static void main(String[] args){
        while(selectEmployee() != -1);
    }

    // Displays dialog box and full payroll table.
    public static int selectEmployee(){

        // Creates a String array equal to number of employees plus 2 for Table and Exit.
        String[] options = new String[payroll.getEmployeeCount() + 2];
        for(int i = 0; i < payroll.getEmployeeCount(); i++){
            options[i] = String.valueOf(payroll.getEmployeeId(i));
        }
        // Adds Exit and View Table options to the string array as the 2nd to last and last element in array.
        options[options.length - 1] = "Exit";
        options[options.length - 2] = "View Table";

        // Dialog box to get user to select option of employee ID, table, or exit.
        int choice = JOptionPane.showOptionDialog(null, "Select an employee ID or View table: ","Employee Selection",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        // If user chooses to exit or x to close out, returns -1. Otherwise, returns selected employee ID.
        if (choice == options.length - 1 || choice == -1)
            return -1;

        // If user chooses to view table, displays the payroll table and calls selectEmployee() again.
        if (choice == options.length - 2) {
            displayPayrollTable();
            return selectEmployee();
        }
        // Converts user's choice from a string to integer. Choice variable represents index of selected element in options array.
        int selectedEmployeeId = Integer.parseInt(options[choice]);
        userInput(selectedEmployeeId); // Calls userInput method to get and validate user input.
        return selectedEmployeeId; // Returns user's input.
    }

    // Takes user input as an integer parameter and validates user input for hours worked and pay rate.
    public static void userInput(int selectedEmployeeId){

        // Gets values from user with minimum values, returns selected employee ID if user cancels.
        // Calls getValidInput method with String message and minimum value as parameters.
        String hoursInput = getValidInput("Enter hours worked for ID# " + selectedEmployeeId + ":", 0);
        if (hoursInput == null){
            return;
        }
        String payRateInput = getValidInput("Enter pay rate for ID# " + selectedEmployeeId + ":", 6.00);
        if (payRateInput == null){
            return;
        }

        // Converts user's input to double and assigns it to hours and payRate variables.
        double hours = Double.parseDouble(hoursInput);
        double payRate = Double.parseDouble(payRateInput);

        // Calls findEmployeeId method from payroll class passing selectedEmployeeId as argument.
        int index = payroll.findEmployeeId(selectedEmployeeId);

        // Finds index of employee ID in array. If not -1, sets hours, pay rate, and wages for that employee.
        if (index != -1){
            payroll.setHours(index, hours);
            payroll.setPayRate(index, payRate);
            payroll.setWages(index);
        }
        displayPayrollTable(); // Displays updated payroll table.
    }
    // Validates user input having String and double as parameters.
    public static String getValidInput(String message, double min){
        while(true){
            try {
                // Gets user's input as string, if user cancels, returns null.
                String input = JOptionPane.showInputDialog(message);
                if(input == null)
                    return null;

                // Converts user's input to double and checks if it's greater than or equal to min.
                double value = Double.parseDouble(input);
                if (value < min) throw new IllegalArgumentException("Value must be greater than or equal to " + min + ". Please try again.");
                return input;

                // If user's input is valid, returns it. If not, catches exceptions and displays error message.
            } catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Invalid input. Please enter a positive number only. Please try again.");
            } catch(IllegalArgumentException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
    // Creates table to display payroll information.
    public static void displayPayrollTable(){

        // Creates a StringBuilder object to build the table. Initializes table with a header.
        StringBuilder table = new StringBuilder("-".repeat(73) + "\n");

        // Appends formatted string to table with column headers.
        table.append(String.format("%-15s %-15s %-15s %-15s\n", "Employee ID", "Hours Worked", "Pay Rate", "Wages"));
        table.append("-".repeat(73)).append("\n"); // Separates header from payroll information.

        // Loops through each employee.
        for (int i = 0; i < payroll.getEmployeeCount(); i++){

            // Appends formatted string to table with payroll information for each employee.
            table.append (String.format("%-25s %-20.2f %-16.2f %-15.2f\n", payroll.getEmployeeId(i), payroll.getHours(i), payroll.getPayRate(i), payroll.getWages(i)));
        }
        table.append("-".repeat(73)).append("\n"); // Creates footer.

        // Displays table with updated payroll information.
        JOptionPane.showMessageDialog(null, table.toString(), "Weekly Payroll Table", JOptionPane.PLAIN_MESSAGE);
    }
}

class PayRoll{
    // Private and final array initialization of employee IDs along with "0.0" arrays for hours, pay rate, and wages with 7 elements.
    private final int[] employeeId = {5658845,4520125,7895122,8777541,8451277,1302850,7850489};
    private final double[] hours = new double[7];
    private final double[] payRate = new double[7];
    private final double[] wages = new double[7];

    // Getter method to get employee count.
    public int getEmployeeCount(){
        return employeeId.length;
    }
    // Getter method to get employee ID at given index.
    public int getEmployeeId(int index){
        return employeeId[index];
    }
    // Setter method to set pay rate at given index and takes double hours as argument.
    public void setHours(int index, double hours){
        this.hours[index] = hours;
    }
    // Getter method to get hours worked at given index.
    public double getHours(int index){
        return hours[index];
    }
    // Setter method to set pay rate at given index and takes double as argument.
    public void setPayRate(int index, double payRate){
        this.payRate[index] = payRate;
    }
    // Getter method to get pay rate at given index.
    public double getPayRate(int index){
        return payRate[index];
    }
    // Setter method to calculate and set wages at given index. Multiples hours worked by pay rate to get wages.
    public void setWages(int index){
        wages[index] = hours[index] * payRate[index];
    }
    // Getter method to get wages at given index.
    public double getWages(int index){
        return wages[index];
    }
    // Method to find index of employee ID in array. Returns -1 if employee ID not found.
    public int findEmployeeId(int employeeId){
        for(int i = 0; i < this.employeeId.length; i++){
            if(this.employeeId[i] == employeeId){
                return i;
            }
        }
        return -1;
    }
}