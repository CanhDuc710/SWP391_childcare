/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Reservation;

import AuthenticationController.BaseAccountAuthenticationController;
import Model.Account;
import Model.Reservation;
import dal.AccountDBContext;
import dal.ReservationDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


/**
 *
 * @author GL
 */
@WebServlet(name = "BookReservation", urlPatterns = {"/Reservation/Booking"})
public class BookReservationController extends BaseAccountAuthenticationController{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, Account acc) throws ServletException, IOException {
        ReservationDBContext rdb = new ReservationDBContext();
        ArrayList<Reservation> available = rdb.getAvailable();
        request.setAttribute("available", available);
        
        AccountDBContext adb = new AccountDBContext();
        request.setAttribute("account", acc);
        adb.getInfo(acc);
        if(acc.getGender()) request.setAttribute("gender", "Male");
        else request.setAttribute("gender", "Female");
        
        request.setAttribute("slots", rdb.getSlots());
        
        request.getRequestDispatcher("../BookReservation.jsp").forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, Account acc) throws ServletException, IOException {
        ReservationDBContext rdb = new ReservationDBContext();
        int availableId = Integer.parseInt(request.getParameter("availablereservation"));
        
        AccountDBContext adb = new AccountDBContext();
        adb.getInfo(acc);
        
        if (!rdb.checkAvailable(availableId) && acc.getRoleId() == 1) {
            rdb.book(acc.getAccountId(), availableId);
        }
        
        
    }

}
