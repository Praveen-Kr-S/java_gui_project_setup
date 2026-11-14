package Learn_gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Dasboard {
	
	JFrame f;
	JLabel title,l3,l4;
	JTextField t3,t4;
	
	JButton b;
	
	public void dg() {
		
		f = new JFrame("Main Page");
		f.setSize(1920,1080);
		f.getContentPane().setBackground(Color.GRAY);
		f.setLayout(null);
		f.setVisible(true);
		
		
		title = new JLabel("Welcome To Amazon");
		title.setBounds(600, 100, 500, 45);
		title.setFont(new Font("Arial",Font.BOLD,40));
		title.setForeground(Color.ORANGE);
		f.add(title);
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
