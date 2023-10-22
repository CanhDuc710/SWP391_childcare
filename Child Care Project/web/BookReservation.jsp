<%-- 
    Document   : BookReservation
    Created on : 09-Oct-2023, 15:26:30
    Author     : GL
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="../src/java/Reservation/BookReservationController.java" method="post">
  <div class="elem-group inlined">
    <label for="from>From</label>
    <input type="date" id="from" name="from" required>
  </div>
  <div class="elem-group inlined">
    <label for="to">To</label>
    <input type="date" id="to" name="to" required>
  </div>
  <div class="elem-group">
    <label for="reservation-selection">Select /label>
    <select id="reservation-selection" name="reservationSelect" required>
        <c:forEach items="${requestScope.doctors}" var="doc">
            <option value="${doc.accountId}">${doc.name}</option>
        </c:forEach>
    </select>
  </div>
  <button type="submit">Book selected reservation</button>
</form>
    </body>
</html>
