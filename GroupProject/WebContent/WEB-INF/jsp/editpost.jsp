<html>
	<head>
		<%@ include file = "include/header.jsp" %>
	</head>	
	<body>
		<%@ include file = "include/menu.jsp" %>
			
		<textarea rows="10" cols="200" readonly>
		
		<!-- Insert code linking to database to display text from previously selected file -->
		
		</textarea>
		
		<!-- Not quite sure how we want to do this; do we want to have this page where they can edit it? 
			
			Probably need to have an IF statement that checks if the user is the user who posted, to enable the delete button, else it creates a popup saying they don't have access to delete
			this post. 
			
			
		 -->
		
		<button name = "Edit" type = "submit" value = "Edit">Edit Post</button>
		<button name = "Cancel"	type = "submit" value = "Cancel">Cancel Edit</button>
		<button name = "Delete"	type = "submit" value = "Delete">Delete Post</button>		
			
			
	</body>
</html>
		