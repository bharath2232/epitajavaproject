/**  
* StudentDao.java - Student data layer Interface class. 
* @author  Bharat and Atiqullah
* @version 1.0 
* @see College Project
*/
package com.iam.dao;

import java.util.List;

import com.iam.entity.Student;

public interface StudentDao {
	/**
	 * An abstract method to save data in DB
	 * 
	 * @param stud
	 *            : student data
	 * 
	 * @return int : status
	 */
	public int save(Student stud);

	/**
	 * An abstract method to update data in DB
	 * 
	 * @param stud
	 *            : student data
	 * @return int : status
	 */
	public int update(Student stud);

	/**
	 * An abstract method to delete data from DB
	 * 
	 * @param rollno
	 *            : Roll number
	 * @return int : status
	 */
	public int delete(int rollno);

	/**
	 * An abstract method to deleteByName data from DB
	 * 
	 * @param name
	 *            : Student name
	 * @return int : status
	 */
	public int deleteByName(String name);

	/**
	 * An abstract method to getAllStudentData data from DB
	 * 
	 * @return List
	 */
	public List<Student> getAllStudentData();

	/**
	 * An abstract method to getAllStudentData by roll number data from DB
	 * 
	 * @param rollno
	 *            : Roll number
	 * @return Student : Student data
	 */
	public Student getStudentDataByRollno(int rollno);
}