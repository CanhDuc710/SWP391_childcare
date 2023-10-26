<%-- 
    Document   : header_include
    Created on : Oct 5, 2023, 2:06:11 PM
    Author     : BlackZ36
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                        <li><a class="nav-link scrollto " href="Home">Home</a></li>
                        <!--drop about-->
                        <li><a class="nav-link scrollto" href="Services?show=0">Services</a></li>
                        <li><a class="nav-link scrollto" href="ReservationDetail">Reservation</a></li>

                        <li class="dropdown"><a href="#"><span>More</span> <i class="bi bi-chevron-down"></i></a>
                            <ul>
                                <li><a href="#testimonials">Posts</a></li>
                                <li><a href=Doctors">Doctors</a></li>
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
                                <li class="dropdown"><a href="Account"><span>Account</span> <i class="bi bi-chevron-down"></i></a>
                                    <ul>
                                        <li><a href="Account">My Profile</a></li>
                                        <li><a href="MyChildren">My Children's Information</a></li>
                                        <li class="dropdown"><a href="#"><span>My Reservations</span> <i class="bi bi-chevron-right"></i></a>
                                            <ul>
                                                <li><a href="MyReservation">All</a></li>
                                                <li><a href="MyReservation?statusId=1" style="color: darkgoldenrod">Pending</a></li>
                                                <li><a href="MyReservation?statusId=2" style="color: green">Finished</a></li>
                                                <li><a href="MyReservation?statusId=3" style="color: red">Cancelled</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="ChangePassword">Change Password</a></li>
                                        <li><a href="Logout" style="color: red;">Logout</a></li>
                                    </ul>
                                </li>
                            </c:when> 
                        </c:choose>

                        <!--drop contact-->


                    </ul>
                    <i class="bi bi-list mobile-nav-toggle"></i>
                </nav><!-- .navbar -->

                <a href="ReservationContact" class="appointment-btn scrollto"><span class="d-none d-md-inline">Make an</span> Appointment</a>

            </div>
        </header>
    </body>
</html>
