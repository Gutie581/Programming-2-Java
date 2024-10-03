/*

    Program that illustrates Classes, Objects, Constructors, Getter, Setters, and Access Modifiers

    Helps to make a template of the code using //.

 */


// Main class of our program
public class Bicycle
{
    // Global variables and Global constants
    // Declare fields/Attributes (Same thing)

    // Fields/Attributes are as follows:
    public Integer wheels;
    public Double wheel_diameter;
    public String frame;
    public boolean is_Braking;
    public String make;
    public String type;
    public Integer gears;
    public String color;
    public String handlebar_shape;

    // Global variable
    public static Integer speed;

    public Bicycle()
    {

    }

    // Make constructor method that creates objects in white.
    public Bicycle(Integer wheels, Double wheel_diam, String frame, boolean is_Braking, String bikeMake, String type, int gears
    , String color, String handlebar_shape)
    {
        this.wheels = wheels;
        this.wheel_diameter = wheel_diam;
        this.frame = frame;
        this.is_Braking = is_Braking;
        this.make = bikeMake;
        this.type = type;
        this.gears = gears;
        this.color = color;
        this.handlebar_shape = handlebar_shape;


    }

    public static void main(String[] args)
    {
        // now the value BMX has all of these values. Use setters to change the values, getters to call these specific value.
        Bicycle BMX = new Bicycle(2, 26.0, "aluminium", false, "BMX", "Mountain",
                7, "Black", "straight");

        Bicycle schwinn = new Bicycle();
    }

    // Methods, including setters and getters.
    // Setters to set the attriubtes
    // getters to get them
}

class tricycle()
{


}