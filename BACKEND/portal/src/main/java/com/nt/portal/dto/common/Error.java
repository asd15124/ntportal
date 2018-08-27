package com.nt.portal.dto.common;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.nt.portal.exception.ApplicationException;
import com.nt.portal.exception.SecurityException;
import com.nt.portal.exception.SystemException;
import com.nt.portal.exception.ValidationException;

/**
 * Class to hold error related details
 * 
 * @author suhail.ahmed
 * @version 1.0
 */
public final class Error implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The error code. */
	private String errorCode;

	/** The error type. */
	private String errorType;

	/** The error context. */
	private String errorContext;

	/** Error or Warning differentiator. */
	private boolean isError;

	/** The parameters. */
	private Map<String, String> parameters;

	private List<Object> arguments;

	/** The Throwable Context */
	private Throwable context;

	/**
	 * Instantiates a new error.
	 * 
	 * @param e
	 *            the e
	 * @param isError
	 *            the is error
	 */
	public Error(ApplicationException e, boolean isError) {
		this.errorType = e.getExceptionType();
		this.errorCode = e.getMessage();
		this.isError = isError;
		this.context = e;
		addDynamicArguments(e.getPlaceValues());
	}

	private void addDynamicArguments(Object[] placeValues) {
		if (placeValues != null && placeValues.length > 0)
			this.arguments = Arrays.asList(placeValues);
	}

	/**
	 * Instantiates a new error.
	 * 
	 * @param e
	 *            the e
	 * @param isError
	 *            the is error
	 */
	public Error(ValidationException e, boolean isError) {
		this.errorType = e.getExceptionType();
		this.errorCode = e.getMessage();
		this.isError = isError;
		this.context = e;
		addDynamicArguments(e.getPlaceValues());
	}

	/**
	 * Instantiates a new error.
	 * 
	 * @param e
	 *            the e
	 */
	public Error(SystemException e) {
		this.errorType = e.getExceptionType();
		this.errorCode = e.getMessage();
		this.context = e;
		isError = true;
	}

	/**
	 * Instantiates a new error.
	 * 
	 * @param e
	 *            the e
	 */
	public Error(SecurityException e) {
		this.errorType = e.getExceptionType();
		this.errorCode = e.getMessage();
		this.context = e;
		isError = true;
		addDynamicArguments(e.getPlaceValues());
	}

	public Error(Throwable e) {
		this.errorType = e.getClass().getName();
		this.errorCode = e.getMessage();
		this.context = e;
		isError = true;
	}

	/**
	 * Gets the error code.
	 * 
	 * @return the error code
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * Sets the error code.
	 * 
	 * @param errorCode
	 *            the new error code
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * Gets the error type.
	 * 
	 * @return the error type
	 */
	public String getErrorType() {
		return errorType;
	}

	/**
	 * Sets the error type.
	 * 
	 * @param errorType
	 *            the new error type
	 */
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	/**
	 * Gets the error context.
	 * 
	 * @return the error context
	 */
	public String getErrorContext() {
		return errorContext;
	}

	/**
	 * Sets the error context.
	 * 
	 * @param errorContext
	 *            the new error context
	 */
	public void setErrorContext(String errorContext) {
		this.errorContext = errorContext;
	}

	/**
	 * Sets the parameters.
	 * 
	 * @param parameterMap
	 *            the parameter map
	 */
	public void setParameters(Map<String, String> parameterMap) {
		this.parameters = parameterMap;
	}

	/**
	 * Gets the parameters.
	 *
	 * @return the parameters
	 */
	public Map<String, String> getParameters() {
		return parameters;
	}

	/**
	 * Check whether this Error is an error or warning.
	 * 
	 * @return boolean True if this is an error
	 */
	public boolean isError() {
		return isError;
	}

	public List<Object> getDynamicArguments() {
		return this.arguments;
	}

	public Throwable getContext() {
		return this.context;
	}

	@Override
	public String toString() {
		return "Error [errorCode=" + errorCode + ", errorType=" + errorType + ", errorContext=" + errorContext
				+ ", isError=" + isError + ", parameters=" + parameters + "]";
	}
}
