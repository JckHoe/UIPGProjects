package Assignment;

import java.awt.*;

import javax.swing.*;

public class AssignmentRobot extends JFrame{
	
	//Constructor for this class
	public AssignmentRobot (){
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
		AssignmentRobot assignment = new AssignmentRobot();
	}
	
	//The panel Class
	class MyPanel extends JPanel{
		
		//Override the paintComponent() method in the super class Graphic
		@Override
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			
			g.setColor(Color.GRAY);
			//Head
			g.fillRoundRect(123, 150, 80, 80, 10, 10);
			//Body
			g.fillRoundRect(106, 238, 118, 118, 15, 15);
			
			g.setColor(Color.YELLOW);
			//Top Head
			g.fillArc(100, 120, 120, 100, 0, 180);
			//Arms
			g.fillRect(82, 270, 16, 40);
			g.fillRect(233, 270, 16, 40);
			//Legs
			g.fillRect(125, 356, 25, 55);
			g.fillRect(180, 356, 25, 55);
			
			g.setColor(Color.BLACK);
			//ears
			g.fillRect(108, 182, 15, 8);
			g.fillRect(203, 182, 15, 8);
			//nose
			g.fillOval(160, 190, 15, 15);
			//eyes
			g.fillArc(71, 253, 70, 30, 90, 180);
			g.fillArc(189, 253, 70, 30, 270, 180);
			//hands
			g.fillOval(75, 300, 45, 25);
			g.fillOval(225, 300, 45, 25);
			//Body Stripe 1 (Black)
			g.fillRect(136, 254, 7, 35);
			g.fillRect(150, 254, 7, 35);
			g.fillRect(164, 254, 7, 35);
			g.fillRect(178, 254, 7, 35);
			g.fillRect(192, 254, 7, 35);
			//Feet
			g.fillArc(108, 400, 55, 40, 0, 180);
			g.fillArc(170, 400, 55, 40, 0, 180);
			
			g.setColor(Color.LIGHT_GRAY);
			//eyes and ears
			g.fillOval(93, 178, 15, 15);
			g.fillOval(217, 178, 15, 15);
			g.fillOval(140, 174, 15, 15);
			g.fillOval(180, 174, 15, 15);
			// eye lines
			g.drawOval(133, 170, 28, 28);
			g.drawOval(173, 170, 28, 28);
			
			g.setColor(Color.CYAN);
			//Necks
			g.fillRect(155, 230, 22, 8);
			
			g.setColor(Color.RED);
			//Body Stripe 2
			g.fillRect(129, 254, 7, 35);
			g.fillRect(143, 254, 7, 35);
			g.fillRect(157, 254, 7, 35);
			g.fillRect(171, 254, 7, 35);
			g.fillRect(185, 254, 7, 35);
			g.fillRect(199, 254, 7, 35);
			
			g.setColor(Color.BLUE);
			//Body Button 1
			g.fillOval(135, 308, 15, 15);
			
			g.setColor(Color.green);
			//Body Button 2
			g.fillOval(157, 308, 15, 15);
			
			g.setColor(Color.YELLOW);
			//Body Button 3
			g.fillOval(179, 308, 15, 15);
			
			g.setColor(Color.WHITE);
			//Body Button 4
			g.fillOval(200, 308, 15, 15);
			
			//Text
			g.setColor(Color.BLACK);
			g.setFont(new Font("Times New Roman", Font.BOLD, 40));
			g.drawString("My First Robot in Java", 350, 300);
			g.setFont(new Font("Arial", Font.PLAIN, 18));
			g.drawString("by Ong Jack Hoe (Student ID :0322368)", 400, 350);
		}
	}
}
