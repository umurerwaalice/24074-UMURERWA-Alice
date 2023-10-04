package com.admissionApp;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.MessagingException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import com.admissionApp.EmailUtil;

/**
 * Servlet Filter implementation class AddFilter
 */
public class AddFilter implements Filter {

   	
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req= (HttpServletRequest) request;
		HttpServletResponse res= (HttpServletResponse) response;
		HttpSession sess=req.getSession(false);
		 String passportFileName = req.getPart("passport").getSubmittedFileName();
	     String passportFileType = passportFileName.substring(passportFileName.lastIndexOf(".") + 1);
	     String certificateFileName = req.getPart("certificate").getSubmittedFileName();
	     String certificateFileType = certificateFileName.substring(certificateFileName.lastIndexOf(".") + 1);
	     
		 if(sess !=null) {
			String emai=(String)sess.getAttribute("emails");
			if(emai !=null && !emai.isEmpty() && passportFileType.equalsIgnoreCase("jpg") || passportFileType.equalsIgnoreCase("png")
						&& certificateFileType.equalsIgnoreCase("pdf")) {
				try {
		            EmailUtil.main(emai);
		        } catch (Exception ex) {
		            Logger.getLogger(AddFilter.class.getName()).log(Level.SEVERE, null, ex);
		        }
				
				
					chain.doFilter(request, response);
					
				}
			else {
				res.sendRedirect("admissionForm.html");
			}
				
			
		}
		 else {
			 res.sendRedirect("admissionForm.html");
		 }
		
	}








	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	

}
