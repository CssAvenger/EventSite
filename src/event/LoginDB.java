package event;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LoginDB {
	 
		String sql= "select * from eventdb.joindb where email=? and password=?";
		String url = "jdbc:mysql://localhost:3306";
		String user="root";
		String password="Mainjaan";
	public boolean check(String uname, String pass) {
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,user,password);
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1, uname);
		st.setString(2, pass);
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
}
