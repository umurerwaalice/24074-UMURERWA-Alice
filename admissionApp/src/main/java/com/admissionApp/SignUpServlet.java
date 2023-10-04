package com.admissionApp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

public class SignUpServlet extends HttpServlet {
	 public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 String email=request.getParameter("email");
		 String pass=request.getParameter("password");
		 
	            response.sendRedirect("admissionForm.html");
	        
	        
	        
	        
	    }
}
