<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.library.model.Borrow" %>

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

            <%
                List<Borrow> borrowList = (List<Borrow>) request.getAttribute("borrow");

                if (borrowList != null && !borrowList.isEmpty()) {

                    for (Borrow borrow : borrowList) {
            %>

                <tr>
                    <td><%= borrow.getBorrowid() %></td>
                    <td><%= borrow.getStudentid() %></td>
                    <td><%= borrow.getBookid() %></td>
                    <td><%= borrow.getBorrowdate() %></td>
                    <td><%= borrow.getReturndate() %></td>
                    <td><%= borrow.getBookstatus() %></td>
                </tr>

            <%
                    }

                } else {
            %>

                <tr>
                    <td colspan="6">No Borrow History Available</td>
                </tr>

            <%
                }
            %>

            </tbody>

        </table>
        <a href="${pageContext.request.contextPath}/Librarian/dashboard.html">
            <button class="back-btn">Back</button>
        </a>

    </div>

</body>
</html>