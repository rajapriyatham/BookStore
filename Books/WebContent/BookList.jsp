<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	    <title>Books Store Application</title>
	</head>
	<body>
	    <h1>Books Management</h1>
	    <h2>
	            <a href="AddBook.jsp">Add New Book</a>
	            &nbsp;&nbsp;&nbsp;
	            <a href="index1.jsp">List All Books</a>
	             
	    </h2>
	    
	    <div align="center">
	        <table border="1" cellpadding="5">
	            <caption><h2>List of Books</h2></caption>
	            <tr>
	                <th>ID</th>
	                <th>Title</th>
	                <th>Author</th>
	                <th>Price</th>
	                <th>Actions</th>
	            </tr>
	            <c:forEach var="book" items="${listBook}">
	                <tr>
	                    <td>${book.id}</td>
						<td>${book.title}</td>
						<td>${book.author}</td>
						<td>${book.price}</td>
						<td>
	                        <a href="EditServlet?bookId=${book.id}">Edit</a>
	                        &nbsp;&nbsp;&nbsp;&nbsp;
	                        <a href="DeleteServlet?booksId=${book.id}">Delete</a>                     
	                    </td>
	                </tr>
	            </c:forEach>
	        </table>
	    </div>   
	</body>
</html>