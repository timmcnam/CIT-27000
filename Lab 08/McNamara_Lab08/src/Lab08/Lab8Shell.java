// Timothy McNamara
// Lab 08
// 6/9/2024
// CIT 27000

package Lab08;

import java.util.Scanner;
public class Lab8Shell
{
	public static void main(String args[])
	{
		// DATA
		Shape[] shapes = new Shape[10];
		int nextIDNumber = 1;
		boolean exit = false;
		int selection;
		Scanner input = new Scanner(System.in);
		int id;
		int x, y;
		double base, height, width, radius;
		boolean found = false;

		// ALGORITHM
		// loop until user exits
		do
		{
			// display menu
			System.out.println("1 -> Add a new circle");
			System.out.println("2 -> Add a new rectangle");
			System.out.println("3 -> Add a new right triangle");
			System.out.println("4 -> Delete a shape");
			System.out.println("5 -> Delete all shape");
			System.out.println("6 -> Display all shapes");
			System.out.println("7 -> Move a shape");
			System.out.println("8 -> Enter a scale factor");
			System.out.println("9 -> Scale all shapes");
			System.out.println("10 -> Exit program");

			// get user choice
			selection = input.nextInt();
			while (selection < 1 || selection > 10)
			{
				System.out.println("ARE YOU SERIOUS? Please enter valid choice");
				selection = input.nextInt();
			}

			// switch on selection
			switch(selection)
			{
			case 1:
				// ADD NEW CIRCLE
                // get size from user (one variable)
                System.out.println("Enter the radius:");
                radius = input.nextDouble();
                while (radius <= 0) {
                    System.out.println("Invalid number, please enter a number greater than zero.");
                    radius = input.nextDouble();
                }

                // get location from user (two variables)
                System.out.println("Enter X location:");
                x = input.nextInt();
                System.out.println("Enter Y location:");
                y = input.nextInt();

                // set found to false
                found = false;

                // loop through array
                for (int i = 0; i < shapes.length; i++) {
                    // if this is not a valid object
                    if (shapes[i] == null) {
                        // create new Circle object and assign to current array element
                        shapes[i] = new Circle(nextIDNumber++, x, y, radius);

                        // set found to true
                        found = true;

                        // break out of loop
                        break;
                    }
                }

                // if not found, give error message
                if (!found) {
                    System.out.println("No more room to add new shapes. ¯\\_(ツ)_/¯");
                }

                // break out of switch statement
                break;

			case 2:				
				// ADD NEW RECTANGLE
				// get size from user (two variables)
		        System.out.println("Enter the width:");
		        width = input.nextDouble();
		        while (width <= 0) {
		            System.out.println("Invalid number, please enter a positive number");
		            width = input.nextDouble();
		        }

		        System.out.println("Enter the height:");
		        height = input.nextDouble();
		        while (height <= 0) {
		            System.out.println("Invalid number, please enter a positive number");
		            height = input.nextDouble();
		        }
		        
		        // get location from user (two variables)
		        System.out.println("Enter X location:");
		        x = input.nextInt();
		        System.out.println("Enter Y location:");
		        y = input.nextInt();
		        
		        // set found to false
		        found = false;
		        // loop through array
		        for (int i = 0; i < shapes.length; i++) {
		        	// if this is not a valid object
		            if (shapes[i] == null) {
		            	// create new Rectangle object and assign to current array element
		                shapes[i] = new Rectangle(nextIDNumber++, x, y, width, height);
		                
		                // set found to true
		                found = true;
		                
		                // break out of loop
		                break;
		            }
		        }
		        
		        // if not found, give error message
		        if (!found) {
		            System.out.println("No more room to add new shapes.");
		        }
		        // break out of switch statement
		        break;

			case 3:
				// ADD NEW RIGHT TRIANGLE
				// get size from user (two variables)
				System.out.println("Enter the base");
				base = input.nextDouble();
				while (base <= 0)
				{
					System.out.println("Invalid number, please enter positive number");
					base = input.nextDouble();
				}

				System.out.println("Enter the height");
				height = input.nextDouble();
				while (height <= 0)
				{
					System.out.println("Invalid number, please enter positive number");
					height = input.nextDouble();
				}

				// get location from user (two variables)
				System.out.println("Enter X location");
				x = input.nextInt();
				while (x < 0)
				{
					System.out.println("Invalid number, please enter positive number or zero");
					x = input.nextInt();
				}

				System.out.println("Enter Y location");
				y = input.nextInt();
				while (y < 0)
				{
					System.out.println("Invalid number, please enter positive number or zero");
					y = input.nextInt();
				}

				// set found to false
				found = false;

				// loop through array
				for (int i = 0; i < shapes.length; i++)
				{
					// if this is not a valid object
					if (shapes[i] == null)
					{
	 					// create new RightTriangle object and assign to current array element
						shapes[i] = new RightTriangle(nextIDNumber++, x, y, base, height);

						// set found to true
						found = true;

						// break out of loop
						break;
					}
				}

				// if not found, give error message
				if (!found)
				{
					System.out.println("No more room");
				}

				// break out of switch statement
				break;

			case 4:
				// DELETE ONE SHAPE
				// get id number to delete
				System.out.println("Enter the ID of the shape to delete:");
		        id = input.nextInt();
		        // set found to false
		        found = false;
		        // loop through array
		        for (int i = 0; i < shapes.length; i++) {
		        	// if this is a valid object and the correct object
		            if (shapes[i] != null && shapes[i].getId() == id) {
		            	// delete object
		                shapes[i] = null;
		                // set found to true
		                found = true;
		                // break out of loop
		                break;
		            }
		        }
		        
		        // if not found, give error message
		        if (!found) {
		            System.out.println("Shape not found.");
		        }
		        // break out of switch statement
		        break;

			case 5:
				// DELETE ALL SHAPES
				// loop through array
				
				for (int i = 0; i < shapes.length; i++) {
					// if this is a valid object
					if (shapes[i] != null) {
					// delete object
		            shapes[i] = null;
					}
		        }
		        System.out.println("All shapes have been deleted.");
		     // break out of switch statement
		        break;
		        
			case 6:
				// DISPLAY ALL SHAPES
				// print header
				System.out.println("Here are our shapes");
				// loop through array
				for (Shape shape : shapes) {
					// if this is a valid object
		            if (shape != null) {
		            	// display ID, X, Y, Perimeter and Area
		                System.out.println("ID: " + shape.getId() +
		                				 "\nX: " + shape.getXLoc() +
		                				 "\nY: " + shape.getYLoc() +
		                				 "\nPerimeter: " + shape.getPerimeter() +
		                				 "\nArea: " + shape.getArea());
		            }
		        }

				// break out of switch statement
				break;
				
			case 7:
				// MOVE A SHAPE
				// get id number to move
				System.out.println("Enter the ID of the shape to move:");
		        id = input.nextInt();

				// get location from user (two variables)
		        System.out.println("Enter new X location:");
		        x = input.nextInt();
		        System.out.println("Enter new Y location:");
		        y = input.nextInt();
				// set found to false
		        found = false;
		        
				// loop through array					
		        for (Shape shape : shapes) {
		        	// if this is a valid object and the correct object
		            if (shape != null && shape.getId() == id) {
		            	// call two set methods
		                shape.setXLoc(x);
		                shape.setYLoc(y);
		                // set found to true
		                found = true;
		                // break out of loop
		                break;
		            }
		        }

				// if not found, give error message
		        if (!found) {
		            System.out.println("Shape not found.");
		        }
		        
		        // break out of switch statement
		        break;

			case 8:
				// ENTER A SCALE FACTOR
				// get scale factor
				// ENTER A SCALE FACTOR
		        System.out.println("Enter a scale factor:");
		        // call SetScaleFactor to set the new scale factor
		        Shape.setScaleFactor(input.nextDouble());
		        // break out of switch statement
		        break;

			case 9:
				// SCALE ALL SHAPES
				// loop through array
				for (Shape shape : shapes) {
					// if this is a valid object
		            if (shape != null) {
		            	// call ScaleShape
		                shape.scaleShape();
		            }
		        }
		        System.out.println("All shapes have been scaled.");
		        // break out of switch statement
		        break;

			case 10:
				// EXIT PROGRAM
				// confirm user wants to exit
                System.out.println("Are you sure you want to exit? (yes/no)");
                String exitVar = input.next();
                // if the answer is yes
                if (exitVar.equalsIgnoreCase("yes")) {
                	// set variable to break out of loop
                    exit = true;
                }

                // break out of switch statement
                break;
        
			}

		} while (!exit);

	}

}