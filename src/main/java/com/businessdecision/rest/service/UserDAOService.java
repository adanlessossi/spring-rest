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
 * @author bernard.adanlessossi
 *
 */
@Component
public class UserDAOService {

	private static List<User> users = new ArrayList<>();
	
	private static int userCount = 6;
	
	static {
		users.add(new User(1, "Bernard", new Date()));
		users.add(new User(2, "Thomas", new Date()));
		users.add(new User(3, "Tania", new Date()));
		users.add(new User(4, "Pia", new Date()));
		users.add(new User(5, "Pierre", new Date()));
		users.add(new User(6, "Marcel", new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(final User user) {
		if (user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(final Integer id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteById(final Integer id) {
		Iterator<User> iter = users.iterator();
		while(iter.hasNext()) {
			User user = iter.next();
			if (user.getId() == id) {
				iter.remove();
				return user;
			}
		}
		return null;
	}
}
