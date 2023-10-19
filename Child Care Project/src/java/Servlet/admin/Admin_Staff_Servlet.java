/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet.admin;

import Model.Account;
import Model.Admin;
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
 * @author duchi
 */
@WebServlet(name = "Admin_Staff_Serlvet", urlPatterns = {"/Admin/Staff"})
public class Admin_Staff_Servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Admin_Patient_Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Admin_Patient_Servlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DAO dao = new DAO();

        //get account
        Admin admin = (Admin) session.getAttribute("ADMIN");

        if (admin != null) {

            ArrayList<Account> staff_list = dao.admin_get_staffs();

            request.setAttribute("ADMIN", admin);
            request.setAttribute("STAFF_LIST", staff_list);

            RequestDispatcher rd = request.getRequestDispatcher("Staff_inner.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("MESSAGE", "Login First");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DAO dao = new DAO();

        //get type attribute
        String type = request.getParameter("txtType");

        if (type.equals("Add")) {

            //lay tra parameter
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            String phone = request.getParameter("txtPhone");
            String email = request.getParameter("txtEmail");
            String name = request.getParameter("txtName");
            int role = Integer.parseInt(request.getParameter("txtRole"));
            boolean gender = false;
            if (request.getParameter("txtGender").equals("male")) {
                gender = true;
            }
            //response.getWriter().write(" - " + username + " - " + password + " - " + phone + " - " + email + " - " + name + " - " + " - " + gender + " - " + role);
            boolean register = dao.admin_staff_register(username, password, email, phone, name, gender, role);
            response.sendRedirect("Staff");

        } else if (type.equals("Save")) {

            //lay tra parameter
            int id = Integer.parseInt(request.getParameter("txtID"));
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            String phone = request.getParameter("txtPhone");
            String email = request.getParameter("txtEmail");
            String name = request.getParameter("txtName");
            String address = request.getParameter("txtAddress");
            String txtRoleIdString = request.getParameter("txtRoleId");
            int role = Integer.parseInt(txtRoleIdString);
            boolean gender = Boolean.parseBoolean(request.getParameter("txtGender"));
            int status = Integer.parseInt(request.getParameter("txtStatus"));

            //response.getWriter().write(id + " - " + username + " - " + password + " - " + phone + " - " + email + " - " + name + " - " + address + " - " + gender + " - " + status + " - " + role);
            boolean update = dao.admin_update_staff(id, username, password, email, phone, name, address, gender, status, role);
            response.sendRedirect("Staff");
        } else if (type.equals("Delete")) {

            int id = Integer.parseInt(request.getParameter("txtID"));
            boolean delete = dao.admin_delete_staff(id);
            response.sendRedirect("Staff");

        } else {
            response.getWriter().write(type);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
