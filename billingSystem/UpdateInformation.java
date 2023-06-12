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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateInformation extends JFrame implements ActionListener{

	
	JTextField addressl,cityl,statel,phoneNol,emaill;
	String meter;
	JButton update,cancel;
	JLabel namel;
	public UpdateInformation(String meter) {
		// TODO Auto-generated constructor stub
		this.meter=meter;
		setBounds(300,150,1050,450);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		 
		 
		 JLabel heading=new JLabel ("Update Customer Information");
		 heading.setBounds(110,0,400,30);
		 heading.setFont(new Font("Tohoma",Font.PLAIN,20));
		 add(heading);
		 
		 JLabel name=new JLabel("Name");
		 name.setBounds(30,70,100,20);
		 add(name);
		 
		  namel=new JLabel("");
		 namel.setBounds(230,70,200,20);
		 add(namel);
		 
		 JLabel meterNumber=new JLabel("Meter Number");
		 meterNumber.setBounds(30,110,100,20);
		 add(meterNumber);
		 
		 JLabel meterNumberl=new JLabel("");
		 meterNumberl.setBounds(230,110,200,20);
		 add(meterNumberl);
		 
		 JLabel address=new JLabel("Address");
		 address.setBounds(30,150,100,20);
		 add(address);
		 
		  addressl=new JTextField();
		 addressl.setBounds(230,150,200,20);
		 add(addressl);
		 
		 JLabel city=new JLabel("City");
		 city.setBounds(30,190,100,20);
		 add(city);
		 
		 cityl=new JTextField();
		 cityl.setBounds(230,190,200,20);
		 add(cityl);
		 
		 JLabel email=new JLabel("Email");
		 email.setBounds(30,230,100,20);
		 add(email);
		 
		 emaill=new JTextField("");
		 emaill.setBounds(230,230,200,20);
		 add(emaill);
		 
		 JLabel phoneNo=new JLabel("Phone Number");
		 phoneNo.setBounds(30,270,100,20);
		 add(phoneNo);
		 
		 phoneNol=new JTextField();
		 phoneNol.setBounds(230,270,200,20);
		 add(phoneNol);
		 
		 try {
			 Connect c=new Connect();
			 ResultSet rs=c.s.executeQuery("select * from customer where meter_no ='"+meter+"'");
			 while(rs.next()) {
				 namel.setText(rs.getString("name"));
//				 addressl.setText(rs.getString("address"));
//				 cityl.setText(rs.getString("name"));
				 meterNumberl.setText(rs.getString("meter_no"));
//				 phoneNol.setText(rs.getString("phone"));
//				 emaill.setText(rs.getString("email")); 
			 }
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 
		 update=new JButton("Update");
		 update.setBounds(70,330,100,25);
		 update.addActionListener(this);
		add(update);
		
		 cancel=new JButton("Cancel");
		 cancel.setBounds(230,330,100,25);
		 cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
		Image i2=i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(550,50,400,300);
		add(image);
		
		
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==update) {
			String labelName=namel.getText();
			String address =addressl.getText();
			String email=emaill.getText();
			String city=cityl.getText();
			String phone=phoneNol.getText();
			
			try {
				Connect c=new Connect();
				String query="update customer set address ='"+address+"', city= '"+city+"' , email ='"+email+"' , phone ='"+phone+"' where meter_no='"+meter+"'";
			System.out.println(query);
				c.s.executeUpdate(query);
			
			JOptionPane.showMessageDialog(null, "User Information Updated Successfully");
			setVisible(false);
			}
			catch(Exception exc) {
				exc.printStackTrace();
			}
		}
		else {
			setVisible(false);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new UpdateInformation("164695");
	}

}
