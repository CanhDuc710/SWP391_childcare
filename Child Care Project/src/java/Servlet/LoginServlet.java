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

/**
 *
 * @author BlackZ36
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("ACCOUNT");
        String type = request.getParameter("type");

        if (type == null) {

            response.sendRedirect("Login?type=patient");
            return;
        }

        if (type.equalsIgnoreCase("patient")) {
            if (account == null) {
                RequestDispatcher rd = request.getRequestDispatcher("Login_inner.jsp");
                rd.forward(request, response);
            } else {
                response.sendRedirect("Account");
            }
        } else if (type.equalsIgnoreCase("staff")) {
            if (account == null) {
                RequestDispatcher rd = request.getRequestDispatcher("Login_inner_staff.jsp");
                rd.forward(request, response);
            } else {
                response.sendRedirect("Account");
            }
        } else {
            if (account == null) {
                RequestDispatcher rd = request.getRequestDispatcher("Login_inner.jsp");
                rd.forward(request, response);
            } else {
                response.sendRedirect("Account");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        HttpSession session = request.getSession();

        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String type = request.getParameter("txtType");

        if (type == null) {

        } else if (type.equalsIgnoreCase("staff")) {

            Account staff = dao.StaffLogin(username, password);
            if (staff == null) {
                request.setAttribute("LOGIN_VALID", "Login Failed. Please Check Username/Password");
                RequestDispatcher rd = request.getRequestDispatcher("Login_inner_staff.jsp");
                rd.forward(request, response);
            } else {
                if (staff.getStatusId() == 2) {
                    session.setAttribute("ACCOUNT", staff);
                    response.sendRedirect("Home");
                } else {
                    request.setAttribute("LOGIN_VALID", "Please Contact <a href='#'> Admin</a> For More.");
                    RequestDispatcher rd = request.getRequestDispatcher("Login_inner_staff.jsp");
                    rd.forward(request, response);
                }
            }

        } else if (type.equalsIgnoreCase("patient")) {

            Account patient = dao.PatientLogin(username, password);
            if (patient == null) {
                request.setAttribute("LOGIN_VALID", "Login Failed. Please Check Username/Password");
                RequestDispatcher rd = request.getRequestDispatcher("Login_inner.jsp");
                rd.forward(request, response);
            } else {
                if (patient.getStatusId() == 2) {
                    session.setAttribute("ACCOUNT", patient);
                    response.sendRedirect("Home");
                } else {
                    request.setAttribute("LOGIN_VALID", "Please Check Your Email For Verification Before Login. Click <a href='#'> here</a> to Re-Verify");
                    RequestDispatcher rd = request.getRequestDispatcher("Login_inner.jsp");
                    rd.forward(request, response);
                }
            }

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
