package billingSystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculateBill  extends JFrame  implements ActionListener{

	JTextField nameField,units,emailField,phoneField;
	JButton next,cancel;
	JLabel name,addressField;
	Choice meterNumber,month;
	public CalculateBill()  {
		// TODO Auto-generated constructor stub
		setSize(700,500);
		setLocation(400, 200);

		JPanel p=new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(173, 216,230));
		add(p);

		JLabel heading=new JLabel("Calculate Electricity Bill ");
		heading.setFont(new Font("Tohoma",Font.PLAIN,24));
		heading.setBounds(100, 20, 400, 25);
		p.add(heading);

		name=new JLabel("Meter Number");
		name.setBounds(100, 80, 100, 20);
		p.add(name);

		meterNumber=new Choice();
		try {
			Connect c=new Connect();
			ResultSet rs=c.s.executeQuery( "Select * from customer");
			while(rs.next()) {
				String s=rs.getString("meter_no");
				meterNumber.add(s);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		meterNumber.setBounds(240,80,200,20);
		p.add(meterNumber);

		JLabel meterNo=new JLabel("Name");
		meterNo.setBounds(100,120,100,20);
		p.add(meterNo);

		name=new JLabel("");
		name.setBounds(240,120,200,20);
		p.add(name);


		JLabel address=new JLabel("Address");
		address.setBounds(100, 160, 100, 20);
		p.add(address);

		addressField=new JLabel();
		addressField.setBounds(240,160,200,20);
		p.add(addressField);

		try {
			Connect c=new Connect();
			ResultSet rs=c.s.executeQuery("Select * from customer where meter_no ='"+meterNumber.getSelectedItem()+"'");
			while(rs.next()) {
				name.setText(rs.getString("name"));
				addressField.setText(rs.getString("address"));
			}
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}


		meterNumber.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				try {
					Connect c=new Connect();
					ResultSet rs=c.s.executeQuery("Select * from customer where meter_no ='"+meterNumber.getSelectedItem()+"'");
					while(rs.next()) {
						name.setText(rs.getString("name"));
						addressField.setText(rs.getString("address"));
					}
				}
				catch(Exception exc) {
					exc.printStackTrace();
				}

			}
		});

		JLabel city=new JLabel("UnitsConsumed");
		city.setBounds(100, 200, 100, 20);
		p.add(city);

		units=new JTextField();
		units.setBounds(240,200,160,20);
		p.add(units);


		JLabel state=new JLabel("Month");
		state.setBounds(100, 240, 100, 20);
		p.add(state);

		month=new Choice();
		month.setBounds(240,240,200,20);
		month.add("January");
		month.add("Febrary");
		month.add("March");
		month.add("April");
		month.add("May");
		month.add("June");
		month.add("July");
		month.add("August");
		month.add("September");
		month.add("October");
		month.add("November");
		month.add("December");
		p.add(month);


		next=new JButton("Submit");
		next.setBounds(120,350,100,25);
		next.addActionListener(this);
		p.add(next);

		cancel=new JButton("Cancel");
		cancel.setBounds(250,350,100,25);
		cancel.addActionListener(this);
		p.add(cancel);

		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
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
			String meter1=meterNumber.getSelectedItem();
			String unit=units.getText();
			String mon=month.getSelectedItem();
			
			int unit_consumed=Integer.parseInt(unit);
			int totalBill=unit_consumed*3;

			String query1="insert into bill  values('"+meter1+"' , '"+mon+"' , '"+unit+"' , '"+totalBill +"','Not Paid')";
		//			String query2="insert into login values ('"+meter1+"','','"+name+"','','')";
			System.out.println(query1);
			try {
				Connect c=new Connect();
				c.s.executeUpdate(query1);
//				c.s.executeUpdate(query2);

				JOptionPane.showMessageDialog(null, "Customer Bill Updated Succesfully");
				setVisible(false);

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
		new CalculateBill();
	}

}
