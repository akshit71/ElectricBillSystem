package billingSystem;

import javax.swing.*;
import java.awt.*;
public class Splash extends JFrame  implements Runnable{
  
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(2000);
			setVisible(false);
			new Login();
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	public Splash() {
		// TODO Auto-generated constructor stub
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg"));
        Image i2=i1.getImage().getScaledInstance(730, 550, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3 );
		add(image);
		setVisible(true);
		
		int x=1;
		for(int i=2;i<600;i+=4,x+=1) {
			setSize(i+x,i);
			setLocation(700-((i+x)/2),400-(i/2));
			try {
			Thread.sleep(5);	
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		setSize(730,550);
		setLocation(300, 150);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Splash s=new Splash();
Thread t=new Thread(s);
t.start();  
	}

}
