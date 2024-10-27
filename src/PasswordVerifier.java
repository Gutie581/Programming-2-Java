

import javax.swing.*;

public class PasswordVerifier {
    public static void main(String[] args) {

        while(true){
            // Dialog box displaying password requirements.
            JOptionPane.showMessageDialog(null, """
                    Password Requirement:
                    - At least 8 characters long.
                    - At least one uppercase letter.
                    - At least one lowercase letter.
                    - At least one of the following special characters: ! @ # $ % ^ & *""");

            // User input.
            String password = JOptionPane.showInputDialog(null, "Enter your password", "Password Verification", JOptionPane.QUESTION_MESSAGE);

            // If user cancels or closes window.
            if (password == null){
                break;
            }

            // Calls isValidPassword method.
            if (isValidPassword(password)){
                JOptionPane.showMessageDialog(null, "Valid Password");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Password\nEnsure your password meets the specified requirements.");
            }
        }
    }

    public static boolean isValidPassword(String password){
        // Gets length of string, if less than 8, returns false.
        if (password.length() < 8){
            return false;
        }

        // Initializes password requirements to false.
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        // String to define special characters.
        String specialChars = "!@#$%^&*";

        // Converts password to Character array to iterate through each character.
        for (char c : password.toCharArray()){
            // Checks each type of character to the method defined.
            if (Character.isUpperCase(c)){
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)){
                hasLowerCase = true;
            } else if (Character.isDigit(c)){
                hasDigit = true;
            // Checks for special characters.
            } else if (specialChars.indexOf(c) != -1){
                hasSpecialChar = true;
            }
        }
        // Returns results of each requirement to check if password is valid.
        return hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar;
    }
}
