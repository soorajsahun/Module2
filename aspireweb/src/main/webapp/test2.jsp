<!--Page Directive tag -->
<!-- page is the name of the tag -->
<!-- UTF-8 supports many languages -->
<%@ page 
	 language="java" 
	 contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"
     
     autoFlush="false"
     buffer="12kb"
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
नमस्ते,hello,ਸਤ ਸ੍ਰੀ ਅਕਾਲ,
<%
for(int i=0;i<1000;i++){
	out.println("नमस्ते...");
}
%>
</body>
</html>