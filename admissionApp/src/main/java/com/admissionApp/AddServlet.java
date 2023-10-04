package com.admissionApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig
public class AddServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	            throws ServletException, IOException {
		HttpSession sess=req.getSession(false);
		
		String emai=(String)sess.getAttribute("emails");
	
		PrintWriter out=res.getWriter();
		out.println("Email sent "+emai+ "   Successfull");
	}
	
}
