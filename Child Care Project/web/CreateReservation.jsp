<%-- 
    Document   : CreateReservation
    Created on : 12-Oct-2023, 13:29:59
    Author     : GL
--%>
<link href="assets/css/reservation.css" rel="stylesheet" type="text/css"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="../src/java/Reservation/CreateReservationController.java" method="post" onsubmit="return validateDates()">
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
                <c:forEach items="${requestScope.slots}" var="slot">
                    <input type="checkbox" id="selectedslot" name="selectedslots" value="${slot.id}">
                    Slot ${slot.id}: From ${slot.startTime}, To ${slot.endTime} </br>
                </c:forEach>
            </div>
            <button type="submit">Create Reservations</button>
        </form>
        <script>
            function validateDates() {
                var fromInput = document.getElementById("from");
                var toInput = document.getElementById("to");
                var fromDate = new Date(fromInput.value);
                var toDate = new Date(toInput.value);
                var today = new Date();
                if (fromDate < today) {
                    alert("From date must be at least today.");
                    return false;
                }

                if (toDate <= fromDate) {
                    alert("To date must be higher than From date.");
                    return false;
                }

                return true;
            }
        </script>
    </body>
</html>
