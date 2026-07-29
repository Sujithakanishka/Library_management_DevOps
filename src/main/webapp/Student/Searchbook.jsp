<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.library.model.Book"%>

<%
Book book = (Book)request.getAttribute("book");
String message = (String)request.getAttribute("message");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>🔎 Search Book</title>

<link rel="stylesheet"
href="${pageContext.request.contextPath}/css/style.css">

<style>

.result-container{
    width:900px;
    margin:30px auto;
}

.book-table{
    width:100%;
    border-collapse:collapse;
}

.book-table th{
    background:#2563eb;
    color:white;
    padding:12px;
}

.book-table td{
    border:1px solid #ddd;
    padding:12px;
    text-align:center;
}

.book-table tr:nth-child(even){
    background:#f5f5f5;
}

.table-back{
    margin-top:20px;
    text-align:right;
}

.result-title{
    text-align:center;
    margin-bottom:20px;
}

.error{
    color:red;
    text-align:center;
    margin-top:20px;
    font-weight:bold;
}

</style>

</head>

<body class="Body">

<!-- SEARCH FORM -->

<div class="container">

<h1>Search Book</h1>

<form action="${pageContext.request.contextPath}/Searchbook"
method="post">

<input type="hidden" name="action" value="search">

<label><b>Book Name</b></label>

<input
type="text"
name="bookname"
placeholder="Enter Book Name"
required>

<br><br>

<button type="submit">Search</button>

<br><br>

<% if(book==null){ %>

 <a href="${pageContext.request.contextPath}/Student/Dashboard.html">
<button type="button">Back</button>
</a>

<% } %>

</form>

<% if(message!=null){ %>

<p class="error"><%=message%></p>

<% } %>

</div>

<!-- SEARCH RESULT -->

<% if(book!=null){ %>

<div class="result-container">

<h2 class="result-title">Search Result</h2>

<table class="book-table">

<tr>

<th>Book ID</th>
<th>Book Name</th>
<th>Author</th>
<th>Category</th>
<th>Quantity</th>
<th>Status</th>

</tr>

<tr>

<td><%=book.getBookid()%></td>
<td><%=book.getBookname()%></td>
<td><%=book.getAuthor()%></td>
<td><%=book.getCategory()%></td>
<td><%=book.getQuantity()%></td>
<td><%=book.getBookstatus()%></td>

</tr>

</table>

<div class="table-back">

 <a href="${pageContext.request.contextPath}/Student/Dashboard.html">
                <button type="button">Back</button>
            </a>

</div>

</div>

<% } %>

</body>
</html>
