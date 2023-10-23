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
                        <div class="row" style="align-content: center;">
                            <a href="#" class="btn" style="background-color: #3fbbc0; color: white; height: 50px;"> Book </a>
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
                    <div class="border rounded-2 px-3 py-2 bg-white">
                        <!-- Pills navs -->
                        <ul class="nav nav-pills nav-justified mb-3" id="ex1" role="tablist">
                            <li class="nav-item d-flex" role="presentation">
                                <a class="nav-link d-flex align-items-center justify-content-center w-100 active" id="ex1-tab-1" data-mdb-toggle="pill" href="#ex1-pills-1" role="tab" aria-controls="ex1-pills-1" aria-selected="true">Feedback</a>
                            </li>
                            
                        </ul>
                        <!-- Pills navs -->

                        <!-- Pills content -->
                        <div class="tab-content" id="ex1-content">
                            <div class="tab-pane fade show active" id="ex1-pills-1" role="tabpanel" aria-labelledby="ex1-tab-1">

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
