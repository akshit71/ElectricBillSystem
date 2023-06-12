package billingSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Paytm extends JFrame implements ActionListener{
	String meter;
	JButton back;
	public Paytm(String meter) {
		// TODO Auto-generated constructor stub
		this.meter=meter;
		setSize(800,600);
		setLocation(400, 150);

		JEditorPane j=new JEditorPane();
		j.setEditable(false);
		
		try {
			j.setPage("https://paytm.com/online-payments");
			
		}
		catch(Exception exe) {
			j.setContentType("text/html");
			j.setText("<html>Could not load page</html>");
		}
		
		JScrollPane pane=new JScrollPane();
		add(pane);
		
		back=new JButton("Back");
		back.setBounds(640,20,80,30);
		back.addActionListener(this);
		j.add(back);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		setVisible(false);
		new PayBill(meter);
	}
	

	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Paytm("164695");
	}

}
