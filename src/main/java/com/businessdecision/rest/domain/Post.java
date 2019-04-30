/**
 * 
 */
package com.businessdecision.rest.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author bernard.adanlessossi
 *
 */
@Entity
public class Post {

	@Id
	@GeneratedValue
	private Integer postId;
	
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;

	/**
	 * Creates this.
	 */
	public Post() {
		super();
	}

	/**
	 * Creates this.
	 * @param postId
	 * @param description
	 * @param user
	 */
	public Post(Integer postId, String description, User user) {
		super();
		this.postId = postId;
		this.description = description;
		this.user = user;
	}

	/**
	 * @return the postId
	 */
	public Integer getPostId() {
		return postId;
	}

	/**
	 * @param postId the postId to set
	 */
	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", description=" + description + "]";
	}
}
