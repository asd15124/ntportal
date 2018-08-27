package com.nt.portal.dto.common;

import java.io.Serializable;

/**
 * Class to hold error messages
 * 
 * @author suhail.ahmed
 * @version 1.0
 *
 */
public class ErrorMessage implements Serializable {

	private static final long serialVersionUID = -976406856455949115L;

	private int errorMessageId;

	private String errorMessageCode;

	private String errorMessageLabel;

	/**
	 * @return the errorMessageId
	 */
	public int geterrorMessageId() {
		return errorMessageId;
	}

	/**
	 * @param errorMessageId
	 *            the errorMessageId to set
	 */
	public void seterrorMessageId(int errorMessageId) {
		this.errorMessageId = errorMessageId;
	}

	/**
	 * @return the errorMessageCode
	 */
	public String getErrorMessageCode() {
		return errorMessageCode;
	}

	/**
	 * @param errorMessageCode
	 *            the errorMessageCode to set
	 */
	public void setErrorMessageCode(String errorMessageCode) {
		this.errorMessageCode = errorMessageCode;
	}

	/**
	 * @return the errorMessageLabel
	 */
	public String getErrorMessageLabel() {
		return errorMessageLabel;
	}

	/**
	 * @param errorMessageLabel
	 *            the errorMessageLabel to set
	 */
	public void setErrorMessageLabel(String errorMessageLabel) {
		this.errorMessageLabel = errorMessageLabel;
	}

}
