package Test;

import java.sql.*;

public class DBConnection {
	private static Connection con = null;// reference variable

	private DBConnection() {
	}

	static {
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/amitdb", "root", "Mysql@0033");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getCon() {
		return con;
	}
}





