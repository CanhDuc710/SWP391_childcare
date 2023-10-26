<%-- 
    Document   : reservatio_contact_include
    Created on : Oct 26, 2023, 3:22:30 PM
    Author     : BlackZ36
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Reservation Contact</title>

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" />
        <style>
            body{
                margin-top: 10px;
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
            .fa-2x {
                font-size: 2em;
            }

            .table-billing-history th, .table-billing-history td {
                padding-top: 0.75rem;
                padding-bottom: 0.75rem;
                padding-left: 1.375rem;
                padding-right: 1.375rem;
            }
            .table > :not(caption) > * > *, .dataTable-table > :not(caption) > * > * {
                padding: 0.75rem 0.75rem;
                background-color: var(--bs-table-bg);
                border-bottom-width: 1px;
                box-shadow: inset 0 0 0 9999px var(--bs-table-accent-bg);
            }

            .border-start-primary {
                border-left-color: #0061f2 !important;
            }
            .border-start-secondary {
                border-left-color: #6900c7 !important;
            }
            .border-start-success {
                border-left-color: #00ac69 !important;
            }
            .border-start-lg {
                border-left-width: 0.25rem !important;
            }
            .h-100 {
                height: 100% !important;
            }
            .custom-button {
                background-color: #3fbbc0;
                color: white;
                border: none;
                padding: 7px 14px;
                cursor: pointer;
                border-radius: 5px;
                transition: background-color 0.3s ease;
            }

            .custom-button:hover {
                background-color: #65c9cd;
            }
        </style>
    </head>

    <body>
        <div class="container-xl px-4 mt-4">

            <hr class="mt-0 mb-4">
            <div class="row">
                <div class="col-lg-4 mb-4">
                    <!-- Billing card 1-->
                    <div class="card h-100 border-start-lg border-start-primary">
                        <div class="card-body">
                            <div class="small text-muted">Bill Total Price</div>
                            <div class="h3">${TOTAL} $</div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 mb-4">
                    <!-- Billing card 2-->
                    <div class="card h-100 border-start-lg border-start-secondary">
                        <div class="card-body">
                            <div class="small text-muted">Booked Date</div>
                            <div class="h3">${DATE}</div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 mb-4">
                    <!-- Billing card 3-->
                    <div class="card h-100 border-start-lg border-start-success">
                        <div class="card-body">
                            <div class="small text-muted">Choose Children</div>
                            <div class="h3 d-flex align-items-center">
                                <select class="form-control" style="font-size: 15px;">
                                    <c:forEach var="children" items="${CHILDREN_LIST}">
                                        <option value="${children.childrenId}">${children.name}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <a class="text-arrow-icon small text-success" href="MyChildren">
                                Add New Children
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-arrow-right"><line x1="5" y1="12" x2="19" y2="12"></line><polyline points="12 5 19 12 12 19"></polyline></svg>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Payment methods card-->
            <div class="card card-header-actions mb-4">
                <div class="card-header">
                    <div class="row align-items-center">
                        <div class="col">
                            Choose Doctor
                        </div>
                    </div>
                </div>
                <div class="card-body px-0">
                    <!-- Payment method 1-->
                    <div class="d-flex align-items-center justify-content-between px-4">
                        <p style="margin-right: 30px;">Doctor</p>
                        <select class="form-control" style="font-size: 15px;">
                            <c:forEach var="doctor" items="${DOCTOR_LIST}">
                                <option value="${doctor.accountId}">${doctor.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <hr>
                    <!-- Payment method 3-->
                    <div class="d-flex align-items-center justify-content-between px-4">
                        <p style="margin-right: 30px;">Date</p>
                        <input type="date" class="form-control" style="font-size: 15px;" name="chosenDate">
                    </div>
                    <hr>
                    <!-- Payment method 2-->
                    <div class="d-flex align-items-center justify-content-between px-4">
                        <p style="margin-right: 30px;">Slot</p>
                        <select class="form-control" style="font-size: 15px;">
                            <c:forEach var="slot" items="${SLOT_LIST}">
                                <option value="${slot.slotId}">Slot ${slot.slotId}: ${slot.startTime} - ${slot.endTime}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <hr>
                    <div class="d-flex align-items-center justify-content-between px-4">
                        <p style="margin-right: 30px;">Status</p>
                        <c:if test="${STATUS eq null}">
                            <p style="color: red;">Please Check Before Submit</p>
                        </c:if>
                        <c:if test="${STATUS ne null}">
                            <input type="text" name="txtStatus" style="color: green;" value="${STATUS}">
                        </c:if>
                    </div>
                    <hr>
                    <c:if test="${STATUS eq null}">
                        <div class="d-flex align-items-center justify-content-center px-4">
                            <button class="custom-button" type="button">Check Availability</button>
                        </div>
                    </c:if>
                </div>
            </div>

            <!-- Billing history card-->
            <div class="card mb-4">
                <div class="card-header">
                    <div class="row align-items-center">
                        <div class="col">
                            Billing History
                        </div>
                        <div class="col-auto">
                            <a href="ReservationDetail">
                                <button class="custom-button" type="button">Change Service(s) Chosen List</button>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="card-body p-0">
                    <!-- Billing history table-->
                    <div class="table-responsive table-billing-history">
                        <table class="table mb-0">
                            <thead>
                                <tr>
                                    <th class="border-gray-200 text-center" scope="col">Image</th>
                                    <th class="border-gray-200 text-center" scope="col">Service ID</th>
                                    <th class="border-gray-200 text-center" scope="col">Category</th>
                                    <th class="border-gray-200 text-center" scope="col">Name</th>
                                    <th class="border-gray-200 text-center" scope="col">Price</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="service" items="${CHOSEN_SERVICE_LIST}">
                                    <tr>
                                        <td class="text-center"> <img src="assets/img/service/${service.image}" alt="alt" width="90px"
                                                                      class="mx-auto d-block" /> </td>
                                        <td class="text-center" style="padding-top: 30px;">${service.serviceId}</td>
                                        <td class="text-center" style="padding-top: 30px;">
                                            <c:forEach var="category" items="${CATEGORY_LIST}">
                                                <c:if test="${category.categoryId eq service.categoryId}">
                                                    ${category.name}
                                                </c:if>
                                            </c:forEach>
                                        </td>
                                        <td class="text-center" style="padding-top: 30px;">${service.name}</td>
                                        <td class="text-center" style="padding-top: 30px;">${service.price - (service.price * (service.discount/100))}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                    </div>
                </div>
            </div>
            <!-- Payment methods card-->
            <div class="card card-header-actions mb-4">
                <div class="card-header">
                    <div class="row align-items-center">
                        <div class="col">
                            Billing History
                        </div>
                        <div class="col-auto">
                            <a href="#">
                                <button class="custom-button" type="button">Change Service(s) Chosen List</button>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="card-body px-0">
                    <!-- Payment method 1-->
                    <div class="d-flex align-items-center justify-content-between px-4">
                        <div class="d-flex align-items-center">
                            <i class="fab fa-cc-visa fa-2x cc-color-visa"></i>
                            <div class="ms-4">
                                <div class="small">Visa ending in 1234</div>
                                <div class="text-xs text-muted">Expires 04/2024</div>
                            </div>
                        </div>
                        <div class="ms-4 small">
                            <div class="badge bg-light text-dark me-3">Default</div>
                            <a href="#!">Edit</a>
                        </div>
                    </div>
                    <hr>
                    <!-- Payment method 2-->
                    <div class="d-flex align-items-center justify-content-between px-4">
                        <div class="d-flex align-items-center">
                            <i class="fab fa-cc-mastercard fa-2x cc-color-mastercard"></i>
                            <div class="ms-4">
                                <div class="small">Mastercard ending in 5678</div>
                                <div class="text-xs text-muted">Expires 05/2022</div>
                            </div>
                        </div>
                        <div class="ms-4 small">
                            <a class="text-muted me-3" href="#!">Make Default</a>
                            <a href="#!">Edit</a>
                        </div>
                    </div>
                    <hr>
                    <!-- Payment method 3-->
                    <div class="d-flex align-items-center justify-content-between px-4">
                        <div class="d-flex align-items-center">
                            <i class="fab fa-cc-amex fa-2x cc-color-amex"></i>
                            <div class="ms-4">
                                <div class="small">American Express ending in 9012</div>
                                <div class="text-xs text-muted">Expires 01/2026</div>
                            </div>
                        </div>
                        <div class="ms-4 small">
                            <a class="text-muted me-3" href="#!">Make Default</a>
                            <a href="#!">Edit</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="card card-header-actions mb-4">
                <button class="custom-button" style="height: 50px;" type="submit">MAKE RESERVATION</button>
            </div>
        </div>
    </body>

</html>

