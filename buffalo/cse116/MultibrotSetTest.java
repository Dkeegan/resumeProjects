package edu.buffalo.cse116;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import java.awt.geom.Point2D;

/**
 * @author sovin
 * Test Cases for the Multibrot Set
 */
public class MultibrotSetTest {
	MultibrotSet Multi = new MultibrotSet();
	FractalDraw draw = new FractalDraw();
	GetterandSetter getter = new GetterandSetter();
	@Test
	public void rowToXCord() {
		GetterandSetter.SetEscapeDistance(2);
		GetterandSetter.SetEscapeTime(255);
		Point2D cords = new Point2D.Double(0, 0);
		assertEquals(255, Multi.multibrot(cords));
	}// I think that is how they are supposed to be done?

	@Test
	public void rowToYCord() {
		GetterandSetter.SetEscapeDistance(2);
		GetterandSetter.SetEscapeTime(255);
		Point2D cords = new Point2D.Double(0, 0);
		assertEquals(255, Multi.multibrot(cords));
	}

	@Test
	public void exceedsTheEscapeDistance() {// no idea what this means
		GetterandSetter.SetEscapeDistance(2);
		GetterandSetter.SetEscapeTime(255);
		Point2D cords = new Point2D.Double(0.3207031250000001, -0.07109374999999386);
		
		assertEquals(255, Multi.multibrot(cords), .000001);
	}

	@Test
	public void singleLoopPass() {
		GetterandSetter.SetEscapeDistance(2);
		GetterandSetter.SetEscapeTime(255);
		Point2D cords = new Point2D.Double(0.9921875, 1.05625);
		assertEquals(1, Multi.multibrot(cords), .000001);
	}// the escape time when passes = 1 Doesnt work but I dont know why

	@Test
	public void fractalReturns() {
		GetterandSetter.SetEscapeDistance(2);
		GetterandSetter.SetEscapeTime(255);
		assertEquals(512, draw.FractalMulti(-1.0,1.0,-1.3,1.3).length);// x
		// ? I dont know how to make y
	}
	@Test
	public void multiLoopPass() {
		GetterandSetter.SetEscapeDistance(3);
		Point2D cords = new Point2D.Double(0.7025440313111545, -0.5520547945205528);
		assertEquals(10, Multi.multibrot(cords), .000001);
	}
	@Test
	public void distanceFromOrigin(){
		GetterandSetter.SetEscapeDistance(2);
		GetterandSetter.SetEscapeTime(135);
		Point2D cords = new Point2D.Double(-1.7443359374999874, -0.017451171875000338);
		
		assertEquals(1, Multi.multibrot(cords), .00001);
	}
}