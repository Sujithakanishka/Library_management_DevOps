<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.library.model.Book"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>📖 View Books</title>

<link rel="stylesheet"
href="${pageContext.request.contextPath}/css/style.css">

</head>

<body class="view">

<div class="table-container">

<h1>Library Books</h1>

<table>

<thead>

<tr>

<th>Book ID</th>
<th>Book Name</th>
<th>Author</th>
<th>Category</th>
<th>Quantity</th>
<th>Status</th>
<th>Action</th>

</tr>

</thead>

<tbody>

<%

List<Book> books=(List<Book>)request.getAttribute("books");

if(books!=null && !books.isEmpty())
{

for(Book book:books)
{

%>

<tr>

<td><%=book.getBookid()%></td>

<td><%=book.getBookname()%></td>

<td><%=book.getAuthor()%></td>

<td><%=book.getCategory()%></td>

<td><%=book.getQuantity()%></td>

<td>

<%=book.getBookstatus()%>

</td>

<td>

<form action="${pageContext.request.contextPath}/changebookstatus"
method="post">

<input type="hidden"
name="bookid"
value="<%=book.getBookid()%>">

<button type="submit">

Change Status

</button>

</form>

</td>

</tr>

<%

}

}

else

{

%>

<tr>

<td colspan="7">

No Books Available

</td>

</tr>

<%

}

%>

</tbody>

</table>

<br>

<a href="${pageContext.request.contextPath}/Librarian/dashboard.html">

<button class="back-btn">

Back

</button>

</a>

</div>

</body>

</html>
