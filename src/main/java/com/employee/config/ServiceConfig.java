package com.employee.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.employee.service.EmployeeService;
import com.employee.service.EmployeeServiceImpl;
import com.employee.dao.EmployeeDao;

public class ServiceConfig {

	@Autowired
	private EmployeeDao EmployeeDao;
	
	
	@Bean
	public EmployeeService employeeService(){
		return new EmployeeServiceImpl(EmployeeDao);
	}
	
}
