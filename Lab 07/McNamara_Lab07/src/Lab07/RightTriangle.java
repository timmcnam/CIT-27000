// I love using the "this" keyword, it helps me better understand java and keep the naming convention simple
// for me. I also am not sure whether I have been properly been implementing the reverse camel case
// standard when it comes to methods, but I will try to be starting now. 

// Timothy McNamara
// 5/28/2024
// Lab 07
// CIT 27000

package Lab07;

public class RightTriangle {
	// with three instance variables of type double called base, height, and hypotenuse.
		private double base;
		private double height;
		private double hypotenuse;

		// add three new instance variables
		private int id;
		private int xLoc;
		private int yLoc;

		// add static scaleShape
		private static double scaleFactor;

		// update constructor to take the new instance variables
		public RightTriangle(int id, double base, double height, int x, int y)
		{
			SetBaseAndHeight(base, height);
			xLoc = x;
	        yLoc = y;
	        this.id = id;
			
			// set the other instance variables
		}

		// a single set method which takes new values for base and height and calculates the hypotenuse,
		public void SetBaseAndHeight(double base , double height)
		{
			if (base > 0.0 && height > 0.0)
			{
				this.base = base;
				this.height = height;
				hypotenuse = Math.sqrt(base * base + height * height);
			}
		}

		// add set methods for the three new instance variables
		// As long as they are greater than zero, we should be 
		// set on "setting" the variables.
		public void SetXLoc(int x) {
	        if (x >= 0) {
	            xLoc = x;
	        }
	    }
		
		// Decided not to use the "this."keyword since 
		// I just renamed the argument variables
	    public void SetYLoc(int y) {
	        if (y >= 0) {
	            yLoc = y;
	        }
	    }

	    public void SetId(int id) {
	        if (id > 0) {
	            this.id = id;
	        }
	    }

		public static void SetScaleFactor(double scaleFactor) {
	        if (scaleFactor > 0.0) {
	            RightTriangle.scaleFactor = scaleFactor;
	        }
	    }
		private void SetHypotenuse(double hypotenuse) {
			this.hypotenuse = hypotenuse;
		}
		
		public void SetHeight(double height) {
			if (height > 0) {
				this.height = height;
			double hyp = Math.sqrt(Math.pow(base, 2)+Math.pow(height,2));
			SetHypotenuse(hyp);
			}
		}
		
		public void SetBase(double b) {
			if (b > 0)
				base = b;
			double hyp = Math.sqrt(Math.pow(b, 2)+Math.pow(height,2));
			SetHypotenuse(hyp);
		}
			
		// get methods for all three instance variables
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

		// add get methods for the three new instance variables
		public int GetId() {
			return id;
		}
		public int GetXLoc() {
			return xLoc;
		}
		public int GetYLoc() {
			return yLoc;
		}
		

		// and methods getArea and getPerimeter.
		public double GetArea()
		{
			return 0.5 * base * height;
		}
		public double GetPerimeter()
		{
			return base + height + hypotenuse;
		}

		// add ScaleShape method
		public void ScaleShape() {
			double b = base * scaleFactor;
			double h = height * scaleFactor;
			SetBase(b);
			SetHeight(h);
		}
		
		// method for all the right Triangle stats.
		// Lined them up so they look prettier
		public String PrintRightTriangleStats() {
	        return "TRIANGLE      -> " + GetId() +
	        	   "\nThe base    -> "  + GetBase() + 
	        	   "\nHeight      ->" + GetHeight() + 
	        	   "\nHypotenuse  -> " + GetHypotenuse() + 
	        	   "\nArea        -> " + GetArea() + 
	        	   "\nPerimeter   -> " + GetPerimeter() + "\n";
	    }


}
