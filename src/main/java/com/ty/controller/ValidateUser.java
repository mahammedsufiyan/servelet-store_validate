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
@WebServlet(value = "/validate")
public class ValidateUser extends HttpServlet {
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		PrintWriter printWriter = resp.getWriter();
		
		
		UserService service = new UserService();
		User user = service.validateUser(email, password);
		
		if(user != null) {
			
			String html="<html><body><h1>Ok user is Succsussfully Logined</h1></body></html>";
			printWriter.write(html);
			RequestDispatcher dispatcher = req.getRequestDispatcher("home.html");
			dispatcher.forward(req, resp);
		}
		else {
			
			String html1="<html><body><h1>Check user name or password</h1></body></html>";
			printWriter.write(html1);
			RequestDispatcher dispatcher = req.getRequestDispatcher("validateuser.html");
			dispatcher.include(req, resp);
			
		}
		
	
	}
}
