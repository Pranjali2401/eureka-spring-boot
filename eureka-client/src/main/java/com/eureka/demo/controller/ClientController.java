package com.eureka.demo.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/")
public class ClientController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "homeFallBack")
	@GetMapping("/")
	public String getClient() {
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("message -1", " Hello from cilent -1 ");
		jsonobject.put("message -2", restTemplate.exchange("http://localhost:8002/", HttpMethod.GET, null, String.class).getBody());
		
		return jsonobject.toString();
	}
	
	public String homeFallBack() {
		
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("message -1", " Hello from cilent -1 ");
		jsonobject.put("message -2", "Client -2 is down");
		return jsonobject.toString();
	}
	
	@GetMapping("/client")
	public String getMessage() {
		
		JSONObject jsonobject1 = new JSONObject();
		
		 HttpHeaders headers = new HttpHeaders();   
		  headers.set("name", "USA");
		  
		  HttpEntity<?> request = new HttpEntity<>(headers);
		    
		jsonobject1.put("post method ",restTemplate.postForEntity("http://localhost:8002/", request, String.class).getBody());  
		return jsonobject1.toString();
	}
}
