<%-- 
    Document   : footer
    Created on : Sep 20, 2023, 1:35:06 PM
    Author     : BlackZ36
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="row">

                <div class="col-lg-5 me-auto col-12">
                    <h5 class="mb-lg-4 mb-3">Opening Hours</h5>

                    <ul class="list-group list-group-flush">
                        <li class="list-group-item d-flex">
                            Sunday : Closed
                        </li>

                        <li class="list-group-item d-flex">
                            Monday, Tuesday - Firday
                            <span>8:00 AM - 3:30 PM</span>
                        </li>

                        <li class="list-group-item d-flex">
                            Saturday
                            <span>10:30 AM - 5:30 PM</span>
                        </li>
                    </ul>
                </div>

                <div class="col-lg-2 col-md-6 col-12 my-4 my-lg-0">
                    <h5 class="mb-lg-4 mb-3">Our Clinic</h5>

                    <p><a href="mailto:hello@company.co">hello@company.co</a><p>

                    <p>123 Digital Art Street, San Diego, CA 92123</p>
                </div>

                <div class="col-lg-3 col-md-6 col-12 ms-auto">
                    <h5 class="mb-lg-4 mb-3">Socials</h5>

                    <ul class="social-icon">
                        <li><a href="#" class="social-icon-link bi-facebook"></a></li>

                        <li><a href="#" class="social-icon-link bi-twitter"></a></li>

                        <li><a href="#" class="social-icon-link bi-instagram"></a></li>

                        <li><a href="#" class="social-icon-link bi-youtube"></a></li>
                    </ul>
                </div>

                <div class="col-lg-3 col-12 ms-auto mt-4 mt-lg-0">
                    <p class="copyright-text">Copyright Â© Medic Care 2021 
                        <br><br>Design: <a href="https://templatemo.com" target="_parent">TemplateMo</a></p>
                </div>

            </div>
    </body>
</html>
