package com.salil.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.salil.service.EmployeeEmployerervice;

@RestController
public class EmployeeController {
	
	
	@Resource
	EmployeeEmployerervice userService;

	
	
	@RequestMapping(value = "/employeeEmployerDetails", method = RequestMethod.GET)
	public List getAllEmployeeEmploymentDetails() {
		
		return userService.getAllEmployeeEmploymentDetails();
	}
	
	@RequestMapping(value = "/employeeEmployerDetails/{userId}", method = RequestMethod.GET)
	public List getEmployeeEmploymentDetails(@PathVariable("userId") String userId) {
		
		return userService.getEmployeeEmploymentDetails(userId);
	}

	@RequestMapping(value = "/employerDetails", method = RequestMethod.GET)
	public List getAllEmployerDetails() {
		
		return userService.getAllEmployerDetails();
	}
	
	@RequestMapping(value = "/employerDetails/{employerId}", method = RequestMethod.GET)
	public List getEmployerDetails(@PathVariable("employerId") String employerId) {
		
		return userService.getEmployerDetails(employerId);
	}

}