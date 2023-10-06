<%-- 
    Document   : features_include
    Created on : Oct 5, 2023, 8:45:58 PM
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
        <section id="featured-services" class="featured-services">
            <div class="container" data-aos="fade-up">

                <div class="row justify-content-center">


                    <c:forEach var="category" items="${CATEGORY_LIST}">
                        <div class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0">
                            <div class="icon-box" data-aos="fade-up" data-aos-delay="200">
                                <div class="icon"><i class="fas fa-hand-holding-medical"></i></div>
                                <h4 class="title"><a href="">${category.name}</a></h4>
                                <p class="description">${category.detail}</p>
                            </div>
                        </div>
                    </c:forEach>


                </div>

            </div>
        </section>
    </body>
</html>
