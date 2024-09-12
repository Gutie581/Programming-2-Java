/*
In class coding. Page 184. #12 The Speed of Sound

The following table shows the approximate speed of sound in air, water, and steel:
Medium | Speed
Air    | 1,100 feet per second
Water  | 4,900 feet per second
Steel  | 16,400 feet per second

Write a program that asks the user to enter “air”, “water”, or “steel”,
and the distance that a sound wave will travel in the medium.
The program should then display the amount of time it will take.

You can calculate the amount of time it takes sound to travel in air with the following formula:
        Time = Distance/1,100

You can calculate the amount of time it takes sound to travel in water with the following formula:
        Time = Distance/4,900

You can calculate the amount of time it takes sound to travel in steel with the following formula:
        Time = Distance/16,400

 */


import javax.swing.JOptionPane;

public class Module3Decisions
{

    public static void main(String[] args)
    {
        // Declaring the constant values for the mediums
        final int air_medium = 1100;
        final int water_medium = 4900;
        final int steel_medium = 16400;

        //
        int distance = 0;
        double time = 0.0;

        String playerChoice = JOptionPane.showInputDialog(null, "Choose air, " +
                "water or steel");

        distance = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter a" +
                " distance that the sound wave traveled: "));

        // Good idea in class, might look at later.
        // time = (distance = Integer.parseInt(JOptionPane.showInputDialog(null,"PLease " +
        //"enter the distance the sound wave traveled: "))) / (air);

        if (playerChoice.equalsIgnoreCase("air"))
        {
            time = ((double) distance / air_medium);
            JOptionPane.showMessageDialog(null, "It took " + time +
                    " seconds for the wave to travel through air at a distance of " + distance + " feet." );
        }

        {
        // Check out using a Switch instead of and if statement.
        }

    }
}
