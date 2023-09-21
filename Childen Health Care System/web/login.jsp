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
        <form action="Login" method="POST">
            <table>
            <tr>
                <td><b>Username</b></td>
                <td><input type="text" name="username" id="username"></td>
            </tr>
            <tr>
                <td><b>Password</b></td>
                <td><input type="password" name="password" id="password"></td>
            </tr>
            <c:if test="${param.error eq true}">
                <tr>
                    <td colspan="2" style="text-align: center; color: red">Either username or password is wrong
                </tr>
            </c:if>
            <tr>
                <td colspan="2" style="text-align: center" ><input type="submit" value="Login"></td>
            </tr>
            </table>
        </form>
    </body>
</html>
