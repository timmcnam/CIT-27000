/* Didn't put a commented header for my previous labs 
 * nor have I been putting good comments in them. 
 * Going to start doing this since this is good 
 * practice for coding.
 * Timothy McNamara
 * 05/19/20234
 * CIT 270
 * LAB 03
*/
package Lab03;

import java.util.Scanner;

public class Lab03Task01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// Variables used to sum up all the even and odd numbers
		int evenBoi=0;
		int oddBoi=0;
		
		// Used to represent count of all the one digit numbers
		int oneDigNumCnt=0;
		int twoDigNumCnt=0;
		
		// Used to count the odd numbers and the even numbers
		int oddNumCnt=0;
		int evenNumCnt=0;
		
		// Used to sum the one digit numbers and the two digit numbers
		int oneDigNumSum=0;
		int twoDigNumSum=0;
		
		// User enters supposedly random integers
        System.out.println("User, please enter four positive integers.");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        int num4 = scanner.nextInt();

      //Searching for largest number
        int largestNum = num1;
        if(num2>largestNum)
        	largestNum=num2;
        if(num3>largestNum)
        	largestNum=num3;
        if(num4>largestNum)
        	largestNum=num4;
        
        // Searching for smallest number
        int smallestNum = num1;
        if(num2<smallestNum)
        	smallestNum=num2;
        if(num3<smallestNum)
        	smallestNum=num3;
        if(num4<smallestNum)
        	smallestNum=num4;
        
        // The following statements poll through each integer
        // The integers are then take through the modulus operator
        // and if the remainder is zero they are even, otherwise
        // the are odd numbers. The number is then added to a the
        // variable oddBoi or evenBoi. The hold the sum of the odd 
        // numbers and the even numbers.
        if(num1%2 == 0) {
        	evenNumCnt++;
        	evenBoi += num1;
        }
        else {
        	oddNumCnt++;
        	oddBoi += num1;
        }

        if(num2%2 == 0){
        	evenNumCnt++;
        	evenBoi += num2;
        }
        else{
        	oddNumCnt++;
        	oddBoi += num2;
        }

        if(num3%2 == 0){
        	evenNumCnt++;
        	evenBoi += num3;
        }
        else{
        	oddNumCnt++;
        	oddBoi += num3;
        }

        if(num4%2 == 0){
        	evenNumCnt++;
        	evenBoi += num4;
        }
        else{
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
        } 
        else {
        	twoDigNumCnt++; 
        	twoDigNumSum += num1; 
        }
        if (num2 < 10) {
        	oneDigNumCnt++;
        	oneDigNumSum += num2; 
        } 
        else { 
        	twoDigNumCnt++; 
        	twoDigNumSum += num2; 
        }
        if (num3 < 10) { 
        	oneDigNumCnt++; 
        	oneDigNumSum += num3; 
        } 
        else { 
        	twoDigNumCnt++; 
        	twoDigNumSum += num3;
        }
        if (num4 < 10) { 
        	oneDigNumCnt++; 
        	oneDigNumSum += num4; 
        } 
        else { 
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

}
