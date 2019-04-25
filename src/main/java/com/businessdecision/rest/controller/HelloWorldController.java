/**
 * 
 */
package com.businessdecision.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
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

	@Autowired
	private MessageSource messageSource;
	
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
	
	@GetMapping(path = "/hello-world/internationalized")
	public String sayHelloInternationalized() {
		return messageSource.getMessage("good.morning", null, LocaleContextHolder.getLocale());
	}
}
