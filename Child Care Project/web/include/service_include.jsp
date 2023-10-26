<%-- 
    Document   : service_include
    Created on : Oct 5, 2023, 11:43:10 PM
    Author     : duchi
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .button111 {
                font-family: "Roboto", sans-serif;
                font-weight: 500;
                font-size: 14px;
                letter-spacing: 1px;
                display: inline-block;

                border-radius: 4px;
                transition: 0.5s;
                line-height: 1;
                color: #fff;
                background: #3fbbc0;
            }

            .button222 {
                background-color: 3fbbc0;
                color: #fff;
                padding: 14px 32px;
            }

            .button222:hover {
                background-color: #65c9cd;
                color: white;
            }
            .button-item .container {
                margin-top: 60px;
                display: flex;
                justify-content: center;
            }
        </style>
    </head>
    <body>
        <section id="services" class="services services">
            <div class="container" data-aos="fade-up">

                <div class="section-title">
                    <h2>Services</h2>
                    <p>Our Current Services</p>
                </div>

                <div class="row">

                    <c:forEach var="service" items="${SERVICE_LIST}">

                        <div class="col-lg-4 col-md-6 icon-box" data-aos="zoom-in" data-aos-delay="100" style="">
                            <c:choose>
                                <c:when test="${service.categoryId == 1}">
                                    <div class="icon"><i class="fas fa-hand-holding-medical"></i></div>
                                    </c:when>
                                    <c:when test="${service.categoryId == 2}">
                                    <div class="icon"><i class="fas fa-stethoscope"></i></div>
                                    </c:when>
                                    <c:when test="${service.categoryId == 3}">
                                    <div class="icon"><i class="fas fa-thermometer"></i></div>
                                    </c:when>
                                </c:choose>
                            <h4 class="title"><a href="ServiceDetail?serviceID=${service.serviceId}">${service.name}</a></h4>
                                <c:forEach var="category" items="${CATEGORY_LIST}">
                                    <c:if test="${category.categoryId eq service.categoryId}" >
                                    <h6>${category.name}</h6>
                                </c:if>
                            </c:forEach>
                            <p class="description">${service.detail}</p>

                        </div>
                    </c:forEach>

                </div>
                <div class="button-item active">
                    <div class="container">
                        <a href="Services" class="button111 button222">Read More</a>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
