<%-- 
    Document   : Login
    Created on : Sep 21, 2023, 6:10:57 PM
    Author     : duchi
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><<a href="Home">Home</a></h1>
        <h2>Thông tin người dùng</h2>
        <p>Username: ${username}</p>
        <p>Name: ${name}</p>
        <p>Email: ${email}</p>
        <p>Phone: ${phone}</p>
        <p>Password: ${password}</p>
        <p>Confirm: ${confirm}</p>
        <p>Gender: ${gender ? 'Male' : 'Female'}</p>
        <p>Message: ${MESSAGE}</p>
        
    </body>

</html>
