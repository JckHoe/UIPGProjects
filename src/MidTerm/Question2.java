package MidTerm;

import java.awt.*;
import javax.swing.*;

public class Question2 extends JFrame{
	public Question2() {
		MyPanel drawPanel = new MyPanel();
		setTitle("UIPG");
		setSize(800,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(drawPanel);
		setVisible(true);
	}
	
	public static void main (String [] args){
		Question2 question2 = new Question2();
	}
}
class MyPanel extends JPanel{
	
	//Override the paintComponent() method in the super class Graphic
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.RED);
		int[] xPoints = {90, 180, 300, 390, 390, 300, 180, 90 };
		int[] yPoints = {180, 90, 90, 180, 300, 390, 390, 300 };
		g.fillPolygon(xPoints, yPoints, 8);
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.BOLD, 80)); 
		g.drawString("STOP", 135, 270);
	}
}
