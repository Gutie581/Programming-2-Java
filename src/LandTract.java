// Challenge 08 - Daniel Gutierrez - KEA418 - 10/18/2024

import javax.swing.JOptionPane;

public class LandTract{

    // Defines private and final fields that will not change.
    private final double length;
    private final double width;

    public static void main(String[] args){

        // Gets user input and converts input to a double.
        double lengthTract1 = Double.parseDouble(JOptionPane.showInputDialog("Please enter the length of the first tract: "));
        double widthTract1 = Double.parseDouble(JOptionPane.showInputDialog("Please enter the width of the first tract: "));
        // Creates new instance of LandTract from user's input and initializes the object tract1 with dimensions.
        LandTract tract1 = new LandTract(lengthTract1, widthTract1);

        // Gets user input and converts input to a double.
        double lengthTract2 = Double.parseDouble(JOptionPane.showInputDialog("Please enter the length of the second tract: "));
        double widthTract2 = Double.parseDouble(JOptionPane.showInputDialog("Please enter the width of the second tract: "));
        // Creates new instance of LandTract from user's input and initializes the object tract2 with dimensions.
        LandTract tract2 = new LandTract(lengthTract2, widthTract2);

        // Displays area of both tracts by using the getArea method from the object tract#.
        JOptionPane.showMessageDialog(null,"The area of the first tract is " + tract1.getArea() + "." +
                "\nThe area of the second tract is " + tract2.getArea() + ".");

        // Compares if both areas are equal by calling the equals method by passing tract2 as an argument.
        if (tract1.equals(tract2)) {
            JOptionPane.showMessageDialog(null, "The area of the 2 tracts are equal in size. ");
        } else {
            JOptionPane.showMessageDialog(null, "The area of the 2 tracts are not equal in size. ");
        }

        // Calls the toString representation of the objects automatically rather than the area in memory where
        // part of the object string is stored.
        JOptionPane.showOptionDialog(null,tract1, "Tract 1",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,null,null);
        JOptionPane.showOptionDialog(null,tract2, "Tract 2",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,null,null);

    }

    // Constructor method for class where it initializes the variables.
    private LandTract(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Getter method for Area calculations.
    private double getArea(){
        return length * width;
    }

    // Compares areas are equal by taking a new parameter "newTract", gets the area of the newTract and compares
    // the objects. Then stores boolean results in "status" variable.
    private boolean equals(LandTract newTract){
        boolean status;
        if (this.getArea() == newTract.getArea()) {
            status = true;
        } else {
            status = false;
        }
        return status;
    }

    // Overrides the toString method to provide length, width, and area of each dimension.
    @Override
    public String toString(){
        return "\n Length = " + length + "\n Width = " + width + "\n Area = " + getArea();
    }
}