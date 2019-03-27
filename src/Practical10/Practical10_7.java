package Practical10;
import java.awt.*;

import javax.swing.*;

public class Practical10_7 extends JFrame{
	//Constructor for this class
	public Practical10_7(){
		MyPanel drawPanel = new MyPanel();
		setTitle("UIPG");
		setSize(800,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(drawPanel);
		setVisible(true);
	}
	
	//Main Method
	public static void main (String [] args){
		Practical10_7 practical = new Practical10_7();
	}
}
//The panel Class
	class MyPanel extends JPanel{
		
		//Override the paintComponent() method in the super class Graphic
		@Override
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.setColor(Color.BLACK);
			g.drawLine(40, 30, 40, 500);
			g.drawLine(15, 450, 500, 450);
			
			g.setColor(Color.GREEN);
			g.fillRect(60, 150, 50, 300);
			
			g.setColor(Color.YELLOW);
			g.fillRect(130, 290, 50, 160);
			
			g.setColor(Color.GRAY);
			g.fillRect(200, 180, 50, 270);
			
			g.setColor(Color.CYAN);
			g.fillRect(270, 235, 50, 215);
		}
	}
