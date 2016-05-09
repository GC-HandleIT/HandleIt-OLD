package com.handleit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletDev")
public class ServletDev extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DevObj devToAddtoDB = new DevObj();

    public ServletDev() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		devToAddtoDB.setId(request.getParameter("form-id"));
		devToAddtoDB.setFirstName(request.getParameter("form-first_name"));
		devToAddtoDB.setLastName(request.getParameter("form-last_name"));
		devToAddtoDB.setEmailAddress(request.getParameter("form-email_address"));
		devToAddtoDB.setLocation(request.getParameter("form-location"));
		devToAddtoDB.setPicUrl(request.getParameter("form-picture_url"));
		devToAddtoDB.setProfileUrl(request.getParameter("form-profile_url"));
		devToAddtoDB.setSkills(request.getParameter("form-skills"));
		
		
		
		doGet(request, response);
	}

}
