// Timothy McNamara
// Lab 08
// 6/9/2024
// CIT 27000
package Lab08;

class Rectangle extends Shape {
    // Instance variables
    private double width, height;

    // Constructor
    public Rectangle(int id, double xLoc, double yLoc, double width, double height) {
        super(id, xLoc, yLoc);
        this.width = width;
        this.height = height;
    }

    // Getters and setters
    public double getWidth() 
    { 
    	return width; 
    }
    
    public double getHeight() 
    { 
    	return height; 
    }
    
    public void setHeight(double height) 
    {
        if (height > 0.0) {
            this.height = height;
        }
    }
    
    public void setWidth(double width) 
    {
        if (width > 0.0) {
            this.width = width;
        }
    }

    // Override abstract methods
    
    public double getPerimeter() 
    { 
    	return 2 * (width + height); 
    }

    
    public double getArea() 
    { 
    	return width * height; 
    }

   
    public void scaleShape() 
    {
        width *= getScaleFactor();
        height *= getScaleFactor();
    }
}