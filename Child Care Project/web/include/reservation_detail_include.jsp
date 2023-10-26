<%-- 
    Document   : reservation_detail_include
    Created on : Oct 26, 2023, 1:41:43 PM
    Author     : BlackZ36
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>

            .title{
                margin-bottom: 5vh;
            }
            .card{
                margin: auto;
                max-width: 950px;
                width: 100%;
                box-shadow: 0 6px 20px 0 rgba(0, 0, 0, 0.19);
                border-radius: 1rem;
                border: transparent;
            }
            @media(max-width:767px){
                .card{
                    margin: 3vh auto;
                }
            }
            .cart{
                background-color: #fff;
                padding: 4vh 5vh;
                border-bottom-left-radius: 1rem;
                border-top-left-radius: 1rem;
            }
            @media(max-width:767px){
                .cart{
                    padding: 4vh;
                    border-bottom-left-radius: unset;
                    border-top-right-radius: 1rem;
                }
            }
            .summary{
                background-color: #ddd;
                border-top-right-radius: 1rem;
                border-bottom-right-radius: 1rem;
                padding: 4vh;
                color: rgb(65, 65, 65);
            }
            @media(max-width:767px){
                .summary{
                    border-top-right-radius: unset;
                    border-bottom-left-radius: 1rem;
                }
            }
            .summary .col-2{
                padding: 0;
            }
            .summary .col-10
            {
                padding: 0;
            }
            .row{
                margin: 0;
            }
            .title b{
                font-size: 1.5rem;
            }
            .main{
                margin: 0;
                padding: 2vh 0;
                width: 100%;
            }
            .col-2, .col{
                padding: 0 1vh;
            }
            a{
                padding: 0 1vh;
            }
            .close{
                margin-left: auto;
                font-size: 0.7rem;
            }
            img{
                width: 3.5rem;
            }
            .back-to-shop{
                margin-top: 4.5rem;
            }
            h5{
                margin-top: 4vh;
            }
            hr{
                margin-top: 1.25rem;
            }
            form{
                padding: 2vh 0;
            }
            select{
                border: 1px solid rgba(0, 0, 0, 0.137);
                padding: 1.5vh 1vh;
                margin-bottom: 4vh;
                outline: none;
                width: 100%;
                background-color: rgb(247, 247, 247);
            }
            input{
                border: 1px solid rgba(0, 0, 0, 0.137);
                padding: 1vh;
                margin-bottom: 4vh;
                outline: none;
                width: 100%;
                background-color: rgb(247, 247, 247);
            }
            input:focus::-webkit-input-placeholder
            {
                color:transparent;
            }
            .btn{
                background-color: #000;
                border-color: #000;
                color: white;
                width: 100%;
                font-size: 0.7rem;
                margin-top: 4vh;
                padding: 1vh;
                border-radius: 0;
            }
            .btn:focus{
                box-shadow: none;
                outline: none;
                box-shadow: none;
                color: white;
                -webkit-box-shadow: none;
                -webkit-user-select: none;
                transition: none;
            }
            .btn:hover{
                color: white;
            }
            a{
                color: black;
            }
            a:hover{
                color: black;
                text-decoration: none;
            }
            #code{
                background-image: linear-gradient(to left, rgba(255, 255, 255, 0.253) , rgba(255, 255, 255, 0.185)), url("https://img.icons8.com/small/16/000000/long-arrow-right.png");
                background-repeat: no-repeat;
                background-position-x: 95%;
                background-position-y: center;
            }
        </style>
    </head>
    <body>
        <div class="card">
            <div class="row">
                <div class="col-md-8 cart">
                    <div class="title">
                        <div class="row">
                            <div class="col"><h4><b>Reservation: </br> Chosen Service</b></h4></div>
                            <div class="col"></div>
                            <div class="col align-self-center text-right text-muted">${count} Service(s)</div>
                        </div>
                    </div>    

                    <c:if test="${CHOSEN_SERVICE_LIST ne null}">
                        <c:forEach var="service" items="${CHOSEN_SERVICE_LIST}">

                            <div class="row border-top border-bottom">
                                <div class="row main align-items-center">
                                    <div class="col-2"><img class="img-fluid" src="assets/img/service/${service.image}"></div>

                                    <!--name and category-->
                                    <div class="col-6">
                                        <c:forEach var="category" items="${CATEGORY_LIST}">
                                            <c:if test="${service.categoryId eq category.categoryId}">
                                                <div class="row text-muted">${category.name}</div>
                                            </c:if>
                                        </c:forEach>
                                        <div class="row">${service.name}</div>
                                    </div>

                                    <!--price-->
                                    <div class="col-2 pt-4">
                                        <input type="text" name="price" id="price" class="service-price" value="${service.price - service.price * service.discount / 100}" readonly> 
                                    </div>

                                    <div class="col-2">
                                        <a href="AddService?remove=${service.serviceId}">
                                            <i class="fa-solid fa-xmark"></i>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </c:if>

                    <div class="back-to-shop"><a href="Services">&leftarrow;</a><span class="text-muted">Back to Services</span></div>
                </div>
                <div class="col-md-4 summary">
                    <div><h5><b>Summary</b></h5></div>
                    <hr>
                    <div class="row">
                        <div class="col" style="padding-left:0;">Service(s) <span style="font-weight: bold; margin-left: 50px;">  ${count}</span></div>
                    </div>

                    <div class="row" style="border-top: 1px solid rgba(0,0,0,.1); padding: 2vh 0; margin-top: 100px;">
                        <div class="col">TOTAL PRICE</div>
                        <div class="col text-right">&dollar; ${totalPrice}</div>
                    </div>
                    <a href="ReservationContact"> <button class="btn">TO RESERVATION CONTACT</button> </a>
                </div>
            </div>

        </div>

        <script type="text/javascript">
            var servicePrices = document.querySelectorAll('.service-price');
            var total = 0;

            servicePrices.forE ach(function (priceInput) {
                total += parseFloat(priceInput.value);
            });

            // Lưu tổng giá trị vào một biến JavaScript
            var totalPrice = total;

// Sử dụng totalPrice theo nhu cầu của bạn
        </script>


    </body>
</html>
