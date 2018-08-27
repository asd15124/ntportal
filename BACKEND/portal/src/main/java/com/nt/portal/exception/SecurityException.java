package com.nt.portal.exception;

/**
 * Base exception class to handle security related exception
 * 
 * @author suhail.ahmed
 * @version 1.0
 *
 */
public class SecurityException extends Exception {

	private static final long serialVersionUID = -1018517686872320706L;

	private String exceptionType;

	private String message;

	private Object[] placeValues;

	public SecurityException() {
		super();
	}

	public SecurityException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}

	public SecurityException(Throwable cause) {
		super(cause);
	}

	/**
	 * @return the exceptionType
	 */
	public String getExceptionType() {
		return exceptionType;
	}

	/**
	 * @param exceptionType
	 *            the exceptionType to set
	 */
	public void setExceptionType(String exceptionType) {
		this.exceptionType = exceptionType;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the placeValues
	 */
	public Object[] getPlaceValues() {
		return placeValues;
	}

	/**
	 * @param placeValues
	 *            the placeValues to set
	 */
	public void setPlaceValues(Object[] placeValues) {
		this.placeValues = placeValues;
	}

}
