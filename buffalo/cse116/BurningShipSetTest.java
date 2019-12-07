package edu.buffalo.cse116;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import java.awt.geom.Point2D;

/**
 * @author sovin
 * Test Cases for the Burning Ship Set
 */
public class BurningShipSetTest {
	BurningShipSet burn = new BurningShipSet();
	FractalDraw draw = new FractalDraw();
	GetterandSetter getter = new GetterandSetter();
	@Test
	public void rowToXCord() {
		GetterandSetter.SetEscapeDistance(2);
		GetterandSetter.SetEscapeTime(255);
		Point2D cords = new Point2D.Double(0, 0);
		assertEquals(255, burn.burningShip(cords));
	}// I think that is how they are supposed to be done?

	@Test
	public void rowToYCord() {
		GetterandSetter.SetEscapeDistance(2);
		GetterandSetter.SetEscapeTime(255);
		Point2D cords = new Point2D.Double(0, 0);
		assertEquals(255, burn.burningShip(cords));
	}

	@Test
	public void exceedsTheEscapeDistance() {// no idea what this means
		Point2D cords = new Point2D.Double(-1.7443359374999874, -0.017451171875000338);
		GetterandSetter.SetEscapeDistance(2);
		GetterandSetter.SetEscapeTime(255);
		assertEquals(255, burn.burningShip(cords), .00001);
	}

	@Test
	public void singleLoopPass() {
		GetterandSetter.SetEscapeDistance(2);
		GetterandSetter.SetEscapeTime(255);
		Point2D cords = new Point2D.Double(0.5946289062500001, 1.2949218750000122);
		assertEquals(1, burn.burningShip(cords), .000001);
	}// the escape time when passes = 1 Doesnt work but I dont know why

	@Test
	public void fractalReturns() {
		assertEquals(512, draw.FractalShip(-1.8,-1.7,-.08,0.025).length);// x
		
	}
	@Test
	public void multiLoopPass() {
		GetterandSetter.SetEscapeTime(255);
		GetterandSetter.SetEscapeDistance(3);
		Point2D cords = new Point2D.Double(-1.6999999999999802, 0.0030136986301371603);
		assertEquals(10, burn.burningShip(cords), .000001);
	}
	@Test
	public void distanceFromOrigin(){
		GetterandSetter.SetEscapeDistance(2);
		GetterandSetter.SetEscapeTime(135);
		Point2D cords = new Point2D.Double(-1.7443359374999874, -0.017451171875000338);
		
		assertEquals(135, burn.burningShip(cords), .00001);
	}
}