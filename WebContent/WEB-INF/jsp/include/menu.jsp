<%@ page import="edu.edgewood.site.*"%>

<div>Y-Enterprises Review Site</div>
<hr/>
<div>
<a href="<%=request.getContextPath()%>">Home</a>
	
	<%
		User loginUser = (User)session.getAttribute("loginUser");
		if(loginUser == null){
	%>
		| <a href = "login">Login</a>
		| <a href = "view">View Posts</a>
	<% } else { %>
	
		| <a href = "logout"> Logout</a>
		| <a href = "edit">Edit Posts</a>
	<%
		if (loginUser.isAdmin()){
	
	%>
		| <a href = "userlist">User Listing</a>
		| <a href = "adduser">Add User</a>
		
	<% 
		}
	}
	%>
	

		
</div>