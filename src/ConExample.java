import java.sql.*;

public class ConExample {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/sems";
		String username = "root";
		String password = "";

		System.out.println("Connecting database...");

		try {       
		    Class.forName("com.mysql.jdbc.Driver");
		    System.out.println("Driver Loaded");
		    Connection conn = DriverManager.getConnection(url,"root","");
		    //Database Name - testDB, Username - "root", Password - ""
		    System.out.println("Connected...");   
		    Statement stmt = conn.createStatement();
		    String sql = "SELECT * FROM login WHERE uname='"+"051-19-0001"+"' AND pass='"+"123456789"+"'  " ;
		    ResultSet res = stmt.executeQuery(sql);
		    
		    while(res.next()) {
		    	System.out.println(res.getString(1)+"  "+res.getString(2));
		    	
		    }
		    
		    
		} catch(Exception e) {
		    e.printStackTrace();
		}
	}

}
