package com.employee.service;

import java.util.List;

import com.employee.entity.EmployeeEntity;


public interface EmployeeService {

	List<EmployeeEntity> getAll();

	void insertEmployeeData(EmployeeEntity employeeEntity);

}
