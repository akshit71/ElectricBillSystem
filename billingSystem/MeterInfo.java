package billingSystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MeterInfo extends JFrame implements ActionListener{
	JButton next;
	JLabel meter;
	Choice meterLocation,meterType,phaseCode,billType;
	String meterNumber;
	 public MeterInfo(String meterNum) {
		// TODO Auto-generated constructor stub
		 this.meterNumber=meterNum;
		setSize(700,500);
		setLocation(400, 200);
		
		JPanel p=new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(173, 216,230));
		add(p);
		
		JLabel heading=new JLabel("Meter Information");
		heading.setFont(new Font("Tohoma",Font.PLAIN,24));
		heading.setBounds(180, 20, 200, 25);
		p.add(heading);
		
		JLabel name=new JLabel("Meter Number");
		name.setBounds(100, 80, 100, 20);
		p.add(name);
		
		JLabel meterNumber=new JLabel(meterNum);
		meterNumber.setBounds(240,80,100,20);
		p.add(meterNumber);
		
		
		JLabel meterNo=new JLabel("Meter Location");
		meterNo.setBounds(100,120,100,20);
		p.add(meterNo);
		
		meterLocation=new Choice();
		meterLocation.add("Inside");
		meterLocation.add("Outside");
		meterLocation.setBounds(240,120,200,20);
		p.add(meterLocation);
		
		
		JLabel address=new JLabel("Meter Type");
		address.setBounds(100, 160, 100, 20);
		p.add(address);
		
		meterType=new Choice();
		meterType.add("Electric");
		meterType.add("Solar");
		meterType.setBounds(240,160,200,20);
		p.add(meterType);
	
		
		JLabel city=new JLabel("Phase Code");
		city.setBounds(100, 200, 100, 20);
		p.add(city);
		
		phaseCode=new Choice();
		phaseCode.add("011");
		phaseCode.add("022");
		phaseCode.add("033");
		phaseCode.add("044");
		phaseCode.add("055");
		phaseCode.add("066");
		phaseCode.add("077");
		phaseCode.add("088");
		phaseCode.add("099");
		phaseCode.setBounds(240,200,200,20);
		p.add(phaseCode);
	
		
		
		JLabel state=new JLabel("Bill Type");
		state.setBounds(100, 240, 100, 20);
		p.add(state);
		
		billType=new Choice();
		billType.add("Normal");
		billType.add("Industrial");
		billType.setBounds(240,240,200,20);
		p.add(billType);
	
		
		JLabel email=new JLabel("Days");
		email.setBounds(100, 280, 100, 20);
		p.add(email);
		
		JLabel emails=new JLabel("30 Days");
		emails.setBounds(240, 280, 100, 20);
		p.add(emails);
		
		JLabel phone=new JLabel("Note");
		phone.setBounds(100, 320, 200, 20);
		p.add(phone);
		
		JLabel phones=new JLabel("Note the Bill is Calculated for 30 days only.");
		phones.setBounds(240, 320, 300, 20);
		p.add(phones);
		
		
		next=new JButton("Submit");
		next.setBounds(220,390,100,25);
		next.addActionListener(this);
		p.add(next);
		
		
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
				String meter=meterNumber;
				String location=meterLocation.getSelectedItem();
				String type=meterType.getSelectedItem();
				String code=phaseCode.getSelectedItem();
				String typeBill=billType.getSelectedItem();
				String days="30";
				
				String query="insert into meter_info values ('"+meter+"' , '"+location+"' , '"+type+"' , '"+code+"' , '"+typeBill+"' , '"+days+"')";
	           System.out.println(query);

	            try {
	            	Connect c=new Connect();
	            	c.s.executeUpdate(query);
	            	
	            	JOptionPane.showMessageDialog(null, "Meter Inforamation Added Succesfully");
	            	setVisible(false);
	            	
	            	
	            }catch(Exception exc) {
	            	exc.printStackTrace();
	            }
			}
			
			
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new MeterInfo("");
	}

}
