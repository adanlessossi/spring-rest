/**
 * 
 */
package com.businessdecision.rest.controller;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return service.findAll();
	}

	@GetMapping("/users/{id}")
	public EntityModel<User> getOneUser(@PathVariable Integer id) throws UserNotFoundException {
		User user = service.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("id-" + id);
		}
		// HATEOAS --> provide link back to all users
	    EntityModel<User> model = new EntityModel<>(user);
	    WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllUsers());
	    model.add(linkTo.withRel("all-users"));
		return model;
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteById(@PathVariable Integer id) throws UserNotFoundException {
		User user = service.deleteById(id);
		if (user == null) {
			throw new UserNotFoundException("id-" + id);
		}
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
