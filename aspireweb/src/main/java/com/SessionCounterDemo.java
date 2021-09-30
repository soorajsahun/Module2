package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionCounterDemo
 */
@WebServlet("/SessionCounterDemo")
//Means how many times you have visited that URL
public class SessionCounterDemo extends HttpServlet {
	int counterr=0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		ServletOutputStream out=response.getOutputStream();
		HttpSession session=request.getSession();
		Object o=session.getAttribute("counter");
		if (o==null) {//or if(session.isNew())
			out.println("<h1>First time Welcome to Counter Demo...Attempts:"+counterr);
			counterr++;
			session.setAttribute("counterr", counterr);
		} else {
			String c=o.toString();
			int n=Integer.parseInt(c);
			out.println("<h1>Welcome to counter Demo again...Attempts:"+n);
			n++;
			session.setAttribute("counterr", n);
		}
	}

}
