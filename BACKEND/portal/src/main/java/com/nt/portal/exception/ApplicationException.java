package com.nt.portal.exception;

/**
 * Base exception class for Application related exception
 * 
 * @author suhail.ahmed
 * @version 1.0
 */
public class ApplicationException extends Exception {

	private static final long serialVersionUID = -2094440569509993019L;

	private String exceptionType;

	private String message;

	private Object[] placeValues;

	public ApplicationException() {

	}

	public ApplicationException(String message) {
		super(message);
		this.message = message;
	}

	public ApplicationException(Throwable cause) {
		super(cause);
	}

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
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
