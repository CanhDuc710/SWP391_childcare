<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">


        <title>Enter Email</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- CSS FILES -->        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <style type="text/css">
            body{
                background-color:#eee;
            }
            .social-btn {
                display: inline-block;
                width: 2.25rem;
                height: 2.25rem;
                -webkit-transition: border-color 0.25s ease-in-out,background-color 0.25s ease-in-out,color 0.25s ease-in-out;
                transition: border-color 0.25s ease-in-out,background-color 0.25s ease-in-out,color 0.25s ease-in-out;
                border: 1px solid #e7e7e7;
                border-radius: 50%;
                background-color: #fff;
                color: #545454;
                text-align: center;
                text-decoration: none;
                line-height: 2.125rem;
                vertical-align: middle;
            }
            .form-control {
                display: block;
                width: 100%;
                height: calc(1.5em + 1rem + 2px);
                padding: .5rem 1rem;
                font-size: 1rem;
                font-weight: 400;
                line-height: 1.5;
                color: #404040;
                background-color: #fff;
                background-clip: padding-box;
                border: 1px solid #e1e1e1;
                border-radius: 0;
                -webkit-transition: border-color 0.2s ease-in-out,-webkit-box-shadow 0.2s ease-in-out;
                transition: border-color 0.2s ease-in-out,-webkit-box-shadow 0.2s ease-in-out;
                transition: border-color 0.2s ease-in-out,box-shadow 0.2s ease-in-out;
                transition: border-color 0.2s ease-in-out,box-shadow 0.2s ease-in-out,-webkit-box-shadow 0.2s ease-in-out;
            }
            .input-group>.form-control, .input-group>.form-control-plaintext, .input-group>.custom-select, .input-group>.custom-file {
                position: relative;
                -webkit-box-flex: 1;
                -ms-flex: 1 1 auto;
                flex: 1 1 auto;
                width: 1%;
                margin-bottom: 0;
            }
            .input-group-text {
                display: -webkit-box;
                display: -ms-flexbox;
                display: flex;
                -webkit-box-align: center;
                -ms-flex-align: center;
                align-items: center;
                padding: .5rem 1rem;
                margin-bottom: 0;
                font-size: 1rem;
                font-weight: 400;
                line-height: 1.5;
                color: #404040;
                text-align: center;
                white-space: nowrap;
                background-color: #fff;
                border: 1px solid #e1e1e1;
            }

            .svg-icon {
                width: 1.5em;
                height: 1.5em;
            }

            .svg-icon path,
            .svg-icon polygon,
            .svg-icon rect {
                fill: #4691f6;
            }

            .svg-icon circle {
                stroke: #4691f6;
                stroke-width: 1;
            }

        </style>
    </head>
    <body>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
        <div class="container pb-5 mb-sm-4">
            <div class="row pt-5">
                <div class="col-md-6 pt-sm-3 mx-auto my-auto">
                    <div class="card">
                        <div class="card-body" style="display: flex; flex-direction: column; align-items: center; justify-content: center;" >
                            <input class="form-control text-center" type="password" name="txtPassword" placeholder="Enter Email For Sending Verification" readonly>
                            <h2 class="h4 mb-4 mt-4">Enter Email</h2>

                            <form action="SendEmail" method="POST">
                                <div class="input-group form-group">

                                    <input class="form-control text-center" style="width: 400px;" type="email" name="txtEmail" placeholder="Your Email" required >
                                </div>
                                <div class="d-flex flex-wrap justify-content-between">
                                    </br>

                                </div>

                                <input type="hidden" name="txtTy" value="staff">
                                <div style="text-align: center;">
                                    <button class="btn btn-primary" type="submit">SEND</button>
                                    <br/>
                                    <label class="mt-3" style="color: green;">${MESSAGE}</label>
                                </div>

                                <input type="hidden" name="isPassword" value="false" />
                            </form>



                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js"></script>
        <script type="text/javascript">

        </script>
    </body>
</html>
