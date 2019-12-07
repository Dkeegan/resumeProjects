package edu.buffalo.cse116;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import edu.buffalo.cse116.GetterandSetter;

/**
 * @author sovin
 * This is the Class to for the creation of a dialog box, which accepts values for escape distance
 */

@SuppressWarnings("serial")
public class DialogBox extends JFrame {

	//Class Declarations
	JTextField jtfText;
	JTextField jtfText2;
	JTextField jtfText3;
	JLabel escapedist;
	JLabel escapetime;
	JLabel threads;
	String disp = "";
	TextHandler handler = null;
	TextHandler handler2 = null;
	TextHandler handler3 = null;
	
	/**
	 * This is the method to create the Dialog Box
	 */
	public void DialogBox() {
		Container container = getContentPane();
		SpringLayout layout = new SpringLayout();
		container.setLayout(layout);
		
		jtfText = new JTextField(5);
		jtfText2 = new JTextField(5);
		jtfText3 = new JTextField(5);
		
		escapedist = new JLabel ("Escape Distance(normal is 2):     ");
		escapetime = new JLabel ("Escape Time(normal is 255):     ");
		threads = new JLabel("Threads(normal is 1):   ");
		
		
		container.add(jtfText);
		container.add(jtfText2);
		container.add(jtfText3);
		
		container.add("Escape Distance", escapedist);
		container.add("Escape Time", escapetime);
		container.add("Threads", threads);
		
		layout.putConstraint(SpringLayout.WEST, jtfText, 250, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.SOUTH, jtfText2, 50, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.WEST, jtfText2, 250, SpringLayout.WEST, container);		
		layout.putConstraint(SpringLayout.SOUTH, escapetime, 50, SpringLayout.WEST, container);
		
		layout.putConstraint(SpringLayout.SOUTH, jtfText3, 90, SpringLayout.WEST, container);
		layout.putConstraint(SpringLayout.WEST, jtfText3, 250, SpringLayout.WEST, container);		
		layout.putConstraint(SpringLayout.SOUTH, threads, 90, SpringLayout.WEST, container);
		
		handler = new TextHandler();
		handler2 = new TextHandler();
		handler3 = new TextHandler();
		
		jtfText.addActionListener(handler);
		jtfText2.addActionListener(handler2);
		jtfText3.addActionListener(handler3);
		
		
		
		setSize(325, 150);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	//Inner Class TextHandler
	private class TextHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == jtfText) {
				double xDouble = Double.parseDouble(e.getActionCommand());
				
				if(xDouble > 0){
				GetterandSetter.SetEscapeDistance(xDouble);
				disp = "Escape Distance Set To : " + GetterandSetter.GetEscapeDistance();
				}else{
					disp = "Invalid Value! Please Enter A Value Greater Than Zero";
				}
				
			} else {
			}
			if(e.getSource() == jtfText2){
				int xInt = Integer.parseInt(e.getActionCommand());
				
				if(xInt > 0 && xInt <256){
					GetterandSetter.SetEscapeTime(xInt);
					disp = "Escape Time Set To : " +GetterandSetter.GetEscapeTime();
				}else{
					disp = "Invalid Value! Please Enter A Value Between 1 and 255";
				}
				
			} else {
				
			}
			
			if (e.getSource() == jtfText3) {
				int xInt1 = Integer.parseInt(e.getActionCommand());
					
				if(xInt1 > 0 && xInt1 < 129){				
					GetterandSetter.SetThreads(xInt1);
					disp = "Number of Threads Set To : " + GetterandSetter.GetThreads();
				}else{
					disp = "Invalid Value! Please Enter A Thread Count Between 1 and 128";
				}
				
			} else{
				
			}
				JOptionPane.showMessageDialog(null, disp);
		}
			
	}
	
	
}

