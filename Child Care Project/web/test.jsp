<%-- 
    Document   : register
    Created on : 21 Sept 2023, 13:23:56
    Author     : GL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
// Lấy giá trị tham số doctor từ URL
String doctor = request.getParameter("doctor");
%>

<!DOCTYPE html>

<html>
    <head>
        <title>Registration Page</title>
    </head>
    <body>



        ${doctor}
        id: ${id} <br/>
        email_current: ${email} <br/>
        phone_current: ${phone} <br/>
        ---------------- <br/>
        email: ${email1} <br/>
        phone1: ${phone1} <br/>
        name1: ${name1} <br/>
        -------------------- <br/>
        tab-param: ${tab}
        -------------------- <br/>
        pass_old: ${password1}
        pass_change: ${password2}
        pass_confirm: ${password3}
    </body>
</html>