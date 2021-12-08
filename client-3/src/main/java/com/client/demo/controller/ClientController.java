package com.client.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/")
public class ClientController {

	@HystrixCommand(fallbackMethod = "fallBackMethod")
	@GetMapping
	public String getMessage() {
		return "Hello from Client -3";
	}
	
	public String fallBackMethod() {
		return "Client -3 is down";
	}
	@PostMapping()
	public String addMessage(@RequestBody String name) {
		System.out.println("client -3  post method call "+name);
		return name;
	}
}
