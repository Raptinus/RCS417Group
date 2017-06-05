<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ page import = "java.util.List" %>
<%@ page import = "edu.edgewood.model.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<link rel="stylesheet" type="text/css" href="style.css">
	 	<%@ include file="include/header.jsp" %> 
	</head>
<body>

	<%@ include file="include/menu.jsp" %>
	
	<p />
	
	${errmsg}
	
	<p />
	
	<%
		List<Post> posts = (List<Post>) request.getAttribute("postList");
	
		for (Post post: posts) {
	%>
	
		${post.title} | created by ${post.creatorId} <br>
		${post.shortDesc} <br>
		
	
	<%
		}
	%>
	
</body>
</html>