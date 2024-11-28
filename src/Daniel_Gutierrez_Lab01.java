import javax.swing.JOptionPane;

public class Daniel_Gutierrez_Lab01 {
    public static void main(String[] args) {
        userInterface(); // Calls the userInterface method.
    }

    public static void userInterface() {
        JOptionPane.showMessageDialog(null, "Welcome to the Polygon Area Calculator!");

        do {
            try {
                int sides = getValidIntInput("Enter the number of sides (3 or 4):");
                // Requires user to input 3 or 4 sides, if not then a message is displayed and loop continues.
                if (sides != 3 && sides != 4) {
                    JOptionPane.showMessageDialog(null, "Only triangles, squares and rectangles are supported.");
                    continue;
                }

                int points = getValidIntInput("Enter the number of points:");
                // Displays yes and no option to determine if the shape is closed.
                boolean isClosed = JOptionPane.showConfirmDialog(null,
                        "Is the shape closed?", "Shape Closed?",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
                // Creates a new polygon object to determine if the shape is valid. If not, then the loop continues.
                Polygon polygon = new Polygon(sides, points, isClosed);
                if (!polygon.isPolygon(sides, points, isClosed)) {
                    JOptionPane.showMessageDialog(null, "This is not a valid polygon.");
                    continue;
                }
                // If 3 side, then triangle input method is called. If 4 sides, then rectangle input method is called.
                if (sides == 3) {
                    handleTriangle();
                } else {
                    handleRectangle();
                }

            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        // Asks user if they want to calculate another shape. If yes, then loop continues.
        } while (JOptionPane.showConfirmDialog(null,
                "Do you want to calculate another shape?",
                "Continue?",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);

        JOptionPane.showMessageDialog(null, "Thank you for using the Polygon Area Calculator!");
        System.exit(0);
    }

    private static void handleTriangle() {
        // Asks the user for the 3 lengths of the triangle.
        double sideA = getValidDoubleInput("Enter side A of the triangle:");
        double sideB = getValidDoubleInput("Enter side B of the triangle:");
        double sideC = getValidDoubleInput("Enter side C of the triangle:");
        // Creates a new triangle object with the 3 sides.
        Triangle triangle = new Triangle(sideA, sideB, sideC);
        JOptionPane.showMessageDialog(null,
                "Triangle Area: %s\nTriangle Type: %s".formatted(triangle.getArea(), triangle.getType()));
    }

    private static void handleRectangle() {
        // Asks the user if the rectangle is a square or not.
        boolean isSquare = JOptionPane.showConfirmDialog(null, "Are all sides equal?", "Square Check",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
        // If square, then the user is asked for the side length. If not, then the user is asked for the length and width.
        if (isSquare) {
            double side = getValidDoubleInput("Enter the side length of the square:");
            Square square = new Square(side);
            JOptionPane.showMessageDialog(null, "Square Area: " + square.getArea());
        } else {
            double length = getValidDoubleInput("Enter the length of the rectangle:");
            double width = getValidDoubleInput("Enter the width of the rectangle:");
            Rectangle rectangle = new Rectangle(length, width);
            JOptionPane.showMessageDialog(null, "Rectangle Area: " + rectangle.getArea());
        }
    }

    // Method to get valid integer input from the user.
    public static int getValidIntInput(String userInput) {
        while (true) {
            try {
                return Integer.parseInt(JOptionPane.showInputDialog(userInput));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid integer.");
            }
        }
    }

    // Method to get valid double input from the user.
    public static double getValidDoubleInput(String userInput) {
        while (true) {
            try {
                return Double.parseDouble(JOptionPane.showInputDialog(userInput));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            }
        }
    }
}
// Polygon superclass.
class Polygon {
    private int nsides;
    private int npoints;
    private boolean isClosed;

    // Constructor for the Polygon class with 3 parameters.
    public Polygon(int sides, int points, boolean closed) {
        this.nsides = sides;
        this.npoints = points;
        this.isClosed = closed;
    }

    // Method to determine if the shape is a polygon by seeing if the sides are greater than or equal to 3.
    // If the sides and points are equal, and if the shape is closed.
    public boolean isPolygon(int sides, int points, boolean closed) {
        return sides >= 3 && sides == points && closed;
    }

    // Method to determine the shape of the polygon.
    public String setShape (int sides, int points, boolean isEqual){
        if (!isPolygon(sides, points, true)) {
            return "Not a polygon";
        }
        if (sides == 3) {
            return "Triangle";
        } else if (sides == 4) {
            return isEqual ? "Square" : "Rectangle"; // If the sides are equal, then it is a square. If not, then it is a rectangle.
        }
        return "Polygon";
    }
}

// Rectangle subclass that extends the attributes from Polygon superclass.
class Rectangle extends Polygon{
    private double length;
    private double width;

    // Constructor for the Rectangle class with 2 parameters that calls the Polygon superclass.
    public Rectangle(double len, double w) {
        super(4, 4, true);
        this.length = len;
        this.width = w;
    }

    // Setters and getters for the length and width of the rectangle.
    public void setLength(double len) {
        this.length = len;
    }
    public void setWidth(double w) {
        this.width = w;
    }
    public double getLength() {
        return this.length;
    }
    public double getWidth() {
        return this.width;
    }

    public double getArea() { // Standard method to calculate the area of a rectangle.
        return this.length * this.width;
    }
}

// Square subclass that extends the attributes from Rectangle class.
// My UML design mistakenly inherited from the Polygon class instead of the Rectangle class.
class Square extends Rectangle {
    private double sideLength;

    public Square(double side) {
        super(side, side);
        this.sideLength = side;
    }

    public void setSideLength(double side) {
        super.setLength(side);
        super.setWidth(side);
        this.sideLength = side;
    }
    public double getSideLength() {
        return this.sideLength;
    }
    @Override
    public double getArea() {
        return super.getArea();
    }
}

// Triangle subclass that extends the attributes from Polygon superclass.
class Triangle extends Polygon{
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double a, double b, double c) {
        super(3, 3, true);
        if (!(a + b > c && b + c > a && a + c > b)) { // Checks if the sides are valid for a triangle.
            throw new IllegalArgumentException("Invalid triangle sides!");
        }
        this.sideA = a;
        this.sideB = b;
        this.sideC = c;
        getType();
    }

    public void setSides(double a, double b, double c) {
        this.sideA = a;
        this.sideB = b;
        this.sideC = c;
    }
    public double getSideA() {
        return this.sideA;
    }
    public double getSideB() {
        return this.sideB;
    }
    public double getSideC() {
        return this.sideC;
    }

    // Method to calculate the area of a triangle using Heron's formula.
    // Heron's formula: A = sqrt(s(s - a)(s - b)(s - c)), where s = (a + b + c) / 2.
    public String getArea() {
        double s = (sideA + sideB + sideC) / 2;
        double area =  Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
        return String.format("%.2f", area);
    }

    // Method to determine the type of triangle based on the sides.
    public String getType() {
        if (sideA == sideB && sideB == sideC) {
            return "Equilateral Triangle";
        } else if (sideA == sideB || sideB == sideC || sideA == sideC) {
            return "Isosceles Triangle";
        } else {
            return "Scalene Triangle";
        }
    }

    // I realize this method is part of my UML design but really serves no purpose on its own
    // getType() does the job instead.
    private void determineType(){};
}