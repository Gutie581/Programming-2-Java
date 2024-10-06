// Challenge 06 - Daniel Gutierrez - KEA418 - 10/06/24

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class TheCircleClass
{
    public static void main(String[] args){

        // Creates infinite loop until user inputs correct input or exits.
        while(true) {
            try {
                /*

                If user input would be taken in as a double, clicking "Cancel" or "X" would return as null.
                Double primitive data type cannot be null causing an error "Cannot invoke 'String.trim()' because 'in' is null."
                This would prevent the user from exiting unless they proceed with a number.
                To counter this error, user input is a string, checked if null, then converted to double if a number.
                Allows for a cleaner exit for user.

                */

                // Asks user for the radius as an input for exceptions.
                String input = JOptionPane.showInputDialog("Please enter the radius of the circle: ");

                if (input == null){
                    System.exit(0);
                }

                double radius = Double.parseDouble(input);

                // Creates a circle object with the user's inputted radius.
                circle Circle = new circle(radius);

                // Setter sets radius.
                Circle.setRadius(radius);

                // Uses format specifier to have more presentable results
                String message = String.format(
                        "Circle Results%n" + "Radius: %,.2f%n" + "Area: %,.2f%n" + "Diameter: %,.2f%n" + "Circumference: %,.2f",
                        Circle.getRadius(), Circle.area(), Circle.diameter(), Circle.circumference());

                JOptionPane.showMessageDialog(null, message);   // Display message.

                // Helps set the size of the frame to not make the user adjust their window.
                int frameSize;
                if (radius <= 100 ) {
                    frameSize = 200;
                }
                else {
                    radius *= 1.5;
                    frameSize = (int) (radius * 1.5);
                }

                // Creates window frame to draw output of the circle.
                JFrame frame = new JFrame("Circle Drawing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(Circle);
                frame.setSize(frameSize, frameSize);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                break;
            }
            // Catch block for any general exception.
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + e.getMessage());
            }
        }
    }
}

// Class to extend the JPanel
class circle extends JPanel{
    // Creates private field and constant variable.
    private double radius;
    private final double pi = 3.14159;

    // Constructor method that accepts the radius of the circle as an argument. Throws error if not a positive number.
    public circle(double radius){
        if (radius <= 0){
            throw new IllegalArgumentException("Radius must be greater than 0");
        }
        this.radius = radius;
    }

    // Mutator method for the radius.
    public void setRadius(double radius){
        this.radius = radius;
    }

    // Accessor method for the radius field.
    public double getRadius(){
        return radius;
    }

    // Method to calculate Area.
    public double area(){
        return pi * radius * radius;
    }

    // Method to calculate diameter
    public double diameter(){
        return radius * 2;
    }

    // Method to calculate the circumference
    public double circumference(){
        return 2 * pi * radius;
    }

    // Overrides the default paintComponent inorder to draw the circle.
    @Override
    protected void paintComponent(Graphics g){
        // Super class JComponent, calls the paintComponent method with the graphics object.
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;    // Coverts graphics (g) object to graphics2D variable (g2d).

        // Uses renderingHints object to apply antialiasing which smooths out the circle edges.
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        // Get the width and height of the panel.
        int width = getWidth();
        int height = getHeight();

        // Calculates the center of the panel by dividing dimension in half.
        int centerX = width / 2;
        int centerY = height / 2;

        // Calculates the top-left corner of the circle to find center.
        int x = (width - centerX) / 2;
        int y = (height - centerY) / 2;

        // Makes the circle output green in color.
        Ellipse2D.Double e = new Ellipse2D.Double(x, y, radius, radius);
        g2d.setColor(Color.green);
        g2d.fill(e);

        // Draws the circle.
        g2d.draw(new Ellipse2D.Double(x, y, radius, radius));
    }
}