/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Model.Account;
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

/**
 *
 * @author BlackZ36
 */
@WebServlet(name = "ChangePasswordServlet", urlPatterns = {"/ChangePassword"})
public class ChangePasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DAO dao = new DAO();
        VALID valid = new VALID();

        Account account = (Account) session.getAttribute("ACCOUNT");
        if (account != null) {
            request.setAttribute("ID", account.getAccountId());
            RequestDispatcher rd = request.getRequestDispatcher("ChangePassword_inner.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("LOGIN_VALID", "Please Login First.");
            RequestDispatcher rd = request.getRequestDispatcher("Login_inner.jsp");
            rd.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DAO dao = new DAO();
        VALID valid = new VALID();
        Account account = (Account) session.getAttribute("ACCOUNT");

        String oldPassword = request.getParameter("txtOld");
        String newPassword = request.getParameter("txtNew");
        String confirmPassword = request.getParameter("txtConfirm");

        boolean change = false;
        if (oldPassword.equals(account.getPassword())) {
            if (newPassword.equals(confirmPassword)) {
                if (valid.valid_password(newPassword)) {
                    change = true;
                } else {

                    request.setAttribute("MESSAGE", "Invalid New Password Format (alphanumeric with 6-20 letters.)");
                    RequestDispatcher rd = request.getRequestDispatcher("ChangePassword_inner.jsp");
                    rd.forward(request, response);
                }
            } else {
                request.setAttribute("MESSAGE", "Your new password and confirm are not the same.");
                RequestDispatcher rd = request.getRequestDispatcher("ChangePassword_inner.jsp");
                rd.forward(request, response);
            }
        } else {
            request.setAttribute("MESSAGE", "Your OLD password is incorrect.");
            RequestDispatcher rd = request.getRequestDispatcher("ChangePassword_inner.jsp");
            rd.forward(request, response);
        }

        if (change) {
            boolean changed = dao.update_password( account.getAccountId() , newPassword);
            if (changed) {
                session.removeAttribute("ACCOUNT");
                request.setAttribute("IMG", "success.gif");
                request.setAttribute("MESSAGE", "Done");
                request.setAttribute("MESSAGE2", "<a href='Login'> Back</a> to Login.");
                RequestDispatcher rd = request.getRequestDispatcher("Notification_inner.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("IMG", "error.gif");
                request.setAttribute("MESSAGE", "Failed. Please Try Again");
                request.setAttribute("MESSAGE2", "<a href='Login'> Back</a> to Login.");
                RequestDispatcher rd = request.getRequestDispatcher("Notification_inner.jsp");
                rd.forward(request, response);
            }
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
