/**
 * 
 */
package com.businessdecision.rest.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The details about a user.
 * @author bernard.adanlessossi
 *
 */
@ApiModel(description = "Details about Users")
@Entity
public class User{

	@Id
	@GeneratedValue
	private Integer userId;
	
	@Size(min = 2, message = "Name should have at least 2 characters")
	@ApiModelProperty(notes = "The Name property should have at least 2 characters")
	private String name;
	
	@Past
	@ApiModelProperty(notes = "The Birthdate property should be in the past")
	private Date birthDate;

	/**
	 * Creates this.
	 */
	public User() {
		super();
	}

	/**
	 * Creates this with parameters.
	 * @param userId the user Id
	 * @param name the name
	 * @param birthDate the birthdate
	 */
	public User(final Integer userId, final String name, final Date birthDate) {
		this.userId = userId;
		this.name = name;
		this.birthDate = birthDate;
	}

	/**
	 * Gets the user id.
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 * @param id the id to set
	 */
	public void setUserId(final Integer userId) {
		this.userId = userId;
	}

	/**
	 * Gets the user name.
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the user name.
	 * @param name the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * Gets the user birthdate.
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * Sets the user birthdate.
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
