//public class Notes9_11_24{ }
/*
Strings are basically arrays, where "John". "J" is 0, "o" is 1, "h" is 2 , "n" is 3.
Uses char.at() for the challenge 3. Helps to
The charAt() method is used to return the character at a specified index.
 */

// Cheatsheet for Java String methods.
// https://www.codecademy.com/learn/learn-java/modules/learn-java-string-methods/cheatsheet

/*
String comparisons Methods
Layout:
method - example - description

equals - (name1.equals(name2)) - compares the contents of two strings.
compareTo - (name3.compareTo(name4) == 0) - compares the contents of two strings.
compareToIgnoreCase - (name5.compareToIgnoreCase(name6) == 0) - compares the contents of two strings, ignoring case.
startsWith - (name7.startsWith("Jo")) - determines if a string starts with a specified substring.
endsWith - (name8.endsWith("hn")) - determines if a string ends with a specified substring.
equalsIgnoreCase - - compares the contents of two strings, ignoring case.
regionMatches - - compares a specified portion of one string with another string.
indexOf - - determines the index of a specified substring within a string.
lastIndexOf - - determines the last index of a specified substring within a string.
substring - - extracts a substring from a string.
concat - - concatenates two strings.
replace - - replaces characters in a string.
toLowerCase - - converts a string to lowercase.
toUpperCase - - converts a string to uppercase.
trim - - removes leading and trailing spaces from a string.
split - - splits a string into substrings.
charAt() - - returns the character at a specified index.
isUpperCase() - (Character.isUpperCase(letter)) - determines if a character is uppercase.
isLowerCase() - - determines if a character is lowercase.

 */

/*
Example that is helpful for Challenge 3

Example 6: The following code determines if a character is uppercase or lowercase.
        char letter = 'A';
        if (Character.isUpperCase(letter)) {
            System.out.println("The letter is uppercase.");
        }
        else {
            System.out.println("The letter is lowercase.");
        }

 */