

<%
	String uname=request.getParameter("uname");
	if(uname.equals("ramu")){
		//response.sendRedirect("welcome.jsp");
		RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
		rd.forward(request, response);
	}
	else{
		//response.sendRedirect("register.jsp");
		RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
		rd.forward(request, response);
	}
%>
