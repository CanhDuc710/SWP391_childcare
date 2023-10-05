<%-- 
    Document   : profile_include
    Created on : Oct 5, 2023, 3:16:49 PM
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
            body{
                margin-top:20px;
                background-color:#f2f6fc;
                color:#69707a;
            }
            .img-account-profile {
                height: 10rem;
            }
            .rounded-circle {
                border-radius: 50% !important;
            }
            .card {
                box-shadow: 0 0.15rem 1.75rem 0 rgb(33 40 50 / 15%);
            }
            .card .card-header {
                font-weight: 500;
            }
            .card-header:first-child {
                border-radius: 0.35rem 0.35rem 0 0;
            }
            .card-header {
                padding: 1rem 1.35rem;
                margin-bottom: 0;
                background-color: rgba(33, 40, 50, 0.03);
                border-bottom: 1px solid rgba(33, 40, 50, 0.125);
            }
            .form-control, .dataTable-input {
                display: block;
                width: 100%;
                padding: 0.875rem 1.125rem;
                font-size: 0.875rem;
                font-weight: 400;
                line-height: 1;
                color: #69707a;
                background-color: #fff;
                background-clip: padding-box;
                border: 1px solid #c5ccd6;
                -webkit-appearance: none;
                -moz-appearance: none;
                appearance: none;
                border-radius: 0.35rem;
                transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
            }

            .nav-borders .nav-link.active {
                color: #0061f2;
                border-bottom-color: #0061f2;
            }
            .nav-borders .nav-link {
                color: #69707a;
                border-bottom-width: 0.125rem;
                border-bottom-style: solid;
                border-bottom-color: transparent;
                padding-top: 0.5rem;
                padding-bottom: 0.5rem;
                padding-left: 0;
                padding-right: 0;
                margin-left: 1rem;
                margin-right: 1rem;
            }
        </style>
    </head>
    <body>
        <div class="container-xl px-4 mt-4">
            <hr class="mt-0 mb-4">
            <div class="row">
                <div class="col-xl-4">
                    <!-- Profile picture card-->
                    <div class="card mb-4 mb-xl-0">
                        <div class="card-header">Profile Picture</div>
                        <div class="card-body text-center">
                            <!-- Profile picture image-->
                            <img class="img-account-profile rounded-circle mb-2" src="images/user/${ACCOUNT.avatar}" alt="">
                            <!-- Profile picture help block-->
                            <div class="small font-italic text-muted mb-4">JPG or PNG no larger than 5 MB</div>
                            <!-- Profile picture upload button-->
                            <button class="btn btn-primary" type="button">Upload new image</button>
                        </div>
                    </div>
                </div>
                <div class="col-xl-8">
                    <!-- Account details card-->
                    <div class="card mb-4">
                        <div class="card-header">Account Details</div>
                        <div class="card-body">
                            <form>
                                <!-- Form Group (username)-->
                                <div class="row gx-3 mb-3">
                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputPhone">Username</label>
                                        <input class="form-control" id="inputPhone" type="text" style="background-color: rgba(220,220,220,0.9)" value="${ACCOUNT.username}">
                                    </div>
                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputPhone">Account Type</label>
                                        <c:choose>
                                            <c:when test="${ACCOUNT.roleId == 1}" >
                                                <input class="form-control" id="inputPhone" type="text" style="background-color: rgba(220,220,220,0.9); color: green;" value="Patient">
                                            </c:when>
                                        </c:choose>
                                    </div>
                                </div>
                                <!-- Form Group (email address)-->
                                <div class="mb-3">
                                    <label class="small mb-1" for="inputEmailAddress">Email address</label>
                                    <input class="form-control" id="inputEmailAddress" type="email" style="background-color: rgba(220,220,220,0.9);" value="${ACCOUNT.email}" readonly>
                                </div>
                                <!-- Form Row-->
                                <div class="mb-3">
                                    <label class="small mb-1" for="inputFirstName">Full Name</label>
                                    <input class="form-control" id="inputFirstName" type="text" value="${ACCOUNT.name}">
                                </div>
                                <!-- Form Row        -->
                                <!-- Form Row-->
                                <div class="mb-3">
                                    <label class="small mb-1" for="inputFirstName">Address</label>
                                    <input class="form-control" id="inputFirstName" type="text" value="${ACCOUNT.address}">
                                </div>

                                <!-- Form Row-->
                                <div class="row gx-3 mb-3">
                                    <!-- Form Group (phone number)-->
                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputPhone">Phone number</label>
                                        <input class="form-control" id="inputPhone" type="text"value="${ACCOUNT.phone}">
                                    </div>
                                    <!-- Form Group (birthday)-->
                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputBirthday">Gender</label>
                                        <c:if test="${ACCOUNT.gender == 1}">
                                            <input class="form-control" id="inputBirthday" type="text" name="txtGender"value="Male">
                                        </c:if>
                                        <c:if test="${ACCOUNT.gender == 0}">
                                            <input class="form-control" id="inputBirthday" type="text" name="txtGender"value="Female">
                                        </c:if>
                                    </div>
                                </div>
                                <!-- Save changes button-->
                                <button class="btn btn-primary" type="button">Save changes</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
