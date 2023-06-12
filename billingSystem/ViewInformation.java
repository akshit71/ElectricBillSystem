package billingSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ViewInformation extends JFrame implements ActionListener{
	JButton cancel;
	String meter;
public ViewInformation(String meter) {
	// TODO Auto-generated constructor stub
	this.meter=meter;
	 setBounds(350,150,850,650);
	 getContentPane().setBackground(Color.WHITE);
	 setLayout(null);
	 
	 
	 JLabel heading=new JLabel ("View Customer Information");
	 heading.setBounds(250,0,500,40);
	 heading.setFont(new Font("Tohoma",Font.PLAIN,20));
	 add(heading);
	 
	 JLabel name=new JLabel("Name");
	 name.setBounds(70,80,100,20);
	 add(name);
	 
	 JLabel namel=new JLabel("");
	 namel.setBounds(250,80,100,20);
	 add(namel);
	 
	 JLabel meterNumber=new JLabel("Meter Number");
	 meterNumber.setBounds(500,80,100,20);
	 add(meterNumber);
	 
	 JLabel meterNumberl=new JLabel("");
	 meterNumberl.setBounds(650,80,100,20);
	 add(meterNumberl);
	 
	 JLabel address=new JLabel("Address");
	 address.setBounds(70,140,100,20);
	 add(address);
	 
	 JLabel addressl=new JLabel("");
	 addressl.setBounds(250,140,100,20);
	 add(addressl);
	 
	 JLabel city=new JLabel("City");
	 city.setBounds(500,140,140,20);
	 add(city);
	 
	 JLabel cityl=new JLabel("");
	 cityl.setBounds(650,140,140,20);
	 add(cityl);
	 
	 JLabel email=new JLabel("Email");
	 email.setBounds(70,200,100,20);
	 add(email);
	 
	 JLabel emaill=new JLabel("");
	 emaill.setBounds(250,200,300,20);
	 add(emaill);
	 
	 JLabel phoneNo=new JLabel("Phone Number");
	 phoneNo.setBounds(500,200,100,20);
	 add(phoneNo);
	 
	 JLabel phoneNol=new JLabel("");
	 phoneNol.setBounds(650,200,100,20);
	 add(phoneNol);
	 
	 try {
		 Connect c=new Connect();
		 ResultSet rs=c.s.executeQuery("select * from customer where meter_no ='"+meter+"'");
		 while(rs.next()) {
			 namel.setText(rs.getString("name"));
			 addressl.setText(rs.getString("address"));
			 cityl.setText(rs.getString("name"));
			 meterNumberl.setText(rs.getString("meter_no"));
			 phoneNol.setText(rs.getString("phone"));
			 emaill.setText(rs.getString("email")); 
		 }
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	 
	 cancel=new JButton("Cancel");
	 cancel.setBounds(310,280,100,25);
	 cancel.addActionListener(this);
	add(cancel);
	
	ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/viewCustomer.jpg"));
	Image i2=i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
	ImageIcon i3=new ImageIcon(i2);
	JLabel image=new JLabel(i3);
	image.setBounds(20,350,600,300);
	add(image);
	
	 setVisible(true);
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	setVisible(false);
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new ViewInformation("561128");
	}


}
