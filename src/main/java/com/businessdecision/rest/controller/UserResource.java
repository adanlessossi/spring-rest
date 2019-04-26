/**
 * 
 */
package com.businessdecision.rest.controller;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.businessdecision.rest.domain.User;
import com.businessdecision.rest.exception.UserNotFoundException;
import com.businessdecision.rest.service.UserDAOService;

/**
 * The {@link User} resource.
 * 
 * @author bernard.adanlessossi
 *
 */
@RestController
public class UserResource {

	@Autowired
	private UserDAOService service;

	/**
	 * Gets all {@link User}'s.
	 * @return the list of users
	 */
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return service.findAll();
	}

	/**
	 * Finds a single {@link User} by id.
	 * @param userId the user id
	 * @return the user
	 * @throws UserNotFoundException if not found
	 */
	@GetMapping("/users/{userId}")
	public Resource<User> getOneUser(@PathVariable Integer userId) throws UserNotFoundException {
		User user = service.findOne(userId);
		if (user == null) {
			throw new UserNotFoundException("id-" + userId);
		}
		// HATEOAS --> provide link back to all users
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllUsers());
		Resource<User> resource = new Resource<User>(user);		
	    resource.add(linkTo.withRel("all-users"));
		return resource;
	}
	
	/**
	 * Delete the {@link User} by id.
	 * @param userId the user id
	 * @throws UserNotFoundException if not existing
	 */
	@DeleteMapping("/users/{userId}")
	public void deleteById(@PathVariable Integer userId) throws UserNotFoundException {
		User user = service.deleteById(userId);
		if (user == null) {
			throw new UserNotFoundException("userId-" + userId);
		}
	}

	/**
	 * Creates a new {@link User}.
	 * @param user the user to create
	 * @return the newly created user
	 */
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}").buildAndExpand(savedUser.getUserId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
