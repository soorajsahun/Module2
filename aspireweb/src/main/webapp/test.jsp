<%@page import="java.util.Date"%> <!--Directive Tag-->
<h1>Hello World</h1>

<!--Scriplets Tag-->
<%
Date d=new Date();
System.out.println(d);

String uname=request.getParameter("uname");
String upass=request.getParameter("upass");
out.println("<h1>"+uname+":"+upass+"</h1>");

session.setAttribute("upass", upass);

printstr();
%>

<!--Expression Tag-->
<%=application.getRealPath("")  %>
<h1>
<%=session.getAttribute("upass") %>
</h1>

<!--Declaration Tag-->
<%!
//you can not use any implicit object here, because it is outside the jspService method
String str="Hello boys";	
public void printstr(){
	System.out.println("Str...."+str);
}
%>
