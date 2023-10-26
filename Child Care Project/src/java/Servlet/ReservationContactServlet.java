/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Model.*;
import dal.DAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author BlackZ36
 */
@WebServlet(name = "ReservationContactServlet", urlPatterns = {"/ReservationContact"})
public class ReservationContactServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ReservationContactServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ReservationContactServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DAO dao = new DAO();
        Account account = (Account) session.getAttribute("ACCOUNT");
        ArrayList<Services> chosen_service_list = (ArrayList<Services>) session.getAttribute("CHOSEN_SERVICE_LIST");

        if (account != null) {

            if (chosen_service_list != null) {
                
                ArrayList<ServicesCategory> category_list = dao.get_service_category_list();
                ArrayList<Children> children_list = dao.get_children_by_parentID(account.getAccountId());
                LocalDate today = LocalDate.now();
                ArrayList<Account> doctor_list = dao.get_doctor_list();
                ArrayList<Slot> slot_list = dao.get_slot_list();
                double total = 0;
                for(Services service : chosen_service_list){
                    total += service.getPrice() - (service.getPrice()*(service.getDiscount()/100)) ;
                }
                
                request.setAttribute("TOTAL", total);
                request.setAttribute("DATE", today);
                request.setAttribute("SLOT_LIST", slot_list);
                request.setAttribute("CATEGORY_LIST", category_list);
                request.setAttribute("DOCTOR_LIST", doctor_list);
                request.setAttribute("CHOSEN_SERVICE_LIST", chosen_service_list);
                request.setAttribute("CHILDREN_LIST", children_list);
                request.setAttribute("ACCOUNT", account);
                RequestDispatcher rd = request.getRequestDispatcher("ReservationContact_inner.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("NOTIBOX", true);
                request.setAttribute("NOTICONTENT", "Please Add One Or More Service(s)");
                RequestDispatcher rd = request.getRequestDispatcher("Services");
                rd.forward(request, response);
            }

        } else {
            request.setAttribute("LOGIN_VALID", "Please Login First");
            RequestDispatcher rd = request.getRequestDispatcher("Login_inner.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
