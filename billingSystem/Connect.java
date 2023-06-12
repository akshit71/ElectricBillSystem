package billingSystem;

import java.sql.*;
import java.sql.DriverManager;

public class Connect {
	   Connection c;
	   Statement s;
	public Connect() {
		// TODO Auto-generated constructor stub
	  
         try {
		c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs","root","@Maruti800");		
	  s=c.createStatement(); 
         }
         catch(Exception e) {
        	 e.printStackTrace();
         }
	}
}
