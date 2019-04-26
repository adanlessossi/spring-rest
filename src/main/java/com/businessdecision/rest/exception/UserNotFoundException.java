/**
 * 
 */
package com.businessdecision.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Thrown when a {@link User} is not found.
 * @author bernard.adanlessossi
 *
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = 530464423540337541L;

	/**
	 * Creates this with a message.
	 * @param message the message
	 */
	public UserNotFoundException(String message) {
		super(message);
	}

}
