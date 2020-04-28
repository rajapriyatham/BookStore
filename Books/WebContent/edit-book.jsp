<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" >
<title>Edit Book Page</title>
</head>
<body>
	<form action="UpdateServlet" method="get">
		<div class="container">
			<h1>Edit Book Details</h1>
			<hr>
			<div class="form-group">
				<label for="book_id"><b>Id</b></label> 
				<input type="text" class="form-control" name="book_id"  value="${book.id}" required>
			</div>
			<div class="form-group">
				<label for="title"><b>Title</b></label> 
				<input type="text" class="form-control" name="title" value="${book.title}" required>
			</div>
			<div class="form-group">
				<label for="author"><b>Author</b></label> 
				<input type="text" class="form-control" name="author" value="${book.author}" required>
			</div>
			<div class="form-group">
				<label for="price"><b>Price</b></label>
				<input type="text" class="form-control" name="price" value="${book.price}" required>
			</div>
			<hr>
			<button type="submit" class="btn btn-primary">Update</button>
		</div>
	</form>

</body>
</html>