package PracticalTest;

import java.awt.*;

import javax.swing.*;


public class Question3 extends JFrame{
	public Question3() {
		MyPanel drawPanel = new MyPanel();
		setTitle("UIPG");
		setSize(800,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(drawPanel);
		setVisible(true);
	}
	
	public static void main (String [] args){
		Question3 question = new Question3();
	}
}
class MyPanel extends JPanel{

	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.BLUE);
		g.setFont(new Font("Arial", Font.PLAIN, 18));
		g.drawString("year0", 30, 40);
		g.drawString("year1", 30, 110);
		g.drawString("year2", 30, 180);
		g.drawString("year3", 30, 250);
		g.drawString("year4", 30, 320);
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("Times New Roman", Font.BOLD, 25));
		g.drawString("Bar Chart from Year 2012 - 2017", 70, 400);
		
		g.setColor(Color.RED);
		g.setFont(new Font("Arial", Font.PLAIN, 18));
		g.drawString("100%",270 , 45);
		g.drawString("80%",270 , 115);
		g.drawString("70%",270 , 185);
		g.drawString("30%",270 , 255);
		g.drawString("50%",270 , 325);
		
		g.setColor(Color.GREEN);
		g.fillRect(100, 15, 150, 50);
		g.fillRect(100, 85, 120, 50);
		g.fillRect(100, 155, 100, 50);
		g.fillRect(100, 225, 40, 50);
		g.fillRect(100, 295, 75, 50);
	}
}
