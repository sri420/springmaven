package com.sri.domain;	

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;





public class Employee {

	@NotNull		
	String empno;
	
	@NotNull
	@Size(min = 2, max = 14)
	String empname;

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}
	
	
}