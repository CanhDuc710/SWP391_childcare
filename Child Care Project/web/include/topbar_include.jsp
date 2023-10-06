<%-- 
    Document   : topbar_include
    Created on : Oct 5, 2023, 2:02:40 PM
    Author     : BlackZ36
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Favicons -->
        <link href="../assets/img/favicon.png" rel="icon">
        <link href="../assets/img/apple-touch-icon.png" rel="apple-touch-icon">

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Roboto:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

        <!-- Vendor CSS Files -->
        <link href="assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
        <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
        <link href="assets/vendor/aos/aos.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
        <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

        <!-- Template Main CSS File -->
        <link href="assets/css/style.css" rel="stylesheet">
    </head>
    <body>
        <!-- ======= Top Bar ======= -->
        <div id="topbar" class="d-flex align-items-center fixed-top">
            <div class="container d-flex align-items-center justify-content-center justify-content-md-between">
                <div class="align-items-center d-none d-md-flex">
                    <i class="bi bi-clock"></i> Monday - Saturday, 7:30AM to 5PM
                </div>
                <div class="d-flex align-items-center">
                    <i class="bi bi-clock"></i><div id="clock" style="padding-right: 40px;"></div>
                    <i class="bi bi-phone"></i> Call us now +84 0123 456 789
                </div>
            </div>
        </div>
    </body>

    <script>
        function updateClock() {
            var now = new Date();
            var day = now.getDate();
            var month = now.getMonth() + 1; // Tháng bắt đầu từ 0
            var year = now.getFullYear().toString().slice(2); // Lấy 2 chữ số cuối của năm
            var hours = now.getHours();
            var minutes = now.getMinutes();
            var seconds = now.getSeconds();

            // Định dạng thời gian theo DD-MM-YY HH:MM:SS
            var formattedTime = (day < 10 ? '0' : '') + day + '-' +
                    (month < 10 ? '0' : '') + month + '-' +
                    year + ' ' +
                    (hours < 10 ? '0' : '') + hours + ':' +
                    (minutes < 10 ? '0' : '') + minutes + ':' +
                    (seconds < 10 ? '0' : '') + seconds;

            // Hiển thị thời gian vào thẻ HTML có id là "clock"
            document.getElementById('clock').textContent = formattedTime;
        }

// Gọi hàm cập nhật thời gian mỗi giây
        setInterval(updateClock, 1000);
    </script>

</html>
