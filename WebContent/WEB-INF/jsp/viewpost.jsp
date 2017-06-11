<html>
	<head>
		<%@ include file = "include/header.jsp" %>
	</head>	
	<body>
		<%@ include file = "include/menu.jsp" %>
		
		${errmsg}
		<p />
		
		
		${post.title} | created by ${post.creatorId} on ${post.dateCreated}
		<p />
		
		${post.shortDesc}
		
		<p />
		
		${post.longDesc}
		
			
	</body>
</html>
		
		
		
