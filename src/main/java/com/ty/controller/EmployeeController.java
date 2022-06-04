package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dto.Employee;
import com.ty.services.EmployeeServices;
import com.ty.services.UserService;

public class EmployeeController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		String gender = req.getParameter("gender");
		String role = req.getParameter("role");

		PrintWriter printWriter = resp.getWriter();

		Employee emp = new Employee();
		emp.setName(name);
		emp.setPhone(phone);
		emp.setAddres(address);
		emp.setRole(role);
		emp.setGender(gender);

		EmployeeServices employeeServices = new EmployeeServices();
		Employee employee = employeeServices.saveEmployee(emp);

		if (employee != null) {
			String htmlcode = "<html><body><h1>Name is " + name + " </h1><h1>Phone is " + phone
					+ " </h1>" + "<h1>Gender is " + gender + " </h1><h1>Role is "+role+"<h1>Address is " + address
					+ " </h1></body></html>";
			printWriter.write(htmlcode);
		}
	}

}
