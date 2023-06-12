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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PayBill extends JFrame implements ActionListener{
Choice monthDetails;
JButton pay,back;
String Meter;

	public PayBill(String Meter) {
		// TODO Auto-generated constructor stub
		this.Meter=Meter;
		setBounds(300,150,900,600);
		setLayout(null);
		
		JLabel heading=new JLabel("Electricity Bill");
		heading.setFont(new Font("Tohoma",Font.BOLD,24));
		heading.setBounds(120,5,400,30);
		add(heading);
		
		JLabel meterNumber=new JLabel("Meter Number");
		meterNumber.setBounds(35,80,200,20);
		add(meterNumber);
		
		JLabel meterNumberl=new JLabel("");
		meterNumberl.setBounds(300,80,200,20);
		add(meterNumberl);
		
		JLabel name=new JLabel("Name");
		name.setBounds(35,140,200,20);
		add(name);
		
		JLabel namel=new JLabel("");
		namel.setBounds(300,140,200,20);
		add(namel);
		
		JLabel month=new JLabel("Month");
		month.setBounds(35,200,200,20);
		add(month);
		
		
		monthDetails =new Choice();
		monthDetails.setBounds(300,200,200,20);
		monthDetails.add("January");
		monthDetails.add("Febrary");
		monthDetails.add("March");
		monthDetails.add("April");
		monthDetails.add("May");
		monthDetails.add("June");
		monthDetails.add("July");
		monthDetails.add("August");
		monthDetails.add("September");
		monthDetails.add("October");
		monthDetails.add("November");
		monthDetails.add("December");
		add(monthDetails);
		
		
		JLabel units=new JLabel("Units");
		units.setBounds(35,260,200,20);
		add(units);
		
		JLabel unitsl=new JLabel("");
		unitsl.setBounds(300,260,200,20);
		add(unitsl);
		
		
		JLabel totalBill=new JLabel("Total Billl");
		totalBill.setBounds(35,320,200,20);
		add(totalBill);
		
		JLabel totalBilll=new JLabel("");
		totalBilll.setBounds(300,320,200,20);
		add(totalBilll);
		
		JLabel status=new JLabel("Status");
		status.setBounds(35,380,200,20);
		add(status);
		
		JLabel statusl=new JLabel("");
		statusl.setBounds(300,380,200,20);
		statusl.setForeground(Color.RED);
		add(statusl);
		
		try {
			Connect c=new Connect();
			ResultSet rs=c.s.executeQuery("select * from customer where meter_no ='"+Meter+"'");
			while(rs.next()) {
				meterNumberl.setText(Meter);
				namel.setText(rs.getString("name"));
			}
			 rs=c.s.executeQuery("select * from bill where meter_no ='"+Meter+"' and month ='"+monthDetails.getSelectedItem()+"'");
		while(rs.next()) {
			unitsl.setText(rs.getString("units"));
			statusl.setText(rs.getString("status"));
			totalBilll.setText(rs.getString("totalbill"));
		}
		}
		catch(Exception exe) {
			exe.printStackTrace();
		}
		
		
		monthDetails.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				try {
					Connect c=new Connect();
					ResultSet rs=c.s.executeQuery("select * from bill where meter_no ='"+Meter+"' and month ='"+monthDetails.getSelectedItem()+"'");
				if(rs.next()) {
					unitsl.setText(rs.getString("units"));
					statusl.setText(rs.getString("status"));
					totalBilll.setText(rs.getString("totalbill"));
				}
				else {
					unitsl.setText("0");
					statusl.setText("No Bill Outstading");
					totalBilll.setText("0");
				}
				}
				catch(Exception exe) {
					exe.printStackTrace();
				}
			}
		});
		
		pay=new JButton("Pay");
		pay.setBounds(100,460,100,25);
		pay.addActionListener(this);
		add(pay);
		
		back=new JButton("Back");
		back.setBounds(230,460,100,25);
		back.addActionListener(this);
		add(back);
		
		getContentPane().setBackground(Color.WHITE);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
		Image i2=i1.getImage().getScaledInstance(600, 300,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(400,120,600,300);
		add(image);
		setVisible(true);
	}
	
	@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==pay) {
				try {
					Connect c=new Connect();
					c.s.executeUpdate("Update bill set status ='Paid' where meter_no='"+Meter+"' and month ='"+monthDetails.getSelectedItem()+"' ");
			
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
				setVisible(false);
				new Paytm(Meter);
			}
			else {
				setVisible(false);
			}
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
  new PayBill("164695");
	}

}
