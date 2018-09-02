package com.cg.laps.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

		static Connection conn = null;
	
		// Returns connection object;
		public static Connection establishConnection() {

			
			try {
				
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/test", "root",
						"root");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return conn;
		}

}
