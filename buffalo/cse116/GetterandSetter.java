package edu.buffalo.cse116;
import java.awt.image.IndexColorModel;

import edu.buffalo.cse116.Global;

/**
 * @author sovin
 * This Class is to Set and Return Values of Escape Distance and Color Models, which are called as global variables
 *
 */
public class GetterandSetter {
	
	/**
	 * This method is to Get the current value of Escape Distance
	 * @return Global.escapedist - This is the current value of Escape Distance
	 */
	public static double GetEscapeDistance(){
		return Global.escapedist;
	}
	/**
	 * This method is to Set a new value for Escape Distance
	 * @param new_escape_dist - New Value of type double, used as the Escape Distance
	 * @return Global.escapedist - This is the current value of Escape Distance
	 */
	public static double SetEscapeDistance(double new_escape_dist){
		Global.escapedist= new_escape_dist;
		return Global.escapedist;
	}

	/**
	 * This method is to Get the current Color Model
	 * @return Global.escapedist - This is the current Color Model
	 */
	public static IndexColorModel GetColorModel(){
		return Global.Model;
	}
	

	/**
	 * This method is to Set the current Color Model
	 * @return Global.escapedist - This is the current Color Model
	 */
	public static IndexColorModel SetColorModel(IndexColorModel newModel){
		Global.Model = newModel;
		return Global.Model;
	}
	
	/**
	 * This method is to get the Current Escape Time Value
	 * @return Global.escapetime - Current Escape Time value
	 */
	public static int GetEscapeTime(){
		return Global.escapetime;
	}
	
	/**This method is to allow a new value of Escape Time to be set
	 * 
	 * @param new_escape_time - new user inputed Escape Time
	 * @return Global.escapetime - the updated/current Escape Time
	 */
	public static int SetEscapeTime(int new_escape_time){
		Global.escapetime= new_escape_time;
		return Global.escapetime;
	}
	
	/**This method is to get the Current Fractal being used/generated
	 * @return Global.update - the current 2D array of escape time values
	 */
	public static int[][] GetFractal(){
		return Global.update;
		
	}
	/**This method is to set a new Fractal, which will be used to work on
	 * @param is - new 2D array of escape time values to be inputed
	 */
	public static void SetFractal(int[][] is){
		Global.update=is;
	}
	/**
	 * This method is to get the Current Thread Count
	 * @return Global.thread - Current Thread Count
	 */
	public static int GetThreads(){
		return Global.thread;
	}
	
	/**This method is to allow a new Thread count to be set
	 * 
	 * @param int threads - new user inputed thread count
	 * @return Global.thread - the updated/current thread count
	 */
	public static int SetThreads(int threads){
		Global.thread= threads;
		return Global.thread;
	}


}