<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Child Care Project</title>
        <meta content="" name="description">
        <meta content="" name="keywords">

        <!-- Favicons -->
        <link href="assets/img/favicon.png" rel="icon">
        <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-paginator@1.4.1/css/bootstrap-paginator.min.css" rel="stylesheet">

        <!-- Template Main CSS File -->
        <link href="assets/css/style.css" rel="stylesheet">


    </head>

    <body>

        <!-- ======= Top Bar ======= -->
        <jsp:include page="include/topbar_include.jsp" />

        <!-- ======= Header ======= -->
        <jsp:include page="include/header_include.jsp" />
        <!-- End Header -->

        <!-- ======= Hero Section ======= -->
        <jsp:include page="include/slider_include.jsp" />
        <!-- End Hero -->

        <main id="main">

            <!-- ======= Featured Services Section ======= -->
            <jsp:include page="include/features_include.jsp" />
            <!-- End Featured Services Section -->

            <!-- ======= Cta Section ======= -->
            <section id="cta" class="cta">
                <div class="container" data-aos="zoom-in">

                    <div class="text-center">
                        <h3>In an emergency? Need help now?</h3>
                        <p> Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                        <a class="cta-btn scrollto" href="ReservationContact">Make an Make an Appointment</a>
                    </div>

                </div>
            </section>
            <!-- End Cta Section -->

            <!-- ======= About Us Section ======= -->
            <%--<jsp:include page="include/about-us_include.jsp" />--%>
            <!-- End About Us Section -->

            <!-- ======= Counts Section ======= -->
            <section id="counts" class="counts">
                <div class="container" data-aos="fade-up">

                    <div class="row no-gutters justify-content-center">

                        <div class="col-lg-3 col-md-6 d-md-flex align-items-md-stretch">
                            <div class="count-box">
                                <i class="fas fa-user-md"></i>
                                <span data-purecounter-start="0" data-purecounter-end="${DOCTOR_COUNT}" data-purecounter-duration="1" class="purecounter"></span>

                                <p><strong>Doctors</strong> Is Activating</p>
                                <a href="Doctors">Find out more &raquo;</a>
                            </div>
                        </div>

                        <div class="col-lg-3 col-md-6 d-md-flex align-items-md-stretch">
                            <div class="count-box">
                                <i class="far fa-hospital"></i>
                                <span data-purecounter-start="0" data-purecounter-end="${SERVICE_COUNT}" data-purecounter-duration="1" class="purecounter"></span>
                                <p><strong>Services</strong> Is Activating</p>
                                <a href="Services">Find out more &raquo;</a>
                            </div>
                        </div>



                    </div>

                </div>
            </section><!-- End Counts Section -->


            <!-- ======= Services Section ======= -->
            <jsp:include page="include/service_include.jsp" />
            <!-- End Services Section -->


            <!-- ======= Testimonials Section ======= -->
            <section id="testimonials" class="testimonials">
                <div class="container" data-aos="fade-up">

                    <div class="section-title">
                        <h2>Post</h2>
                    </div>

                    <div class="testimonials-slider swiper" data-aos="fade-up" data-aos-delay="100">
                        <div class="swiper-wrapper">

                            <c:forEach var="post" items="${POST_LIST}" varStatus="loop">
                                <c:if test="${loop.index < 3}">
                                    <div class="swiper-slide-1" style="width: 500px;">
                                        <div class="testimonial-item">
                                            <p>
                                                <i class="bx bxs-quote-alt-left quote-icon-left"></i>
                                                ${post.detail}
                                                <i class="bx bxs-quote-alt-right quote-icon-right"></i>
                                            </p>
                                            <c:forEach var="staff" items="${STAFF_LIST}">
                                                <c:if test="${staff.accountId eq post.authorId}">
                                                    <img src="assets/img/user/${staff.username}/${staff.avatar}" class="testimonial-img" alt="">
                                                </c:if>
                                            </c:forEach>

                                            <h3>${post.title}</h3>
                                            <h4>Author: ${post.authorId}</h4>
                                            <h4>Last Modified: ${post.updateDate}</h4>
                                        </div>
                                    </div>
                                </c:if>
                            </c:forEach>

                        </div>
                        <div class="swiper-pagination"></div>
                    </div>

                </div>
            </section>
            <!--End Testimonials Section--> 

            <!-- ======= Doctors Section ======= -->
            <%--<jsp:include page="include/doctor_include.jsp" />--%>
            <!-- End Doctors Section -->


            <!-- ======= Contact Section ======= -->
            <section id="contact" class="contact">
                <div class="container">

                    <div class="section-title">
                        <h2>Contact</h2>
                        <p>Magnam dolores commodi suscipit. Necessitatibus eius consequatur ex aliquid fuga eum quidem. Sit sint consectetur velit. Quisquam quos quisquam cupiditate. Et nemo qui impedit suscipit alias ea. Quia fugiat sit in iste officiis commodi quidem hic quas.</p>
                    </div>

                </div>

                <div>
                    <iframe style="border:0; width: 100%; height: 350px;" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d10534.409620711!2d105.51702305023339!3d21.013622238224986!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135abc60e7d3f19%3A0x2be9d7d0b5abcbf4!2zVHLGsOG7nW5nIMSQ4bqhaSBI4buNYyBGUFQ!5e0!3m2!1svi!2s!4v1696515428672!5m2!1svi!2s" frameborder="0" allowfullscreen></iframe>
                </div>

                <div class="container">

                    <div class="row mt-5 justify-content-center">

                        <div class="col-lg-6">

                            <div class="row">
                                <div class="col-md-12">
                                    <div class="info-box">
                                        <i class="bx bx-map"></i>
                                        <h3>Our Address</h3>
                                        <p>Hoa Lac Hi-Tech Park, Km29 Thang Long Avenue, Thach Hoa, Thach That, Hanoi</p>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="info-box mt-4">
                                        <i class="bx bx-envelope"></i>
                                        <h3>Email Us</h3>
                                        <p>info@example.com<br>contact@example.com</p>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="info-box mt-4">
                                        <i class="bx bx-phone-call"></i>
                                        <h3>Call Us</h3>
                                        <p>+84 0987654321<br>+84 0123456789</p>
                                    </div>
                                </div>
                            </div>

                        </div>

                    </div>

                </div>
            </section><!-- End Contact Section -->

        </main><!-- End #main -->

        <!-- ======= Footer ======= -->
        <jsp:include page="include/footer_include.jsp" />
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