package edu.buffalo.cse116;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;
import java.awt.image.IndexColorModel;
import java.util.Arrays;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import edu.buffalo.cse116.DialogBox;
import edu.buffalo.fractal.FractalPanel;





/**
 * @author sovin
 * This is our UI class, which creates the programs functionality and User GUI
 */
public class UI implements Runnable {

	
	Rectangle2D rectangle;
	
	JFrame _frame;
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem menuItem;
	JRadioButtonMenuItem rbMenuItem;	
	JRadioButton rbMenu;
	JMenuItem MenuItem;
	
	String disp = "";
//	Zoom zoom = new Zoom();

	public boolean isPointTwoInQuadOne(Point p1, Point p2) {
        return p1.x >= p2.x && p1.y >= p2.y;
    }
	
	
	
	@SuppressWarnings("serial")
	@Override
	public void run() {
	final	FractalDraw draw = new FractalDraw();
		_frame = new JFrame("Fractals");
		

		final DialogBox change = new DialogBox();
		final	FractalPanel Panel = new FractalPanel(){
	        Point p1 = null;
	        Point p2   = null;
	        {addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                	 p1 = e.getPoint();
                	 
                	 if(p1.getX() < 0 && p1.getY() <0){
                		 p1.setLocation(0,0);
                	 }else if(p1.getX() < 0){
                		 p1.setLocation(0, p1.y);
                	 }else if(p1.getY() < 0){
                		 p1.setLocation(p1.x, 0);
                	 }else if(p1.getX() > 2048 && p1.getY() > 2048){
                		 p1.setLocation(2048, 2048);
                	 }else if(p1.getX() > 2048){
                		 p1.setLocation(2048, p1.y);
                	 }else if(p1.getY() > 2048){
                		 p1.setLocation(p1.x, 2048);
                	 }else{
                	 }
             
                     rectangle = new Rectangle2D.Double(p1.x, p1.y, p1.x - p1.x, p1.y - p1.y);
                     
                }

                public void mouseReleased(MouseEvent e) {
//                	zoom.Zoom(p1, p2);
                	updateImage(GetterandSetter.GetFractal());
                	rectangle.setRect(0,0,0,0);  
                	
                	System.out.println("Point 1 Coords: "+p1);
                	System.out.println("Point 2 Coords: "+p2);
                	repaint();
                	
                	

                }
            });
            addMouseMotionListener(new MouseMotionAdapter() {
                public void mouseMoved(MouseEvent e) {
                    p2 = e.getPoint();
                }

                public void mouseDragged(MouseEvent e) {
                	
                        p2 = e.getPoint();
                        
                      	if(p2.getX() < 0 && p2.getY() <0){
                    		 p2.setLocation(0,0);
                    	 }else if(p2.getX() < 0){
                    		 p2.setLocation(0, p2.y);
                    	 }else if(p2.getY() < 0){
                    		 p2.setLocation(p2.x, 0);
                    	 }else if(p2.getX() > 2048 && p2.getY() > 2048){
                    		 p2.setLocation(2048, 2048);
                    	 }else if(p2.getX() > 2048){
                    		 p2.setLocation(2048, p2.y);
                    	 }else if(p2.getY() > 2048){
                    		 p2.setLocation(p2.x, 2048);
                    	 }else{
                    	 }
                    
                        if (isPointTwoInQuadOne(p1, p2)) {
                            rectangle.setRect(p2.x, p2.y, p1.x - p2.x, p1.y - p2.y);
                        } else {
                            rectangle.setRect(p1.x, p1.y, p2.x - p1.x, p2.y - p1.y);
                        }
                        
                        repaint();
                    }
                
            });
        }
        public void paint(Graphics g) {
        	Color c=new Color(1f,0f,0f,.5f );
        	super.paint(g);
            Graphics2D g2 = (Graphics2D)g;
            if (rectangle != null) {
            	g2.setColor(c);
            	g2.fill(rectangle);	                
            }
        }      
    };
		// Create the menu bar.
		menuBar = new JMenuBar();

		// Build the first menu
		menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);
		menu.getAccessibleContext().setAccessibleDescription("A second way to close the program");
		menuBar.add(menu);

		
		MenuItem = new JMenuItem("Close");

		MenuItem.setSelected(false);
		MenuItem.setMnemonic(KeyEvent.VK_C);
		MenuItem.addActionListener (new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
//		closeMenu.add(rbMenuItem);
		menu.add(MenuItem);
		
		
		MenuItem = new JMenuItem("Reset");
		
		MenuItem.setSelected(false);
		MenuItem.setMnemonic(KeyEvent.VK_R);
		MenuItem.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if(!Arrays.equals(GetterandSetter.GetFractal(), draw.FractalMandel(-2.15, .6, -1.3, 1.3))){
					GetterandSetter.SetFractal(draw.FractalMandel(-2.15, .6, -1.3, 1.3));
					GetterandSetter.SetEscapeDistance(2);
					GetterandSetter.SetEscapeTime(255);
				}else if(!Arrays.equals(GetterandSetter.GetFractal(), draw.FractalJulia(-1.7,1.7,-1.0,1.0))){
					GetterandSetter.SetFractal(draw.FractalJulia(-1.7,1.7,-1.0,1.0));
					GetterandSetter.SetEscapeDistance(2);
					GetterandSetter.SetEscapeTime(255);
				}else if(!Arrays.equals(GetterandSetter.GetFractal(),draw.FractalShip(-1.8,-1.7,-.08,0.025))){
					GetterandSetter.SetFractal(draw.FractalShip(-1.8,-1.7,-.08,0.025));
					GetterandSetter.SetEscapeDistance(2);
					GetterandSetter.SetEscapeTime(255);
				}else if(!Arrays.equals(GetterandSetter.GetFractal(),draw.FractalMulti(-1.0,1.0,-1.3,1.3))){
					
					GetterandSetter.SetFractal(draw.FractalMulti(-1.0,1.0,-1.3,1.3));
					GetterandSetter.SetEscapeDistance(2);
					GetterandSetter.SetEscapeTime(255);
				}
				
				
				
				else{
					System.out.println("We ain't zoomin boi");
				}
				Panel.updateImage(GetterandSetter.GetFractal());
				String disp = "Zoom Reset";
				JOptionPane.showMessageDialog(null, disp);
			}
			
		});
		

		menu.add(MenuItem);
		
		// Build the Second menu.
		menu = new JMenu("Fractal");
		menu.setMnemonic(KeyEvent.VK_R);
		menu.getAccessibleContext().setAccessibleDescription("The menu to choose the Fractal");
		menuBar.add(menu);
		// List the options to choose from in the file
		ButtonGroup setsMenu = new ButtonGroup();
		
		rbMenuItem = new JRadioButtonMenuItem("Mandelbrot Set");
		rbMenuItem.setSelected(true);
		rbMenuItem.setMnemonic(KeyEvent.VK_M);
		rbMenuItem.addActionListener (new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Panel.setSize(Panel.getImageWidth(), Panel.getImageHeight());
				GetterandSetter.SetFractal(draw.FractalMandel(-2.15,.6,-1.3,1.3));
				Panel.updateImage(GetterandSetter.GetFractal());
				
			}
			
		});
		setsMenu.add(rbMenuItem);
		menu.add(rbMenuItem);

		rbMenuItem = new JRadioButtonMenuItem("Julia Set");
		rbMenuItem.setMnemonic(KeyEvent.VK_J);
		rbMenuItem.addActionListener (new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Panel.setSize(Panel.getImageWidth(), Panel.getImageHeight());
				GetterandSetter.SetFractal(draw.FractalJulia(-1.7,1.7,-1.0,1.0));
				Panel.updateImage(GetterandSetter.GetFractal());
				
			}
			
		});
		setsMenu.add(rbMenuItem);
		menu.add(rbMenuItem);

		rbMenuItem = new JRadioButtonMenuItem("Burning Ship Set");
		rbMenuItem.setMnemonic(KeyEvent.VK_B);
		
		rbMenuItem.addActionListener (new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				Panel.setSize(Panel.getImageWidth(), Panel.getImageHeight());
				GetterandSetter.SetFractal(draw.FractalShip(-1.8,-1.7,-.08,0.025));
				Panel.updateImage(GetterandSetter.GetFractal());
				
				
			}
			
		});
		setsMenu.add(rbMenuItem);	
		
		menu.add(rbMenuItem);

		rbMenuItem = new JRadioButtonMenuItem("Multibrot Set");
		rbMenuItem.setMnemonic(KeyEvent.VK_U);
		rbMenuItem.addActionListener (new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
			
				Panel.setSize(Panel.getImageWidth(), Panel.getImageHeight());
				GetterandSetter.SetFractal(draw.FractalMulti(-1.0,1.0,-1.3,1.3));
				Panel.updateImage(GetterandSetter.GetFractal());
				
			}
			
		});
		
		setsMenu.add(rbMenuItem);
		menu.add(rbMenuItem);

		// Build second menu in the menu bar.
	
		//Our color methods should be a different class. Like Fractal Draw. This is a low priority but they
		//are doing a function so they do not belong in the ui section
		menu = new JMenu("Colors");
		menu.setMnemonic(KeyEvent.VK_C);
		menu.getAccessibleContext().setAccessibleDescription("Choose your colors!");
		menuBar.add(menu);
		ButtonGroup colorsMenu = new ButtonGroup();
		rbMenuItem = new JRadioButtonMenuItem("Color 1");
		rbMenuItem.setSelected(true);
		rbMenuItem.setMnemonic(KeyEvent.VK_1);

		rbMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int SIZE = 256;
				byte[] r = new byte[SIZE];
				byte[] g = new byte[SIZE];
				byte[] b = new byte[SIZE];
				for (int i = 0; i < SIZE; i++) {
					g[i] = (byte) i;
					r[i / 4] = (byte) i;
					b[i / 8] = (byte) i;
				}
				IndexColorModel newModel = new IndexColorModel(8, SIZE, r, g, b);
				GetterandSetter.SetColorModel(newModel);
				Panel.setIndexColorModel(GetterandSetter.GetColorModel());
				Panel.updateImage(GetterandSetter.GetFractal());

			}

		});
		colorsMenu.add(rbMenuItem);
		menu.add(rbMenuItem);

		rbMenuItem = new JRadioButtonMenuItem("Color 2");
		rbMenuItem.setMnemonic(KeyEvent.VK_2);
		rbMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int SIZE = 256;
				byte[] r = new byte[SIZE];
				byte[] g = new byte[SIZE];
				byte[] b = new byte[SIZE];
				for (int i = 0; i < SIZE; i++) {
					b[i] = (byte) i;
					r[i / 4] = (byte) i;
					g[i / 8] = (byte) i;
				}
				IndexColorModel newModel = new IndexColorModel(8, SIZE, r, g, b);
				GetterandSetter.SetColorModel(newModel);
				Panel.setIndexColorModel(GetterandSetter.GetColorModel());
				Panel.updateImage(GetterandSetter.GetFractal());

			}

		});
		colorsMenu.add(rbMenuItem);
		menu.add(rbMenuItem);

		rbMenuItem = new JRadioButtonMenuItem("Color 3");
		rbMenuItem.setMnemonic(KeyEvent.VK_3);
		rbMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int SIZE = 256;
				byte[] r = new byte[SIZE];
				byte[] g = new byte[SIZE];
				byte[] b = new byte[SIZE];
				for (int i = 0; i < SIZE; i++) {
					r[i] = (byte) i;
					g[i / 4] = (byte) i;
					b[i / 32] = (byte) i;
				}
				IndexColorModel newModel = new IndexColorModel(8, SIZE, r, g, b);
				GetterandSetter.SetColorModel(newModel);
				Panel.setIndexColorModel(GetterandSetter.GetColorModel());

				Panel.updateImage(GetterandSetter.GetFractal());

			}

		});
		colorsMenu.add(rbMenuItem);
		menu.add(rbMenuItem);

		rbMenuItem = new JRadioButtonMenuItem("Color 4");
		rbMenuItem.setMnemonic(KeyEvent.VK_4);
		rbMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int SIZE = 256;
				byte[] r = new byte[SIZE];
				byte[] g = new byte[SIZE];
				byte[] b = new byte[SIZE];
				for (int i = 0; i < SIZE; i++) {
					r[i] = (byte) i;
					g[i / 4] = (byte) i;
					b[i / 8] = (byte) i;
				}
				IndexColorModel newModel = new IndexColorModel(8, SIZE, r, g, b);
				GetterandSetter.SetColorModel(newModel);
				Panel.setIndexColorModel(GetterandSetter.GetColorModel());
				Panel.updateImage(GetterandSetter.GetFractal());

			}

		});
		colorsMenu.add(rbMenuItem);
		menu.add(rbMenuItem);

		rbMenuItem = new JRadioButtonMenuItem("Are you feeling lucky?");
		rbMenuItem.setMnemonic(KeyEvent.VK_L);
		rbMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int SIZE = 256;
				Random rand = new Random();

				byte[] r = new byte[SIZE];
				byte[] g = new byte[SIZE];
				byte[] b = new byte[SIZE];
				for (int i = 0; i < SIZE; i++) {
					r[rand.nextInt(256)] = (byte) i;
					g[rand.nextInt(256)] = (byte) i;
					b[rand.nextInt(256)] = (byte) i;
				}
				IndexColorModel newModel = new IndexColorModel(8, SIZE, r, g, b);
				GetterandSetter.SetColorModel(newModel);
				Panel.setIndexColorModel(GetterandSetter.GetColorModel());
				Panel.updateImage(GetterandSetter.GetFractal());
			}

		});
		colorsMenu.add(rbMenuItem);
		menu.add(rbMenuItem);
		
		
		


		change.DialogBox();
		GetterandSetter.SetEscapeDistance(2);
		GetterandSetter.SetEscapeTime(255);
		GetterandSetter.SetFractal(draw.FractalMandel(-2.15,.6,-1.3,1.3));
		Panel.setSize(2048,2048);
		Panel.setPreferredSize(new Dimension(2048,2048));
		Panel.updateImage(GetterandSetter.GetFractal());
		_frame.add(Panel);
		_frame.setJMenuBar(menuBar);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.pack();
		_frame.setVisible(true);
		
		System.out.println(Panel.getSize());
		
		
	}
	

}

