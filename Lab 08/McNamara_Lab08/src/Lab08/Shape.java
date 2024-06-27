// Timothy McNamara
// Lab 08
// 6/9/2024
// CIT 27000
package Lab08;

abstract class Shape {
	 private static double scaleFactor;
	    private int id;
	    private double xLoc, yLoc;

	    // Constructor for Shape
	    public Shape(int id, double xLoc, double yLoc) {
	        this.id = id;
	        this.xLoc = xLoc;
	        this.yLoc = yLoc;
	    }

	    // Getters and setters for id, xLoc, yLoc, and scaleFactor
	    public int getId() 
	    { 
	    	return id; 
	    }
	    
	    public void setId(int id) 
	    { 
	    	this.id = id; 
	    }
	    
	    public double getXLoc() 
	    { 
	    	return xLoc; 
	    }
	    
	    public void setXLoc(double xLoc) 
	    { 
	    	this.xLoc = xLoc; 
	    }
	    
	    public double getYLoc() 
	    { 
	    	return yLoc; 
	    }
	    
	    public void setYLoc(double yLoc) 
	    { 
	    	this.yLoc = yLoc; 
	    }
	    
	    public static double getScaleFactor() 
	    { 
	    	return scaleFactor;
	    }
	    
	    public static void setScaleFactor(double scaleFactor) 
	    { 
	    	Shape.scaleFactor = scaleFactor; 
	    }

	    // Abstract methods to be implemented by subclasses
	    public abstract double getArea();
	    public abstract double getPerimeter();
	    public abstract void scaleShape();
	}


