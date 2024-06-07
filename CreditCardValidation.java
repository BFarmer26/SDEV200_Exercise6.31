import java.util.Scanner;

public class CreditCardValidation {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Creates the scanner

        // Prompt for the user to enter their credit card number as a long number
        System.out.print("Enter a credit card number as a long integer: ");
        long number = input.nextLong();

        if(isValid(number)) {
            System.out.println("The card number entered is valid.");
        } else {
            System.out.println("The card number entered is invalid.");
        }
    }

    // Returns true when the card number is valid
    public static boolean isValid(long number) {
        return (getSize(number) >= 13 && getSize(number) <= 16) &&
        (prefixMatched(number, 4) ||
         prefixMatched(number, 5) ||
         prefixMatched(number, 37) ||
         prefixMatched(number, 6)) &&
         ((sumOfDoubleEvenPlace(number) +
         sumOfOddPlace(number)) % 10 == 0);
    }

    // Gets the result from previous step
    public static int sumOfDoubleEvenPlace(long number) {
        int sum = 0;
        String num = String.valueOf(number);
        for (int i = num.length() -2; i >= 0; i -= 2) {
            int digit = Integer.parseInt(String.valueOf(num.charAt(i)));
            sum += getDigit(digit * 2);
        }
        return sum;
    }

    // Either returns the number if it is a 
    // single digit, or returns the sum of the  
    // two digits
    public static int getDigit(int number)
    {
        if (number < 9)
            return number;
        return number / 10 + number % 10;
    }

    // Returns the sum of odd-placed digits
    public static int sumOfOddPlace(long number)
    {
        int sum = 0;
        String num = String.valueOf(number);
        for (int i = num.length() - 1; i >= 0; i -=2) {
            int digit = Integer.parseInt(String.valueOf(num.charAt(i)));
            sum += digit;
        }
        return sum;
    }

    // Return true if the number d is a prefix
    // for a number
    public static boolean prefixMatched(long number, int d) {
        return getPrefix(number, getSize(d)) == d;
    }

    // Returns the number of digits in d
    public static int getSize(long d) {
        return String.valueOf(d).length();
    }

    // Returns the first k number of digits
    // If the number of digits is less than k,
    // the number is returned
    public static long getPrefix(long number, int k) {
        String num = String.valueOf(number);
        if (num.length() < k) {
            return number;
        } else {
            return Long.parseLong(num.substring(0, k));
        }
    }
}
