<%@ page import="edu.edgewood.model.*"%>

<div>Y-Enterprises Review Site</div>
<hr/>
<div>
<a href="<%=request.getContextPath()%>">Home</a>
	
	<%
		User loginUser = (User)session.getAttribute("loginUser");
		if(loginUser == null){
	%>
		| <a href = "login">Login</a>
	<% } else { %>
	
		<%= loginUser.getUserId() %> | <a href = "newpost.jsp">New Post</a> | <a href = "logout">Logout</a>
	<% 
	
	}
	%>
	
	<hr/>
	

		
</div>