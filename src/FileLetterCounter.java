// Challenge 04 - Daniel Gutierrez - KEA418


// import required.
import javax.swing.JOptionPane;
import java.io.*;
import java.util.Scanner;


public class FileLetterCounter
{
    public static void main(String[] args)
    {
        // Ask user for file name
        String fileName;

        // Do-while loop since challenge states to ask user for the name of a file.
        do
        {
            fileName = JOptionPane.showInputDialog("Enter the name of the file: ");

            // Uses the NOT logical operator and equals method to see if input matches the "output" text.
            if (!fileName.equals("output"))
            {
                JOptionPane.showMessageDialog(null, "File not found. Please try again. " +
                        "\nHint: Use \"output\" as the file name.");
            }
        }
        while (!fileName.equals("output"));

        // Ask user for the character to count
        String charCount = JOptionPane.showInputDialog("Enter a character to count: ");

        // Takes the first character from the user's input.
        char numberChar = charCount.charAt(0);

        // Initializes count as integer
        int count = 0;

        try
        {
            // Open a file to read using FileReader and Scanner
            FileReader fileReader = new FileReader("C:/Users/gutie/Desktop/output.txt");
            Scanner fileScanner = new Scanner(fileReader);

            // While loop to continue as long as there is another line to read in the file
            while (fileScanner.hasNextLine())
            {
                // Stores next line of file as nextLine variable and reads next line in file
                String nextLine = fileScanner.nextLine();

                // For loop iterates through each character and index increments by 1
                for (int i = 0; i < nextLine.length(); i += 1)
                {
                    // If loop to check if the character at index position is equal to the inputted first character
                    if (nextLine.charAt(i) == numberChar)
                    {
                        count += 1;        // If character is equal, add 1 to the count
                    }
                }
            }

            // Close reader and scanner
            fileScanner.close();
            fileReader.close();

            // Display the results
            JOptionPane.showMessageDialog(null, "Number of times " + "\"" + numberChar + "\"" +
                    " appears in the file is " + count + " times.");
        }
        catch (Exception e)             // Catches any generic exceptions that are thrown
        {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

        // Ends the program
        System.exit(0);
    }
}
