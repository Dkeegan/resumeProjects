package edu.buffalo.cse116;

import java.awt.geom.Point2D;

/**
 * @author sovin
 * This class is for the Multibrot Set Fractal
 */
public class MultibrotSet {
	/**
	 * Value used for tests only; first x value cord of the set
	 */
	public double xCalcfirst;
	/**
	 * Value used for tests only; first y value cord of the set
	 */
	public double yCalcfirst;
	/**
	 * distance from the point (xCalc, yCalc) to (0,0) using the Pythagorean theorem
	 */
	public double dist;

	/**
	 * This method is to create the escapetime values for the Multibrot Set fractal
	 * 
	 * @param cords  cords are the points for the fractal
	 * @return escapetime - the escape time values of each point in the fractal
	 * 
	 * 
	 */
	public int multibrot(Point2D cords) {
		xCalcfirst = cords.getX();//here for tests
		yCalcfirst = cords.getY();
		
		
		double xCalc = cords.getX();
		double yCalc = cords.getY();
		dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));
		int passes = 0;
		
		while (dist <= GetterandSetter.GetEscapeDistance() && passes < GetterandSetter.GetEscapeTime()) {
			
			double xPrime = Math.pow(xCalc, 3) - (3 * xCalc * Math.pow(yCalc, 2)) + cords.getX();
			double yPrime = (3 * Math.pow(xCalc, 2) * yCalc) - Math.pow(yCalc, 3) + cords.getY();
			xCalc = xPrime;
			yCalc = yPrime;
			passes++;


			dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));

		}
		
		int escapetime = passes;
		
		return escapetime;

	}

}
