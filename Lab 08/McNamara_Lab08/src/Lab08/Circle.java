// Timothy McNamara
// Lab 08
// 6/9/2024
// CIT 27000
package Lab08;

class Circle extends Shape {
	// Instance variable
    private double radius;

    // Constructor
    public Circle(int id, double xLoc, double yLoc, double radius) {
        super(id, xLoc, yLoc);
        this.radius = radius;
    }

    // Getters and setters
    public double getRadius() 
    { 
    	return radius; 
    }
    
    public void setRadius(double radius) {
        if (radius > 0.0) {
            this.radius = radius;
        }
    }

    // Override abstract methods
    
    public double getPerimeter() 
    { 
    	return 2 * Math.PI * radius; 
    }

    
    public double getArea() 
    { 
    	return Math.PI * radius * radius; 
    }

    
    public void scaleShape() 
    { 
    	radius *= getScaleFactor(); 
    }

}
