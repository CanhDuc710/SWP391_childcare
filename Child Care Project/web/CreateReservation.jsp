<%-- 
    Document   : CreateReservation
    Created on : 12-Oct-2023, 13:29:59
    Author     : GL
--%>
<link href="assets/css/reservation.css" rel="stylesheet" type="text/css"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<style>
    body {
        width: 500px;
        margin: 0 auto;
        padding: 50px;
    }

    div.elem-group {
        margin: 20px 0;
    }

    div.elem-group.inlined {
        width: 49%;
        display: inline-block;
        float: left;
        margin-left: 1%;
    }

    label {
        display: block;
        font-family: 'Nanum Gothic';
        padding-bottom: 10px;
        font-size: 1.25em;
    }

    input[type=date], select, textarea{
        border-radius: 2px;
        border: 2px solid #777;
        box-sizing: border-box;
        font-size: 1.25em;
        font-family: 'Nanum Gothic';
        width: 100%;
        padding: 10px;
    }

    div.elem-group.inlined input {
        width: 95%;
        display: inline-block;
    }

    textarea {
        height: 250px;
    }

    hr {
        border: 1px dotted #ccc;
    }

    button {
        height: 50px;
        background: orange;
        border: none;
        color: white;
        font-size: 1.25em;
        font-family: 'Nanum Gothic';
        border-radius: 4px;
        cursor: pointer;
    }

    button:hover {
        border: 2px solid black;
        align-content: center;
    }
</style>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- ======= Header ======= -->
        <!-- ======= Top Bar ======= -->
        <jsp:include page="include/topbar_include.jsp" />

        <!-- ======= Header ======= -->
        <jsp:include page="include/header_include.jsp" />
        <!-- End Header --><!-- End Header -->
        
        <!-- Favicons -->   
        <link href="assets/img/favicon.png" rel="icon">
        <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">
        
    </head>

    <body>
        
        <form action="Create" method="post" onsubmit="return validateDates()">
            <div class="elem-group inlined">
                <label for="from">From</label>
                <input type="date" id="from" name="from" required>
            </div>
            <div class="elem-group inlined">
                <label for="to">To</label>
                <input type="date" id="to" name="to" required>
            </div>
            <div class="elem-group">
                <label for="doctor-selection">Select Doctor for Reservations</label>
                <select id="doctor-selection" name="doctor" required>
                    <c:forEach items="${requestScope.doctors}" var="doc">
                        <option value="${doc.accountId}">${doc.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="elem-group">
                <label for="selectedslot">Select slots to assign the doctor to</label>
            </div>
            <c:forEach items="${requestScope.slots}" var="slot">
                <div class="elem-group">
                    <input style="clear: " type="checkbox" id="selectedslot" name="selectedslots" value="${slot.slotId}">
                    Slot ${slot.slotId}: From ${slot.startTime}, To ${slot.endTime}
                </div>
            </c:forEach>

            <button type="submit">Submit</button>
            <c:if test="${error} eq true"><div class="elem-group" style="color: red">Fail to create reservation</div></c:if>
        </form>
        
    </body>
</html>
