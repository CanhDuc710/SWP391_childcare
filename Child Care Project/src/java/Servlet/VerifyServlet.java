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
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author duchi
 */
@WebServlet(name = "VerifyServlet", urlPatterns = {"/Verify"})
public class VerifyServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet VerifyServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VerifyServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        // Lấy giá trị của tham số từ URL
        try {
            String encodedEmail = request.getParameter("encodedEmail");
            String encodedID = request.getParameter("encodedID");
            if (encodedEmail != null && encodedID != null) {
                // Giải mã tham số để lấy giá trị gốc
                String email = new String(Base64.getUrlDecoder().decode(encodedEmail), StandardCharsets.UTF_8);
                String id = new String(Base64.getUrlDecoder().decode(encodedID), StandardCharsets.UTF_8);

                //kiem tra id 
                boolean integer = false;
                try {
                    int numericId = Integer.parseInt(id);
                    // Nếu không có lỗi, id là một số nguyên hợp lệ
                    integer = true;
                } catch (NumberFormatException e) {
                    // Nếu có lỗi, id không phải là số nguyên hợp lệ
                    integer = false;
                }
                
                if (integer) {
                    // lay ra model email va cac tham so
                    EmailVerify object = dao.Get_Verify_Email_DateTime(email, Integer.parseInt(id));
                    if (object != null) {
                        int type = object.getType();
                        Timestamp end = object.getEnd();
                        int status = object.getStatus();
                        
                        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
                        
                        if (type == 1) {// 1 is register confirmation
                            if (currentTime.before(end) && status != 0) {
                                boolean check = dao.update_emailVerify_status(email, Integer.parseInt(id));
                                if (check) {
                                    boolean check1 = dao.Change_status_account(email, 2);
                                    request.setAttribute("IMG", "success.gif");
                                    request.setAttribute("MESSAGE", "<p style='color: green;'>Verify Successful</p>");
                                    request.setAttribute("MESSAGE2", "Please <a href='Login'> login</a> using username and password.");
                                    RequestDispatcher rd = request.getRequestDispatcher("Notification_inner.jsp");
                                    rd.forward(request, response);
                                } else {
                                    request.setAttribute("IMG", "error.gif");
                                    request.setAttribute("MESSAGE", "Verify Failed.");
                                    request.setAttribute("MESSAGE2", "Please try again.");
                                    RequestDispatcher rd = request.getRequestDispatcher("Notification_inner.jsp");
                                    rd.forward(request, response);
                                }
                            } else {
                                request.setAttribute("IMG", "warning.gif");
                                request.setAttribute("MESSAGE", "<p style='color: yellow;'>Your Verification Is Expired</p>");
                                request.setAttribute("MESSAGE2", "Please Re-send Or Check Again.");
                                RequestDispatcher rd = request.getRequestDispatcher("Notification_inner.jsp");
                                rd.forward(request, response);
                            }
                        } else if (type == 2) { // 2 is reset password
                            if (currentTime.before(end) && status != 0) {
                                
                                request.setAttribute("ID", id);
                                request.setAttribute("USER_EMAIL", email);
                                RequestDispatcher rd = request.getRequestDispatcher("ResetPassword_inner.jsp");
                                rd.forward(request, response);
                            } else {
                                request.setAttribute("IMG", "warning.gif");
                                request.setAttribute("MESSAGE", "<p style='color: yellow;'>Your Verification Is Expired</p>");
                                request.setAttribute("MESSAGE2", "Please Re-send Or Check Again.");
                                RequestDispatcher rd = request.getRequestDispatcher("Notification_inner.jsp");
                                rd.forward(request, response);
                            }
                        }
                    } else { //kiem tra oject email verify lay ra co null hay khong
                        request.setAttribute("IMG", "error.gif");
                        request.setAttribute("MESSAGE", "Invalid Request");
                        request.setAttribute("MESSAGE2", "<a href='Home'> Back</a> to Homepage.");
                        RequestDispatcher rd = request.getRequestDispatcher("Notification_inner.jsp");
                        rd.forward(request, response);
                    }
                } else { // kiem tra decodeid co phai la integer hay khong
                    request.setAttribute("IMG", "error.gif");
                    request.setAttribute("MESSAGE", "Invalid Request");
                    request.setAttribute("MESSAGE2", "<a href='Home'> Back</a> to Homepage.");
                    RequestDispatcher rd = request.getRequestDispatcher("Notification_inner.jsp");
                    rd.forward(request, response);
                }
            } else { //kiem tra decode email va decode id
                request.setAttribute("IMG", "error.gif");
                request.setAttribute("MESSAGE", "Invalid Request");
                request.setAttribute("MESSAGE2", "<a href='Home'> Back</a> to Homepage.");
                RequestDispatcher rd = request.getRequestDispatcher("Notification_inner.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {  //kiem tra xem encode email va encode id co dung base64 hay khong
            request.setAttribute("IMG", "error.gif");
            request.setAttribute("MESSAGE", "Invalid Request");
            request.setAttribute("MESSAGE2", "<a href='Home'> Back</a> to Homepage.");
            RequestDispatcher rd = request.getRequestDispatcher("Notification_inner.jsp");
            rd.forward(request, response);
        }
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
}
