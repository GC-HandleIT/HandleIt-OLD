package com.handleit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ServletNonProfConn {

	static Scanner sc = new Scanner(System.in);
	public static ArrayList<NonProfObj> NonProfObjForConn = new ArrayList<>();
	static boolean passOrFail = false;

	static final String JBDC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/?user=root?autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "sesame";

	public static Connection conn = null;
	public static Statement stmt = null;
	public static PreparedStatement prepStmt = null;
	public static ResultSet resSet = null;

	public static void writeToNonProfTable(NonProfObj newNonProfObj) {

		try {
			ServletDevConn.initConnToDatabase();
			prepStmt = conn.prepareStatement(insertToTable);

			prepStmt.setString(1, newNonProfObj.getId());
			prepStmt.setString(2, newNonProfObj.getName());
			prepStmt.setString(3, newNonProfObj.getLink());
			prepStmt.setString(4, newNonProfObj.getContact_person());
			prepStmt.setString(5, newNonProfObj.getEmail_address());
			prepStmt.setString(6, newNonProfObj.getFocus());
			prepStmt.setString(7, newNonProfObj.getLocation());
			prepStmt.setString(8, newNonProfObj.getProject_type());
			prepStmt.setString(9, newNonProfObj.getProject_description());

			prepStmt.executeUpdate();
			passOrFail = true;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public static NonProfObj NonProfLoginSearch(String NonProfLoginEmail) {

		try {

			ServletDevConn.initConnToDatabase();
			stmt = conn.createStatement();
			resSet = stmt.executeQuery("SELECT * FROM `db`.`non prof table`; ");

			while (resSet.next())
				;
			String nonProfSearchParam = resSet.getString("`email`");

			if (nonProfSearchParam.equalsIgnoreCase(NonProfLoginEmail)) {

				NonProfObj nonProfForLogin = new NonProfObj();

				nonProfForLogin.setId(resSet.getString("`id`"));
				nonProfForLogin.setName(resSet.getString("`name`"));
				nonProfForLogin.setLink(resSet.getString("`link`"));
				nonProfForLogin.setContact_person(resSet.getString("`contact_person`"));
				nonProfForLogin.setEmail_address(resSet.getString("`location`"));
				nonProfForLogin.setFocus(resSet.getString("`pic_url`"));
				nonProfForLogin.setLocation(resSet.getString("`profile_url`"));
				nonProfForLogin.setProject_type(resSet.getString("`skills`"));
				nonProfForLogin.setProject_description(resSet.getString("`about_me`"));

				return nonProfForLogin;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static NonProfObj searchForADev(String aColumn, String aValue) {
		String searchThisColumn = null;
		String searchThisValue = null;

		try {

			ServletDevConn.initConnToDatabase();
			stmt = conn.createStatement();
			resSet = stmt.executeQuery("(SELECT * FROM `db`.`devtable` WHERE `" + searchThisColumn + "` LIKE '%{$"
					+ searchThisValue + "}%'");

			while (resSet.next()) {

				NonProfObj npForDev = new NonProfObj();

				npForDev.setId(resSet.getString("`id`"));
				npForDev.setName(resSet.getString("`first_name`"));
				npForDev.setLink(resSet.getString("`last_name`"));
				npForDev.setContact_person(resSet.getString("`email_address`"));
				npForDev.setEmail_address(resSet.getString("`location`"));
				npForDev.setFocus(resSet.getString("`pic_url`"));
				npForDev.setLocation(resSet.getString("`profile_url`"));
				npForDev.setProject_type(resSet.getString("`skills`"));
				npForDev.setProject_description(resSet.getString("`about_me`"));

				return npForDev;
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
