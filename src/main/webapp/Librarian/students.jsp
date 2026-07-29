<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.library.model.Student" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>📖 View Students</title>

<link rel="stylesheet"
      href="${pageContext.request.contextPath}/css/style.css">

</head>

<body class="view">

<div class="table-container">

    <h1>Students List</h1>

    <table>

        <thead>
            <tr>
                <th>Student ID</th>
                <th>Student Name</th>
                <th>Email</th>
            </tr>
        </thead>

        <tbody>

        <%
            List<Student> students = (List<Student>) request.getAttribute("students");

            if(students != null && !students.isEmpty())
            {
                for(Student student : students)
                {
        %>

        <tr>

           <td><%= student.getStudentid() %></td>

            <td><%= student.getUsername() %></td>

            <td><%= student.getEmail() %></td>

           <td>
        </td>

        </tr>

        <%
                }
            }
            else
            {
        %>

        <tr>

            <td colspan="3">No Students Available</td>

        </tr>

        <%
            }
        %>

        </tbody>

    </table>

    <br>

   <a href="${pageContext.request.contextPath}/Librarian/dashboard.html">

        <button class="back-btn">Back</button>

    </a>

</div>
</body>

</html>
