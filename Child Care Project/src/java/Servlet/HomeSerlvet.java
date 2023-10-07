/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import Model.*;
import dal.DAO;
import java.util.ArrayList;

/**
 *
 * @author duchi
 */
@WebServlet(name = "HomeSerlvet", urlPatterns = {"/Home"})
public class HomeSerlvet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet homeSerlvet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet homeSerlvet at " + request.getContextPath() + "</h1>");
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
        request.setAttribute("ACCOUNT", account);

        //lay ra service list va set attribute
        ArrayList<Services> service_list = dao.get_service_list();
        request.setAttribute("SERVICE_LIST", service_list);
        request.setAttribute("SERVICE_COUNT", service_list.size());

        //lay ra doctor list va set attribute
        ArrayList<Account> doctor_list = dao.get_doctor_list();
        request.setAttribute("DOCTOR_LIST", doctor_list);
        request.setAttribute("DOCTOR_COUNT", doctor_list.size());

        //lay ra category va set attribute
        ArrayList<ServicesCategory> category_list = dao.get_service_category_list();
        request.setAttribute("CATEGORY_LIST", category_list);
        request.setAttribute("CATEGORY_COUNT", category_list.size());

        //kiem tra NOTIBOX và content
        Boolean notibox = (Boolean) request.getAttribute("NOTIBOX");
        String content = (String) request.getAttribute("NOTICONTENT");
        request.setAttribute("NOTIBOX", notibox);
        request.setAttribute("NOTICONTENT", content);

        //First Time Welcome
        Boolean first = (Boolean) session.getAttribute("FIRST");
        if (first == null) {
            request.setAttribute("NOTIBOX", true);
            request.setAttribute("NOTICONTENT", "Welcome to SWP391 Project!");
            session.setAttribute("FIRST", true);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("Home.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DAO dao = new DAO();
        Account account = (Account) session.getAttribute("ACCOUNT");
        request.setAttribute("ACCOUNT", account);

        //lay ra service list va set attribute
        ArrayList<Services> service_list = dao.get_service_list();
        request.setAttribute("SERVICE_LIST", service_list);
        request.setAttribute("SERVICE_COUNT", service_list.size());

        //lay ra doctor list va set attribute
        ArrayList<Account> doctor_list = dao.get_doctor_list();
        request.setAttribute("DOCTOR_LIST", doctor_list);
        request.setAttribute("DOCTOR_COUNT", doctor_list.size());

        //lay ra category va set attribute
        ArrayList<ServicesCategory> category_list = dao.get_service_category_list();
        request.setAttribute("CATEGORY_LIST", category_list);
        request.setAttribute("CATEGORY_COUNT", category_list.size());

        //kiem tra NOTIBOX và content
        Boolean notibox = (Boolean) request.getAttribute("NOTIBOX");
        String content = (String) request.getAttribute("NOTICONTENT");
        request.setAttribute("NOTIBOX", notibox);
        request.setAttribute("NOTICONTENT", content);

        RequestDispatcher dispatcher = request.getRequestDispatcher("Home.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
