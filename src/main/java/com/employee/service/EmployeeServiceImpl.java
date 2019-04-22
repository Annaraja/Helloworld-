package com.employee.service;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.employee.dao.EmployeeDao;
import com.employee.entity.EmployeeEntity;




@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeServiceImpl implements EmployeeService{

	
	private final EmployeeDao employeeDao;
	

	private SqlParameterSource getSqlParameterDataSource(
			EmployeeEntity employeeEntity) {
		MapSqlParameterSource sqlParameterSource =new MapSqlParameterSource();
		sqlParameterSource.addValue("empname", employeeEntity.getEmpname());
		sqlParameterSource.addValue("empid", employeeEntity.getId());
		sqlParameterSource.addValue("empnum", employeeEntity.getEmpnumber());
		sqlParameterSource.addValue("empcity", employeeEntity.getEmpcity());
		sqlParameterSource.addValue("empage", employeeEntity.getEmpage());
		sqlParameterSource.addValue("empmail", employeeEntity.getEmpmail());
		return sqlParameterSource;
	}

	public List<EmployeeEntity> getAll() {
		return employeeDao.getAll();
	}

	public void insertEmployeeData(EmployeeEntity employeeEntity) {
		SqlParameterSource	sqlParameterSource= getSqlParameterDataSource(employeeEntity);
		employeeDao.insertEmployeeData(sqlParameterSource,employeeEntity);
		
	}

}
