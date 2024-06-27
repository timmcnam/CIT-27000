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
			System.out.println("1 Add a new circle");
			System.out.println("2 Add a new rectangle");
			System.out.println("3 Add a new right triangle");
			System.out.println("4 Delete a shape");
			System.out.println("5 Delete all shape");
			System.out.println("6 Display all shapes");
			System.out.println("7 Move a shape");
			System.out.println("8 Enter a scale factor");
			System.out.println("9 Scale all shapes");
			System.out.println("10 Exit program");

			// get user choice
			selection = input.nextInt();
			while (selection < 1 || selection > 10)
			{
				System.out.println("Please enter valid choice");
				selection = input.nextInt();
			}

			// switch on selection
			switch(selection)
			{
			case 1:
				// ADD NEW CIRCLE
				// get size from user (one variable)

				// get location from user (two variables)

				// set found to false

				// loop through array
					// if this is not a valid object
	 					// create new Circle object and assign to current array element

						// set found to true

						// break out of loop

				// if not found, give error message

				// break out of switch statement

			case 2:
				// ADD NEW RECTANGLE
				// get size from user (two variables)

				// get location from user (two variables)

				// set found to false

				// loop through array
					// if this is not a valid object
	 					// create new Rectangle object and assign to current array element

						// set found to true

						// break out of loop

				// if not found, give error message

				// break out of switch statement

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

				// set found to false

				// loop through array
					// if this is a valid object and the correct object
						// delete object

						// set found to true

						// break out of loop

				// if not found, give error message

				// break out of switch statement

			case 5:
				// DELETE ALL SHAPES
				// loop through array
					// if this is a valid object
						// delete object

				// break out of switch statement

			case 6:
				// DISPLAY ALL SHAPES
				// print header
				System.out.println("Here are our shapes");

				// loop through array
					// if this is a valid object
						// display ID, X, Y, Perimeter and Area


				// break out of switch statement

			case 7:
				// MOVE A SHAPE
				// get id number to move

				// get location from user (two variables)

				// set found to false

				// loop through array
					// if this is a valid object and the correct object
						// call two set methods

						// set found to true

						// break out of loop

				// if not found, give error message

				// break out of switch statement

			case 8:
				// ENTER A SCALE FACTOR
				// get scale factor

				// call SetScaleFactor to set the new scale factor

				// break out of switch statement

			case 9:
				// SCALE ALL SHAPES
				// loop through array
					// if this is a valid object
						// call ScaleShape

				// break out of switch statement
				break;

			case 10:
				// EXIT PROGRAM
				// confirm user wants to exit
					// set variable to break out of loop

				// break out of switch statement
			}

		} while (!exit);

	}

}

abstract class Shape
{
	// declare static variable

	// declare instance variables

	// one constructor

	// get/set methods

	// abstract methods
}

class Circle extends Shape
{
	// declare instance variable
	private double radius;

	// one constructor

	// get/set methods
	public double GetRadius()
	{
		return radius;
	}
	public void SetRadius(double r)
	{
		if (r > 0.0)
		{
			radius = r;
		}
	}

	// override abstract methods
	// GetPerimeter method
	public double GetPerimeter()
	{
		return 2 * Math.PI * radius;
	}

	// GetArea method
	public double GetArea()
	{
		return Math.PI * radius * radius;
	}

	// ScaleShape method


}

class Rectangle extends Shape
{
	// declare instance variables
	private double base;
	private double height;

	// one constructor

	// get/set methods
	public double GetBase()
	{
		return base;
	}
	public void SetBase(double b)
	{
		if (b > 0.0)
		{
			base = b;
		}
	}
	public double GetHeight()
	{
		return height;
	}
	public void SetHeight(double h)
	{
		if (h > 0.0)
		{
			height = h;
		}
	}

	// override abstract methods
	// GetPerimeter method
	public double GetPerimeter()
	{
		return (2 * base + 2 * height);
	}

	// GetArea method
	public double GetArea()
	{
		return base * height;
	}

	// ScaleShape method


}

class RightTriangle extends Shape
{
	// declare instance variables
	private double base;
	private double height;
	private double hypotenuse;

	// one constructor

	// get/set methods
	public void SetBaseAndHeight(double b, double h)
	{
		if (b > 0.0 && h > 0)
		{
			base = b;
			height = h;
			hypotenuse = Math.sqrt(base*base + height*height);
		}
	}

	public double GetBase()
	{
		return base;
	}
	public double GetHeight()
	{
		return height;
	}

	public double GetHypotenuse()
	{
		return hypotenuse;
	}

	// override abstract methods
	// GetPerimeter method
	public double GetPerimeter()
	{
		return base + height + hypotenuse;
	}

	// GetArea method
	public double GetArea()
	{
		return 0.5 * base * height;
	}

	// ScaleShape method


}