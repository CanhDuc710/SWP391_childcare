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
    </head>
    <body>
        <section id="services" class="services services">
            <div class="container" data-aos="fade-up">

                <div class="section-title">
                    <h2>Services</h2>
                    <p>danh muc dich cu cua chung toi.</p>
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
                            <h4 class="title"><a href="">${service.name}</a></h4>
                                <c:forEach var="category" items="${CATEGORY_LIST}">
                                    <c:if test="${category.categoryId eq service.categoryId}" >
                                    <h6>${category.name}</h6>
                                </c:if>
                            </c:forEach>
                            <p class="description">${service.detail}</p>

                        </div>
                    </c:forEach>

                </div>

            </div>
        </section>
    </body>
</html>
