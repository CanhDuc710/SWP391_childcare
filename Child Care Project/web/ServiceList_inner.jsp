<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Services</title>
        <meta content="" name="description">
        <meta content="" name="keywords">

        <!-- Favicons -->
        <link href="assets/img/favicon.png" rel="icon">
        <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Roboto:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">


    </head>

    <body>


        <!-- ======= Header ======= -->
        <!-- ======= Top Bar ======= -->
        <jsp:include page="include/topbar_include.jsp" />

        <!-- ======= Header ======= -->
        <jsp:include page="include/header_include.jsp" />
        <!-- End Header --><!-- End Header -->

        <main id="main">

            <!-- ======= Breadcrumbs Section ======= -->
            <section class="breadcrumbs">
                <div class="container">

                    <div class="d-flex justify-content-between align-items-center">
                        <h2><a href="Login" >Login And Register</a></h2>
                        <ol>
                            <li><a href="Home">Home</a></li>
                            <li>Login</li>
                        </ol>
                    </div>

                </div>
            </section><!-- End Breadcrumbs Section -->

            <section class="inner-page" style="margin-top: 60px;">

                <jsp:include page="include/service_list_include.jsp" />

            </section>

        </main><!-- End #main -->

        <!-- ======= Footer ======= -->
        <jsp:include page="include/footer_include.jsp"/> 
        <!-- End Footer -->
        <!--notibox-->
        <c:if test="${NOTIBOX}">
            <jsp:include page="include/noti-box_include.jsp" />
        </c:if>
        <!--notibox end-->


        <div id="preloader"></div>
        <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

        <!-- Vendor JS Files -->
        <script src="assets/vendor/purecounter/purecounter_vanilla.js"></script>
        <script src="assets/vendor/aos/aos.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
        <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
        <script src="assets/vendor/php-email-form/validate.js"></script>

        <!-- Template Main JS File -->
        <script src="assets/js/main.js"></script>
        <script src="1script/reload.js"></script>

    </body>

</html>