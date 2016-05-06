package com.handleit;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ServletDevConn {

	static Scanner sc = new Scanner(System.in);
	public static ArrayList<DevObj> DevObjForConn = new ArrayList<>();

	static final String JBDC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/?user=root?autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "sesame";

	private static Connection conn = null;
	private static Statement stmt = null;
	private static PreparedStatement prepStmt = null;
	private static ResultSet resSet = null;

	public static void initConnToDatabase() {

		try {
			Class.forName(JBDC_DRIVER);

			System.out.println("Connecting to the Database");
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
	}

	public static DevObj searchForDev(String devLoginEmail) { //use this to log into the dev portal
		
		try {
			initConnToDatabase();
			stmt = conn.createStatement();
			resSet = stmt.executeQuery("SELECT * FROM `db`.`dev table` ");
			
			while (resSet.next());
				String devSearchParam = resSet.getString("`email`");
				
				if (devSearchParam.equalsIgnoreCase(devLoginEmail)) {
					
					DevObj devForLogin = new DevObj();
					
					
					
				}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return null;
		
	}
}
