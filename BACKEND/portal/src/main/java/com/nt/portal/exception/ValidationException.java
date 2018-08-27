package com.nt.portal.exception;

/**
 * Base Exception class for Business related Exception
 * 
 * @author suhail.ahmed
 * @version 1.0
 *
 */
public class ValidationException extends Exception {

	private static final long serialVersionUID = -4359082794160036377L;

	private String exceptionType;

	private String message;

	private String errMsgDesc;

	private Object[] placeValues;

	public ValidationException() {

	}

	public ValidationException(String message) {
		super(message);
		this.message = message;
	}

	public ValidationException(Throwable cause) {
		super(cause);
	}

	public ValidationException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}

	public ValidationException(String message, String errMsgDesc) {
		super(message);
		this.message = message;
		this.errMsgDesc = errMsgDesc;
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

	public String getErrMsgDesc() {
		return errMsgDesc;
	}

	public void setErrMsgDesc(String errMsgDesc) {
		this.errMsgDesc = errMsgDesc;
	}

}
