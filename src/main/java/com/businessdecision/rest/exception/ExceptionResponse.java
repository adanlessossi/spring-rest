/**
 * 
 */
package com.businessdecision.rest.exception;

import java.util.Date;

/**
 * Response to be returned when a exception occurs.
 * @author bernard.adanlessossi
 *
 */
public class ExceptionResponse {

	private Date timestamp;
	
	private String message;
	
	private String details;

	/**
	 * Creates this.
	 * @param timestamp the exception timestamp
	 * @param message the exception message
	 * @param details the exception details
	 */
	public ExceptionResponse(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	/**
	 * Gets the exception Timestamp.
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * Sets the exception Timestamp.
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * Gets the exception message.
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the exception message.
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Gets the exception details.
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * Sets the exception details.
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}
}
