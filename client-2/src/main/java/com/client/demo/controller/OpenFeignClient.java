package com.client.demo.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value="eureka-3", url="http://localhost:8003/", fallback = MyFeignClientFallBackImp.class)
public interface OpenFeignClient {
	
	@GetMapping
	String client3Response(); 
	
	@PostMapping
	String addClient(@RequestBody String name);

}
