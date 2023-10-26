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
import java.util.ArrayList;

/**
 *
 * @author BlackZ36
 */
@WebServlet(name = "ServiceDetailServlet", urlPatterns = {"/ServiceDetail"})
public class ServiceDetailServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServiceDetailServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServiceDetailServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        Services service = new Services();
        String productId = request.getParameter("serviceID");
        

        if (productId == null) {
            response.sendRedirect("Services");
        } else {
            try {
                int id = Integer.parseInt(productId);
                service = dao.get_service_by_id(id);
                
                ArrayList<AverageRate> average_rate = dao.get_average_rate_list();
                ArrayList<ServicesCategory> category = dao.get_service_category_list();
                ArrayList<Services> service_list = dao.get_service_list();
                ArrayList<Account> account_list = dao.admin_get_patients();
                ArrayList<Feedback> feedback_list = dao.get_feedback_list();
                
                
                request.setAttribute("FEEDBACK_LIST", feedback_list);
                request.setAttribute("ACCOUNT_LIST", account_list);
                request.setAttribute("AVERAGE_RATE", average_rate);
                request.setAttribute("CATEGORY", category);
                request.setAttribute("SERVICE", service);
                request.setAttribute("SERVICE_LIST", service_list);

                RequestDispatcher rd = request.getRequestDispatcher("ServiceDetail_inner.jsp");
                rd.forward(request, response);
            } catch (Exception e) {
                response.sendRedirect("Services");
            }
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
