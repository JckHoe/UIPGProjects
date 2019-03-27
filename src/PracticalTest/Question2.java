package PracticalTest;

import java.awt.*;

import javax.swing.*;

public class Question2 extends JFrame{
	public Question2 (){
		String [] course = {"BCS", "BIT", "BSE", "CFS"};
		setLayout(new BorderLayout());
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		
		p1.setLayout(new GridLayout(5,2));
		p1.add(new JLabel("Student ID "));
		p1.add(new JTextField());
		p1.add(new JLabel("Student Name "));
		p1.add(new JTextField());
		p1.add(new JLabel("Programme "));
		p1.add(new JComboBox(course));
		p1.add(new JLabel("Semester "));
		p1.add(new JTextField());
		
		p2.setLayout(new FlowLayout());
		p2.add(new JButton("Register"));
		p2.add(new JButton("Cancel"));
		
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
		
		setTitle("UIPG");
		setSize(600,200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main (String [] args){
		Question2 question2 = new Question2();
	}
}
