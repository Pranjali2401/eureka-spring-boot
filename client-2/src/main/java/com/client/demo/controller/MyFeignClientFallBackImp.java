package com.client.demo.controller;

import org.json.JSONObject;

public class MyFeignClientFallBackImp implements OpenFeignClient {

	@Override
	public String client3Response() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("message -2", "Hello from Client -2");
		jsonObject.put("message -3", "Client -3 is down");

		return jsonObject.toString();
	}

	@Override
	public String addClient(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
