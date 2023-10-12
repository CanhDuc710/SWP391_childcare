/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Model.*;
import dal.DAO;
import dal.VALID;
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

@WebServlet(name = "ServicesServlet", urlPatterns = {"/Services"})
public class ServicesServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServicesServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServicesServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DAO dao = new DAO();
        VALID valid = new VALID();

        // Lấy tham số từ URL
        String showParam = request.getParameter("show");
        if (showParam != null && showParam.equals("0")) {
            request.setAttribute("SHOW", "0");
        }

        //get services list
        ArrayList<Services> service_list = dao.get_service_list();
        ArrayList<ServicesCategory> service_category_list = dao.get_service_category_list();

        //get feedback list
        ArrayList<AverageRate> average_rate = dao.get_average_rate_list();

        //set attribute
        request.setAttribute("SERVICE_LIST", service_list);
        request.setAttribute("SERVICE_CATEGORY_LIST", service_category_list);
        request.setAttribute("AVERAGE_RATE", average_rate);

        //redirect
        RequestDispatcher rd = request.getRequestDispatcher("ServiceList_inner.jsp");
        rd.forward(request, response);
        
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
