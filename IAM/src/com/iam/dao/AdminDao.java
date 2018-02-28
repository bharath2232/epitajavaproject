/**  
* AdminDao.java - Admin data layer Interface class. 
* @author  Bharat and Atiqullah
* @version 1.0 
* @see College Project
*/
package com.iam.dao;

public interface AdminDao {
	/**
	 * An abstract method for checkAdmin
	 * 
	 * @param user
	 *            : user name
	 * @param password
	 *            :password
	 * @return boolean : status
	 */
	public boolean checkAdmin(String user, String password);

}
