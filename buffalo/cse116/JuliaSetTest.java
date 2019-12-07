package edu.buffalo.cse116;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import java.awt.geom.Point2D;

/**
 * @author sovin
 * Test Cases for the Julia Set
 */
public class JuliaSetTest {
	JuliaSet Jul = new JuliaSet();
	FractalDraw draw = new FractalDraw();

	@Test
	public void rowToXCord() {
		GetterandSetter.SetEscapeDistance(2);
		GetterandSetter.SetEscapeTime(255);
		Point2D cords = new Point2D.Double(0, 0);
		assertEquals(176, Jul.juliaset(cords));
	}// I think that is how they are supposed to be done? This test was
		// different than the rest?

	@Test
	public void rowToYCord() {
		GetterandSetter.SetEscapeDistance(2);
		GetterandSetter.SetEscapeTime(255);
		Point2D cords = new Point2D.Double(0, 0);
		assertEquals(176, Jul.juliaset(cords));
	}

	@Test
	public void exceedsTheEscapeDistance() {// no idea what this means
		GetterandSetter.SetEscapeDistance(2);
		GetterandSetter.SetEscapeTime(255);
		Point2D cords = new Point2D.Double(1.0492187499999897, -0.234375);
		
		assertEquals(255, Jul.juliaset(cords), .000001);
	}

	@Test
	public void singleLoopPass() {
		GetterandSetter.SetEscapeDistance(2);
		GetterandSetter.SetEscapeTime(255);
		Point2D cords = new Point2D.Double(1.6933593749999853, 0.9765625);
		assertEquals(1, Jul.juliaset(cords), .000001);
	}// the escape time when passes = 1 Doesnt work but I dont know why

	@Test
	public void fractalReturns() {
		GetterandSetter.SetEscapeDistance(2);
		GetterandSetter.SetEscapeTime(255);
		assertEquals(512, draw.FractalJulia(-1.7,1.7,-1.0,1.0).length);// x
		
	}
	@Test
	public void multiLoopPass() {
		GetterandSetter.SetEscapeDistance(2);
		GetterandSetter.SetEscapeTime(255);
		GetterandSetter.SetEscapeDistance(3);
		Point2D cords = new Point2D.Double(1.4538160469667272,  -0.13502935420743645);
		assertEquals(10, Jul.juliaset(cords), .000001);
	}
	@Test
	public void distanceFromOrigin(){
		GetterandSetter.SetEscapeDistance(2);
		GetterandSetter.SetEscapeTime(135);
		Point2D cords = new Point2D.Double(-1.7443359374999874, -0.017451171875000338);
		
		assertEquals(1, Jul.juliaset(cords), .00001);
	}
}