<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="java.io.* "%>
  <%@ page import="java.util.ArrayList" %>
   <%@ page import="java.util.List" %>
   <%@ page import="com.model.User" %>
    <%@ page import="javax.servlet.http.HttpServletRequest" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"   %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <table border="1">
  <thead>
    <tr>
     <th>UserId </th>
     <th>First Name </th>
     <th>Last Name </th>
     <th>DOB </th>
     <th>Address</th>
     <th>Contact No.:</th>
     <th colspan="2" >Action</th>
    </tr>
  </thead>
  <tbody>
       
        <c:forEach items="${users}" var="users" >
        <tr>
                    <td><c:out value="${users.userid}" /></td>
                    <td><c:out value="${users.firstName}" /></td>
                    <td><c:out value="${users.lastName}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd" value="${users.dob}" /></td>
                    <td><c:out value="${users.address}" /></td>
                    <td><c:out value= "${users.contactNo}" /></td>
                    <td><a href="UserController?action=edit&userId=<c:out value="${user.userid}"/>">EDIT</a></td>
                    <!--  <td><a href="UserController?action=delete&userId=<c:out value="${user.userid}"/>">Delete</a></td>
                -->
                </tr>
                </c:forEach>
  </tbody>
 </table>
 <p><a href="UserController?action=insert">Add User</a>
 <a href="home.jsp">Logout</a> 
 
</body>
</html>