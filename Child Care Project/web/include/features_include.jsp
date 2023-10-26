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
                background-color: #3fbbc0;
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
