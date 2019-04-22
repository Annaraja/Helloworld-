package com.employee.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class UserMapper implements RowMapper<EmployeeEntity>{

	public EmployeeEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmployeeEntity employeeEntity =new EmployeeEntity();
		employeeEntity.setEmpname(rs.getString("empname"));
		employeeEntity.setEmpnumber(rs.getString("empnum"));
		employeeEntity.setEmpmail(rs.getString("empmail"));
		employeeEntity.setEmpcity(rs.getString("empcity"));
		employeeEntity.setId(rs.getInt("empid"));
		employeeEntity.setEmpage(rs.getInt("empAge"));
		return employeeEntity;
	}

}
