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
public class User {

	private Integer id;
	
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
	public User(final Integer id, final String name, final Date birthDate) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
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
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
}
