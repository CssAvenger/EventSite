package event;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ChangeDB {

	String sql="update eventdb.joindb set password =? where Id=?";
	String url = "jdbc:mysql://localhost:3306";
	String user="root";
	String password="Mainjaan";

	public boolean insert(String code, String pass) {
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(url,user,password);  

PreparedStatement ps=con.prepareStatement(sql);  

ps.setString(1,pass);  
ps.setString(2,code);  

 
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
