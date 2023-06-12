package billingSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener ;
import java.sql.ResultSet;

public class Login extends JFrame  implements ActionListener{
	JButton login,cancel,signup;
	JTextField userField;
	JPasswordField passField;
	Choice loging;
	public Login() {
		super("Login Page");
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		  JLabel userName=new JLabel("UserName");
		  userName.setBounds(300, 20, 100, 20);
		  add(userName);
		  
		  userField=new JTextField();
		  userField.setBounds(400,20,150,20);
		  add(userField);
		  
		  JLabel passWord=new JLabel("Password");
		  passWord.setBounds(300, 60, 100, 20);
		  add(passWord);
		  
		  passField=new JPasswordField();
		  passField.setBounds(400, 60, 150, 20);
		  add(passField);
		  
		  JLabel logingInAs=new JLabel("Loging in as");
		  logingInAs.setBounds(300, 100, 100, 20);
		  add(logingInAs);
		  
		  
		  loging=new Choice();
		  loging.add("Admin");
		  loging.add("Costumer");
		  loging.setBounds(400,100,150,20);
		  add(loging);
		  
		  ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
		  Image i2=i1.getImage().getScaledInstance(16,16, Image.SCALE_DEFAULT);
		   login=new JButton("Login",new ImageIcon(i2));
		  login.setBounds(330,160 , 100, 20);
		  login.addActionListener(this);
		  add(login);
		  
		  ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
		  Image i4=i3.getImage().getScaledInstance(16,16, Image.SCALE_DEFAULT);
		  cancel=new JButton("Cancel",new ImageIcon(i4));
		  cancel.setBounds(450,160 , 100, 20);
		  cancel.addActionListener(this);
		  add(cancel);
		  
		  ImageIcon i5=new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
		  Image i6=i5.getImage().getScaledInstance(16,16, Image.SCALE_DEFAULT);
		  signup=new JButton("SignUp",new ImageIcon(i6));
		  signup.setBounds(380,200 , 100, 20);
		  signup.addActionListener(this);
		  add(signup);
		  
		  ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
		  Image i8=i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		  ImageIcon i9=new ImageIcon(i8);
		  JLabel image=new JLabel(i9);
		  image.setBounds(0,0,250,250);
		  add(image);
		  
setSize(640,300);
setLocation(400, 200);
setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==login) {
			String username=userField.getText();
			String password=new String(passField.getPassword());
			String user=loging.getSelectedItem();
			
			try {
				Connect c=new Connect();
				String query="select * from login where username='"+username+"' and  password ='"+password+"' and user ='"+user+"';";
//				System.out.println(query);
				ResultSet  set=c.s.executeQuery(query);
				if(set.next()) {
					String meter=set.getString("meter_no");
					setVisible(false);
					new Project(user,meter);
				}
				else {
					JOptionPane.showMessageDialog(null,"Inalid Login");
					userField.setText("");
				   passField.setText("");
				}
			}catch(Exception exc) {
				exc.printStackTrace();
			}
		}
		else if(e.getSource()==signup) {
			setVisible(false);
			
			new Signup();
		}
		else if(e.getSource()==cancel){
			setVisible(false);
		}
		
	}
	public static void main(String[] args) {
		new Login(); 
	}

}
