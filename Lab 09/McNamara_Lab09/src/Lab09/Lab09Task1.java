// Timothy McNamara
// Lab 09
// 06/16/2024
// CIT 27000

package Lab09;

import java.util.Scanner;
import java.util.InputMismatchException;

 /* Question 2 of Lab 09
  * Taken from Lab 03 where the goal of the lab was to
  * Write an application that will input four positive integers from the user.
  * The program should print out the largest and smallest number. 
  * It should print how many of the numbers are even and how many are odd. 
  * It should print how many of the numbers are one digit 
  * and how many of the numbers are two digit.

  * It should print out the sum of all even numbers and the sum of all odd numbers. 
  * It should print out the sum of all one digit numbers and the sum of 
  * all two digit numbers.

  * The lab didn't require error checking but I have added it like so.
*/
public class Lab09Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Variables used to sum up all the even and odd numbers
        int evenBoi = 0;
        int oddBoi = 0;

        // Used to represent count of all the one digit numbers
        int oneDigNumCnt = 0;
        int twoDigNumCnt = 0;

        // Used to count the odd numbers and the even numbers
        int oddNumCnt = 0;
        int evenNumCnt = 0;

        // Used to sum the one digit numbers and the two digit numbers
        int oneDigNumSum = 0;
        int twoDigNumSum = 0;

        // User enters supposedly random integers
        System.out.println("User, please enter four positive integers.");

        int num1 = getValidNumba(scanner, "Enter the first integer: ");
        int num2 = getValidNumba(scanner, "Enter the second integer: ");
        int num3 = getValidNumba(scanner, "Enter the third integer: ");
        int num4 = getValidNumba(scanner, "Enter the fourth integer: ");

        // Searching for largest number
        int largestNum = num1;
        if (num2 > largestNum) largestNum = num2;
        if (num3 > largestNum) largestNum = num3;
        if (num4 > largestNum) largestNum = num4;

        // Searching for smallest number
        int smallestNum = num1;
        if (num2 < smallestNum) smallestNum = num2;
        if (num3 < smallestNum) smallestNum = num3;
        if (num4 < smallestNum) smallestNum = num4;

        // The following statements poll through each integer
        // The integers are then taken through the modulus operator
        // and if the remainder is zero they are even, otherwise
        // they are odd numbers. The number is then added to the
        // variable oddBoi or evenBoi. They hold the sum of the odd 
        // numbers and the even numbers.
        if (num1 % 2 == 0) {
            evenNumCnt++;
            evenBoi += num1;
        } else {
            oddNumCnt++;
            oddBoi += num1;
        }

        if (num2 % 2 == 0) {
            evenNumCnt++;
            evenBoi += num2;
        } else {
            oddNumCnt++;
            oddBoi += num2;
        }

        if (num3 % 2 == 0) {
            evenNumCnt++;
            evenBoi += num3;
        } else {
            oddNumCnt++;
            oddBoi += num3;
        }

        if (num4 % 2 == 0) {
            evenNumCnt++;
            evenBoi += num4;
        } else {
            oddNumCnt++;
            oddBoi += num4;
        }

        // The following statements poll through the four integers
        // inserted by the user. If they are greater than 10, this
        // means they are a two digit number. The count of double or 
        // single digit numbers are taken and we then take the 
        // sum of the single or double digit numbers using the 
        // oneDigNumSum or twoDigNumSum variables
        if (num1 < 10) {
            oneDigNumCnt++;
            oneDigNumSum += num1;
        } else {
            twoDigNumCnt++;
            twoDigNumSum += num1;
        }
        if (num2 < 10) {
            oneDigNumCnt++;
            oneDigNumSum += num2;
        } else {
            twoDigNumCnt++;
            twoDigNumSum += num2;
        }
        if (num3 < 10) {
            oneDigNumCnt++;
            oneDigNumSum += num3;
        } else {
            twoDigNumCnt++;
            twoDigNumSum += num3;
        }
        if (num4 < 10) {
            oneDigNumCnt++;
            oneDigNumSum += num4;
        } else {
            twoDigNumCnt++;
            twoDigNumSum += num4;
        }

        // The findings are then displayed to the console
        System.out.println("The smallest number is " + smallestNum);
        System.out.println("The largest number is " + largestNum);
        System.out.println("There are " + evenNumCnt + " even numbers");
        System.out.println("There are " + oddNumCnt + " odd numbers");
        System.out.println("There are " + oneDigNumCnt + " one digit numbers.");
        System.out.println("There are " + twoDigNumCnt + " two digit numbers.");
        System.out.println("The sum of even numbers is " + evenBoi);
        System.out.println("The sum of odd numbers is " + oddBoi);
        System.out.println("The sum of one digit numbers is " + oneDigNumSum);
        System.out.println("The sum of two digit numbers is " + twoDigNumSum);
    }

    // Method to get a valid integer from the user with exception handling
    private static int getValidNumba(Scanner scanner, String prompt) {
        int input = 0;
        boolean valid = true;
        boolean invalid = false;
        while (invalid) {
            System.out.print(prompt);
            try {
            	// Attempt to read an integer from the user
            	input = scanner.nextInt();
            	if (input > 0) {
            	// If the answer is acceptable, invalid becomes valid
            	// and we exit the loop. 
                invalid = valid;
            	 } else {
            		 // If the number is not a positive, error message displays.
            		 System.out.println("Enter a positive number...C'mon...");
            	 }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                // clear the invalid input from the buffer
                scanner.next(); 
            }
        }
        return input;
    }

}
