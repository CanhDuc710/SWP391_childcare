/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import dal.DAO;
import dal.VALID;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import Model.*;

/**
 *
 * @author duchi
 */
public class UpdateServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        VALID valid = new VALID();
        HttpSession session = request.getSession();

        String action = request.getParameter("action");

        //update information
        if (action.equalsIgnoreCase("save changes")) {
            Account update = new Account();
            int id = Integer.parseInt(request.getParameter("txtID"));
            String first_email = request.getParameter("email_first");
            String first_phone = request.getParameter("phone_first");

            String name = request.getParameter("txtUpdateName");
            String email = request.getParameter("txtUpdateEmail");
            String phone = request.getParameter("txtUpdatePhone");

            boolean check = true;
            //kiem tra mail exist
            if (!first_email.equals(email)) {
                if (valid.valid_email(email)) {
                    check = false;
                    request.setAttribute("EMAIL_SEND", "Email existed. please try again.");
                }
            }
            //kiem tra phone exist,length,format
            if (!first_phone.equals(phone)) {
                if (valid.valid_phone(phone)) {
                    check = false;
                    request.setAttribute("EMAIL_SEND", "Phone invalid. please try again.");
                }
            }

            if (check) {
                boolean updateCheck = dao.updateInfor(id, name, email, phone);
                if (updateCheck) {

                    request.setAttribute("EMAIL_SEND", "Updated Successfully.");
                } else {
                    request.setAttribute("EMAIL_SEND", "Updated Failed. Please try again.");
                }
            }

            update = dao.get_patient_by_id(id);
            session.setAttribute("ACCOUNT", update);
            request.setAttribute("LOGIN_ACCOUNT", update);

            RequestDispatcher rd = request.getRequestDispatcher("Account.jsp");
            rd.forward(request, response);

        }

        //change password
        if (action.equalsIgnoreCase("changePassword")) {
            int id = Integer.parseInt(request.getParameter("txtID"));
            String old = request.getParameter("old_password");
            String change = request.getParameter("change_password");
            String confirm = request.getParameter("confirm_password");

            Account patient = dao.get_patient_by_id(id);

            if (patient.getPassword().equals(old)) {
                if (valid.valid_password(change)) {
                    if (change.equals(confirm)) {
                        boolean check = dao.change_password(id, change);

                        if (check) {
                            request.setAttribute("CHANGE_MESSAGE", "Updated Successfully.");
                        } else {
                            request.setAttribute("CHANGE_MESSAGE", "Update failed.");
                        }

                    } else {
                        request.setAttribute("CHANGE_MESSAGE", "Confirm password not matched.");
                    }
                } else {
                    request.setAttribute("CHANGE_MESSAGE", "Password must be 6-30 alphanumberic.");
                }
            } else {
                request.setAttribute("CHANGE_MESSAGE", "Old password is not correct.");
            }
            ;
            request.setAttribute("LOGIN_ACCOUNT", patient);
            request.setAttribute("password1", old);
            request.setAttribute("password2", change);
            request.setAttribute("password3", confirm);
            request.getRequestDispatcher("Account.jsp").forward(request, response);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
