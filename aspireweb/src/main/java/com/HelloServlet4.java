 package com;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet4
 */
@WebServlet("/Servlet4")
public class HelloServlet4 extends HttpServlet {
	synchronized protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	synchronized protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello servlet4 doGet called...");
		
		//to print the output not in the console but on browser, we use response
		
		//As browser are light weight objects, they need to be told that we are sending text,file,image,etc
		response.setContentType("text/html");//setting MIME type 
		//we are telling here to browser that we are sending text which is html
		
		ServletOutputStream out=response.getOutputStream();
		String n=request.getParameter("name");
		out.println("<h1>"+n+"</h1>");
		String pass=request.getParameter("pass");
		out.println("<h1>"+pass+"</h1>");
		Enumeration e=request.getParameterNames();
		while(e.hasMoreElements()) {
			String name=(String)e.nextElement();
			String value=request.getParameter(name);
			out.println("<h1 style=color:red>"+name+":"+value+"</h1>");
		}
		
		//ServletContext
		ServletContext application=request.getServletContext();
		String value=(String) application.getAttribute("globalkey");
		System.out.println(value);
}
}
