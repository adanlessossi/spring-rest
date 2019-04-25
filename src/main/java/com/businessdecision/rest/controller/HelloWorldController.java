/**
 * 
 */
package com.businessdecision.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.businessdecision.rest.domain.HelloWorldBean;

/**
 * @author bernard.adanlessossi
 *
 */
@RestController
public class HelloWorldController {

	@GetMapping(path = "/hello-world")
	public String sayHello() {
		return "Hello World of Pain!";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean sayHelloBean() {
		return new HelloWorldBean("Hello World from Bean!");
	}
	
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean sayHelloPath(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
}
