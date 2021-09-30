package com;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
//@- is annotation ,it is a meta data which makes server to understand that 
//in bracket is a servlet class
@WebServlet("/HelloServlet")//HelloServlet-URL- -by this name, servlet is identified
public class HelloServlet extends HttpServlet {
	public HelloServlet() {
		System.out.println("Hello servlet contrutor called...");
	}
	@Override
	public void init() throws ServletException {
		System.out.println(" init without config called...");
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println(" init config called...");
	}
	//prdefined method-doGet
	//prdefined class-HttpServletRequest,HttpServletResponse
	//synchronized-as servlet is multithreaded
	synchronized protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello servlet doGet called...");
	}
	@Override
	public void destroy() {
		System.out.println("destroy called...");
	}

}
