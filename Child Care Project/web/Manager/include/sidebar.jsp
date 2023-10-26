<%-- 
    Document   : sidebar
    Created on : Oct 19, 2023, 2:12:33 AM
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
        <aside id="sidebar" class="sidebar">

            <ul class="sidebar-nav" id="sidebar-nav">





                <li class="nav-heading">Management</li>

                <li class="nav-item">
                    <a class="nav-link collapsed" href="Dashboard">
                        <i class="bi bi-bar-chart-line"></i>
                        <span>Dashboard</span>
                    </a>
                </li>
                
                <li class="nav-item">
                    <a class="nav-link collapsed" href="Patient">
                        <i class="bi bi-person"></i>
                        <span>Patient</span>
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link collapsed" href="Staff">
                        <i class="bi bi-person"></i>
                        <span>Staff</span>
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link collapsed" href="">
                        <i class="bi bi-card-list"></i>
                        <span>Service</span>
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link collapsed" href="">
                        <i class="bi bi-card-list"></i>
                        <span>Post</span>
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link collapsed" href="">
                        <i class="bi bi-card-list"></i>
                        <span>Reservation</span>
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link collapsed" href="">
                        <i class="bi bi-star-fill"></i>
                        <span>Feedback</span>
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link collapsed" href="pages-blank.jsp">
                        <i class="bi bi-file-earmark"></i>
                        <span>Blank</span>
                    </a>
                </li><!-- End Blank Page Nav -->

            </ul>

        </aside><!-- End Sidebar-->
    </body>
</html>
