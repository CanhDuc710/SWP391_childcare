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
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author BlackZ36
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/Register"})
public class RegisterServlet extends HttpServlet {

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
            out.println("<title>Servlet RegisterServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DAO dao = new DAO();
        VALID valid = new VALID();
        String reg_type = request.getParameter("txtType");

        if (reg_type == null) {

        } else if (reg_type.equalsIgnoreCase("patient")) {
            String username = request.getParameter("txtRegUsername");
            String name = request.getParameter("txtRegName");
            String email = request.getParameter("txtRegEmail");
            String phone = request.getParameter("txtRegPhone");
            String password = request.getParameter("txtRegPassword");
            String confirm = request.getParameter("txtRegConfirm");
            Boolean gender = false;
            if (request.getParameter("txtRegGender").equalsIgnoreCase("male")) {
                gender = true;
            } else {
                gender = false;
            }
            //kiem tra cac gia tri vua lay duoc
            //kiem tra username
            boolean check = false;
            if (!valid.exist_username(username)) {
                if (valid.valid_username(username)) {
                    if (!valid.exist_email(email)) {
                        if (valid.valid_phone(phone)) {
                            if (!valid.exist_phone(phone)) {
                                if (valid.valid_password(password)) {
                                    if (valid.confirm_password(password, confirm)) {
                                        check = true;
                                        request.setAttribute("REGISTER_VALID", "moi thong tin da ok");
                                    } else {
                                        request.setAttribute("REGISTER_VALID", "mat khau khong khop");
                                    }
                                } else {
                                    request.setAttribute("REGISTER_VALID", "mat khau khong dung dinh dang");
                                }
                            } else {
                                request.setAttribute("REGISTER_VALID", "so dien thoai bi turng lap");
                            }
                        } else {
                            request.setAttribute("REGISTER_VALID", "so dien thoai khong dung dinh dang");
                        }
                    } else {
                        request.setAttribute("REGISTER_VALID", "email da ton tai");
                    }
                } else {
                    request.setAttribute("REGISTER_VALID", "username khong dung dinh dang");
                }
            } else {
                request.setAttribute("REGISTER_VALID", "username da ton tai");
            }

            if (check) {
                
            }
            RequestDispatcher rd = request.getRequestDispatcher("Login_inner.jsp");
            rd.forward(request, response);
        } else if (reg_type.equalsIgnoreCase("staff")) {

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
