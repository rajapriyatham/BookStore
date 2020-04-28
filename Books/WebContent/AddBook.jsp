<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="AddServlet" method="get">
		<div class="container">
			<h1>Add Book Details</h1>
			<hr>
			<div class="form-group">
				<label for="book_id"><b>Id</b></label> 
				<input type="text" class="form-control" name="book_id"  required>
			</div>
			<div class="form-group">
				<label for="title"><b>Title</b></label> 
				<input type="text" class="form-control" name="title"  required>
			</div>
			<div class="form-group">
				<label for="author"><b>Author</b></label> 
				<input type="text" class="form-control" name="author"  required>
			</div>
			<div class="form-group">
				<label for="price"><b>Price</b></label>
				<input type="text" class="form-control" name="price" required>
			</div>
			<hr>
			<button type="submit" class="btn btn-primary">Save</button>
		</div>
	</form>
</body>
</html>