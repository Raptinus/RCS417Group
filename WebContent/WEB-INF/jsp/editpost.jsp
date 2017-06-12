<html>
	<head>
		<%@ include file = "include/header.jsp" %>
	</head>	
	<body>
		<%@ include file = "include/menu.jsp" %>
			
		<% Post post = (Post) request.getAttribute("post"); %>
			
		<form id = "editpost" action = "editpost" method="post">
		
		<input type="hidden" name="id" value="<%=post.getPostId()%>">
		<input type="hidden" name="creatorid" value="<%=post.getCreatorId()%>">
		<input type="hidden" name="datecreated" value="<%=post.getDateCreated()%>">
		<p />
		
		
		
		Title:<br />
		<input type="text" name="title" value="<%=post.getTitle()%>" pattern = "[a-zA-Z0-9]+" required>
		
		<p />
		Short Description:<br />
		<input type="text" name="shortdesc" value="<%=post.getShortDesc()%>" pattern = "[a-zA-Z0-9]+" required>		
		<p />
		
		Detailed Description:<br />
		<textarea rows="10" cols="45" name="longdesc" required>${post.longDesc}</textarea>
		<p />
		<input type="submit" value="Submit">

		</form>		
			
			
	</body>
</html>
		