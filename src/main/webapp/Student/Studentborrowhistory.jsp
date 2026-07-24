<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.library.model.Borrow" %>

<%
List<Borrow> borrow = (List<Borrow>) request.getAttribute("borrow");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>📋 Borrow History</title>
     <link rel="stylesheet"
      href="${pageContext.request.contextPath}/css/style.css">
</head>

<body class="view">

    <div class="table-container">

        <h1>Borrow History</h1>

        <% if(borrow != null && !borrow.isEmpty()){ %>

        <table>

            <thead>
                <tr>
                    <th>Borrow ID</th>
                    <th>Student ID</th>
                    <th>Book ID</th>
                    <th>Borrow Date</th>
                    <th>Return Date</th>
                    <th>Status</th>
                </tr>
            </thead>

            <tbody>

           <% for(Borrow b : borrow){ %>

                <tr>
                   <td><%= b.getBorrowid() %></td>
                    <td><%= b.getStudentid() %></td>
                    <td><%= b.getBookid() %></td>
                    <td><%= b.getBorrowdate() %></td>
                    <td><%= b.getReturndate() %></td>
                    <td><%= b.getBookstatus() %></td>
                </tr>

                <% } } else { %>

                <h3 style="text-align:center; color:red;">
                    No Borrow History Available
                </h3>

                <% } %>

            </tbody>

        </table>

        <a href="${pageContext.request.contextPath}/Student/Dashboard.html">
            <button class="back-btn">Back</button>
        </a>

    </div>

</body>
</html>