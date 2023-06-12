package billingSystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class CustomerDetails extends JFrame implements ActionListener{

	JTable table;
	JButton print;
	 public CustomerDetails() {
		// TODO Auto-generated constructor stub
		super("Customer Details");
		setSize(1200,650);
		setLocation(200, 150);

		

		table=new JTable();
		try {
			Connect c=new Connect();
			ResultSet rs=c.s.executeQuery("select * from customer");
			table.setModel(DbUtils.resultSetToTableModel(rs));

		}catch( Exception e) {
			e.printStackTrace();
		}

		JScrollPane  sp=new JScrollPane(table);
		add(sp);

		

		print=new JButton("Print");
		print.addActionListener(this);
		add(print,"South");

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			try {
				table.print();

			}catch (Exception exc){
				exc.printStackTrace();
			}
		}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
new CustomerDetails();
	}

}
