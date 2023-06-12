package billingSystem;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import  java.awt.*;
import java.awt.*;

public class GenerateBill extends JFrame implements ActionListener{
   String meter;
   JButton bill;
   Choice monthDetails;
	JTextArea area;
	public GenerateBill(String meter) {
		// TODO Auto-generated constructor stub
		this.meter=meter;
		setSize(500,700);
		setLocation(550,30);
		setLayout(new BorderLayout());
		JPanel panel=new JPanel(); 
		JLabel heading=new JLabel("Generate Bill");
		JLabel meterNumber=new JLabel(meter);
	    monthDetails=new Choice();
		monthDetails.setBounds(520,20,150,20);
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
		
		area=new JTextArea(50,15);
		area.setText("\n\n\t -------------Click on the-------------\n\t     Generate Bill Button to get \n\t      the bill of selected month");
         area.setFont(new Font("Railway",Font.ITALIC,18));
		JScrollPane pane=new JScrollPane(area);
        bill=new JButton("Generate Bill");
        
        panel.add(heading);
        panel.add(meterNumber);
        panel.add(monthDetails);
        add(panel,"North");
        add(pane,"Center");
		add(bill,"South");
		bill.addActionListener(this);
		
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			Connect c=new Connect();
			String month=monthDetails.getSelectedItem();
			area.setText("ELECTRICITY BILL GENERATED FOR THE MONTH\n\t OF "+month+"2022");
		    
			ResultSet rs=c.s.executeQuery("select * from customer where meter_no ='"+meter+"'");
		    if(rs.next()) {
		    	area.append("\n     Customer Name:  "+rs.getString("name"));
		    	area.append("\n     Meter Number   : "+rs.getString("meter_no"));
		    	area.append("\n     Address              : "+rs.getString("address"));
		    	area.append("\n     City                      : "+rs.getString("city"));
		    	area.append("\n     State                   : "+rs.getString("state"));
		    	area.append("\n     Email:                 : "+rs.getString("email"));
		    	area.append("\n     Phone                : "+rs.getString("phone"));
		    	area.append("\n    ---------------------------------------------");
		    	area.append("\n    ---------------------------------------------");
		    }
		    	rs=c.s.executeQuery("select * from meter_info  where meter_no ='"+meter+"'");
			    if(rs.next()) {
			    	area.append("\n     Meter Location  :  "+rs.getString("meter_location"));
			    	area.append("\n     Meter Type        :  "+rs.getString("meter_type"));
			    	area.append("\n     Phase Code       :  "+rs.getString("phaseCode"));
			    	area.append("\n     Bill Type             :  "+rs.getString("bill_type"));
			    	area.append("\n     Days                  :  "+rs.getString("days"));
			    }
		}
	     catch(Exception exc) {
			exc.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      new GenerateBill("164695");
	}
	

}
