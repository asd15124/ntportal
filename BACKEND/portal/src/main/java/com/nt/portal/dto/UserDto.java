package com.nt.portal.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO class for holding User Data
 * 
 * @author suhail.ahmad
 * @version 1.0
 *
 */
public class UserDto implements Serializable {

	/**
	 * Serial Version ID
	 */
	private static final long serialVersionUID = -6641715622459960902L;

	private String firstName;
	private String lastName;
	private String userName;
	private String email;
	private String password;
	private Date createdOn;
	private String formattedCreatedOn;
	private Date updatedOn;
	private String formattedUpdatedOn;

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn
	 *            the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the formattedCreatedOn
	 */
	public String getFormattedCreatedOn() {
		return formattedCreatedOn;
	}

	/**
	 * @param formattedCreatedOn
	 *            the formattedCreatedOn to set
	 */
	public void setFormattedCreatedOn(String formattedCreatedOn) {
		this.formattedCreatedOn = formattedCreatedOn;
	}

	/**
	 * @return the updatedOn
	 */
	public Date getUpdatedOn() {
		return updatedOn;
	}

	/**
	 * @param updatedOn
	 *            the updatedOn to set
	 */
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	/**
	 * @return the formattedUpdatedOn
	 */
	public String getFormattedUpdatedOn() {
		return formattedUpdatedOn;
	}

	/**
	 * @param formattedUpdatedOn
	 *            the formattedUpdatedOn to set
	 */
	public void setFormattedUpdatedOn(String formattedUpdatedOn) {
		this.formattedUpdatedOn = formattedUpdatedOn;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
