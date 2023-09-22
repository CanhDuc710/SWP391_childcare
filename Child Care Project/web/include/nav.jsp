<%-- 
    Document   : nav
    Created on : Sep 11, 2023, 2:24:14 PM
    Author     : BlackZ36
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <meta name="description" content="">
        <meta name="author" content="">


        <!-- CSS FILES -->        
        <link rel="preconnect" href="https://fonts.googleapis.com">

        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;600;700&display=swap" rel="stylesheet">

        <link href="css/bootstrap.min.css" rel="stylesheet">

        <link href="css/bootstrap-icons.css" rel="stylesheet">

        <link href="css/owl.carousel.min.css" rel="stylesheet">

        <link href="css/owl.theme.default.min.css" rel="stylesheet">

        <link href="css/templatemo-medic-care.css" rel="stylesheet">

    </head>
    <body>
        <nav class="navbar navbar-expand-lg bg-light fixed-top shadow-lg">
            <div class="container">
                <a class="navbar-brand mx-auto d-lg-none" href="Home">
                    Medic Care
                    <strong class="d-block">Health Specialist</strong>
                </a>

                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav mx-auto">
                        
                        <a class="navbar-brand d-none d-lg-block" href="Home">
                            Medic Care
                            <strong class="d-block">Children's Health</strong>
                        </a>

                        <li class="nav-item">
                            <a class="nav-link" href="Blog">Blog</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="Service">Services</a>
                        </li> 

                        <li class="nav-item">
                            <a class="nav-link" href="Feedback">Feedback</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="Reservation">Reservation</a>
                        </li>

                        <c:choose>
                            <c:when test="${empty Account}">
                                <a class="nav-link" href="Login">Login</a>
                            </c:when>
                            <c:otherwise>
                                <a class="nav-link" href="Account">Account</a>
                            </c:otherwise>
                        </c:choose>

                    </ul>
                </div>

            </div>
        </nav>
    </body>
</html>
