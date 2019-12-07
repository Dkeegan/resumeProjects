package edu.buffalo.cse116;

import java.awt.Point;
import java.awt.geom.Point2D;

/**
 * @author sovin
 * This Class contains methods to create a 2D array of each of the Fractal Sets
 */
public class FractalDraw {
	

	
	/**This method is for the Burning Ship Set Fractal
	 * @param xRangeStart
	 * @param xRangeEnd
	 * @param yRangeStart
	 * @param yRangeEnd
	 * @return fractal - This is a 2D int array of values, set equal to all possible escape times
	 */
	public int[][] FractalShip(double xRangeStart, double xRangeEnd,double yRangeStart,double yRangeEnd) {
		BurningShipSet burn = new BurningShipSet();
		int[][] fractal = new int[512][512];
		double n = 512;
		


		double xVal = xRangeStart;
		double yVal = yRangeStart;
		
		
		
		double xDiff = (xRangeEnd - xRangeStart) / n;
		double yDiff = (yRangeEnd - yRangeStart) / n;
		

		for (int x = 0; x < n; x++) {
			xVal = xVal + xDiff;
	
			yVal = yRangeStart;

			for (int y = 0; y < n; y++) {
				
				yVal = yVal + yDiff;
				
				Point2D cords = new Point.Double(xVal, yVal);

				int escapeTime = burn.burningShip(cords);
				
				fractal[x][y] = escapeTime;
				
				
				
			}
		}
		
	return fractal;
	
	
}
	/**This method is for the Mandelbrot Set Fractal
	 * @param xRangeStart
	 * @param xRangeEnd
	 * @param yRangeStart
	 * @param yRangeEnd
	 * 
	 * @return fractal - This is a 2D int array of values, set equal to all possible escape times
	 */
	public int[][] FractalMandel(double xRangeStart, double xRangeEnd,double yRangeStart,double yRangeEnd) {
		MandelbrotSet man = new MandelbrotSet();
		int[][] fractal = new int[512][512];
		double n = 512;
		

		
		double xVal = xRangeStart;
		double yVal = yRangeStart;
		
		
		
		double xDiff = (xRangeEnd - xRangeStart) / n;
		double yDiff = (yRangeEnd - yRangeStart) / n;
		
		for (int x = 0; x < n; x++) {
			xVal = xVal + xDiff;
	
			yVal = yRangeStart;

			for (int y = 0; y < n; y++) {
				
				yVal = yVal + yDiff;
				
				Point2D cords = new Point.Double(xVal, yVal);

				int escapeTime = man.mandelbrot(cords);
				
				fractal[x][y] = escapeTime;
				
				

				
			}
		}

	return fractal;
	
}
	
	/**	 * This method is for the Julia Set Fractal
	 * @param xRangeStart
	 * @param xRangeEnd
	 * @param yRangeStart
	 * @param yRangeEnd
	 * @return fractal - This is a 2D int array of values, set equal to all possible escape times
	 */
	public int[][] FractalJulia(double xRangeStart, double xRangeEnd,double yRangeStart,double yRangeEnd) {
		JuliaSet julia = new JuliaSet();
		int[][] fractal = new int[512][512];
		double n = 512;
		

		double xVal = xRangeStart;
		double yVal = yRangeStart;
		
		
		
		double xDiff = (xRangeEnd - xRangeStart) / n;
		double yDiff = (yRangeEnd - yRangeStart) / n;
		
		for (int x = 0; x < n; x++) {
			xVal = xVal + xDiff;
	
			yVal = yRangeStart;

			for (int y = 0; y < n; y++) {
				
				yVal = yVal + yDiff;
				
				Point2D cords = new Point.Double(xVal, yVal);

				int escapeTime = julia.juliaset(cords);
				
				fractal[x][y] = escapeTime;
				

				
			}
		}

	return fractal;
	
}
	/**This method is for the Multibrot Set Fractal
	 * @param xRangeStart
	 * @param xRangeEnd
	 * @param yRangeStart
	 * @param yRangeEnd
	 * @return fractal - This is a 2D int array of values, set equal to all possible escape times
	 */
	public int[][] FractalMulti(double xRangeStart, double xRangeEnd,double yRangeStart,double yRangeEnd) {
		MultibrotSet multi = new MultibrotSet();
		int[][] fractal = new int[512][512];
		double n = 512;
		

		
		double xVal = xRangeStart;
		double yVal = yRangeStart;
		
		
		
		double xDiff = (xRangeEnd - xRangeStart) / n;
		double yDiff = (yRangeEnd - yRangeStart) / n;
		

		for (int x = 0; x < n; x++) {
			xVal = xVal + xDiff;
	
			yVal = yRangeStart;

			for (int y = 0; y < n; y++) {
				
				yVal = yVal + yDiff;
				
				Point2D cords = new Point.Double(xVal, yVal);

				int escapeTime = multi.multibrot(cords);
				
				fractal[x][y] = escapeTime;
				

				
			}
		}

	return fractal;
	
}	
	

}
