/**  
* Student.java - The class is a POJO class for Student object  
* @author  Bharat and Atiqullah
* @version 1.0 
* @see College Project
*/

package com.iam.entity;

public class Student {

	private int rollno;
	private String fname;
	private String lname;
	private String email;
	private String gender;
	private String DOB;
	private String address;
	private String contact;

	/**
	 * Default constructor
	 */
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param fname
	 *            : First name
	 * @param lname
	 *            : Last Name
	 * @param email
	 *            : Email Address
	 * @param gender
	 *            : Gender
	 * @param dOB
	 *            : date of birth
	 * @param address
	 *            : Address
	 * @param contact:
	 *            Contact number
	 * 
	 */
	public Student(String fname, String lname, String email, String gender, String dOB, String address,
			String contact) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.gender = gender;
		DOB = dOB;
		this.address = address;
		this.contact = contact;

	}

	/**
	 * Parameterized constructor
	 * 
	 * @param rollno
	 *            : Roll number
	 * @param fname
	 *            : First name
	 * @param lname
	 *            : Last Name
	 * @param email
	 *            : Email Address
	 * @param gender
	 *            : Gender
	 * @param dOB
	 *            : date of birth
	 * @param address
	 *            : Address
	 * @param contact:
	 *            Contact number
	 */
	public Student(int rollno, String fname, String lname, String email, String gender, String dOB, String address,
			String contact) {
		super();
		this.rollno = rollno;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.gender = gender;
		DOB = dOB;
		this.address = address;
		this.contact = contact;

	}

	/**
	 * @return the rollno
	 */
	public int getRollno() {
		return rollno;
	}

	/**
	 * @param rollno
	 *            the rollno to set
	 */
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}

	/**
	 * @param fname
	 *            the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}

	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}

	/**
	 * @param lname
	 *            the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the dOB
	 */
	public String getDOB() {
		return DOB;
	}

	/**
	 * @param dOB
	 *            the dOB to set
	 */
	public void setDOB(String dOB) {
		DOB = dOB;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * @param contact
	 *            the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

}
