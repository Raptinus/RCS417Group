<%@ page import="edu.edgewood.model.*"%>

<div class="heading">Y-Enterprises Review Site</div>
<hr/>
<div class="nav">
<a href="<%=request.getContextPath()%>">Home</a>
	
	<%
		User loginUser = (User)session.getAttribute("loginUser");
		if(loginUser == null){
	%>
		| <a href = "login">Login</a>
	<% } else { %>
	
		 | <a href = "newpost">New Post</a> | <a href = "logout">Logout</a> | Logged in as <%= loginUser.getUserId() %>
	<% 
	
	}
	%>
	
	<hr/>
	

		
</div>