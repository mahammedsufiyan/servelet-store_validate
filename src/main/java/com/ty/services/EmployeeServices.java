package com.ty.services;

import com.ty.dao.EmployeeDao;
import com.ty.dto.Employee;

public class EmployeeServices {
	
	public Employee saveEmployee(Employee employee) {
		EmployeeDao dao = new EmployeeDao();
		return dao.saveEmployee(employee);
	}
}
