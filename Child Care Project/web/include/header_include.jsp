<%-- 
    Document   : header_include
    Created on : Oct 5, 2023, 2:06:11 PM
    Author     : BlackZ36
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Favicons -->
        <link href="../assets/img/favicon.png" rel="icon">
        <link href="../assets/img/apple-touch-icon.png" rel="apple-touch-icon">

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Roboto:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

        <!-- Vendor CSS Files -->
        <link href="assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
        <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
        <link href="assets/vendor/aos/aos.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
        <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

        <!-- Template Main CSS File -->
        <link href="assets/css/style.css" rel="stylesheet">
    </head>
    <body>
        <header id="header" class="fixed-top">
            <div class="container d-flex align-items-center">

                <a href="Home" class="logo me-auto"><img src="assets/img/logo.png" alt=""></a>
                <!-- Uncomment below if you prefer to use an image logo -->
                <!-- <h1 class="logo me-auto"><a href="index.html">Medicio</a></h1> -->

                <nav id="navbar" class="navbar order-last order-lg-0">
                    <ul>
                        <li><a class="nav-link scrollto " href="#hero">Home</a></li>
                        <!--drop about-->
                        <li><a class="nav-link scrollto" href="#services">Services</a></li>
                        <li><a class="nav-link scrollto" href="#departments">Reservation</a></li>

                        <li class="dropdown"><a href="#"><span>More</span> <i class="bi bi-chevron-down"></i></a>
                            <ul>
                                <li><a href="#slider">Post</a></li>
                                <li><a href="#doctors">Doctor</a></li>
                                <li><a href="#feedback">Feedback</a></li>
                                <li><a href="#contact">Contact</a></li>
                                <li><a href="Test">Test</a></li>
                            </ul>
                        </li>


                        <c:choose>
                            <c:when test="${ACCOUNT == null}">
                                <li class="dropdown"><a href="Login?type=patient"><span>Login</span> <i class="bi bi-chevron-down"></i></a>
                                    <ul>
                                        <li><a href="Login?type=patient">Login As Patient</a></li>
                                        <li><a href="Login?type=staff">Login As Staff</a></li>
                                    </ul>
                                </li>
                                <li><a class="nav-link scrollto" href="Login?type=patient">Register</a></li>
                                </c:when>
                                <c:when test="${ACCOUNT != null}">
                                <li class="dropdown"><a href="#"><span>Account</span> <i class="bi bi-chevron-down"></i></a>
                                    <ul>
                                        <li><a href="Account">User Profile</a></li>
                                        <!--                                <li class="dropdown"><a href="#"><span>Deep Drop Down</span> <i class="bi bi-chevron-right"></i></a>
                                                                            <ul>
                                                                                <li><a href="#">Deep Drop Down 1</a></li>
                                                                                <li><a href="#">Deep Drop Down 2</a></li>
                                                                                <li><a href="#">Deep Drop Down 3</a></li>
                                                                                <li><a href="#">Deep Drop Down 4</a></li>
                                                                                <li><a href="#">Deep Drop Down 5</a></li>
                                                                            </ul>
                                                                        </li>-->
                                        <li><a href="#">Change Password</a></li>
                                        <li><a href="#">My Reservations</a></li>
                                        <li><a href="Logout" style="color: red;">Logout</a></li>
                                    </ul>
                                </li>
                            </c:when> 
                        </c:choose>

                        <!--drop contact-->


                    </ul>
                    <i class="bi bi-list mobile-nav-toggle"></i>
                </nav><!-- .navbar -->

                <a href="#appointment" class="appointment-btn scrollto"><span class="d-none d-md-inline">Make an</span> Appointment</a>

            </div>
        </header>
    </body>
</html>
