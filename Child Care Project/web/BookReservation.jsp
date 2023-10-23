<%-- 
    Document   : BookReservation
    Created on : 09-Oct-2023, 15:26:30
    Author     : GL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

input[type=date], select, textarea {
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
}

table, th, td {
    text-align: center
}


</style>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <body>
        <div class="elem-group inlined">
            <label for="name">Name</label>
            ${account.name}
        </div>
        <div class="elem-group inlined">
            <label for="gender">Gender</label>
            ${gender}
        </div>
        <form action="Booking" method="post">
            <div class="elem-group">
                <table style="width: 100%; height: 100%; border-collapse: collapse;">
                    <style>
                        th, td, tr{
                            border: 1px solid black
                        }
                        
                    </style>
                    <tr>
                        <th colspan="3">Slot time table</th>
                    </tr>
                    <tr>
                        <th>Slot</th>
                        <th>Start Time</th>
                        <th>End Time</th>
                    </tr>
                    <tr>
                    <c:forEach items="${requestScope.slots}" var="slot">
                    <tr>
                        <td>${slot.slotId}</td>
                        <td>${slot.startTime}</td>
                        <td>${slot.endTime}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="elem-group">
                <label for="reservation-selection">Select a reservation with doctor</label>
                <select id="reservation-selection" name="availablereservation" required>
                    <c:forEach items="${requestScope.available}" var="reser">
                        <option value="${reser.reservationId}">Date: ${reser.date} | Doctor: ${reser.doctorAcc.name} | Slot: ${reser.slotId}</option>
                    </c:forEach>
                </select>
            </div>
            

            <button type="submit">Book</button>
            
            <c:if test="${param.error eq true}">
                
                <div style="text-align: center; color: red">Booking fail</div>
                
            </c:if>
        </form>
    </body>
</html>
