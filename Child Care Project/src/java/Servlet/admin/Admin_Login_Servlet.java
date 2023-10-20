/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet.admin;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorConfig;
import dal.DAO;
import Model.*;
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
 * @author duchi
 */
@WebServlet(name = "Admin_Login_Serlvet", urlPatterns = {"/Admin/Login"})
public class Admin_Login_Servlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Admin_Login_Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Admin_Login_Servlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        HttpSession session = request.getSession();

        //lay ra parameter
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String key = request.getParameter("txtKey");

        //kiem tra
        String secretKey = "nguyenduyduchinhprojectkey"; // Lấy secret key từ cơ sở dữ liệu hoặc nơi lưu trữ của bạn

        GoogleAuthenticatorConfig config = new GoogleAuthenticatorConfig.GoogleAuthenticatorConfigBuilder().build();
        GoogleAuthenticator gAuth = new GoogleAuthenticator(config);
        
        boolean isCodeValid = gAuth.authorize(secretKey, Integer.parseInt(key));
        
        if (username != null && password != null && key != null) {
            
            if (key.equals("1")) {
                Admin admin = dao.AdminLogin(username, password);
                if (admin != null) {
                    session.setAttribute("ADMIN", admin);
                    
                    response.sendRedirect("Dashboard");
                } else {
                    request.setAttribute("MESSAGE", "Invalid username/password");
                    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                    rd.forward(request, response);
                }
            } else {
                request.setAttribute("MESSAGE", "WRONG KEY");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }
        }
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
