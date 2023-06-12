package billingSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.*;

public class Signup extends JFrame  implements ActionListener {

	JButton create,back;
	Choice accountType;
	JTextField meterField,userNameField,nameField;
	JPasswordField passwordField;
	public Signup() {
		// TODO Auto-generated constructor stub
		setSize(700,400);
		setLocation(450, 100);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		JPanel panel=new JPanel();
		panel.setBounds(30,30,650,300);
		panel.setBorder(new TitledBorder(new LineBorder(Color.GRAY),"Creat-Account",TitledBorder.LEADING,TitledBorder.TOP,null,Color.BLACK));
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		add(panel);

		JLabel heading=new JLabel("Create Account As");
		heading.setBounds(100,50,140,20);
		panel.add(heading);


		accountType=new Choice();
		accountType.add("Admin");
		accountType.add("Costumer");
		accountType.setBounds(260, 50,150, 20);
		panel.add(accountType);

		JLabel meter=new JLabel("Meter Number");
		meter.setBounds(100,90,140,20);
		meter.setVisible(false);
		panel.add(meter);
		
		

		meterField=new JTextField();
		meterField.setBounds(260, 90,122,20);
		meterField.setVisible(false);
		panel.add(meterField);
		


		JLabel userName=new JLabel("Username");
		userName.setBounds(100,130,140,20);
		panel.add(userName);

		userNameField=new JTextField();
		userNameField.setBounds(260, 130,122,20);
		panel.add(userNameField);

		
		JLabel name=new JLabel("Enter your Name");
		name.setBounds(100,170,140,20);
		panel.add(name);
		
		nameField=new JTextField();
		nameField.setBounds(260, 170,122,20);
		panel.add(nameField);
		
		
       meterField.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				try {
					Connect c=new Connect();
					ResultSet rs=c.s.executeQuery("select * from login where meter_no ='"+meterField.getText()+"'");
				while(rs.next()) {
					nameField.setText(rs.getString("name"));
				}
				}
				catch(Exception exc) {
					exc.printStackTrace();
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JLabel password=new JLabel("Enter Your Password");
		password.setBounds(100,210,140,20);
		panel.add(password);
		
		 passwordField=new JPasswordField();
		passwordField.setBounds(260, 210,122,20);
		panel.add(passwordField);
		
		accountType.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				String user =accountType.getSelectedItem();
				if(user.equals("Admin")) {
					meterField.setVisible(false);
					meter.setVisible(false);
					nameField.setEditable(true);
				}
				else {
					meterField.setVisible(true);
					meter.setVisible(true);
					nameField.setEditable(false);
				}
			}
		});
 
		create =new JButton("Create");
		create.setBounds(140, 260, 120, 25);
		create.addActionListener(this);
		panel.add(create);
		
		back =new JButton("Back");
		back.setBounds(300, 260, 120, 25);
		back.addActionListener(this);
		panel.add(back);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
		Image i2=i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(415,30,250,250);
		panel.add(image);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==create) {
			 String aType=accountType.getSelectedItem();
			 String userName=userNameField.getText();
			 String name=nameField.getText();
			 String password=new String(passwordField.getPassword());
			 String meter=meterField.getText();
			 
			 try {
				Connect c=new Connect();
				
				String query=null;
				if(accountType.getSelectedItem().equals("Admin")) {
				query="insert into login values('"+meter+"' , '"+userName+"','"+name+"','"+password+"' , '"+aType+"' )";
				}
				else {
					query="update login set username = '"+userName+"' , password = '"+password+"' , user ='"+aType+"'  where meter_no ='"+meter+"'";
				}
				System.out.println(query);
				System.out.println("Hloo");
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Account Created Succesfully");
				setVisible(false);
                new Login();	
                
			 }catch(Exception exc) {
				 exc.printStackTrace();
			 }
		}
		else if(e.getSource()==back) {
			setVisible(false);
			new Login();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Signup();
	}

}
