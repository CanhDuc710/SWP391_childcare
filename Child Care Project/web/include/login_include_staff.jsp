<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">


        <title>Sign In and Sign Up Page - Bootdey.com</title>
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
                        <div class="card-body">
                            <h2 class="h4 mb-1">Sign in</h2>


<!--                            <div class="d-sm-flex align-items-center py-3">
                                <h3 class="h6 font-weight-semibold opacity-70 mb-3 mb-sm-2 mr-sm-3">With Social Account</h3>
                                <div>
                                    <a class="social-btn sb-google mr-2 mb-2" href="#" data-toggle="tooltip" title data-original-title="Sign in with Twitter">
                                        <i class="fa fa-google"></i>
                                    </a>
                                </div>
                            </div>-->


                            <hr>
                            <h3 class="h6 font-weight-semibold opacity-70 pt-4 pb-2">Username And Password</h3>

                            <form class="needs-validation" action="Login" method="POST">
                                <div class="input-group form-group">
                                    <div class="input-group-prepend"><span class="input-group-text"><svg class="svg-icon" viewBox="0 0 20 20">
                                            <path d="M12.075,10.812c1.358-0.853,2.242-2.507,2.242-4.037c0-2.181-1.795-4.618-4.198-4.618S5.921,4.594,5.921,6.775c0,1.53,0.884,3.185,2.242,4.037c-3.222,0.865-5.6,3.807-5.6,7.298c0,0.23,0.189,0.42,0.42,0.42h14.273c0.23,0,0.42-0.189,0.42-0.42C17.676,14.619,15.297,11.677,12.075,10.812 M6.761,6.775c0-2.162,1.773-3.778,3.358-3.778s3.359,1.616,3.359,3.778c0,2.162-1.774,3.778-3.359,3.778S6.761,8.937,6.761,6.775 M3.415,17.69c0.218-3.51,3.142-6.297,6.704-6.297c3.562,0,6.486,2.787,6.705,6.297H3.415z"></path>
                                            </svg></span></div>
                                    <input class="form-control" type="text" name="txtUsername" placeholder="Username" required >
                                </div>
                                <div class="input-group form-group">
                                    <div class="input-group-prepend"><span class="input-group-text"><svg class="svg-icon" viewBox="0 0 20 20">
                                            <path d="M17.308,7.564h-1.993c0-2.929-2.385-5.314-5.314-5.314S4.686,4.635,4.686,7.564H2.693c-0.244,0-0.443,0.2-0.443,0.443v9.3c0,0.243,0.199,0.442,0.443,0.442h14.615c0.243,0,0.442-0.199,0.442-0.442v-9.3C17.75,7.764,17.551,7.564,17.308,7.564 M10,3.136c2.442,0,4.43,1.986,4.43,4.428H5.571C5.571,5.122,7.558,3.136,10,3.136 M16.865,16.864H3.136V8.45h13.729V16.864z M10,10.664c-0.854,0-1.55,0.696-1.55,1.551c0,0.699,0.467,1.292,1.107,1.485v0.95c0,0.243,0.2,0.442,0.443,0.442s0.443-0.199,0.443-0.442V13.7c0.64-0.193,1.106-0.786,1.106-1.485C11.55,11.36,10.854,10.664,10,10.664 M10,12.878c-0.366,0-0.664-0.298-0.664-0.663c0-0.366,0.298-0.665,0.664-0.665c0.365,0,0.664,0.299,0.664,0.665C10.664,12.58,10.365,12.878,10,12.878"></path>
                                            </svg></span></div>
                                    <input class="form-control" type="password" name="txtPassword" placeholder="Password" required>
                                </div>
                                <div class="d-flex flex-wrap justify-content-between">
                                    <a class="nav-link-inline font-size-sm" style="margin-top: 10px;" href="ResetPassword">Forgot password?</a>
                                    </br>
                                    <label style="color: rgba(255,0,0,0.8); font-weight: bold; margin-top: 10px;">${LOGIN_VALID}</label>
                                </div>

                                <input type="hidden" name="txtType" value="staff">
                                <hr class="mt-4">
                                <div class="text-right pt-4">
                                    <button class="btn btn-primary" type="submit">Sign In</button>
                                </div>
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
