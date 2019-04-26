/**
 * 
 */
package com.businessdecision.rest.domain;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 * @author bernard.adanlessossi
 *
 */
public class User{

	private Integer userId;
	
	@Size(min = 2, message = "Name should have at least 2 characters")
	private String name;
	
	@Past
	private Date birthDate;

	/**
	 * Creates this.
	 */
	public User() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param birthDate
	 */
	public User(final Integer userId, final String name, final Date birthDate) {
		this.userId = userId;
		this.name = name;
		this.birthDate = birthDate;
	}

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param id the id to set
	 */
	public void setUserId(final Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(final Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
}
