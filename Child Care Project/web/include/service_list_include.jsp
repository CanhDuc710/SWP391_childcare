<%-- 
    Document   : service_list_include
    Created on : Oct 10, 2023, 1:49:43 AM
    Author     : duchi
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" />
        <style>
            body{
                margin-top: 60px;
                background:#f1f2f7;
            }

            section {
                padding: 0;
                overflow: hidden;
            }

            /*panel*/
            .panel {
                border: none;
                box-shadow: none;
            }

            .panel-heading {
                border-color:#eff2f7 ;
                font-size: 16px;
                font-weight: 300;
            }

            .panel-title {
                color: #2A3542;
                font-size: 14px;
                font-weight: 400;
                margin-bottom: 0;
                margin-top: 0;
                font-family: 'Open Sans', sans-serif;
            }


            /*product list*/

            .prod-cat li a{
                border-bottom: 1px dashed #d9d9d9;
                padding-right: 50px;
            }

            .prod-cat li a {
                color: #3b3b3b;
            }

            .prod-cat li ul {
                margin-left: 30px;
                padding-right: 50px;
            }

            .prod-cat li ul li a{
                border-bottom:none;
            }
            .prod-cat li ul li a:hover,.prod-cat li ul li a:focus, .prod-cat li ul li.active a , .prod-cat li a:hover,.prod-cat li a:focus, .prod-cat li a.active{
                background: none;
                color: #ff7261;
            }

            .pro-lab{
                margin-right: 20px;
                font-weight: normal;
            }

            .pro-sort {
                padding-right: 20px;
                float: left;
            }

            .pro-page-list {
                margin: 5px 0 0 0;
            }

            .product-list img{
                width: 100%;
                border-radius: 4px 4px 0 0;
                -webkit-border-radius: 4px 4px 0 0;
            }

            .product-list .pro-img-box {
                position: relative;
            }
            .adtocart {
                background: #3fbbc0;
                width: 50px;
                height: 50px;
                border-radius: 50%;
                -webkit-border-radius: 50%;
                color: #fff;
                display: inline-block;
                text-align: center;
                border: 3px solid #fff;
                left: 42%;
                bottom: -25px;
                position: absolute;
            }

            .adtocart i{
                color: #fff;
                font-size: 25px;
                line-height: 42px;
            }

            .pro-title {
                color: #5A5A5A;
                display: inline-block;
                margin-top: 20px;
                font-size: 16px;
            }

            .product-list .price {
                color: black ;
                font-size: 13px;
                text-decoration: line-through;
            }
            
            .product-list .price-sale {
                color: #3fbbc0 ;
                font-size: 18px;
            }

            .product-list .detail {
                color: black ;
                font-size: 12px;
                margin-top: 20px;
                margin-bottom: 40px;
            }

            .pro-img-details {
                margin-left: -15px;
            }

            .pro-img-details img {
                width: 100%;
            }

            .pro-d-title {
                font-size: 16px;
                margin-top: 0;
            }

            .product_meta {
                border-top: 1px solid #eee;
                border-bottom: 1px solid #eee;
                padding: 10px 0;
                margin: 15px 0;
            }

            .product_meta span {
                display: block;
                margin-bottom: 10px;
            }
            .product_meta a, .pro-price{
                color:#fc5959 ;
            }

            .pro-price, .amount-old {
                font-size: 18px;
                padding: 0 10px;
            }

            .amount-old {
                text-decoration: line-through;
            }

            .quantity {
                width: 120px;
            }

            .pro-img-box {
                width: 250px;
                height: 220px;
                position: relative;
            }

            .pro-img-box img {
                width: 102%;
                height: 100%;
                object-fit: cover;
            }

            .pro-img-list {
                margin: 10px 0 0 -15px;
                width: 100%;
                display: inline-block;
            }

            .pro-img-list a {
                float: left;
                margin-right: 10px;
                margin-bottom: 10px;
            }

            .pro-d-head {
                font-size: 18px;
                font-weight: 300;
            }


        </style>
    </head>
    <body>
        <div class="container bootdey">
            <div class="col-md-3">
                <section class="panel">
                    <div class="panel-body">
                        <input type="text" placeholder="Keyword Search" class="form-control" />
                    </div>
                </section>
                <section class="panel">
                    <header class="panel-heading">
                        Category
                    </header>
                    <div class="panel-body">
                        <ul class="nav prod-cat">


                            <c:choose>
                                <c:when test="${SHOW == 1}">
                                    <li>
                                        <a href="Services?show=1" class="active"><i class="fa fa-angle-right"></i> All </a>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <li>
                                        <a href="Services"><i class="fa fa-angle-right"></i> All </a>
                                    </li>
                                </c:otherwise>
                            </c:choose>

                            <c:forEach var="category" items="${SERVICE_CATEGORY_LIST}">
                                <li>
                                    <a href="Services"><i class="fa fa-angle-right"></i> ${category.name} </a>
                                </li>
                            </c:forEach>

                        </ul>
                    </div>
                </section>
                <section class="panel">
                    <header class="panel-heading">
                        Price Range
                    </header>
                    <div class="panel-body sliders">
                        <div id="slider-range" class="slider"></div>
                        <div class="slider-info">
                            <span id="slider-range-amount"></span>
                        </div>
                    </div>
                </section>
                <section class="panel">
                    <header class="panel-heading">
                        Filter
                    </header>
                    <div class="panel-body">
                        <form role="form product-form">
                            <div class="form-group">
                                <label>Category</label>
                                <select id="categorySelect" class="form-control">

                                    <c:forEach var="category" items="${SERVICE_CATEGORY_LIST}">
                                        <option>${category.name}</option>
                                    </c:forEach>
                                        
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Price</label>
                                <select id="categorySelect" class="form-control">
                                    <option>a</option>
                                    <option>b</option>
                                    <option>c</option>
                                    <option>d</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Rating</label>
                                <select id="categorySelect" class="form-control">
                                    <option>a</option>
                                    <option>b</option>
                                    <option>c</option>
                                    <option>d</option>
                                </select>
                            </div>
                            <button class="btn btn-primary" type="submit">Filter</button>
                        </form>
                    </div>
                </section>

            </div>


            <div class="col-md-9">
                <section class="panel">
                    <div class="panel-body">
                        <div class="pull-right">
                            <ul class="pagination pagination-sm pro-page-list">
                                <li><a href="#">1</a></li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">»</a></li>
                            </ul>
                        </div>
                    </div>
                </section>

                <div class="row product-list">


                    <c:forEach var="service" items="${SERVICE_LIST}">
                        <div class="col-md-4">
                            <section class="panel">
                                <div class="pro-img-box">
                                    <img src="assets/img/service/${service.image}" alt="" />
                                    <a href="#" class="adtocart">
                                        <i class="fa fa-clipboard-user"></i>
                                    </a>
                                </div>

                                <div class="panel-body text-center">
                                    <h3>
                                        <a href="ServiceDetail?serviceID=${service.serviceId}" class="pro-title">
                                            ${service.name}
                                        </a>
                                    </h3>
                                    <p class="detail">${service.detail}</p>
                                    <p class="price">Price: $${service.price}</p>
                                    <p class="price-sale"">Price: $${service.price - service.price*service.discount/100}  (${service.discount}%) </p>
                                </div>
                            </section>
                        </div>
                    </c:forEach>



                </div>
            </div>
        </div>
    </body>

</html>
