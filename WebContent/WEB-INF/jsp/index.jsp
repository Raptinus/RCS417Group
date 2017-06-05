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
	<!--  need to implement a test for session cookie of logged-in user -->
	<p />
	
	${errmsg}
	
	<p />
	
	<%
		List<Post> posts = (List<Post>) request.getAttribute("postList");
	
	  	if(posts != null) {
			for (Post post: posts) {
	%>
	
		<%= post.getTitle()%> | created by <%= post.getCreatorId()%>  <br />
		<%= post.getShortDesc()%> <br />
		<!--  need to implement a method of posting info -->
		<form id="<%=post.getPostId() %>" action="viewpost" method="post">
			<input type='submit' value="View">
		</form>
	
		
		
		<p />
		
	
	<%
			}
	  	}
	%>
	
</body>
</html>