
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <meta name="description" content="">
        <meta name="author" content="">

        <title>Medic Care Bootstrap 5 CSS Template</title>

        <!-- CSS FILES -->        
        <link rel="preconnect" href="https://fonts.googleapis.com">

        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;600;700&display=swap" rel="stylesheet">

        <link href="css/bootstrap.min.css" rel="stylesheet">

        <link href="css/bootstrap-icons.css" rel="stylesheet">

        <link href="css/owl.carousel.min.css" rel="stylesheet">

        <link href="css/owl.theme.default.min.css" rel="stylesheet">

        <link href="css/templatemo-medic-care.css" rel="stylesheet">

    </head>

    <body id="top">

        <main>

            <!--nav bar section begin --
            <jsp:include page="include/nav.jsp"/>
            <!--nav bar section end -->

            <!--slider section begin-->
            <jsp:include page="include/slider.jsp"/>
            <!--slider section end-->          

            <!--feedback section begin-->
            <section class="section-padding pb-0" id="reviews">
                <jsp:include page="include/feedback.jsp" />
            </section>
            <!--feedback section end-->

        </main>

        <!--footer section begin-->   
        <footer class="site-footer section-padding" id="contact">
            <jsp:include page="include/footer.jsp" />
        </footer>
        <!--footer section end-->

        <!-- JAVASCRIPT FILES -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/scrollspy.min.js"></script>
        <script src="js/custom.js"></script>
        <!--
        
        TemplateMo 566 Medic Care
        
        https://templatemo.com/tm-566-medic-care
        
        -->
    </body>
</html>