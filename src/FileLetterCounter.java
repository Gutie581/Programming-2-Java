/*

File Letter Counter

NOTE: REMEMBER TO USE THE GUI

Overview

Write a program that asks the user to enter the name of a file, and then asks the user to enter a character.
The program should count and display the number of times that the specified character appears in the file.
**You can use Notepad or another text editor to create a simple file that can be used to test the program.

Paste the following text into your file:

Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore
magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.

Test Data:

I will test how many times the character 'e' appears in the text above.

 */

// import required.
import javax.swing.JOptionPane;
import java.io.*;



public class FileLetterCounter
{
    public static void main(String[] args)
    {
        // Ask user for file name
        String fileName = JOptionPane.showInputDialog("Enter a file name");

        // Ask user for the character to count
        String charCount = JOptionPane.showInputDialog("Enter a character to count");

        // Takes the first character from the user.
        char numberChar = charCount.charAt(0);

        try
        {
            // Create and write to the new file
            FileWriter fileWriter = new FileWriter("C:/Users/gutie/Desktop", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore\n" +
                    "magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                    "consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.\n" +
                    "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            int count = 0;
            int c;
            while ((c = bufferedReader.read()) != -1)
            {
                if ((char) c == numberChar)
                {
                    count ++;
                }
            }
            bufferedReader.close();

            // Display the results
            JOptionPane.showMessageDialog(null, "Number of times " + numberChar +
                    "appears in the file is " + count + " times");
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());

        }




    }



}
