package com.sri.service;

import org.springframework.stereotype.Service;

@Service("old")
public class EmployeeServiceImpl implements EmployeeService{

	public int getEmployee(int empno) {
		System.out.println("Inide OLD getEmployee:");
		return 0;
	}

}
