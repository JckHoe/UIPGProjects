package MidTerm;

import java.awt.*;
import javax.swing.*;

public class Question1 extends JFrame{
	public Question1 (){
		String [] gender = {"Male", "Female"};
		setLayout(new BorderLayout());
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		
		p1.setLayout(new GridLayout(5,2));
		p1.add(new JLabel("Name"));
		p1.add(new JTextField());
		p1.add(new JLabel("ID "));
		p1.add(new JTextField());
		p1.add(new JLabel("Password "));
		p1.add(new JTextField());
		p1.add(new JLabel("E-Mail: "));
		p1.add(new JTextField());
		p1.add(new JLabel("Gender"));
		p1.add(new JComboBox<String>(gender));
		
		p2.setLayout(new FlowLayout());
		p2.add(new JButton("Save"));
		p2.add(new JButton("Clear"));
		p2.add(new JButton("Exit"));
		
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
		
		setTitle("UIPG");
		setSize(600,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main (String [] args){
		Question1 question1 = new Question1();
	}
}
