package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AuthModel {
	
	//base de datos
		
	public AuthModel() {
		
	}
	
	
	public void login(String username, String password) {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_super_data_17","freedb_master_of_data_test","mr2@d4rgDFKC7Ps");  
			
			Statement stmt=con.createStatement();  
			
			ResultSet rs=stmt.executeQuery("SELECT * FROM `users`");  
			
			while(rs.next())  
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getDate(4));  
			
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*if(username.equals("admin") && password.equals("1234")) {
			
			System.out.println( "Bienvenido" );
		}else
			System.err.println(" Error de acceso");
			*/
		
	}
}
