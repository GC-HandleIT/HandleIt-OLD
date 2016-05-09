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
			prepStmt.setString(4, newNonProfObj.getContactPerson());
			prepStmt.setString(5, newNonProfObj.getEmailAddress());
			prepStmt.setString(6, newNonProfObj.getFocus());
			prepStmt.setString(7, newNonProfObj.getLocation());
			prepStmt.setString(8, newNonProfObj.getProjectType());
			prepStmt.setString(9, newNonProfObj.getProjectDescription());

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
			String nonProfSearchParam = resSet.getString("`email_address`");

			if (nonProfSearchParam.equalsIgnoreCase(NonProfLoginEmail)) {

				NonProfObj nonProfForLogin = new NonProfObj();

				nonProfForLogin.setId(resSet.getString("`id`"));
				nonProfForLogin.setName(resSet.getString("`name`"));
				nonProfForLogin.setLink(resSet.getString("`link`"));
				nonProfForLogin.setContactPerson(resSet.getString("`contact_person`"));
				nonProfForLogin.setEmailAddress(resSet.getString("`email_address`"));
				nonProfForLogin.setFocus(resSet.getString("`focus`"));
				nonProfForLogin.setLocation(resSet.getString("`location`"));
				nonProfForLogin.setProjectType(resSet.getString("`project_type`"));
				nonProfForLogin.setProjectDescription(resSet.getString("`project_description`"));

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
				npForDev.setName(resSet.getString("`name`"));
				npForDev.setLink(resSet.getString("`link`"));
				npForDev.setContactPerson(resSet.getString("`contact_person`"));
				npForDev.setEmailAddress(resSet.getString("`email_address`"));
				npForDev.setFocus(resSet.getString("`focus`"));
				npForDev.setLocation(resSet.getString("`location`"));
				npForDev.setProjectType(resSet.getString("`project_type`"));
				npForDev.setProjectDescription(resSet.getString("`project_description`"));

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
