package com.employee.dao;

import java.util.List;

import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.employee.entity.EmployeeEntity;


public interface EmployeeDao {

	List<EmployeeEntity> getAll();

	void insertEmployeeData(SqlParameterSource sqlParameterSource, EmployeeEntity employeeEntity);

}
