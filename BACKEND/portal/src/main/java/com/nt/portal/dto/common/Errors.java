package com.nt.portal.dto.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Errors class to list of errors related details
 * 
 * @author suhail.ahmed
 * @version 1.0
 */
public class Errors implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The error list. */
	private List<Error> errorList = new ArrayList<Error>();

	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
	public boolean isEmpty() {
		return errorList.isEmpty();
	}

	/**
	 * Adds the error.
	 *
	 * @param a_error
	 *            the error
	 */
	public void addError(Error error) {
		errorList.add(error);
	}

	/**
	 * Gets the error.
	 *
	 * @return the error
	 */
	public Error getError() {
		Error error = null;

		if (!errorList.isEmpty()) {
			error = errorList.get(0);
		}
		return error;
	}

	/**
	 * Check if there are any errors in the response
	 *
	 * @return boolean True if any error is present
	 */
	public boolean isError() {
		boolean result = false;
		for (Error error : errorList) {
			if (error.isError()) {
				result = true;
				break;
			}
		}
		return result;
	}

	/**
	 * @return the errorList
	 */
	public List<Error> getErrors() {
		return errorList;
	}

	/**
	 * To String method
	 */
	@Override
	public String toString() {
		return "Errors [errorList=" + errorList + "]";
	}

}
