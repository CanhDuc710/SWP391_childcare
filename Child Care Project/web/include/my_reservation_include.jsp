<%-- 
    Document   : my_reservation_include
    Created on : Oct 26, 2023, 4:02:24 AM
    Author     : duchi
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">


        <title>career list - Bootdey.com</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <style type="text/css">
            body{
                background:#f5f5f5;
                margin-top:20px;
            }

            /* ===== Career ===== */
            .career-form {
                background-color: #3fbbc0;
                border-radius: 5px;
                padding: 0 16px;
            }

            .career-form .form-control {
                background-color: rgba(255, 255, 255, 0.2);
                border: 0;
                padding: 12px 15px;
                color: #fff;
            }

            .career-form .form-control::-webkit-input-placeholder {
                /* Chrome/Opera/Safari */
                color: #fff;
            }

            .career-form .form-control::-moz-placeholder {
                /* Firefox 19+ */
                color: #fff;
            }

            .career-form .form-control:-ms-input-placeholder {
                /* IE 10+ */
                color: #fff;
            }

            .career-form .form-control:-moz-placeholder {
                /* Firefox 18- */
                color: #fff;
            }

            .career-form .custom-select {
                background-color: rgba(255, 255, 255, 0.2);
                border: 0;
                padding: 12px 15px;
                color: #fff;
                width: 100%;
                border-radius: 5px;
                text-align: left;
                height: auto;
                background-image: none;

            }

            .career-form .custom-select:focus {
                -webkit-box-shadow: none;
                box-shadow: none;
                color: black;
            }

            .career-form .select-container {
                position: relative;
            }

            .career-form .select-container:before {
                position: absolute;
                right: 15px;
                top: calc(50% - 14px);
                font-size: 18px;
                color: #ffffff;
                content: '\F2F9';
                font-family: "Material-Design-Iconic-Font";
            }

            .filter-result .job-box {
                background:#fff;
                -webkit-box-shadow: 0 0 35px 0 rgba(130, 130, 130, 0.2);
                box-shadow: 0 0 35px 0 rgba(130, 130, 130, 0.2);
                border-radius: 10px;
                padding: 10px 35px;
            }

            ul {
                list-style: none;
            }

            .list-disk li {
                list-style: none;
                margin-bottom: 12px;
            }

            .list-disk li:last-child {
                margin-bottom: 0;
            }

            .job-box .img-holder {
                height: 65px;
                width: 65px;
                background-color: #4e63d7;
                font-family: "Open Sans", sans-serif;
                color: #fff;
                font-size: 22px;
                font-weight: 700;
                display: -webkit-box;
                display: -ms-flexbox;
                display: flex;
                -webkit-box-pack: center;
                -ms-flex-pack: center;
                justify-content: center;
                -webkit-box-align: center;
                -ms-flex-align: center;
                align-items: center;
                border-radius: 65px;
            }

            .career-title {
                background-color: #4e63d7;
                color: #fff;
                padding: 15px;
                text-align: center;
                border-radius: 10px 10px 0 0;
                background-image: -webkit-gradient(linear, left top, right top, from(rgba(78, 99, 215, 0.9)), to(#5a85dd));
                background-image: linear-gradient(to right, rgba(78, 99, 215, 0.9) 0%, #5a85dd 100%);
            }

            .job-overview {
                -webkit-box-shadow: 0 0 35px 0 rgba(130, 130, 130, 0.2);
                box-shadow: 0 0 35px 0 rgba(130, 130, 130, 0.2);
                border-radius: 10px;
            }

            @media (min-width: 992px) {
                .job-overview {
                    position: -webkit-sticky;
                    position: sticky;
                    top: 70px;
                }
            }

            .job-overview .job-detail ul {
                margin-bottom: 28px;
            }

            .job-overview .job-detail ul li {
                opacity: 0.75;
                font-weight: 600;
                margin-bottom: 15px;
            }

            .job-overview .job-detail ul li i {
                font-size: 20px;
                position: relative;
                top: 1px;
            }

            .job-overview .overview-bottom,
            .job-overview .overview-top {
                padding: 35px;
            }

            .job-content ul li {
                font-weight: 600;
                opacity: 0.75;
                border-bottom: 1px solid #ccc;
                padding: 10px 5px;
            }

            @media (min-width: 768px) {
                .job-content ul li {
                    border-bottom: 0;
                    padding: 0;
                }
            }

            .job-content ul li i {
                font-size: 20px;
                position: relative;
                top: 1px;
            }

            .mb-30 {
                margin-bottom: 30px;
            }
            .btn-custom-1 {
                padding: 5px 10px;
                font-size: 16px;
                border-radius: 5px;
                border: none;

            }

            /* Nếu bạn muốn thêm hiệu ứng hover */
            .btn-custom-1:hover {
                background-color: #e2e6ea;

            }

            .select{
                height: 34px;
                width: 150px;
                padding: 5px 0 5px 5px;
                background-color: rgba(255, 255, 255, 0.2);
                color: white;
                border-radius: 5px;
                border: none;


                /*hide default down arrow in webkit */
                -webkit-appearance: none;
            }

            .select option {
                color: black;
            }

        </style>
    </head>
    <body>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css" integrity="sha256-3sPp8BkKUE7QyPSl6VfBByBroQbKxKG7tsusY2mhbVY=" crossorigin="anonymous" />
        <div class="container">
            <div class="row">
                <div class="col-lg-10 mx-auto mb-4">
                    <div class="section-title text-center ">
                        <h3 class="top-c-sep">My Reservation</h3>
                        <p>Total Reservation...</p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-10 mx-auto">
                    <div class="career-search mb-60">
                        <form action="MyReservation" method="post" class="career-form mb-60">
                            <div class="row">
                                <div class="col-md-6 col-lg-10 my-3">
                                    <div class="input-group position-relative" >
                                        <input style="height: 48px;" type="text" class="form-control" placeholder="Enter Children Name"  id="keywords">
                                    </div>
                                </div>
                                <div class="col-md-6 col-lg-2 my-3">
                                    <button type="button" class="btn btn-lg btn-block btn-light btn-custom" id="contact-submit">
                                        Search
                                    </button>
                                </div>

                                <div class="col-md-3 col-lg-3 my-3 d-flex justify-content-between align-items-center">
                                    <select class="select">
                                        <option value="1">Date: Newest First</option>
                                        <option value="2">Date: Oldest First</option>
                                        <option value="3">Status</option>
                                    </select>
                                    <button type="button" class="btn-custom-1" id="contact-submit">
                                        Filter
                                    </button>
                                </div>

                            </div>
                        </form>
                        <div class="filter-result">
                            <p class="mb-30 ff-montserrat mt-4">
                                <c:forEach var="reservation" items="${RESERVATION_LIST}" varStatus="loop">
                                    <c:set var="totalReservations" value="${loop.count}" />
                                </c:forEach>

                                <!-- Sau vòng lặp, bạn có thể sử dụng loop.count để lấy số lượng phần tử trong danh sách -->
                                Total Reservations: ${totalReservations}

                            </p>


                            <c:forEach var="reservation" items="${RESERVATION_LIST}">

                                <div class="job-box d-md-flex align-items-center justify-content-between mb-30">
                                    <div class="job-left my-4 d-md-flex align-items-center flex-wrap">
                                        <div class="job-content">
                                            <h5 class="text-center text-md-left">
                                                <c:forEach var="child" items="${CHILDREN_LIST}">
                                                    <c:if test="${child.childrenId eq reservation.childrenId}">
                                                        Name: ${child.name}
                                                    </c:if>
                                                </c:forEach>
                                            </h5>
                                            <ul class="d-md-flex flex-wrap text-capitalize ff-open-sans p-0 mt-4">
                                                <li class="mr-md-4">
                                                    <i class="fa-solid fa-list-check"></i> ID:${reservation.reservationId}
                                                </li>
                                                <li class="mr-md-4">
                                                    <i class="fa-solid fa-calendar-days"></i> ${reservation.bookDate}
                                                </li>
                                                <li class="mr-md-4">
                                                    <i class="fa-solid fa-stethoscope"></i> ${reservation.date}
                                                </li>
                                                <li class="mr-md-4">
                                                    <i class="fa-solid fa-money-bill-wave"></i> ${reservation.total}
                                                </li>
                                                <li class="mr-md-4">
                                                    <c:if test="${reservation.statusId == 1}">
                                                        <i class="fa-regular fa-circle-pause" style="color: orange; display: inline-block; vertical-align: middle;">
                                                            <span style="font-size: 12px; display: inline-block; vertical-align: middle;">Pending Confirmation</span>
                                                        </i>
                                                    </c:if>
                                                    <c:if test="${reservation.statusId == 2}">
                                                        <i class="fa-regular fa-square-check" style="color: darkgreen; display: inline-block; vertical-align: middle;">
                                                            <span style="font-size: 12px; display: inline-block; vertical-align: middle;">Confirmed</span>
                                                        </i>
                                                    </c:if>
                                                    <c:if test="${reservation.statusId == 3}">
                                                        <i class="fa-solid fa-user-check" style="color: skyblue; display: inline-block; vertical-align: middle;">
                                                            <span style="font-size: 12px; display: inline-block; vertical-align: middle;">Completed</span>
                                                        </i>
                                                    </c:if>
                                                    <c:if test="${reservation.statusId == 4}">
                                                        <i class="fa-solid fa-ban" style="color: red; display: inline-block; vertical-align: middle;">
                                                            <span style="font-size: 12px; display: inline-block; vertical-align: middle;">Cancelled</span>
                                                        </i>
                                                    </c:if>
                                                    <c:if test="${reservation.statusId == 5}">
                                                        <i class="fa-regular fa-calendar-check" style="color: purple; display: inline-block; vertical-align: middle;">
                                                            <span style="font-size: 12px; display: inline-block; vertical-align: middle;">Rescheduled</span>
                                                        </i>
                                                    </c:if>
                                                    <c:if test="${reservation.statusId == 6}">
                                                        <i class="fa-solid fa-phone-slash" style="color: grey; display: inline-block; vertical-align: middle;">
                                                            <span style="font-size: 12px; display: inline-block; vertical-align: middle;">No Show</span>
                                                        </i>
                                                    </c:if>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="job-right my-4 flex-shrink-0">
                                        <c:if test="${reservation.statusId == 1}">
                                            <a href="#" style="text-decoration: none;"> 
                                                <i class="fa-regular fa-bell-slash text-center" style="color: red; font-size: 35px;">
                                                    <p style="font-size: 10px; margin-top: 15px;">Cancel</p>
                                                </i> 
                                            </a>
                                        </c:if>
                                        <a href="#" style="text-decoration: none;"> 
                                            <i class="fa-solid fa-clipboard-list text-center" style="color: skyblue; font-size: 35px; margin-left: 30px;">
                                                <p style="font-size: 10px; margin-top: 15px;">Detail</p>
                                            </i>
                                        </a>
                                    </div>
                                </div>

                            </c:forEach>




                        </div>
                    </div>

                    <nav aria-label="Page navigation">
                        <ul class="pagination pagination-reset justify-content-center">
                            <li class="page-item disabled">
                                <a class="page-link" href="#" tabindex="-1" aria-disabled="true">
                                    <i class="zmdi zmdi-long-arrow-left"></i>
                                </a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">1</a></li>
                            <li class="page-item d-none d-md-inline-block"><a class="page-link" href="#">2</a></li>
                            <li class="page-item d-none d-md-inline-block"><a class="page-link" href="#">3</a></li>
                            <li class="page-item"><a class="page-link" href="#">...</a></li>
                            <li class="page-item"><a class="page-link" href="#">8</a></li>
                            <li class="page-item">
                                <a class="page-link" href="#">
                                    <i class="zmdi zmdi-long-arrow-right"></i>
                                </a>
                            </li>
                        </ul>
                    </nav>

                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js"></script>
        <script type="text/javascript">

        </script>
    </body>
</html>