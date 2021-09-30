package com;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet3
 */
@WebServlet(
		name = "myservlet3",
		urlPatterns = {"/servlet3","*.get","/blaablaa"}
		)
public class HelloServlet3 extends HttpServlet {
	synchronized protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	synchronized protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello servlet3 doGet called...");
		
		//to read request parameter from HTML form
		//here we are using doPsot, Bcoz we don't want to show key value pair is URL
		//And same we are doing in HTML also by making method="GET"
		String n=request.getParameter("name");
		System.out.println(n);
		String pass=request.getParameter("pass");
		System.out.println(pass);
		Enumeration e=request.getParameterNames();
		while(e.hasMoreElements()) {
			String name=(String)e.nextElement();
			String value=request.getParameter(name);
			System.out.println(name+":"+value);
		}
	}
}
