/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import dal.DAO;
import Model.*;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author BlackZ36
 */
@WebServlet(name = "ReservationDetailServlet", urlPatterns = {"/ReservationDetail"})
public class ReservationDetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        HttpSession session = request.getSession();

        //lay ra danh sach service da chon
        ArrayList<Services> chosen_service_list = (ArrayList<Services>) session.getAttribute("CHOSEN_SERVICE_LIST");

        //lay ra danh sach category
        ArrayList<ServicesCategory> category_list = dao.get_service_category_list();

        if (chosen_service_list == null) {

            request.setAttribute("count", 0);
            RequestDispatcher rd = request.getRequestDispatcher("ReservationDetail_inner.jsp");
            rd.forward(request, response);
        } else {
            double totalPrice = 0.0;
            for (Services service : chosen_service_list) {
                totalPrice += service.getPrice() - (service.getPrice() * service.getDiscount() / 100);
            }
            request.setAttribute("totalPrice", totalPrice);
            int count = chosen_service_list.size();
            request.setAttribute("count", count);
            request.setAttribute("CATEGORY_LIST", category_list);
            request.setAttribute("CHOSEN_SERVICE_LIST", chosen_service_list);
            RequestDispatcher rd = request.getRequestDispatcher("ReservationDetail_inner.jsp");
            rd.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
