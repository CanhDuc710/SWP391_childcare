<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">


        <title>Sign In and Sign Up Page - Bootdey.com</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <style type="text/css">
            body{
                background:#F0F8FF;
            }
            .card {
                margin-bottom: 1.5rem;
                box-shadow: 0 1px 15px 1px rgba(52,40,104,.08);
            }
            .card {
                position: relative;
                display: -ms-flexbox;
                display: flex;
                -ms-flex-direction: column;
                flex-direction: column;
                min-width: 0;
                word-wrap: break-word;
                background-color: #fff;
                background-clip: border-box;
                border: 1px solid #e5e9f2;
                border-radius: .2rem;
            }
            .card-header:first-child {
                border-radius: calc(.2rem - 1px) calc(.2rem - 1px) 0 0;
            }
            .card-header {
                border-bottom-width: 1px;
            }
            .card-header {
                padding: .75rem 1.25rem;
                margin-bottom: 0;
                color: inherit;
                background-color: #fff;
                border-bottom: 1px solid #e5e9f2;
            }

        </style>
    </head>
    <body>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />

        <div class="container p-0">
            <h1 class="h3 mb-3" style="margin: 20px 0px; text-align: center;">Account</h1>
            <div class="row">
                <div class="col-md-5 col-xl-4">

                    <div class="card">
                        <div class="card-header">
                            <h5 class="card-title mb-0">Setting</h5>
                        </div>

                        <div class="list-group list-group-flush" role="tablist">
                            <a class="list-group-item list-group-item-action active" data-toggle="list" href="#account" role="tab">
                                Account
                            </a>
                            <a class="list-group-item list-group-item-action" data-toggle="list" href="#password" role="tab">
                                Password
                            </a>

                            <a class="list-group-item list-group-item-action" style="font-weight: bold; color: red; " href="Logout" role="tab">
                                Logout
                            </a>
                        </div>
                    </div>
                </div>

                <div class="col-md-7 col-xl-8">
                    <div class="tab-content">


                        <div class="tab-pane fade show active" id="account" role="tabpanel">
                            <div class="card">
                                <div class="card-header">




                                    <h5 class="card-title mb-0">Account Information</h5>
                                </div>
                                <div class="card-body">
                                    <form>
                                        <div class="row">
                                            <div class="col-md-8">

                                                <div class="form-group">
                                                    <label for="inputUsername">Account ID</label>
                                                    <input type="text" class="form-control" value="ACC_0${LOGIN_ACCOUNT.account_id}" readonly>
                                                </div>

                                                <div class="form-group">
                                                    <label for="inputUsername">Username</label>
                                                    <input type="text" class="form-control" value="${LOGIN_ACCOUNT.username}" readonly>
                                                </div>


                                                <div class="form-group">
                                                    <label for="inputUsername">Password</label>
                                                    <input type="password" class="form-control" value="${LOGIN_ACCOUNT.password}" readonly>
                                                </div>

                                            </div>         
                                        </div>
                                    </form>

                                </div>
                            </div>



                            <div class="card">
                                <div class="card-header">
                                    <h5 class="card-title mb-0">Update Information</h5>
                                </div>
                                <div class="card-body">
                                    <form method="post" action="Update">
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label for="inputFirstName">Full name</label>
                                                <input type="text" class="form-control" name="txtUpdateName" value="${LOGIN_ACCOUNT.name}">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputEmail4">Email</label>
                                            <input type="hidden" name="email_first" value="${LOGIN_ACCOUNT.email}">
                                            <input type="email" class="form-control" name="txtUpdateEmail" value="${LOGIN_ACCOUNT.email}">
                                        </div>
                                        <div class="form-group">
                                            <label for="inputAddress">Phone Number</label>
                                            <input type="hidden" name="phone_first" value="${LOGIN_ACCOUNT.phone}">
                                            <input type="text" class="form-control" name="txtUpdatePhone" value="${LOGIN_ACCOUNT.phone}">
                                        </div>

                                        <input type="hidden" name="txtID" value="${ACCOUNT.account_id}">
                                        <button type="submit" name="action" class="btn btn-primary" value="Save changes">Save changes</button>


                                    </form>
                                </div>
                            </div>
                        </div>





                        <div class="tab-pane fade" id="password" role="tabpanel">
                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title">Password</h5>

                                    <form method="post" action="Update">
                                        <div class="form-group">
                                            <label for="inputPasswordCurrent">Current password</label>
                                            <input type="password" class="form-control" id="inputPasswordCurrent" name="old_password">
                                            <small><a href="#">Forgot your password?</a></small>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPasswordNew">New password</label>
                                            <input type="password" class="form-control" id="inputPasswordNew" name="change_password">
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPasswordNew2">Verify password</label>
                                            <input type="password" class="form-control" id="inputPasswordNew2" name="confirm_password">
                                        </div>
                                        <input type="hidden" name="txtID" value="${LOGIN_ACCOUNT.accountId}">
                                        <button type="submit" class="btn btn-primary" name="action" value="changePassword" >Save changes</button>
                                    </form>
                                    ${CHANGE_MESSAGE}
                                </div>
                            </div>
                        </div>



                        <!--comment-->
                        <div class="tab-pane fade" id="comment" role="tabpanel">
                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title">Comment list</h5>


                                </div>
                            </div>
                        </div>



                        <!--shop manager-->
                        <div class="tab-pane fade" id="yourproduct" role="tabpanel">
                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title">Shop Product List Manager</h5>

                                    <table border="1" style="text-align: center;">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Type</th>
                                                <th>Name</th>
                                                <th>Detail</th>
                                                <th>Quantity</th>
                                                <th>Price</th>
                                                <th>Rate</th>
                                                <th>Image</th>
                                                <th>Created</th>
                                                <th>Updated</th>
                                                <th>Status</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="product" items="${SELLER_PRODUCT_LIST}">
                                                <tr>
                                                    <td> ${product.productId}  </td>
                                                    <td> ${product.categoryId}  </td>
                                                    <td> ${product.name}  </td>
                                                    <td> ${product.detail}  </td>
                                                    <td> ${product.quantity}  </td>
                                                    <td> $${product.price}  </td>
                                                    <td> ${product.rate}  </td>
                                                    <td> <img src="images/${product.image}" alt="" style="width: 100px; height: 100px;">  </td>
                                                    <td> ${product.createdAt}  </td>
                                                    <td> ${product.updatedAt}  </td>
                                                    <td> 
                                                        <c:if test="${product.status eq 1}">
                                                            <label style="color: green">actived</label>
                                                        </c:if>
                                                        <c:if test="${product.status eq 0}">
                                                            <label style="color: red">deactived</label>
                                                        </c:if>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>


                                </div>
                            </div>
                        </div>

                        <!--product upload-->
                        <div class="tab-pane fade" id="uploadproduct" role="tabpanel">
                            <div class="card">
                                <div class="card-header">
                                    <h5 class="card-title mb-0">Upload Product</h5>
                                </div>
                                <div class="card-body">
                                    <form method="post" action="Add-Product">
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label for="inputFirstName">Product Name</label>
                                                <input type="text" class="form-control" name="txtUpdateName" value="">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputEmail4">Email</label>
                                            <input type="hidden" name="email_first" value="${LOGIN_ACCOUNT.email}">
                                            <input type="email" class="form-control" name="txtUpdateEmail" value="${LOGIN_ACCOUNT.email}">
                                        </div>
                                        <div class="form-group">
                                            <label for="inputAddress">Phone Number</label>
                                            <input type="hidden" name="phone_first" value="${LOGIN_ACCOUNT.phone}">
                                            <input type="text" class="form-control" name="txtUpdatePhone" value="${LOGIN_ACCOUNT.phone}">
                                        </div>
                                        <div class="form-group">
                                            <label for="inputAddress2">Address</label>
                                            <input type="text" class="form-control" name="txtUpdateAddress" value="${LOGIN_ACCOUNT.address}">
                                        </div>
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label for="inputCity">Account Created Date</label>
                                                <input type="text" class="form-control" value="${LOGIN_ACCOUNT.createdAt}" readonly>
                                            </div>
                                            <div class="form-group col-md-2">
                                                <label for="inputZip">Status </label>
                                                <c:choose>
                                                    <c:when test="${LOGIN_ACCOUNT.status==1}">
                                                        <input type="text" class="form-control" style="color: green; font-weight: bold" value="ACTIVED" readonly>
                                                    </c:when>
                                                    <c:when test="${LOGIN_ACCOUNT.status==0}">
                                                        <input type="text" class="form-control" style="color: red; font-weight: bold" value="FLAGGED" readonly>
                                                    </c:when>
                                                    <c:when test="${LOGIN_ACCOUNT.status==3}">
                                                        <input type="text" class="form-control" style="color: orange; font-weight: bold" value="PENDING" readonly>
                                                    </c:when>
                                                </c:choose>

                                            </div>
                                        </div>

                                        <input type="hidden" name="txtID" value="${ACCOUNT.accountId}">
                                        <button type="submit" name="action" class="btn btn-primary" value="Save changes">Save changes</button>

                                        <c:if test="${ACCOUNT.status == 3}">
                                            <input type="hidden" name="txtEmail" value="${ACCOUNT.email}" >
                                            <button type="submit" name="action" class="btn btn-primary" value="Activate">Activate</button>
                                        </c:if>
                                        <c:if test="${ACCOUNT.status == 0}">
                                            <a href="https://www.facebook.com/duchinh0306" class="btn btn-primary">Contact Admin</a>
                                        </c:if>

                                    </form>
                                    <label>${EMAIL_SEND}</label>
                                </div>
                            </div>
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