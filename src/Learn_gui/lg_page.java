package Learn_gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class lg_page implements ActionListener {
	
	JFrame f;
	JLabel l,l3,l4;
	JTextField t3,t4;
	JButton b;

	public void login() {
		
		f = new JFrame("Login Form");
		f.setSize(1920,1080);
//		ImageIcon icon = new ImageIcon("C:\\Users\\prave\\Downloads\\flower_resize.jpg");
//		f.setContentPane(new JLabel(icon));
		f.getContentPane().setBackground(Color.gray);
		f.setLayout(null);
		f.setVisible(true);
		
		l = new JLabel("Login Form");
		l.setBounds(650, 250, 300, 45);
		l.setForeground(Color.ORANGE);
		l.setFont(new Font("Arial",Font.BOLD,40));
		f.add(l);
		
		l3 = new JLabel("User Email : ");
		l3.setBounds(500, 330, 300, 30);
		l3.setForeground(Color.WHITE);
		l3.setFont(new Font("Arial",Font.ITALIC,26));
		f.add(l3);
		
		t3 = new JTextField();
		t3.setBounds(660, 330, 320, 30);
		t3.setForeground(Color.WHITE);
		t3.setBackground(Color.GRAY);
		t3.setFont(new Font("Arial",Font.ITALIC,26));
		f.add(t3);
//		
		l4 = new JLabel("password : ");
		l4.setBounds(500, 400, 300, 30);
		l4.setForeground(Color.WHITE);
		l4.setFont(new Font("Arial",Font.ITALIC,26));
		f.add(l4);
//		
		t4 = new JPasswordField();
		t4.setBounds(660, 400, 320, 30);
		t4.setForeground(Color.WHITE);
		t4.setBackground(Color.GRAY);
		t4.setFont(new Font("Arial",Font.ITALIC,26));
		f.add(t4);
		
		
		b = new JButton("Login");
		b.setBounds(600, 500, 200, 45);
		b.setForeground(Color.orange);
		b.setBackground(Color.black);
		b.setFont(new Font("Arial",Font.ITALIC,32));
		b.addActionListener(this);
		f.add(b);
		
	}

	public static void main(String[] args) {
		
		lg_page lgg = new lg_page();
		lgg.login();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String x3 = t3.getText();
		String x4 = t4.getText();
		
		if(x3.equals("") ||x4.equals("")) {
			new JOptionPane().showMessageDialog(f,"Fill All Fields..");
		}
		else {	
			String url = "jdbc:mysql://localhost:3306/poorna";
			String pass = "root";
			String user = "root";
			
			try {
				Connection c = DriverManager.getConnection(url,user,pass);
				PreparedStatement ps = c.prepareStatement("select * from users where email=? and password=? ");
				ps.setString(1, x3);
				ps.setString(2, x4);
				ResultSet rs=ps.executeQuery();
				if (rs.next()) {
					new JOptionPane().showMessageDialog(f,"Login Successfully..");
					f.setVisible(false);
					Dasboard dd = new Dasboard();
					dd.dg();
					rs.close();
				}
				else {
					new JOptionPane().showMessageDialog(f,"Invailed User..");
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		
	}

}
