package com.aa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aa.service.CustomerService;

@RestController
@RequestMapping("/api/v1")
public class CustomerRestController {
	
	@Autowired
	private CustomerService service;

}
