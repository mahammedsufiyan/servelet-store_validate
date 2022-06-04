package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dto.User;
import com.ty.services.UserService;
@WebServlet(value = "/registration")
public class UserController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		String password = req.getParameter("password");

		PrintWriter printWriter = resp.getWriter();

		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setGender(gender);
		user.setPassword(password);

		UserService service = new UserService();
		User user1 = service.saveUser(user);

		if (user1 != null) {
			String html = "<html><body><h1>Thank you for Registration</h1></body></html>";
			printWriter.write(html);
			RequestDispatcher dispatcher = req.getRequestDispatcher("validateuser.html");
			dispatcher.forward(req, resp);
			
		} else {
			String el = "<html><body><h1>User is Null</h1></body></html>";
			printWriter.write(el);
			RequestDispatcher dispatcher = req.getRequestDispatcher("registration.html");
			dispatcher.include(req, resp);
		}
	}

}
