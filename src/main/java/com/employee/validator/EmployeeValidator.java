package com.employee.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.employee.entity.EmployeeEntity;


@Component
public class EmployeeValidator implements Validator {

	public boolean supports(Class<?> arg0) {
		return EmployeeEntity.class.isAssignableFrom(arg0);
	}

	public void validate(Object arg0, Errors errors) {
ValidationUtils.rejectIfEmptyOrWhitespace(errors, "empname", "nameismissing");
ValidationUtils.rejectIfEmptyOrWhitespace(errors, "empage","ageismissing");
ValidationUtils.rejectIfEmptyOrWhitespace(errors, "empmail","mailismissing");
ValidationUtils.rejectIfEmptyOrWhitespace(errors, "empnumber","numberismissing");
ValidationUtils.rejectIfEmptyOrWhitespace(errors, "empcity","cityismissing");
	}

}
