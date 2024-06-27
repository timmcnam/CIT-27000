// Worked a lot to get this going and to make the console look the prettiest
// when outputting to the console. Hope it all looks great

// Timothy McNamara
// Lab 07
// 5/28/2024
// CIT 27000

package Lab07;

import java.util.Scanner;

public class Lab7Shell {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // DATA
        RightTriangle[] triangles = new RightTriangle[10];
        int nextIdNumber = 1;
        double base = 0;
        double height = 0;        
        boolean exit = false;
        boolean found;
        int selection = 0;
        int id = 0;
        int x = 0;
        int y = 0;        
        final boolean end = true;
        

        // ALGORITHM
        // loop until user exits
        do {
            // display options
            System.out.println("Please select from the following options. "
            		+ "\n 1 <–> Enter a new right triangle"
            		+ "\n 2 <–> Delete a right triangle"
            		+ "\n 3 <–> Delete all right triangles"
            		+ "\n 4 <–> Display all right triangles"
            		+ "\n 5 <–> Move a triangle"
            		+ "\n 6 <–> Resize a triangle"
            		+ "\n 7 <–> Enter a scale factor"
            		+ "\n 8 <–> Scale all triangles"
            		+ "\n 9 <–> Exit program");
           
            

            // get selection (validate)
            selection = input.nextInt();

            // switch on selection
            switch (selection) {
                case 1:
                    // get size from user (two variables only, calculate the hypotenuse)
                    System.out.println("What is the base and height for the right triangle. Please Enter.");
                    base = input.nextDouble();
                    height = input.nextDouble();

                    // get location from user (two variables, X,Y location)
                    System.out.println("Enter a X and Y location for the right triangle:");
                    x = input.nextInt();
                    y = input.nextInt();

                    // set found to false
                    found = false;

                    // loop through array
                    for (int i = 0; i < triangles.length; i++) {
                        // if this is an empty spot
                        if (triangles[i] == null) {
                            // create new RightTriangle object and assign to current array element
                            triangles[i] = new RightTriangle(nextIdNumber++, base, height, x, y);

                            // set found to true
                            found = true;

                            // break out of loop
                            break;
                        }
                    }

                    // if not found, give error message
                    if (!found) {
                        System.out.println("A triangle needs to be removed before adding another.");
                    }

                    // break out of switch statement
                    break;

                case 2:
                    // get id number to delete
                    System.out.println("What Triangle would you like to delete? Enter the ID to delete.");
                    id = input.nextInt();

                    // set found to false
                    found = false;

                    // loop through array
                    for (int i = 0; i < triangles.length; i++) {
                        // if this is a valid object and the correct object
                        if (triangles[i] != null && triangles[i].GetId() == id) {
                            // delete object
                            triangles[i] = null;

                            // set found to true
                            // using the end variable instead of true. Reinventing the wheel to
                            // Test by brain muscles. 
                            found = end;

                            // break out of loop
                            break;
                        }
                    }

                    // if not found, give error message
                    if (!found) {
                        System.out.println("Triangle " + id + " doesn't exist.");
                    }

                    // break out of switch statement
                    break;

                case 3:
                    // loop through array
                    for (int i = 0; i < triangles.length; i++) {
                        // if this is a valid object
                        triangles[i] = null;
                    }

                    // break out of switch statement
                    break;

                case 4:
                    // display header
                    System.out.println("Here are all the Right Triangles:\n");

                    // loop through array
                    for (int i = 0; i < triangles.length; i++) {
                        // if this is a valid object
                        if (triangles[i] != null) {
                            // display all info about object. This should call and display all 8 get methods that return information.
                            System.out.println(triangles[i].PrintRightTriangleStats());
                        }
                    }

                    // break out of switch statement
                    break;

                case 5:
                    // get id number to move
                    System.out.println("Enter ID of the triangle to move:");
                    id = input.nextInt();

                    // get location from user (two variables new X,Y location)
                    System.out.println("Enter new X and Y location for the triangle:");
                    x = input.nextInt();
                    y = input.nextInt();

                    // set found to false
                    found = false;

                    // loop through array
                    for (int i = 0; i < triangles.length; i++) {
                        // if this is a valid object and the correct object
                        if (triangles[i] != null && triangles[i].GetId() == id) {
                            // call two set methods
                            triangles[i].SetXLoc(x);
                            triangles[i].SetYLoc(y);

                            // set found to true
                            found = true;

                            
                            break;
                        }
                    }

                    // if not found, give error message
                    if (!found) {
                        System.out.println("Triangle " + id + " doesn't exist.");
                    }

                    // break out of switch statement
                    break;

                case 6:
                    // get id number to resize
                    System.out.println("What triangle would you like to resize? Enter the ID.");
                    id = input.nextInt();

                    // get size from user (two variables)
                    System.out.println("Enter new base and height for the triangle:");
                    base = input.nextDouble();
                    height = input.nextDouble();

                    // set found to false
                    found = false;

                    // loop through array
                    for (int i = 0; i < triangles.length; i++) {
                        // if this is a valid object and the correct object
                        if (triangles[i] != null && triangles[i].GetId() == id) {
                            // call SetBaseAndHeight
                            triangles[i].SetBaseAndHeight(base, height);

                            // set found to true
                            found = true;

                            
                            break;
                        }
                    }

                    // if found is not true, then the 
                    if (!found) {
                        System.out.println("Triangle " + id + " doesn't exist.");
                    }

                    // break out of switch statement
                    break;

                case 7:
                    // get new scale factor (validate)
                    System.out.println("Enter a  scale factor:");
                    double scaleFactor = input.nextDouble();

                    // call SetScaleFactor to set the new scale factor
                    RightTriangle.SetScaleFactor(scaleFactor);

                    // break out of switch statement
                    break;

                case 8:
                    // loop through array
                    for (int i = 0; i < triangles.length; i++) {
                        // if this is a valid object
                        if (triangles[i] != null) {
                            // call ScaleShape method on object
                            triangles[i].ScaleShape();
                        }
                    }

                    // break out of switch statement
                    break;

                case 9:
                    // confirm user wants to exit
                    System.out.println("Are you sure you want to exit? (yes/no)");
                    String responeToNumberNine = input.next();
                    if (responeToNumberNine.equalsIgnoreCase("yes")) {
                        // set variable to break out of loop
                    	// end sets exit equal to true
                        exit = end;
                    }
                    
                    // break out of switch statement
                    break;
                    
                
            }
            
            // No default since I am unsure whether or not we are requiring one?
            // Nevertheless, I still added this prompt if the selection in not between 1-9
            if ( selection > 9 || selection < 0) {
            	System.out.println("I'm afraid that isn't an option. \n");
            }
            // End loop
            // Couldv'e used while (!exit), just reinventing the wheel.
        } while (exit == false);
    }
}