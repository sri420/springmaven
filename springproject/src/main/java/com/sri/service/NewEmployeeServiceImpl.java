package com.sri.service;

import org.springframework.stereotype.Service;

@Service("new")
public class NewEmployeeServiceImpl implements EmployeeService {
	
	public int getEmployee(int empno) {
		System.out.println("Inide NEW getEmployee:");
		return 0;
	}

}
