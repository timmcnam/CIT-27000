// Timothy McNamara
// Lab 05
// 5/26/2024
// CIT 27000

package Lab05;


public class Circle {
	private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    // Double checks that the radius is the proper one we want. 
    // It's an error check. Also returns nothing.
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // The area of a circle is calculated as π*r^2
    // r is the radius.
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    // The perimeter, I believe, is the circumference
    // of a circle. The formula is 2 * π * r.
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public String printStats() {
        return "Radius: " + radius + "\n Area: " + getArea() + "\n Perimeter: " + getPerimeter();
    }
}
