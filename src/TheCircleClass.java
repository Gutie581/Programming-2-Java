


import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class TheCircleClass {
    public static void main(String[] args) {

        // Starts an infinite loop requiring the user to use a proper input.
        while (true)
        {
            try
            {
                // Asks user for the radius.
                String radiusInput = JOptionPane.showInputDialog("Please enter the radius of the circle: ");

                // Exception handling if user cancels or exits at the input window.
                if (radiusInput == null) {
                    break;
                }
                // Converts string into a double.
                double radius = Double.parseDouble(radiusInput);

                // Creates a circle object with the user's inputted radius.
                Circle circle = new Circle(radius);

                // Sets the radius from the setRadius accessor method.
                circle.setRadius(radius);

                // Calculate and the circle's results using a format that stacks the outputs, places commas,
                // and uses up to 2 decimal places. Gathers specified method from created circle object.
                String message = String.format(
                        "Circle Results:\n Radius: %,.2f \nArea: %,.2f \nDiameter: %,.2f \nCircumference: %,.2f",
                        circle.getRadius(),
                        circle.area(),
                        circle.diameter(),
                        circle.circumference());
                // Display results of the circle dimensions with title.
                JOptionPane.showMessageDialog(null, message, "Circle Information", JOptionPane.INFORMATION_MESSAGE);

                // Creates window that shows dimensions based on user's radius input.
                JFrame frame = new JFrame("Circle Drawing");        // Title of window.
                frame.add(new circlePanel(radius));// Creates new object then adds radius arg from circlePanel class.
                frame.setSize(500,500);                     // Sets size to default W&H of 500 pixels.
                frame.setVisible(true);                                 // Displays the window.
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // Closes window when button is clicked.

                break;
            }

            // Catch block exceptions if invalid number, negative number, and any other exception.
            catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, "Error: Invalid number format. Please enter " +
                        "a positive number.");
            }
            catch (IllegalArgumentException e)
            {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage() + ". Please enter " +
                        "a positive number.");
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + e.getMessage());
            }
        }
    }
}

class Circle
{

    // Creates private field and constant variable.
    private double radius;
    private final double pi = 3.14159;

    // Constructor method that accepts the radius of the circle as an argument and throws error if the radius is not
    // a positive number.
    public Circle(double radius)
    {
        if (radius <= 0)
        {
            throw new IllegalArgumentException("Radius must be positive");
        }
        this.radius = radius;
    }

    // Mutator method for the radius.
    public void setRadius(double radius)
    {
        this.radius = radius;
    }

    // Accessor method for the radius field.
    public double getRadius()
    {
        return radius;
    }

    // Method to calculate Area.
    public double area()
    {
        return pi * radius * radius;
    }

    // Method to calculate the Diameter.
    public double diameter()
    {
        return radius * 2;
    }

    // Method to calculate the circumference.
    public double circumference()
    {
        return 2 * pi * radius;
    }
}

// Class to extend the JPanel
class circlePanel extends JPanel
{
    // Declares private field for the radius.
    private final double radius;

    // Constructor method to initialize the radius.
    public circlePanel(double radius)
    {
        this.radius = radius;
    }

    // Overrides the default paintComponent inorder to draw the circle.
    @Override
    protected void paintComponent(Graphics g)
    {
        // Super class JComponent, calls the painComponent method with the graphics object.
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g; // Converts graphics (g) object to graphics2D variable (g2d).

        // Uses renderingHints object to apply antialiasing which smooths out the circle.
        RenderingHints rh = new RenderingHints(
        RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        // Get the width and height of the panel.
        int width = getWidth();
        int height = getHeight();

        // Calculate the center of the panel by dividing dimension in half.
        int centerX = width / 2;
        int centerY = height / 2;

        // Calculates the top-left corner of the circle.
        int x = (int) (centerX - radius);
        int y = (int) (centerY - radius);

        // Makes the circle output a green color.
        Ellipse2D.Double e = new Ellipse2D.Double(x, y, radius * 2, radius * 2);
        g2d.setColor(Color.green);
        g2d.fill(e);

        // Draws the circle.
        g2d.draw(new Ellipse2D.Double(x, y, radius * 2, radius * 2));
    }
}
