package com.client.demo.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ClientController {

	@Autowired
	private OpenFeignClient feignClient;
	
	@GetMapping("/")
	public String getMessage() {
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("message -2", "Hello from Client -2" );
		jsonObject.put("message -3",feignClient.client3Response());
		
		
		return jsonObject.toString();
	}
	
//	Client 3 is not running
//	public String clientFallBack() {
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("message -2", "Hello from Client -2" );
//		jsonObject.put("message -3","Client 3 is down");
//		
//		
//		return jsonObject.toString();
//	}
	
	
	@PostMapping("/")
	public String getMessage(@RequestBody String name) {
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("message -2", "Hello from Client -2" );
		jsonObject.put("message -3",feignClient.client3Response());
		jsonObject.put("PostMessage-3", feignClient.addClient(name));
		
		
		return jsonObject.toString();
	}
	

	
}
