package com.sri.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sri.domain.Employee;

public class EmployeeValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		return Employee.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "empno", "field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "empname", "field.required");
        Employee emp = (Employee) target;
       /* if (emp.getEmpno() < 0) {
            errors.rejectValue("empno", "fied.Negative");
        } else if (emp.getEmpno() > 110) {
            errors.rejectValue("empno", "field.gt.110");
        }*/
        if (emp.getEmpname().equalsIgnoreCase("sri")){
            errors.rejectValue("Empname", "field.Value.NotAllowed");
        } 
	}

}
