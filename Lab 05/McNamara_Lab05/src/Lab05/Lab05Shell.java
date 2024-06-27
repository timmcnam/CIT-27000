// Timothy McNamara
// Lab 05
// 5/26/2024
// CIT 27000

package Lab05;

import java.util.Scanner;

public class Lab05Shell {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// THese next lines get the information about the 
        // c1 and c2 are just variable names 
		// chosen to represent the first and second circles respectively
        System.out.println("Enter radius for first circle:");
        Circle c1 = new Circle(input.nextDouble());
        // Circle refers to the class predefined by the lab 5 instructions

        System.out.println("Enter radius for second circle:");
        Circle c2 = new Circle(input.nextDouble());

        // r1 and r2 are variable names chosen to represent the first and second right triangles respectively
        System.out.println("Enter base and height for first right triangle:");
        RightTriangle r1 = new RightTriangle(input.nextDouble(), input.nextDouble());
        // RightTriangle refers to the class predefined by the lab 5 instructions
        
        System.out.println("Enter base and height for second right triangle:");
        RightTriangle r2 = new RightTriangle(input.nextDouble(), input.nextDouble());

        // The following 4 lines print the stats for each shape. I am
        // not sure if we need to lower the precision of each double but
        // they are to the millionth place haha.
        System.out.println("Circle 1: \n " + c1.printStats());
        System.out.println("Circle 2: \n " + c2.printStats());
        System.out.println("Right Triangle 1: \n " + r1.printStats());
        System.out.println("Right Triangle 2: \n " + r2.printStats());

        // The next 10 lines of code take the areas of the two circles 
        // and the two right triangles, compare them and then
        // print which one is larger.
        if (c1.getArea() > c2.getArea()) {
            System.out.println("The first Circle has the biggest area.");
        } else {
            System.out.println("The second Circle has the biggest area.");
        }

        if (r1.getArea() > r2.getArea()) {
            System.out.println("The first Right Triangle has the larger area.");
        } else {
            System.out.println("The second Right Triangle has the larger area.");
        }

	}

}


