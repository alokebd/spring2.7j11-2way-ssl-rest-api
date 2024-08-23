package com.nt.gateway.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/nt-gw")
public class NtGatewayController {
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	Environment env;
	
	@GetMapping("/data")
	public String getData() {
		System.out.println("Returning data from nt-gateway own data method");
		return "Hello from NT-GATEWAY-data method";
	}
	
	@GetMapping("/ms-data")
	public String getMsData() {
		System.out.println("Got inside NT-GATEWAY-ms-data method");
		try {
			String msEndpoint = env.getProperty("endpoint.ms-service");
			System.out.println("MS Endpoint name : [" + msEndpoint + "]");
			
			return restTemplate.getForObject(new URI(msEndpoint), String.class);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "Exception occurred.. so, returning default data";
	}
}
