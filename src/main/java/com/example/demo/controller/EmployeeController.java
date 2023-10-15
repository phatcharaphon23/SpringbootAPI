package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	

	@PostMapping("/add_employee")
	public Object AddEmployee(@RequestBody Employee employee) {
		return employeeService.AddEmployee(employee);
	}

	@PostMapping("/update_employee")
	public Object UpdateUsername(@RequestBody HashMap<String,String> info) {
		String nam = info.get("username");
		String id = info.get("id");
		long as = Integer.parseInt(id);
				
//		System.out.println();
		return employeeService.UpdateUsername(nam, as);
	}
	
	
	@PostMapping("/delete_user")
	public Object DeleteEmployee(@RequestBody HashMap<String,Integer> info) {
		long id = info.get("id");
		return employeeService.DeleteEmployee(id);
	}


}
