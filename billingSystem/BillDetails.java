package billingSystem;

import java.awt.Color;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class BillDetails  extends JFrame {
String meter;
	public BillDetails(String meter) {
		// TODO Auto-generated constructor stub
		this.meter=meter;
		setSize(700,650);
		setLocation(400,150);
		
		getContentPane().setBackground(Color.WHITE);
		JTable table=new JTable();
		
		try {
			Connect c=new Connect();
			String query="select * from bill where meter_no ='"+meter+"'";
	ResultSet rs=c.s.executeQuery(query);
	
	table.setModel(DbUtils.resultSetToTableModel(rs));
	
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		JScrollPane sb=new JScrollPane(table);
		sb.setBounds(0,0,700,650);
		add(sb);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new BillDetails("164695");
	}

}
