<%@ page language="java" %>
<%@ page import="com.library.model.Book" %>

<%
Book book = (Book) request.getAttribute("book");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>✏️ Edit book</title>
   <link rel="stylesheet"
      href="${pageContext.request.contextPath}/css/style.css">
</head>

<body class="Body">

<div class="container">

    <header>
        <h1>Edit the Book</h1>
    </header>

    <main>

        <!-- Search Form -->
        <form action="${pageContext.request.contextPath}/editbook" method="post" class="editbook">

            <input type="hidden" name="action" value="search">

            <div>
                <label for="bookid">Book ID</label>

                <input
                    type="number"
                    id="bookid"
                    name="bookid"
                    placeholder="Enter Book ID"
                    required>
            </div>

            <button type="submit">Search</button>

            <% if(book == null){ %>

            <a href="${pageContext.request.contextPath}/Librarian/dashboard.html">
                <button type="button">Back</button>
            </a>

            <% } %>

        </form>

        <br>

        <!-- Update Form -->

        <% if(book != null){ %>

        <form action="${pageContext.request.contextPath}/editbook" method="post" class="updatebook">

            <input type="hidden" name="action" value="update">

            <input
                type="hidden"
                name="bookid"
                value="<%=book.getBookid()%>">

            <div>

                <label>Book Name</label>

                <input
                    type="text"
                    name="bookname"
                    value="<%=book.getBookname()%>"
                    required>

            </div>

            <div>

                <label>Author</label>

                <input
                    type="text"
                    name="author"
                    value="<%=book.getAuthor()%>"
                    required>

            </div>

            <div>

                <label>Category</label>

                <input
                    type="text"
                    name="category"
                    value="<%=book.getCategory()%>"
                    required>

            </div>

            <div>

                <label>Quantity</label>

                <input
                    type="number"
                    name="quantity"
                    value="<%=book.getQuantity()%>"
                    required>

            </div>

            <% if(book != null){ %>

            <button type="submit" name="action" value="update">
                Update
            </button>

            <button type="reset">
                Reset
            </button>
            
            <a href="${pageContext.request.contextPath}/Librarian/dashboard.html">
                <button type="button">Back</button>
            </a>

            <% } %>

        </form>

        <% } %>

    </main>

</div>

</body>
</html>