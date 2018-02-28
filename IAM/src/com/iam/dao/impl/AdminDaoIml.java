/**  
* AdminDaoIml.java - Implementation of Admin data layer Interface class. 
* @author  Bharat and Atiqullah
* @version 1.0 
* @see College Project
*/

package com.iam.dao.impl;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.iam.dao.AdminDao;
import com.iam.utility.DatabaseUtility;

public class AdminDaoIml implements AdminDao {
	InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("config/DB.properties");

	/**
	 * An implementation method for checkAdmin It validate the user and password
	 * from database
	 * 
	* @param user
	 *            : user name
	 * @param password
	 *            :password
	 * 
	 * @return boolean : status
	 * 
	 */

	public boolean checkAdmin(String user, String password) {
		boolean status = false;
		try {
			Connection con = DatabaseUtility.getCon(inputStream);
			PreparedStatement ps = con.prepareStatement("select * from admin where user=? and password=?");
			ps.setString(1, user);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return status;
	}

}
