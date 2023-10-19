<%-- 
    Document   : patient_manager_include
    Created on : Oct 19, 2023, 2:56:48 AM
    Author     : duchi
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Bootstrap CRUD Data Table for Database with Modal Form</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <style>
            body {
                color: #566787;
                background: #f5f5f5;
                font-family: 'Varela Round', sans-serif;
                font-size: 13px;
                margin: 0;
            }
            .table-responsive {
                margin: 30px 0;
            }
            .table-wrapper {
                background: #fff;
                padding: 20px 25px;
                border-radius: 3px;
                min-width: 1000px;
                box-shadow: 0 1px 1px rgba(0,0,0,.05);
            }
            .table-title {
                padding-bottom: 15px;
                background: #435d7d;
                color: #fff;
                padding: 16px 30px;
                min-width: 100%;
                margin: -20px -25px 10px;
                border-radius: 3px 3px 0 0;
            }
            .table-title h2 {
                margin: 5px 0 0;
                font-size: 24px;
            }
            .table-title .btn-group {
                float: right;
            }
            .table-title .btn {
                color: #fff;
                float: right;
                font-size: 13px;
                border: none;
                min-width: 50px;
                border-radius: 2px;
                border: none;
                outline: none !important;
                margin-left: 10px;
            }
            .table-title .btn i {
                float: left;
                font-size: 21px;
                margin-right: 5px;
            }
            .table-title .btn span {
                float: left;
                margin-top: 2px;
            }
            table.table tr th, table.table tr td {
                border-color: #e9e9e9;
                padding: 12px 15px;
                vertical-align: middle;
            }
            table.table tr th:first-child {
                width: 30px;
            }
            table.table tr th:last-child {
                width: 100px;
            }
            table.table-striped tbody tr:nth-of-type(odd) {
                background-color: #fcfcfc;
            }
            table.table-striped.table-hover tbody tr:hover {
                background: #f5f5f5;
            }
            table.table th i {
                font-size: 13px;
                margin: 0 5px;
                cursor: pointer;
            }
            table.table td:last-child i {
                opacity: 0.9;
                font-size: 22px;
                margin: 0 5px;
            }


            table.table .avatar {
                border-radius: 50%;
                vertical-align: middle;
                margin-right: 10px;
            }
            .pagination {
                float: right;
                margin: 0 0 5px;
            }
            .pagination li a {
                border: none;
                font-size: 13px;
                min-width: 30px;
                min-height: 30px;
                color: #999;
                margin: 0 2px;
                line-height: 30px;
                border-radius: 2px !important;
                text-align: center;
                padding: 0 6px;
            }
            .pagination li a:hover {
                color: #666;
            }
            .pagination li.active a, .pagination li.active a.page-link {
                background: #03A9F4;
            }
            .pagination li.active a:hover {
                background: #0397d6;
            }
            .pagination li.disabled i {
                color: #ccc;
            }
            .pagination li i {
                font-size: 16px;
                padding-top: 6px
            }
            .hint-text {
                float: left;
                margin-top: 10px;
                font-size: 13px;
            }
            /* Custom checkbox */
            .custom-checkbox {
                position: relative;
            }
            .custom-checkbox input[type="checkbox"] {
                opacity: 0;
                position: absolute;
                margin: 5px 0 0 3px;
                z-index: 9;
            }
            .custom-checkbox label:before{
                width: 18px;
                height: 18px;
            }
            .custom-checkbox label:before {
                content: '';
                margin-right: 10px;
                display: inline-block;
                vertical-align: text-top;
                background: white;
                border: 1px solid #bbb;
                border-radius: 2px;
                box-sizing: border-box;
                z-index: 2;
            }
            .custom-checkbox input[type="checkbox"]:checked + label:after {
                content: '';
                position: absolute;
                left: 6px;
                top: 3px;
                width: 6px;
                height: 11px;
                border: solid #000;
                border-width: 0 3px 3px 0;
                transform: inherit;
                z-index: 3;
                transform: rotateZ(45deg);
            }
            .custom-checkbox input[type="checkbox"]:checked + label:before {
                border-color: #03A9F4;
                background: #03A9F4;
            }
            .custom-checkbox input[type="checkbox"]:checked + label:after {
                border-color: #fff;
            }
            .custom-checkbox input[type="checkbox"]:disabled + label:before {
                color: #b8b8b8;
                cursor: auto;
                box-shadow: none;
                background: #ddd;
            }
            /* Modal styles */
            .modal .modal-dialog {
                max-width: 400px;
            }
            .modal .modal-header, .modal .modal-body, .modal .modal-footer {
                padding: 20px 30px;
            }
            .modal .modal-content {
                border-radius: 3px;
                font-size: 14px;
            }
            .modal .modal-footer {
                background: #ecf0f1;
                border-radius: 0 0 3px 3px;
            }
            .modal .modal-title {
                display: inline-block;
            }
            .modal .form-control {
                border-radius: 2px;
                box-shadow: none;
                border-color: #dddddd;
            }
            .modal textarea.form-control {
                resize: vertical;
            }
            .modal .btn {
                border-radius: 2px;
                min-width: 100px;
            }
            .modal form label {
                font-weight: normal;
            }
            .address-cell {
                max-width: 200px; /* Đặt giới hạn chiều rộng của cell */
                overflow: hidden;
                text-overflow: ellipsis; /* Thêm hiệu ứng tròn (ellipsis) cho văn bản dài */
                white-space: nowrap;
            }
        </style>
        <script>
            $(document).ready(function () {
                // Activate tooltip
                $('[data-toggle="tooltip"]').tooltip();

                // Select/Deselect checkboxes
                var checkbox = $('table tbody input[type="checkbox"]');
                $("#selectAll").click(function () {
                    if (this.checked) {
                        checkbox.each(function () {
                            this.checked = true;
                        });
                    } else {
                        checkbox.each(function () {
                            this.checked = false;
                        });
                    }
                });
                checkbox.click(function () {
                    if (!this.checked) {
                        $("#selectAll").prop("checked", false);
                    }
                });
            });
        </script>
    </head>
    <body>
        <div class="container-xxl">
            <div class="table-responsive">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-6">
                                <h2>Manage <b>Patients</b></h2>
                            </div>
                            <div class="col-sm-6">
                                <a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Patient</span></a>						
                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>    
                                <th>-</th>
                                <th>Patient ID</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Gender</th>
                                <th>Address</th>
                                <th>Phone</th>
                                <th>Status</th>
                                <th>Actions</th>

                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="patient" items="${PATIENT_LIST}" varStatus="loop">
                            <form action="Patient" method="post">
                                <tr>
                                    <td>${loop.index + 1}</td>
                                    <td>ID: ${patient.accountId}</td>
                                    <td>${patient.name}</td>
                                    <td>${patient.email}</td>
                                    <td>
                                        <c:if test="${patient.gender eq true}">
                                            Male
                                        </c:if>
                                        <c:if test="${patient.gender eq false}">
                                            Female
                                        </c:if>
                                    </td>
                                    <td class="address-cell">${patient.address}</td>
                                    <td>${patient.phone}</td>
                                    <td>
                                        <c:if test="${patient.statusId == 1}">
                                            <p style="color: orange; margin-bottom: 0">Pending</p>
                                        </c:if>
                                        <c:if test="${patient.statusId == 2}">
                                            <p style="color: green; margin-bottom: 0">Activated</p>
                                        </c:if>
                                        <c:if test="${patient.statusId == 3}">
                                            <p style="color: red; margin-bottom: 0">Flagged</p>
                                        </c:if>
                                    </td>
                                    <td>
                                        <button type="button" name="txtType" class="editBtn"
                                                data-id="${patient.accountId}"
                                                data-username="${patient.username}"
                                                data-password="${patient.password}"
                                                data-email="${patient.email}"
                                                data-phone="${patient.phone}"
                                                data-name="${patient.name}"
                                                data-gender="${patient.gender}"
                                                data-address="${patient.address}"
                                                data-status="${patient.statusId}"
                                                style="font-weight: thin; color: green; margin: 3px; background: none; border: none;">
                                            <i class="fas fa-pencil" style="font-size: 20px;"></i>
                                        </button>
                                        <button type="button" class="deleteBtn" name="txtType" style="font-weight: thin; color: red; margin: 3px; background: none; border: none;" data-accountid="${patient.accountId}">
                                            <i class="fas fa-trash"  style="font-size: 20px;"></i>
                                        </button>
                                    </td>

                                </tr>
                            </form>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>        
        </div>


        <!-- Edit Modal HTML -->
        <div id="editEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="Patient" method="POST">
                        <div class="modal-header">
                            <h4 class="modal-title">Edit Patient</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">	
                            <div class="form-group">
                                <label>ID</label>
                                <input type="text" value="txtID" name="txtID" id="IDvalue" class="form-control" readonly>
                            </div>
                            <div class="form-group">
                                <label>Username</label>
                                <input type="text" value="txtUsername" id="Usernamevalue" class="form-control" name="txtUsername" required>
                            </div>
                            <div class="form-group">
                                <label>Password</label>
                                <input type="password" value="txtPassword" id="Passwordvalue" class="form-control" name="txtPassword" required>
                            </div>
                            <div class="form-group">
                                <label>Phone</label>
                                <input type="number" value="txtPhone" id="Phonevalue" class="form-control" name="txtPhone" required>
                            </div>
                            <div class="form-group">
                                <label>Email</label>
                                <input type="email" value="txtEmail" id="Emailvalue" class="form-control" name="txtEmail" required>
                            </div>
                            <div class="form-group">
                                <label>Name</label>
                                <input type="text" value="txtName" id="Namevalue" class="form-control" name="txtName" required>
                            </div>
                            <div class="form-group">
                                <label>Address</label>
                                <textarea value="txtAddress" id="Addressvalue" class="form-control" name="txtAddress"></textarea>
                            </div>
                            <div class="form-group">
                                <label>Gender</label>
                                <select class="form-control" name="txtGender" id="genderSelect" required>
                                    <option value="true">Male</option>
                                    <option value="false">Female</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Status</label>
                                <select class="form-control" name="txtStatus" id="statusSelect" required>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                </select>
                            </div>


                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-success" name="txtType" value="Save">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Edit Modal HTML -->

        <!-- Edit Modal HTML -->
        <div id="addEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="Patient" method="POST">
                        <div class="modal-header">						
                            <h4 class="modal-title">Add Patient</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            <div class="form-group">
                                <label>Username</label>
                                <input type="text" class="form-control" name="txtUsername" required>
                            </div>
                            <div class="form-group">
                                <label>Password</label>
                                <input type="password" class="form-control" name="txtPassword" required>
                            </div>
                            <div class="form-group">
                                <label>Phone</label>
                                <input type="number" class="form-control" name="txtPhone" required>
                            </div>
                            <div class="form-group">
                                <label>Email</label>
                                <input type="email" class="form-control" name="txtEmail" required>
                            </div>
                            <div class="form-group">
                                <label>Name</label>
                                <input type="text" class="form-control" name="txtName" required>
                            </div>
                            <div class="form-group">
                                <label>Gender</label>
                                <select class="form-control" name="txtGender" id="genderSelect" required>
                                    <option value="male">Male</option>
                                    <option value="female">Female</option>
                                </select>
                            </div>


                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-success" name="txtType" value="Add">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Edit Modal HTML -->

        <!--remove modal begin-->
        <div id="deleteEmployeeModal" class="modal fade">
            <div class="modal-dialog" style="margin-top: 180px;">
                <div class="modal-content">
                    <form method="post" action="Patient">
                        <div class="modal-header">						
                            <div class="form-group">
                                <label>Delete Patient ID</label>
                                <input type="text" class="form-control" style="width: 40px" name="txtID" id="IDvaluee" value="" readonly>
                            </div>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            <p>Are you sure you want to delete these Records?</p>
                            <p class="text-warning"><small>This action cannot be undone.</small></p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                            <input type="submit" name="txtType" class="btn btn-danger" value="Delete">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!--remove modal end-->

        <script>
            document.querySelectorAll('.deleteBtn').forEach(function (button) {
                button.addEventListener('click', function () {
                    var accountId = this.getAttribute('data-accountid');
                    // Thiết lập giá trị accountId cho modal

                    //change
                    document.querySelector('#IDvaluee').value = accountId;
                    // Mở modal
                    $('#deleteEmployeeModal').modal('show');
                });
            });

            // Bắt sự kiện click của nút "Cancel" và nút "X"
            document.querySelector('#deleteEmployeeModal .modal-footer .btn-default').addEventListener('click', function () {
                // Đóng modal
                $('#deleteEmployeeModal').modal('hide');
            });

            document.querySelector('#deleteEmployeeModal .modal-header .close').addEventListener('click', function () {
                // Đóng modal
                $('#deleteEmployeeModal').modal('hide');
            });
            document.querySelector('#editEmployeeModal .modal-footer .btn-default').addEventListener('click', function () {
                // Đóng modal
                $('#editEmployeeModal').modal('hide');
            });
            // Bắt sự kiện khi người dùng nhấn phím trên bàn phím
            document.addEventListener('keydown', function (event) {
                // Kiểm tra nếu phím nhấn là phím "Esc" (mã 27)
                if (event.keyCode === 27) {
                    // Đóng modal khi nhấn phím "Esc"
                    $('#deleteEmployeeModal').modal('hide');
                }
            });
// Bắt sự kiện khi người dùng nhấn phím trên bàn phím
            document.addEventListener('keydown', function (event) {
                // Kiểm tra nếu phím nhấn là phím "Esc" (mã 27)
                if (event.keyCode === 27) {
                    // Đóng modal khi nhấn phím "Esc"
                    $('#editEmployeeModal').modal('hide');
                }
            });
            document.querySelector('#editEmployeeModal .modal-header .close').addEventListener('click', function () {
                // Đóng modal
                $('#editEmployeeModal').modal('hide');
            });


            //edit button
            document.querySelectorAll('.editBtn').forEach(function (button) {
                button.addEventListener('click', function () {
                    var id = this.getAttribute('data-id');
                    var username = this.getAttribute('data-username');
                    var password = this.getAttribute('data-password');
                    var email = this.getAttribute('data-email');
                    var phone = this.getAttribute('data-phone');
                    var name = this.getAttribute('data-name');
                    var gender = this.getAttribute('data-gender');
                    var genderSelect = document.getElementById('genderSelect');
                    var address = this.getAttribute('data-address');
                    var status = this.getAttribute('data-status');
                    var statusSelect = document.getElementById('statusSelect');
                    //change
                    document.querySelector('#IDvalue').value = id;
                    document.querySelector('#Usernamevalue').value = username;
                    document.querySelector('#Passwordvalue').value = password;
                    document.querySelector('#Emailvalue').value = email;
                    document.querySelector('#Phonevalue').value = phone;
                    document.querySelector('#Namevalue').value = name;
                    // Dựa trên giá trị boolean gender, chọn tùy chọn trong dropdown
                    if (gender === 'true') {
                        genderSelect.value = 'true';
                    } else if (gender === 'false') {
                        genderSelect.value = 'false';
                    }
                    // Dựa trên giá trị status, chọn tùy chọn trong dropdown
                    if (status === '1') {
                        statusSelect.value = '1';
                    } else if (status === '2') {
                        statusSelect.value = '2';
                    } else if (status === '3') {
                        statusSelect.value = '3';
                    }

                    document.querySelector('#Addressvalue').value = address;
                    //document.querySelector('#Statusvalue').value = accountId;
                    $('#editEmployeeModal').modal('show');
                });
            });


        </script>
    </body>
</html>
