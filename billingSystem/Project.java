package billingSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Project extends JFrame implements ActionListener{
  String AccountType;
  String meter;
	Project(String AccountType,String meter){
		this.AccountType=AccountType;
		this.meter=meter;
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/billing.jpg"));
		Image i2=i1.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		add(image);
		
		JMenuBar menuBar=new JMenuBar();
		setJMenuBar(menuBar);
		
		
		JMenu admin=new JMenu("Admin");
		
		JMenuItem newCustomer=new JMenuItem("New Customer");
		newCustomer.addActionListener(this);
		admin.add(newCustomer);
		
		JMenuItem customerDetails=new JMenuItem("Customer Details");
		customerDetails.addActionListener(this);
		admin.add(customerDetails);
		
		JMenuItem depositDetails=new JMenuItem("Deposit Details");
		depositDetails.addActionListener(this);
		admin.add(depositDetails);
		
		JMenuItem calculateBill=new JMenuItem("Calculate Bill");
		calculateBill.addActionListener(this);
		admin.add(calculateBill);
		
		JMenu info =new JMenu("Information");
		
		JMenuItem updateInfo=new JMenuItem("Update Information");
		updateInfo.addActionListener(this);
		info.add(updateInfo);
		
		JMenuItem  viewInfo=new JMenuItem("View Information");
		viewInfo.addActionListener(this);
		info.add(viewInfo);
		
		JMenu user =new JMenu("User");
		
		
		JMenuItem  payBill=new JMenuItem("Pay Bill");
		payBill.addActionListener(this);
		user.add(payBill);
		
		JMenuItem  billDetails=new JMenuItem("Bill Details");
		billDetails.addActionListener(this);
		user.add(billDetails);
		
		JMenu  report=new JMenu("Report");
	   
	    JMenuItem  generateBill=new JMenuItem("Generate Bill");
	    generateBill.addActionListener(this);
		report.add(generateBill);
		
		
		JMenu utility=new JMenu("Utility");
 	
		
		JMenuItem calculator =new JMenuItem("Calcultor");
		calculator.addActionListener(this);
		utility.add(calculator);
		
		JMenuItem notepad=new JMenuItem("Notepad");
		notepad.addActionListener(this);
		utility.add(notepad);
		
		setLayout(new FlowLayout());
		
		
		JMenu exit=new JMenu("Exit");
		
		JMenuItem exit1=new JMenuItem("Exit");
		exit1.addActionListener(this);
		exit.add(exit1);
		
		if(AccountType.equals("Admin")) {
		menuBar.add(admin);
		}
		else {
		menuBar.add(info);
		 menuBar.add(report);
		 menuBar.add(user);
		}
		menuBar.add(utility);
		menuBar.add(exit);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String msg =e.getActionCommand();
		if(msg.equals("New Customer")) {
			new NewCustomer();
		}
		else if(msg.equals("Customer Details")) {
			new CustomerDetails();
		}
		else if(msg.equals("Deposit Details")) {
			new DepositDetails();
	}
	else if(msg.equals("Calculate Bill")) {
		new CalculateBill();
	}
	else if(msg.equals("View Information")) {
		new ViewInformation(meter);
	}
	else if(msg.equals("Update Information")) {
		new UpdateInformation(meter);
	}
	else if(msg.equals("Bill Details")) {
		new BillDetails(meter);
	}
	else if(msg.equals("Notepad")) {
		try {
		Runtime.getRuntime().exec("notepad.exe");	
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}
	else if (msg.equals("Calculator")) {
try {
			Runtime.getRuntime().exec("calc.exe");
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}
	else if(msg.equals("Exit")) {
		setVisible(false);
		new Login();
	}
	else if(msg.equals("Pay Bill")) {
		new PayBill(meter);
	}
	else if(msg.equals("Generate Bill")) {
		new GenerateBill(meter);
	}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new Project("Admin","1234");
	}
	

}
