/**  
* StudentDaoIml.java - Implementation of Student data layer Interface class. 
* @author  Bharat and Atiqullah
* @version 1.0 
* @see College Project
*/

package com.iam.dao.impl;

import com.iam.dao.StudentDao;
import com.iam.entity.Student;
import com.iam.utility.DatabaseUtility;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoIml implements StudentDao {
	InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("config/DB.properties");

	/**
	 * An implementation method to save data in DB
	 * 
	 * This method takes student data and insert into DB
	 * 
	 * @param stud
	 *            : student data
	 * @return int : status
	 * 
	 */
	public int save(Student stud) {
		int status = 0;
		try {
			Connection con = DatabaseUtility.getCon(inputStream);
			PreparedStatement ps = con.prepareStatement(
					"insert into student(first_name,last_name,email,gender,date_of_birth,address,contact_no) values(?,?,?,?,?,?,?)");
			ps.setString(1, stud.getFname());
			ps.setString(2, stud.getLname());
			ps.setString(3, stud.getEmail());
			ps.setString(4, stud.getGender());
			ps.setString(5, stud.getDOB());
			ps.setString(6, stud.getAddress());
			ps.setString(7, stud.getContact());

			status = ps.executeUpdate();
			con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return status;
	}

	/**
	 * An implementation method to update data in DB
	 * 
	 * This method takes student data and update the student data into DB
	 * 
	 * @param stud
	 *            : student data
	 * @return int : status
	 * 
	 */
	public int update(Student stud) {
		int status = 0;
		try {
			Connection con = DatabaseUtility.getCon(inputStream);
			PreparedStatement ps = con.prepareStatement(
					"update student set first_name=?,last_name=?,email=?,gender=?,date_of_birth=?,address=?,contact_no=? where roll_no=?");
			ps.setString(1, stud.getFname());
			ps.setString(2, stud.getLname());
			ps.setString(3, stud.getEmail());
			ps.setString(4, stud.getGender());
			ps.setString(5, stud.getDOB());
			ps.setString(6, stud.getAddress());
			ps.setString(7, stud.getContact());
			ps.setInt(8, stud.getRollno());
			status = ps.executeUpdate();
			con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return status;
	}

	/**
	 * 
	 * An implementation method to deleteByName data from DB
	 * 
	 * This method takes student roll number and delete the student data from DB
	 * 
	 * @param rollno
	 *            : roll number
	 * @return int : status
	 * 
	 */
	public int delete(int rollno) {
		int status = 0;
		try {
			Connection con = DatabaseUtility.getCon(inputStream);
			PreparedStatement ps = con.prepareStatement("delete from student where roll_no=?");
			ps.setInt(1, rollno);
			status = ps.executeUpdate();
			con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return status;
	}

	/**
	 * 
	 * An implementation method to deleteByName data from DB
	 * 
	 * This method takes student data and delete the student data from DB
	 * 
	 * @param name
	 *            : student data
	 * @return int : status
	 * 
	 */
	public int deleteByName(String name) {
		int status = 0;
		try {
			Connection con = DatabaseUtility.getCon(inputStream);
			PreparedStatement ps = con.prepareStatement("delete from student where name=?");
			ps.setString(1, name);
			status = ps.executeUpdate();
			con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return status;
	}

	/**
	 * 
	 * An implementation method to getAllStudentData data from DB
	 * 
	 * This method takes get all student data from DB
	 * 
	 * @return List : List of Student
	 * 
	 */

	public List<Student> getAllStudentData() {
		List<Student> list = new ArrayList<Student>();
		try {
			Connection con = DatabaseUtility.getCon(inputStream);
			PreparedStatement ps = con.prepareStatement("select * from student");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student stud = new Student();

				stud.setRollno(rs.getInt(1));
				stud.setFname(rs.getString(2));
				stud.setLname(rs.getString(3));
				stud.setEmail(rs.getString(4));
				stud.setGender(rs.getString(5));
				stud.setDOB(rs.getString(6));
				stud.setAddress(rs.getString(7));
				stud.setContact(rs.getString(8));

				list.add(stud);
			}
			con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}

		return list;
	}

	/**
	 * 
	 * An implementation method to getStudentDataByRollno data from DB
	 * 
	 * This method takes get student data from DB using roll number
	 * 
	 * @param rollno
	 *            : student roll number
	 * @return Student : Student data
	 * 
	 */

	public Student getStudentDataByRollno(int rollno) {
		Student stud = new Student();
		try {
			Connection con = DatabaseUtility.getCon(inputStream);
			PreparedStatement ps = con.prepareStatement("select * from student where roll_no=?");
			ps.setInt(1, rollno);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				stud.setRollno(rs.getInt(1));
				stud.setFname(rs.getString(2));
				stud.setLname(rs.getString(3));
				stud.setEmail(rs.getString(4));
				stud.setGender(rs.getString(5));
				stud.setDOB(rs.getString(6));
				stud.setAddress(rs.getString(7));
				stud.setContact(rs.getString(8));

			}
			con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}

		return stud;
	}

}