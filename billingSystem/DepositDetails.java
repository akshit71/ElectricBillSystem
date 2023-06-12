package billingSystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class DepositDetails  extends JFrame implements ActionListener {

	Choice meterNumDetails,monthDetails;
	JTable table;
	JButton search,print;
	public DepositDetails() {
		// TODO Auto-generated constructor stub
		super("Deposit Details");
		setSize(700,700);
		setLocation(400, 100);

		setLayout(null);

		getContentPane().setBackground(Color.WHITE);
		JLabel meterNumber=new JLabel("Search By Meter Number");
		meterNumber.setBounds(20,20,150,20);
		add(meterNumber);

		meterNumDetails =new Choice();
		meterNumDetails.setBounds(180,20,150,20);
		add(meterNumDetails);

		try {
			Connect c=new Connect();
			ResultSet rs=c.s.executeQuery("Select * from customer");
			while(rs.next()) {
				meterNumDetails.add(rs.getString("meter_no"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		JLabel month=new JLabel("Search By Month");
		month.setBounds(400,20,100,20);
		add(month);

		monthDetails =new Choice();
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
		add(monthDetails);


		table=new JTable();
		try {
			Connect c=new Connect();
			ResultSet rs=c.s.executeQuery("select * from bill");
			table.setModel(DbUtils.resultSetToTableModel(rs));

		}catch( Exception e) {
			e.printStackTrace();
		}

		JScrollPane  sp=new JScrollPane(table);
		sp.setBounds(0,100,700,600);
		add(sp);

		search=new JButton("Search");
		search.setBounds(20,70,80,20);
		search.addActionListener(this);
		add(search);

		print=new JButton("Print");
		print.setBounds(120,70,80,20);
		print.addActionListener(this);
		add(print);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==search) {
			String query="select * from bill where meter_no ='"+meterNumDetails.getSelectedItem()+"' and month ='"+monthDetails.getSelectedItem()+"'";
			try {
				Connect c=new Connect();
				ResultSet rs=c.s.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
			catch(Exception exc) {
				exc.printStackTrace();
			}
		}
		else {
			try {
				table.print();

			}catch (Exception exc){
				exc.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DepositDetails();
	}

}
