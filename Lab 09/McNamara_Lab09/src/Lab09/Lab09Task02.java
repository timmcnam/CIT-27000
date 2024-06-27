// Timothy McNamara
// Lab 09
// 06/16/2024
// CIT 27000

package Lab09;

import java.util.Scanner;

/* Question 3 of Lab 09
 * Write a recursive method which takes an integer number 
 * and returns the sum of the numbers from 1 to that number. 
 * The method must solve the problem recursively. 
 * Then write an application which calls the method with a 
 * few different numbers and displays the return value of the method. 
 */

public class Lab09Task02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for the numbers to calculate the sum
        System.out.print("Enter a positive number: ");
        int numba1 = scanner.nextInt();

        System.out.print("Enter another positive integer: ");
        int numba2 = scanner.nextInt();

        System.out.print("Enter a final positive integer: ");
        int numba3 = scanner.nextInt();

        // Calling the recursive sum method with user inputs and displaying the results
        System.out.println("Sum of numbers from 1 to " + numba1 + 
        		" is: " + recursiveSum(numba1));
        System.out.println("Sum of numbers from 1 to " + numba2 + 
        		" is: " + recursiveSum(numba2));
        System.out.println("Sum of numbers from 1 to " + numba3 + 
        		" is: " + recursiveSum(numba3));
    }

    // Recursive method to calculate the sum of numbers from 1 to n
    public static int recursiveSum(int x) {
        if (x == 1) {
            return 1;
        }
        return x + recursiveSum(x - 1);
    }
}
