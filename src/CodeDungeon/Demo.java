package CodeDungeon;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Demo extends JFrame implements ActionListener{
	JPanel p1 = new JPanel();
	JPanel pane = new JPanel();
	public Demo(){
		JButton btn = new JButton("Next Frame");
		btn.addActionListener(this);
		
		p1.add(new JLabel("Ken is FFK King!"));
		p1.add(btn);
		
		pane.add(new JLabel("NEW PANEL"));
		JButton btn2 = new JButton("ANOTHER WAY");
		pane.add(btn2);
		example demo = new example();
		btn2.addActionListener(demo);
		add(p1);
	}
	
	public void actionPerformed(ActionEvent e){
		remove(p1);
		add(pane);
		repaint();
        revalidate();
	}
	
	//another way
		class example implements ActionListener{
			public void actionPerformed(ActionEvent e){
				remove(pane);
				add(p1);
				repaint();
		        revalidate();
			}
		}
	
	public static void main (String [] args){
		Demo demo = new Demo();
		demo.setTitle("UIPG");
		demo.setSize(1200,800);
		demo.setLocationRelativeTo(null);
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		demo.setVisible(true);
	}
}