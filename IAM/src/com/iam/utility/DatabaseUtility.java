/**  
* DatabaseUtility.java - The class helps to get Database related result  
* @author  Bharat and Atiqullah
* @version 1.0 
* @see College Project
*/
package com.iam.utility;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DatabaseUtility {

	/**
	 * This method is use to get the database connection.It will read the DB.config
	 * file and get all the value for DRIVER,URL,USERNAME,PASSWORD.Then Load the
	 * DRIVER using jdbc DB driver and get connection to DB using url, username,
	 * password
	 * 
	 * @param inputStream
	 *            :InputStream
	 * @return DB Connection
	 * @throws Exception
	 *             : Exception
	 */
	public static Connection getCon(InputStream inputStream) throws Exception {

		Properties properties = new Properties();

		// load the inputStream
		properties.load(inputStream);

		// get the value of all property
		String driverClass = properties.getProperty("DRIVER");
		String url = properties.getProperty("URL");
		String username = properties.getProperty("USERNAME");
		String password = properties.getProperty("PASSWORD");

		Connection con = null;
		try {
			Class.forName(driverClass);
			con = DriverManager.getConnection(url, username, password);
			if (con != null) {
				System.out.println("connection successfully");
			}

			else {
				System.out.println(" unable to connect DB");
			}

		} catch (SQLException ex) {
			System.out.println(ex);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return con;
	}

	/**
	 * This method is use to close database connection.
	 * 
	 * @param conn : Connection
	 * @throws Exception : Exception
	 */
	public static void closeConn(Connection conn) throws Exception {

		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
