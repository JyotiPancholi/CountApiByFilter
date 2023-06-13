package com.filter.count_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filter.count_api.repository.ApiCounterRepository;

@RestController
@RequestMapping("/your-api-endpoint")
public class FilterController {

	 private final ApiCounterRepository repo;
	     @Autowired
	     public FilterController(ApiCounterRepository repo) {
	         this.repo = repo;
	     }
	 
	     @GetMapping("/display")
	     public String yourApiEndpoint() {
	         return "Display API";
	     }
	 
	     @GetMapping("/count")
	     public int getCount() {
	 		return 1;
	     }
}
