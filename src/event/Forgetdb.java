package event;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Forgetdb {
    String id,name;
	String sql="select * from eventdb.joindb where email='?';";
	String url = "jdbc:mysql://localhost:3306";
	String user="root";
	String password="Mainjaan";
	
	public boolean change(String email) {			
			try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,user,password);
			PreparedStatement st=con.prepareStatement("select * from eventdb.joindb where email='"+email+"'");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				return true;
			}
			rs.close();
			st.close();
			con.close();
			
			}
			catch(Exception e){
				e.printStackTrace();
			}
		    return false;
		       
	}	

public String id(String email) {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,user,password);
		PreparedStatement st=con.prepareStatement("select * from eventdb.joindb where email='"+email+"'");
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
		    name= rs.getString("companyName");
			id= rs.getString("Id");
		}
		rs.close();
		st.close();
		con.close();
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
	    return id+","+name;

}
}
