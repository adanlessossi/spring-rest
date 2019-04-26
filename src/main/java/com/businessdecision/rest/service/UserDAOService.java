/**
 * 
 */
package com.businessdecision.rest.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.businessdecision.rest.domain.User;

/**
 * DAO service for {@link User}'s.
 * @author bernard.adanlessossi
 *
 */
@Component
public class UserDAOService {

	private static List<User> users = new ArrayList<>();
	
	private static int userCount = 6;
	
	/**
	 * Initializes the user list.
	 */
	static {
		users.add(new User(1, "Bernard", new Date()));
		users.add(new User(2, "Thomas", new Date()));
		users.add(new User(3, "Tania", new Date()));
		users.add(new User(4, "Pia", new Date()));
		users.add(new User(5, "Pierre", new Date()));
		users.add(new User(6, "Marcel", new Date()));
	}
	
	/**
	 * Retrieves all {@link User}'s.
	 * @return the list of  {@link User}'s
	 */
	public List<User> findAll(){
		return users;
	}
	
	/**
	 * Persists a single {@link User}.
	 * @param user the user to save
	 * @return the saved user
	 */
	public User save(final User user) {
		if (user.getUserId() == null) {
			user.setUserId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	/**
	 * Retrieves a specific {@link User} by Id.
	 * @param id the user id
	 * @return the user or null if not found
	 */
	public User findOne(final Integer id) {
		for (User user : users) {
			if (user.getUserId() == id) {
				return user;
			}
		}
		return null;
	}
	
	/**
	 * Deletes a specific {@link User} by id.
	 * @param id the user id
	 * @return the deleted user or null
	 */
	public User deleteById(final Integer id) {
		Iterator<User> iter = users.iterator();
		while(iter.hasNext()) {
			User user = iter.next();
			if (user.getUserId() == id) {
				iter.remove();
				return user;
			}
		}
		return null;
	}
}
