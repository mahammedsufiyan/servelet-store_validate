package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dto.UserDetails;
import com.ty.services.UserDetailsServices;

@WebServlet(value = "/userdetails")
public class UserDetailsController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userName = req.getParameter("name");
		String weblink = req.getParameter("weblink");
		String description = req.getParameter("description");

		UserDetails details = new UserDetails();
		details.setUserName(userName);
		details.setWeblink(weblink);

		details.setDescription(description);

		UserDetailsServices detailsServices = new UserDetailsServices();
		UserDetails savedDetails = detailsServices.saveUserDetails(details);

		PrintWriter printWriter = resp.getWriter();
		if (savedDetails != null) {

			String html = "<html><body><h1>Thank you for Adding details</h1></body></html>";
			printWriter.write(html);
		} else {
			String html = "<html><body><h1>Details are not added</h1></body></html>";
			printWriter.write(html);
			RequestDispatcher dispatcher = req.getRequestDispatcher("userDetails.html");
			dispatcher.include(req, resp);
		}

	}
}
