package com;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/SessionDemo")
public class SessionDemo extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//for every browser a seperate session object is created..
		//the browser can make n number of connections, same session object is used
		//if the person closes the browser, then the session will be lost
		//new opening of a browser will create another session object
		HttpSession session=request.getSession(true);
		
		//If a session is not there, it creates a new session object
		//if a session is already created then it returns the old session
		
		//HttpSession session=request.getSession(false); - if the session is there it will give
		//or else it won't create a new session
		
		System.out.println(session);
		System.out.println(session.getId());
		//the sessionId get stored in the browser in the form of cookies
		//if we block the cookies for the particular URL, then every time it gives new sessionId 
		
		//ServletContext
		ServletContext application=request.getServletContext();
		application.setAttribute("globalkey", "globalvalue shared by servlets");
	}
}