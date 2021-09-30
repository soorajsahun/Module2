package com;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet2
 */
@WebServlet(
		name = "myservlet",
		urlPatterns = {"/hello","*.do","/blabla"},
//		loadOnStartup = 1,//this create the servlet instance even before the request
		initParams = {
				@WebInitParam (name="batchname", value="aspire batch"),
				@WebInitParam(name="goldenurl", value="https://goldentouch.haarisinfotech.com"),
		}
		
		)
public class HelloServlet2 extends HttpServlet {
	public HelloServlet2() {
		System.out.println("Hello servlet2 contrutor called...");
	}
	@Override
	public void init() throws ServletException {
		System.out.println(" init without config called...");
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		//here config object is automatically gets created. It is like 
		//as soon as we join office we get telephone,computer etc services
		System.out.println(" init config called...");
		String batchname=config.getInitParameter("batchname");
		System.out.println("Batch name..:"+batchname);
		System.out.println(config.getInitParameter("goldenurl"));
		
		//if we want to read all the parameters at the same time
		Enumeration e=config.getInitParameterNames();
		while(e.hasMoreElements()) {
			String name=(String)e.nextElement();
			String value=config.getInitParameter(name);
			System.out.println(name+":"+value);
		}
	}
	synchronized protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello servlet2 doGet called...");
		
		//to read request parameter from URL-http://localhost:8080/aspireweb/hello?name=Suraj&pass=123
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
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	@Override
	public void destroy() {
		System.out.println("destroy called.....");
	}
	
}
