/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Model.Account;
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
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@WebServlet(name = "MyChildrenServlet", urlPatterns = {"/MyChildren"})
public class MyChildrenServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MyChildrenServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MyChildrenServlet at " + request.getContextPath() + "</h1>");
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

        if (account != null) {
            ArrayList<Children> children_list = dao.get_children_by_parentID(account.getAccountId());

            request.setAttribute("CHILDREN_LIST", children_list);
            request.setAttribute("ACCOUNT", account);
            RequestDispatcher rd = request.getRequestDispatcher("MyChildren_inner.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("LOGIN_VALID", "Please Login First");
            RequestDispatcher rd = request.getRequestDispatcher("Login_inner.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String type = request.getParameter("txtType");
        DAO dao = new DAO();

        if (type.equals("Save")) {
            Account parent = (Account) request.getSession().getAttribute("ACCOUNT");
            int childId = Integer.parseInt(request.getParameter("txtID"));
            int parentId = parent.getAccountId();
            String name = request.getParameter("txtName");
            Boolean gender = Boolean.parseBoolean(request.getParameter("txtGender"));
            String dobString = request.getParameter("txtDob"); // Lấy chuỗi ngày sinh từ form
            int relation = Integer.parseInt(request.getParameter("txtRelation"));

            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date parsedDate = sdf.parse(dobString);
                java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
                dao.update_children(childId, parentId, name, gender, sqlDate, relation);
            } catch (Exception e) {
                e.printStackTrace();
            }
            response.sendRedirect("MyChildren");
        } else if (type.equals("Add")) {
            Account parent = (Account) request.getSession().getAttribute("ACCOUNT");
            int parentId = parent.getAccountId();
            String name = request.getParameter("txtName");
            Boolean gender = Boolean.parseBoolean(request.getParameter("txtGender"));
            String dobString = request.getParameter("txtDob"); // Lấy chuỗi ngày sinh từ form
            int relation = Integer.parseInt(request.getParameter("txtRelation"));

            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date parsedDate = sdf.parse(dobString);
                java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
                dao.add_children(parentId, name, gender, sqlDate, relation);
            } catch (Exception e) {
                e.printStackTrace();
            }
            response.sendRedirect("MyChildren");
        } else if (type.equals("Delete")) {
            int childId = Integer.parseInt(request.getParameter("txtID"));

//            response.getWriter().write(type + " - " + childId);
            boolean check = dao.remove_children(childId);
            if (!check) {
                response.getWriter().write(type + " - failed - " + childId);
            } else {
                response.sendRedirect("MyChildren");
            }
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
