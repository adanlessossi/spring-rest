/**
 * 
 */
package com.businessdecision.rest.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.businessdecision.rest.domain.Post;
import com.businessdecision.rest.domain.User;
import com.businessdecision.rest.exception.UserNotFoundException;
import com.businessdecision.rest.repository.PostRepository;
import com.businessdecision.rest.repository.UserRepository;

/**
 * The {@link User} resource.
 * 
 * @author bernard.adanlessossi
 *
 */
@RestController
public class UserJpaResource {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	/**
	 * Gets all {@link User}'s.
	 * 
	 * @return the list of users
	 */
	@GetMapping("/jpa/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	/**
	 * Finds a single {@link User} by id.
	 * 
	 * @param userId the user id
	 * @return the user
	 * @throws UserNotFoundException if not found
	 */
	@GetMapping("/jpa/users/{userId}")
	public Resource<User> getOneUser(@PathVariable Integer userId) throws UserNotFoundException {
		Optional<User> user = userRepository.findById(userId);
		if (!user.isPresent()) {
			throw new UserNotFoundException("id-" + userId);
		}
		// HATEOAS --> provide link back to all users
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllUsers());
		Resource<User> resource = new Resource<User>(user.get());
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}

	/**
	 * Delete the {@link User} by id.
	 * 
	 * @param userId the user id
	 * @throws UserNotFoundException if not existing
	 */
	@DeleteMapping("/jpa/users/{userId}")
	public void deleteById(@PathVariable Integer userId) throws UserNotFoundException {
		userRepository.deleteById(userId);
	}

	/**
	 * Creates a new {@link User}.
	 * 
	 * @param user the user to create
	 * @return the newly created user
	 */
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}")
				.buildAndExpand(savedUser.getUserId()).toUri();
		return ResponseEntity.created(location).build();
	}

	/**
	 * Gets the given {@link User}'s Post.
	 * 
	 * @return the list of users
	 */
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> getUserPost(@PathVariable Integer id) throws UserNotFoundException {
		Optional<User> userOptional = userRepository.findById(id);
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}
		return userOptional.get().getPosts();
	}

	/**
	 * Creates a new {@link User}.
	 * 
	 * @param user the user to create
	 * @return the newly created user
	 */
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable Integer id, @RequestBody Post post)
			throws UserNotFoundException {
		Optional<User> userOptional = userRepository.findById(id);
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}
		User existingUser = userOptional.get();
		post.setUser(existingUser);
		
		this.postRepository.save(post);
		

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(post.getPostId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
}
