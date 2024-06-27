// Timothy McNamara
// Lab 05
// 5/26/2024
// CIT 27000

package Lab05;

public class RightTriangle {
	private double height;
	private double base;
    private double hypotenuse;

    // This constructor  takes two double arguments 
    // to initialize the base and height. These variables can 
    // have different names but they just so happen have the same names
    // due to java's simplicity in name schemes. 
    public RightTriangle(double base, double height) {
    	this.height = height;
        this.base = base;
        // The hypotenuse of a right triangle is calculated 
        // using the Pythagorean theorem: a² + b² = c²
        // where a and b are the lengths of the two legs of the triangle, 
        // and c is the measurement of the hypotenuse
        this.hypotenuse = Math.sqrt(Math.pow(base, 2) + Math.pow(height, 2));
    }

    // This affirms there is no errors in the previous calculations
    // Also returns nothing.
    public void setBaseAndHeight(double base, double height) {
        this.base = base;
        this.height = height;
        this.hypotenuse = Math.sqrt(Math.pow(base, 2) + Math.pow(height, 2));
    }
    // Function to represent the height
    public double getHeight() {
        return height;
    }

    public double getBase() {
        return base;
    }

    

    public double getHypotenuse() {
        return hypotenuse;
    }

    // The formula for the area is calculated by 1/2 * base * height
    public double getArea() {
        return 0.5 * base * height;
    }

    // To calculate the perimeter of the triangles, we just add
    // up every single side of the triangle.
    public double getPerimeter() {
        return base + height + hypotenuse;
    }

    public String printStats() {
        return "Base: "  + base + "\n Height:" + height + "\n Hypotenuse: " 
        		+ hypotenuse + "\n Area: " + getArea() + " \n Perimeter: " + getPerimeter();
    }

}
