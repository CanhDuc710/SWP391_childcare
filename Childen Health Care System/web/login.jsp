<%-- 
    Document   : login
    Created on : Aug 12, 2023, 8:55:32 PM
    Author     : GL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <!--nav bar section begin-->
        <jsp:include page="include/nav.jsp" />
        <!--nav bar section end-->
        
        <jsp:include page="include/LoginAndRegister.jsp" />
    </body>
</html>
