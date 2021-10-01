
<%
	String uname=request.getParameter("uname");
	if(uname.equals("ramu")){
		%>
		<jsp:forward page="welcome.jsp"/>
		<%
	}
	else{
		%>
		<jsp:forward page="register.jsp"/>
		<%
	}
%>
