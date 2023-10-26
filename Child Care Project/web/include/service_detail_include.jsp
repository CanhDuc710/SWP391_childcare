<%-- 
    Document   : service_detail_template
    Created on : Oct 23, 2023, 2:15:04 PM
    Author     : BlackZ36
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .icon-hover:hover {
                border-color: #3b71ca !important;
                background-color: white !important;
                color: #3b71ca !important;
            }

            .icon-hover:hover i {
                color: #3b71ca !important;
            }
            .btn {
                display: flex;
                align-items: center;
                justify-content: center;
                height: 50px;
                background-color: #3fbbc0;
                color: white;
                text-decoration: none;
            }
            .btn:hover {
                background-color: #65c9cd;
            }


            .comments-container {
                margin: 60px auto 15px;
                width: 768px;
            }

            .comments-container h1 {
                font-size: 36px;
                color: #283035;
                font-weight: 400;
            }

            .comments-container h1 a {
                font-size: 18px;
                font-weight: 700;
            }

            .comments-list {
                margin-top: 30px;
                position: relative;
            }

            /**
             * Lineas / Detalles
             -----------------------*/
            .comments-list:before {
                content: '';


                background: #c7cacb;
                position: absolute;
                left: 32px;
                top: 0;
            }

            .comments-list:after {
                content: '';
                position: absolute;
                background: #c7cacb;
                -webkit-border-radius: 50%;
                -moz-border-radius: 50%;
                border-radius: 50%;
            }

            .reply-list:before, .reply-list:after {
                display: none;
            }
            .reply-list li:before {
                content: '';
                width: 60px;
                height: 2px;
                background: #c7cacb;
                position: absolute;
                top: 25px;
                left: -55px;
            }


            .comments-list li {
                margin-bottom: 15px;
                display: block;
                position: relative;
            }

            .comments-list li:after {
                content: '';
                display: block;
                clear: both;
                height: 0;
                width: 0;
            }

            .reply-list {
                padding-left: 88px;
                clear: both;
                margin-top: 15px;
            }
            /**
             * Avatar
             ---------------------------*/
            .comments-list .comment-avatar {
                width: 65px;
                height: 65px;
                position: relative;
                z-index: 99;
                float: left;
                border: 3px solid #FFF;
                -webkit-border-radius: 4px;
                -moz-border-radius: 4px;
                border-radius: 4px;
                -webkit-box-shadow: 0 1px 2px rgba(0,0,0,0.2);
                -moz-box-shadow: 0 1px 2px rgba(0,0,0,0.2);
                box-shadow: 0 1px 2px rgba(0,0,0,0.2);
                overflow: hidden;
            }

            .comments-list .comment-avatar img {
                width: 100%;
                height: 100%;
            }

            .reply-list .comment-avatar {
                width: 50px;
                height: 50px;
            }

            .comment-main-level:after {
                content: '';
                width: 0;
                height: 0;
                display: block;
                clear: both;
            }
            /**
             * Caja del Comentario
             ---------------------------*/
            .comments-list .comment-box {
                width: 680px;
                float: right;
                position: relative;
                -webkit-box-shadow: 0 1px 1px rgba(0,0,0,0.15);
                -moz-box-shadow: 0 1px 1px rgba(0,0,0,0.15);
                box-shadow: 0 1px 1px rgba(0,0,0,0.15);
            }

            .comments-list .comment-box:before, .comments-list .comment-box:after {
                content: '';
                height: 0;
                width: 0;
                position: absolute;
                display: block;
                border-width: 10px 12px 10px 0;
                border-style: solid;
                border-color: transparent #FCFCFC;
                top: 8px;
                left: -11px;
            }

            .comments-list .comment-box:before {
                border-width: 11px 13px 11px 0;
                border-color: transparent rgba(0,0,0,0.05);
                left: -12px;
            }

            .reply-list .comment-box {
                width: 610px;
            }
            .comment-box .comment-head {
                background: #FCFCFC;
                padding: 10px 12px;
                border-bottom: 1px solid #E5E5E5;
                overflow: hidden;
                -webkit-border-radius: 4px 4px 0 0;
                -moz-border-radius: 4px 4px 0 0;
                border-radius: 4px 4px 0 0;
            }

            .comment-box .comment-head i {
                float: right;
                margin-left: 14px;
                position: relative;
                top: 2px;
                color: #A6A6A6;
                cursor: pointer;
                -webkit-transition: color 0.3s ease;
                -o-transition: color 0.3s ease;
                transition: color 0.3s ease;
            }

            .comment-box .comment-head i:hover {
                color: #03658c;
            }

            .comment-box .comment-name {
                color: #283035;
                font-size: 14px;
                font-weight: 700;
                float: left;
                margin-right: 10px;
            }

            .comment-box .comment-name a {
                color: #283035;
            }

            .comment-box .comment-head span {
                float: left;
                color: #999;
                font-size: 13px;
                position: relative;
                top: 1px;
            }

            .comment-box .comment-content {
                background: #FFF;
                padding: 12px;
                font-size: 15px;
                color: #595959;
                -webkit-border-radius: 0 0 4px 4px;
                -moz-border-radius: 0 0 4px 4px;
                border-radius: 0 0 4px 4px;
            }

            .comment-box .comment-name.by-author, .comment-box .comment-name.by-author a {
                color: #03658c;
            }
            .comment-box .comment-name.by-author:after {
                content: 'Feedback Verified';
                background: #03658c;
                color: #FFF;
                font-size: 12px;
                padding: 3px 5px;
                font-weight: 700;
                margin-left: 10px;
                -webkit-border-radius: 3px;
                -moz-border-radius: 3px;
                border-radius: 3px;
            }

            /** =====================
             * Responsive
             ========================*/
            @media only screen and (max-width: 766px) {
                .comments-container {
                    width: 480px;
                }

                .comments-list .comment-box {
                    width: 390px;
                }

                .reply-list .comment-box {
                    width: 320px;
                }
            }

        </style>
    </head>


    <!-- content -->
    <section class="py-5">
        <div class="container" style="margin-bottom: 30px;">
            <div class="row gx-5">
                <aside class="col-lg-6">

                    <div class="border rounded-4 mb-3 d-flex justify-content-center">
                        <a data-fslightbox="mygalley" class="rounded-4" target="_blank" data-type="image">
                            <img style="max-width: 100%; max-height: 100vh; margin: auto;" class="rounded-4 fit" src="assets/img/service/${SERVICE.image}" />
                        </a>
                    </div>

                    <!-- thumbs-wrap.// -->
                    <!-- gallery-wrap .end// -->
                </aside>
                <main class="col-lg-6">
                    <div class="ps-lg-3">
                        <h4 class="title text-dark">
                            ${SERVICE.name}
                        </h4>
                        <div class="d-flex flex-row my-3">
                            <c:forEach var="rate" items="${AVERAGE_RATE}">
                                <c:if test="${rate.serviceId eq SERVICE.serviceId}">
                                    <c:set var="starsToShow" value="${rate.averageRate}" />
                                    <c:choose>
                                        <c:when test="${starsToShow > 5}">
                                            <c:set var="starsToShow" value="5" />
                                        </c:when>
                                        <c:when test="${starsToShow < 0}">
                                            <c:set var="starsToShow" value="0" />
                                        </c:when>
                                    </c:choose>

                                    <!-- Số sao được hiển thị -->
                                    <c:forEach begin="1" end="${fn:substringBefore(starsToShow, '.')}">
                                        <i class="rate fa fa-star" aria-hidden="true"></i>
                                    </c:forEach>

                                    <!-- Nếu có phần thập phân, hiển thị nửa sao -->
                                    <c:choose>
                                        <c:when test="${fn:substringAfter(starsToShow, '.') == '5'}">
                                            <i class="rate fa fa-star-half-stroke" aria-hidden="true"></i>
                                        </c:when>
                                    </c:choose>

                                    <!-- Hiển thị số sao trống còn lại -->
                                    <c:forEach begin="1" end="${5 - fn:substringBefore(starsToShow, '.') - (fn:substringAfter(starsToShow, '.') == '5' ? 1 : 0)}">
                                        <i class="rate fa-regular fa-star" aria-hidden="true"></i>
                                    </c:forEach>
                                </c:if>
                            </c:forEach>
                        </div>

                        <div class="mb-3">
                            <span class="h5">$${SERVICE.price - SERVICE.price*SERVICE.discount/100}</span>
                            <span class="text-muted">(${SERVICE.discount}% sale-off)</span>
                            </br>
                            <span class="text-muted" style="font-weight: bold; text-decoration: line-through;" >Price: $${SERVICE.price} </span>
                        </div>

                        <p>
                            ${SERVICE.detail}
                        </p>

                        <div class="row">
                            <dt class="col-3">Type:</dt>
                            <dd class="col-9">
                                <c:forEach var="category" items="${CATEGORY}">
                                    <c:if test="${category.categoryId eq SERVICE.categoryId}">
                                        ${category.name}
                                    </c:if>
                                </c:forEach>
                            </dd>

                        </div>

                        <hr />
                        <div class="row justify-content-center">
                            <div class="col-md-6 text-center">
                                <a href="#" class="btn btn-primary" style="height: 50px; border: none;">Book</a>
                            </div>

                            <div class="col-md-6 text-center">
                                <a href="#" class="btn btn-primary" style="height: 50px; border: none;">Feedback</a>
                            </div>

                        </div>
                    </div>
                </main>
            </div>
        </div>
    </section>
    <!-- content -->

    <section class="bg-light border-top py-4">
        <div class="container">
            <div class="row gx-4">
                <div class="col-lg-8 mb-4">
                    <div class="border rounded-2 px-3 py-2" style="background-color: #f2f2f2;">
                        <!-- Pills navs -->
                        <ul class="nav nav-pills nav-justified mb-3" id="ex1" role="tablist">
                            <li class="nav-item d-flex" role="presentation">
                                <a class="nav-link d-flex align-items-center justify-content-center w-100 active" id="ex1-tab-1" data-mdb-toggle="pill" href="#ex1-pills-1" role="tab" aria-controls="ex1-pills-1" aria-selected="true" style="background-color: #3fbbc0;">Feedback</a>
                            </li>

                        </ul>
                        <!-- Pills navs -->

                        <!-- Pills content -->
                        <div class="tab-content" id="ex1-content">
                            <div class="tab-pane fade show active" id="ex1-pills-1" role="tabpanel" aria-labelledby="ex1-tab-1">

                                <!--feedback zone-->

                                <c:forEach var="feedback" items="${FEEDBACK_LIST}">
                                    <c:forEach var="patient" items="${ACCOUNT_LIST}">
                                        <c:if test="${feedback.serviceId eq SERVICE.serviceId}">
                                            <c:if test="${feedback.patientId eq patient.accountId}">
                                                <ul id="comments-list" class="comments-list">
                                                    <li>
                                                        <div class="comment-main-level">
                                                            <!-- Avatar -->
                                                            <div class="comment-avatar"><img src="assets/img/user/${patient.username}/${patient.avatar}" alt=""></div>
                                                            <!-- Contenedor del Comentario -->
                                                            <div class="comment-box">
                                                                <div class="comment-head">
                                                                    <h6 class="comment-name by-author"><a href="#">${patient.name}</a></h6>

                                                                    <span>${feedback.update_date}</span>
                                                                    <c:forEach var="i" begin="1" end="${5 - feedback.rate}">
                                                                        <i class="fa fa-star text-muted m-0" style="font-size: 15px;"></i>
                                                                    </c:forEach>
                                                                    <c:forEach var="i" begin="1" end="${feedback.rate}">
                                                                        <i class="fa fa-star text-primary m-0" style="font-size: 15px;"></i>
                                                                    </c:forEach>

                                                                </div>
                                                                <div class="comment-content">
                                                                    <h5>${feedback.title} </h5>
                                                                    </br>   
                                                                    ${feedback.detail}
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </c:if>
                                        </c:if>
                                    </c:forEach>
                                </c:forEach>

                                <!--end feedback zone-->


                            </div>
                        </div>
                        <!-- Pills content -->

                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="px-0 border rounded-2 shadow-0">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Similar items</h5>



                                <c:forEach var="service" items="${SERVICE_LIST}" varStatus="loop">
                                    <c:if test="${service.serviceId ne SERVICE.serviceId and loop.index lt 4}">
                                        <div class="d-flex mb-3">
                                            <a href="" class="me-3">
                                                <img src="assets/img/service/${service.image}" style="min-width: 96px; height: 96px;" class="img-md img-thumbnail" />
                                            </a>
                                            <div class="info">
                                                <a href="ServiceDetail?serviceID=${service.serviceId}" class="nav-link mb-1">
                                                    ${service.name} <br />
                                                </a>
                                                </br>
                                                <strong class="text-dark">$${service.price}</strong>
                                            </div>
                                        </div>
                                    </c:if>
                                </c:forEach>




                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>



</html>
