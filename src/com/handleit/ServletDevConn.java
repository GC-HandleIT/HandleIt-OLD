package com.handleit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ServletDevConn {

	static Scanner sc = new Scanner(System.in);
	public static ArrayList<DevObj> DevObjForConn = new ArrayList<>();
	static boolean passOrFail = false;

	static final String JBDC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/?user=root?autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "sesame";

	public static Connection conn = null;
	public static Statement stmt = null;
	public static PreparedStatement prepStmt = null;
	public static ResultSet resSet = null;

	public static void initConnToDatabase() {

		try {
			Class.forName(JBDC_DRIVER);

			System.out.println("Connecting to the Database");
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			System.out.println("Connected to the Database");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
	}

	public static void writeToDevTable(DevObj newDevObj) {

		try {
			initConnToDatabase();
			prepStmt = conn.prepareStatement(insertToTable);

			prepStmt.setString(1, newDevObj.getId());
			prepStmt.setString(2, newDevObj.getFirstName());
			prepStmt.setString(3, newDevObj.getLastName());
			prepStmt.setString(4, newDevObj.getEmailAddress());
			prepStmt.setString(5, newDevObj.getLocation());
			prepStmt.setString(6, newDevObj.getPicUrl());
			prepStmt.setString(7, newDevObj.getProfileUrl());
			prepStmt.setString(8, newDevObj.getSkills());
			prepStmt.setString(8, newDevObj.getAboutMe());

			prepStmt.executeUpdate();
			passOrFail = true;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public static DevObj devLoginSearch(String devLoginEmail) {

		try {

			initConnToDatabase();
			stmt = conn.createStatement();
			resSet = stmt.executeQuery("SELECT * FROM `db`.`dev table`; ");

			while (resSet.next())
				;
			String devSearchParam = resSet.getString("`email`");

			if (devSearchParam.equalsIgnoreCase(devLoginEmail)) {

				DevObj devForLogin = new DevObj();

				devForLogin.setId(resSet.getString("`id`"));
				devForLogin.setFirstName(resSet.getString("`first_name`"));
				devForLogin.setLastName(resSet.getString("`last_name`"));
				devForLogin.setEmailAddress(resSet.getString("`email_address`"));
				devForLogin.setLocation(resSet.getString("`location`"));
				devForLogin.setPicUrl(resSet.getString("`pic_url`"));
				devForLogin.setProfileUrl(resSet.getString("`profile_url`"));
				devForLogin.setSkills(resSet.getString("`skills`"));
				devForLogin.setAboutMe(resSet.getString("`about_me`"));

				return devForLogin;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static DevObj searchForADev(String aColumn, String aValue) {
		String searchThisColumn = null;
		String searchThisValue = null;

		try {

			initConnToDatabase();
			stmt = conn.createStatement();
			resSet = stmt.executeQuery("(SELECT * FROM `db`.`devtable` WHERE `" + searchThisColumn + "` LIKE '%{$"
					+ searchThisValue + "}%'");

			while (resSet.next()) {

				DevObj devForNP = new DevObj();

				devForNP.setId(resSet.getString("`id`"));
				devForNP.setFirstName(resSet.getString("`first_name`"));
				devForNP.setLastName(resSet.getString("`last_name`"));
				devForNP.setEmailAddress(resSet.getString("`email_address`"));
				devForNP.setLocation(resSet.getString("`location`"));
				devForNP.setPicUrl(resSet.getString("`pic_url`"));
				devForNP.setProfileUrl(resSet.getString("`profile_url`"));
				devForNP.setSkills(resSet.getString("`skills`"));
				devForNP.setAboutMe(resSet.getString("`about_me`"));

				return devForNP;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return null;

	}

	private static String insertToTable = "INSERT INTO `database_name`.`table_name`"
			+ "(`thing_1`, thing_2`, `thing_3`, `thing_4`, thing_5`, `thing_6`, `thing_7`, thing_8`, `thing_9`)"
			+ "VALUES" + "(?,?,?,?,?,?,?,?,?)";
}
