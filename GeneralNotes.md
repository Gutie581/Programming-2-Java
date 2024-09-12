Notes from Class:

**logical operators**
&& logical AND     Recall, the && operator is the short-circuit AND operator.
|| logical OR      Recall, the || operator is the short-circuit OR operator.
! logical NOT

**Relational operators**
    == equal to
    != not equal to
    > greater than
    < less than
    >= greater than or equal to
    <= less than or equal to


**Displaying formatted output with System.out.printf and String.format**
When displaying numbers with printf, you can use the following format specifiers:
%d - integer
%f - floating point number
%e - scientific notation
%c - character
%s - string
%b - boolean
%n - new line
%% - percent sign



**String comparisons Methods**
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