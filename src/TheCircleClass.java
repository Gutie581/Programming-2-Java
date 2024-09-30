


import javax.swing.JOptionPane;
import java.io.IOException;
import java.util.Random;
import java.awt.geom.Ellipse2D;
import java.lang.Math;

public class TheCircleClass
{
    public static void main(String[] args) throws IOException
    {
        // Asks user for the circle's radius.
        String radiusInput = JOptionPane.showInputDialog("Please enter the radius of the circle: ");
        double radius = Double.parseDouble(radiusInput);

        // Create a circle object
        Circle circle = new Circle(radius);

        // Calculate and display the circle's results.
        String message = String.format("Circle Results:\n" + "Radius: %2f\n" + "Area: %.2f\n" + "Diameter: %.2f\n"
                        + "Circumference: %.2f",
                circle.getRadius(),circle.area(), circle.diameter(), circle.circumference());

        // Display message.
        JOptionPane.showMessageDialog(null, message, "Circle Information",
                JOptionPane.INFORMATION_MESSAGE);

        // Exit program
        System.exit(0);
    }

}

class Circle
{
    private double radius;
    private final double pi = 3.14159;

    // Constructor method that accepts the radius of the circle as an argument.
    public Circle(double radius)
    {
        this.radius = radius;
    }

    // Constructor method that accepts no argument and sets the radius to 0.0.
    public Circle()
    {
        this.radius = 0.0;
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

    public double area()
    {
        return pi * radius * radius;
    }

    public double diameter ()
    {
        return radius * 2;
    }

    public double circumference()
    {
        return 2 * pi * radius;
    }

}