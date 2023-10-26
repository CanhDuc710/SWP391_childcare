<%-- 
    Document   : reset
    Created on : Sep 25, 2023, 3:20:42 PM
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
            html, body {
                height: 100%;
            }

            body {
                display: flex;
                justify-content: center;
                align-items: center;
                background-color: #f5f5f5;
                height: 100vh; /* Đảm bảo body có chiều cao 100% của viewport */
                margin: 0; /* Loại bỏ khoảng cách lề của body mặc định */
            }

            form {
                padding-top: 10px;
                font-size: 14px;
                margin-top: 30px;
            }

            .card-title {
                font-weight: 300;
            }

            .btn {
                font-size: 14px;
                margin-top: 20px;
                margin-left: 120px;
            }

            .login-form {
                width: 320px;
                margin: 20px;
            }

            .sign-up {
                text-align: center;
                padding: 20px 0 0;
            }

            span {
                font-size: 14px;
            }

        </style>


    </head>
    <body>
        <div class="card login-form">
            <div class="card-body">
                <h3 class="card-title text-center">Reset password</h3>

                <div class="card-text">
                    <form method="POST" action="Reset">
                        <div class="form-group">
                            <label for="exampleInputEmail1" style="margin-bottom: 30px;">Enter Your New Password</label>
                            <input type="password" class="form-control form-control-sm" placeholder="New Password" style="text-align: center" name="txtNew">
                            <input type="password" class="form-control form-control-sm" placeholder="Confirmed Password" style="text-align: center" name="txtConfirm">
                        </div>
                        Status: ${CHANGE_MESSAGE} <br/>
                        <button type="submit" class="btn btn-primary btn-block" >Save</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
