<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ page import="com.model.User" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <script>
        $(function() {
             $('input[name=dob]').datepicker();
        });
    </script>

  <%
 String id = (String) session.getAttribute("userid");
 User users = new User(); 
 users.setUserid(id);
   
 %>
    <form method="POST" action='UserController' name="frmAddUser">
        User ID : <input type="text" readonly="readonly" name="userid"
            value=<%= id %> />  <br />
        
        First Name : 
        <input type="text" name="firstName" value="<c:out value="${user.firstName}" />" /> <br />
        
        Last Name : 
        <input type="text" name="lastName" value="<c:out value="${user.lastName}" />" /> <br />
        
        DOB : 
        <input type="text" name="dob" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${user.dob}" />" /> <br />
        
        Address: 
        <input type="text" name="address" value="<c:out value="${user.address}" />" /> <br /> 
        
        Contact No.:
        <input type="text" name="contactno" value="<c:out value="${user.contactNo}"/>" /> <br />
        <input type="submit" value="Submit" />
    </form>
</body>
</html>