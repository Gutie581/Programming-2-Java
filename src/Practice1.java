// 9/9/24 Monday Class
/*
Switch statements
A switch statement is composed of a variable, the switch keyword, and a set of cases.
Can only use "break" for Switch statements and loops.

Switch statements are much different than loops, can be used in loops.

A switch statement is a control flow construct in Java and many other programming languages that allows for efficient
selection among multiple alternatives based on the value of an expression. Here's a detailed explanation of switch statements:
Basic Structure
A switch statement consists of the following parts:
o The switch keyword followed by an expression in parentheses
o A block of code enclosed in curly braces {}
o One or more case labels, each followed by a value and a colon
o An optional default label

*** Requires colon over semicolon
*/

public class Practice1
{
    public static void main(String[] args) // Define main method
    {

        int day = 4;
        switch (day) // a switch statement is composed of a variable, the switch keyword, and a set of cases.
        {
            case 1:
                System.out.println("Monday");
                break; // break is optional
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break; // break is optional
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break; // break is optional
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break; // break is optional
            default:
                System.out.println("Invalid day");
        }

/*
Boolean Expressions
A Boolean expression is an expression that evaluates to a Boolean value, true or false.

*/
// logical operators
        // && logical AND     Recall, the && operator is the short-circuit AND operator.
        // || logical OR      Recall, the || operator is the short-circuit OR operator.
        // ! logical NOT
        if (isRaining) {
            System.out.println("It is raining.");
        }
        else {
            System.out.println("It is not raining.");
        }

        if (!isSunny) {
            System.out.println("It is not sunny.");
        }
        else {
            System.out.println("It is sunny.");
        }

        if (isRaining && !isSunny) {
            System.out.println("It is raining and it is not sunny.");
        }
        else {
            System.out.println("It is not raining and it is sunny.");
        }

// Relational operators
        // == equal to
        // != not equal to
        // > greater than
        // < less than
        // >= greater than or equal to
        // <= less than or equal to

// Displaying formatted output with System.out.printf and String.format
        double num1 = 1.23456789; // Remember that double is a floating point number with 15 decimal
        // digits of precision.
        System.out.printf("num1 = %.2f\n", num1); // displays num1 with 2 decimal places. Takes the form of
        // printf("format string", ArgumentList);

        int hours = 35;
        System.out.printf("I worked %d hours this week.\n", hours); // displays hours as an integer.
        // %d is a format specifier for integers.
        String name = "John";
        System.out.printf("My name is %s.\n", name); // displays name as a string. %s is a format specifier for strings.

        // When displaying numbers with printf, you can use the following format specifiers:
        // %d - integer
        // %f - floating point number
        // %e - scientific notation
        // %c - character
        // %s - string
        // %b - boolean
        // %n - new line
        // %% - percent sign

        // The general syntax for writing a format specifier is %[flags][width][.precision]conversion-character
        // The width specifier specifies the minimum number of spaces to be written as output.





    }
}