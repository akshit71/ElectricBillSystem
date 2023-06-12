package billingSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class NewCustomer extends JFrame  implements ActionListener{

	JTextField nameField,addressField,stateField,cityField,emailField,phoneField;
	JButton next,cancel;
	JLabel meter;
	public NewCustomer() {
		// TODO Auto-generated constructor stub
		setSize(700,500);
		setLocation(400, 200);
		
		JPanel p=new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(173, 216,230));
		add(p);
		
		JLabel heading=new JLabel("New Customer");
		heading.setFont(new Font("Tohoma",Font.PLAIN,24));
		heading.setBounds(180, 20, 200, 25);
		p.add(heading);
		
		JLabel name=new JLabel("Customer name");
		name.setBounds(100, 80, 100, 20);
		p.add(name);
		
		nameField=new JTextField();
		nameField.setBounds(240,80,200,20);
		p.add(nameField);
		
		JLabel meterNo=new JLabel("Meter Number");
		meterNo.setBounds(100,120,100,20);
		p.add(meterNo);
		
		meter=new JLabel("");
		meter.setBounds(240,120,100,20);
		p.add(meter);
		
		Random random=new Random();
		long number=random.nextLong()%1000000;
		meter.setText(""+Math.abs(number));
		
		JLabel address=new JLabel("Address");
		address.setBounds(100, 160, 100, 20);
		p.add(address);
		
		addressField=new JTextField();
		addressField.setBounds(240,160,200,20);
		p.add(addressField);
		
		JLabel city=new JLabel("City");
		city.setBounds(100, 200, 100, 20);
		p.add(city);
		
		cityField=new JTextField();
		cityField.setBounds(240,200,200,20);
		p.add(cityField);
		
		
		JLabel state=new JLabel("State");
		state.setBounds(100, 240, 200, 20);
		p.add(state);
		
		stateField=new JTextField();
		stateField.setBounds(240,240,200,20);
		p.add(stateField);
		
		JLabel email=new JLabel("Email");
		email.setBounds(100, 280, 200, 20);
		p.add(email);
		
		emailField=new JTextField();
		emailField.setBounds(240,280,200,20);
		p.add(emailField);
		
		JLabel phone=new JLabel("Phone Number");
		phone.setBounds(100, 320, 200, 20);
		p.add(phone);
		
		phoneField=new JTextField();
		phoneField.setBounds(240,320,200,20);
		p.add(phoneField);
		
		next=new JButton("Next");
		next.setBounds(120,390,100,25);
		next.addActionListener(this);
		p.add(next);
		
		cancel=new JButton("Cancel");
		cancel.setBounds(250,390,100,25);
		cancel.addActionListener(this);
		p.add(cancel);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
		Image i2=i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		add(image,"West");
		getContentPane().setBackground(Color.WHITE);
		
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==next) {
			String name=nameField.getText();
			String meter1=meter.getText();
			String address=addressField.getText();
			String city=cityField.getText();
			String state=stateField.getText();
			String email=emailField.getText();
			String phone =phoneField.getText();
			
			String query1="insert into customer values ('"+name+"' , '"+meter1+"' , '"+address+"' , '"+city+"' , '"+state+"' , '"+email+"' , '"+phone+"')";
            String query2="insert into login values ('"+meter1+"','','"+name+"','','')";
           System.out.println(query1);
           System.out.println(query2);
            try {
            	Connect c=new Connect();
            	c.s.executeUpdate(query1);
            	c.s.executeUpdate(query2);
            	
            	JOptionPane.showMessageDialog(null, "Customer Details Added Succesfully");
            	setVisible(false);
            	
            	new MeterInfo(meter1);
            	
            }catch(Exception exc) {
            	exc.printStackTrace();
            }
		}
		else if(e.getSource()==cancel) {
			setVisible(false);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NewCustomer();

	}
	

}
