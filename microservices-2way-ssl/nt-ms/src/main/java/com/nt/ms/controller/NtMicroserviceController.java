package com.nt.ms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nt-ms")
public class NtMicroserviceController {

	@GetMapping("/data")
	public String getData() {
		System.out.println("Returning data from nt-ms data method");
		return "Hello from NT-MS-data method";
	}
}