package Learn_gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class rg_page implements ActionListener {
	
	JFrame f;
	JLabel l,l1,l2,l3,l4;
	JTextField t1,t2,t3,t4;
	JButton b;
	
	
	public void register() {
		f = new JFrame("Register Form");
		f.setSize(1920,1080);
//		ImageIcon icon = new ImageIcon("C:\\Users\\prave\\Downloads\\flower_resize.jpg");
//		f.setContentPane(new JLabel(icon));
		f.getContentPane().setBackground(Color.gray);
		f.setLayout(null);
		f.setVisible(true);
		
		l = new JLabel("Register Form");
		l.setBounds(650, 100, 300, 45);
		l.setForeground(Color.ORANGE);
		l.setFont(new Font("Arial",Font.BOLD,40));
		f.add(l);
//		
//		
		l1 = new JLabel("User Name : ");
		l1.setBounds(500, 200, 300, 30);
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Arial",Font.ITALIC,26));
		f.add(l1);
//		
		t1 = new JTextField();
		t1.setBounds(660  , 200, 320, 30);
		t1.setForeground(Color.WHITE);
		t1.setBackground(Color.GRAY);
		t1.setFont(new Font("Arial",Font.ITALIC,26));
		f.add(t1);
//		
//		
		l2 = new JLabel("User Phone : ");
		l2.setBounds(500, 270, 300, 30);
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("Arial",Font.ITALIC,26));
		f.add(l2);
		
		t2 = new JTextField();
		t2.setBounds(660, 270, 320, 30);
		t2.setForeground(Color.WHITE);
		t2.setBackground(Color.GRAY);
		t2.setFont(new Font("Arial",Font.ITALIC,26));
		f.add(t2);
//		
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
		
		
		b = new JButton("Register");
		b.setBounds(600, 500, 200, 45);
		b.setForeground(Color.orange);
		b.setBackground(Color.black);
		b.setFont(new Font("Arial",Font.ITALIC,32));
		b.addActionListener(this);
		f.add(b);
		
		
		
	}

	public static void main(String[] args) {
		
		rg_page r = new rg_page();
		r.register();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String x1 = t1.getText();
		String x2 = t2.getText();
		String x3 = t3.getText();
		String x4 = t4.getText();
		
		System.out.println(x1+"\n"+x2+"\n"+x3+"\n"+x4);
		
		
		if(x1.equals("") || x2.equals("") || x3.equals("") ||x4.equals("")) {
			new JOptionPane().showMessageDialog(f,"Fill All Fields..");
		}
		
		else {	
		
			String url = "jdbc:mysql://localhost:3306/poorna";
			String pass = "root";
			String user = "root";
			
			try {
				Connection c = DriverManager.getConnection(url,user,pass);
				PreparedStatement ps = c.prepareStatement("insert into users values(?,?,?,?)");
				ps.setString(1, x1);
				ps.setString(2, x2);
				ps.setString(3, x3);
				ps.setString(4, x4);
				ps.execute();
				c.close();
				new JOptionPane().showMessageDialog(f,"User Registerd..");
				f.setVisible(false);
				lg_page lg = new lg_page();
				lg.login();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		
		
	}
		
	
	
	

}
