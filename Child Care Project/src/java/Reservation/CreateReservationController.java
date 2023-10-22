/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reservation;

import AuthenticationController.BaseAccountAuthenticationController;
import Model.Account;
import dal.ReservationDBContext;
import dal.StaffDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

/**
 *
 * @author GL
 */
@WebServlet(name = "CreateReservation", urlPatterns = {"/Reservation/Create"})
public class CreateReservationController extends BaseAccountAuthenticationController{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, Account acc) throws ServletException, IOException {
        StaffDBContext sdb = new StaffDBContext();
        request.setAttribute("doctors", sdb.getDoctor());
        ReservationDBContext rdb = new ReservationDBContext();
        request.setAttribute("slots", rdb.getSlots());
        request.getRequestDispatcher("../CreateReservation.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, Account acc) throws ServletException, IOException {
        String fromDate = request.getParameter("from");
        Date from = Date.valueOf(fromDate);
        String toDate = request.getParameter("to");
        Date to = Date.valueOf(toDate);
        
        String selectedDoctor = request.getParameter("doctor");
        int doctorId = Integer.parseInt(selectedDoctor);
                
        String[] selectedSlots = request.getParameterValues("slots");
        
        ReservationDBContext rdb = new ReservationDBContext();
        rdb.create(doctorId, selectedSlots, from, to);
    }
    
}
