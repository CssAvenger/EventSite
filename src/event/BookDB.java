package event;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BookDB {
	
	
	
	
	
	String sql="insert into eventdb.bookdb values(?,?,?,?,?,?,?,?,?,?,?)";
	String url = "jdbc:mysql://localhost:3306";
	String user="root";
	String password="Mainjaan";
	public boolean insert(String dist, String area, String occassion , String guest, String pack, String budget, String name, String email, String phone, String date, String bookCode) {
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(url,user,password);  

PreparedStatement ps=con.prepareStatement(sql);  

ps.setString(1,dist);  
ps.setString(2,area);  
ps.setString(3,occassion);  
ps.setString(4,guest); 
ps.setString(5,pack);  
ps.setString(6,budget);  
ps.setString(7,name);  
ps.setString(8,email); 
ps.setString(9,phone);  
ps.setString(10,date); 
ps.setString(11,bookCode); 

int i=ps.executeUpdate();  
if(i>0) {
return true;
}
con.close();
ps.close();
}
catch (Exception e2) {System.out.println(e2);}  

	return false;
}
}
