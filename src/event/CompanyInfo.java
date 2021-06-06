package event;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpSession;

public class CompanyInfo {

	  String name, category;
		String sql="select * from eventdb.joindb where email='?';";
		String url = "jdbc:mysql://localhost:3306";
		String user="root";
		String password="Mainjaan";
		
	public String nameCheck(String email) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,user,password);
			PreparedStatement st=con.prepareStatement("select * from eventdb.joindb where email='"+email+"'");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
			    name= rs.getString("companyName");
			}
			rs.close();
			st.close();
			con.close();
			
			}
			catch(Exception e){
				e.printStackTrace();
			}
		    return name;

	} 
	public String org(String email) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,user,password);
			PreparedStatement st=con.prepareStatement("select * from eventdb.joindb where email='"+email+"'");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
			    category= rs.getString("category");
			}
			rs.close();
			st.close();
			con.close();
			
			}
			catch(Exception e){
				e.printStackTrace();
			}
		    return category ;

	} 
}
