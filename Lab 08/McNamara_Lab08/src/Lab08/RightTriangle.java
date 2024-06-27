// Timothy McNamara
// Lab 08
// 6/9/2024
// CIT 27000
package Lab08;

class RightTriangle extends Shape {
    // Instance variables
    private double base;
    private double height;
    private double hypotenuse;

    // Constructor
    public RightTriangle(int id, double xLoc, double yLoc, double base, double height) {
        super(id, xLoc, yLoc);
        setBaseAndHeight(base, height); // This will also calculate the hypotenuse
    }

    // Set base and height, and calculate hypotenuse
    public void setBaseAndHeight(double base, double height) {
        if (base > 0.0 && height > 0.0) {
            this.base = base;
            this.height = height;
            this.hypotenuse = Math.sqrt(base * base + height * height);
        }
    }

    // Getters
    public double getBase() {
        return base;
    }
    public double getHeight() {
        return height;
    }
    public double getHypotenuse() {
        return hypotenuse;
    }

    // Override abstract methods from Shape
   
    public double getArea() {
        return 0.5 * base * height;
    }
    
    
    public double getPerimeter() {
        return base + height + hypotenuse;
    }

    
    public void scaleShape() {
        double scaleFactor = Shape.getScaleFactor();
        setBaseAndHeight(base * scaleFactor, height * scaleFactor);
        // Hypotenuse will be recalculated in setBaseAndHeight method
    }
}