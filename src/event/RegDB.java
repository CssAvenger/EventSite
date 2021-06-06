package event;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RegDB {
	String sql="insert into eventdb.joindb values(?,?,?,?,?)";
	String url = "jdbc:mysql://localhost:3306";
	String user="root";
	String password="Mainjaan";

	int i =(int) Math.floor(10000*Math.random());
	String s1="EVSITE"+i;
	public boolean insert(String a, String b, String c , String d) {
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(url,user,password);  

PreparedStatement ps=con.prepareStatement(sql);  

ps.setString(1,a);  
ps.setString(2,b);  
ps.setString(3,c);  
ps.setString(4,d);  
ps.setString(5,s1);  

 
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
