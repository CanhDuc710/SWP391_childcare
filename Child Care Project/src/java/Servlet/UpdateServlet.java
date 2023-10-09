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
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author duchi
 */
@WebServlet(name = "UpdateServlet", urlPatterns = {"/Update"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 5, // 5MB
        maxRequestSize = 1024 * 1024 * 50)
public class UpdateServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("IMG", "error.gif");
        request.setAttribute("MESSAGE", "Invalid Request");
        request.setAttribute("MESSAGE2", "<a href='Home'> Back</a> to Homepage.");
        RequestDispatcher rd = request.getRequestDispatcher("Notification_inner.jsp");
        rd.forward(request, response);
    }
    
    private static final String user_avatar_folder = "user\\";
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        VALID valid = new VALID();
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        
        String updateType = request.getParameter("txtUpdateType");
        
        if (updateType != null) {
            if (updateType.equalsIgnoreCase("avatar")) {
                
                int id = Integer.parseInt(request.getParameter("txtID"));
                String username = request.getParameter("txtUsername");
                
                String savePath = "C:\\Users\\duchi\\Desktop\\SWP391_childcare\\Child Care Project\\web\\assets\\img\\" + File.separator + user_avatar_folder + username; //specify your path here
                File fileSaveDir = new File(savePath);
                if (!fileSaveDir.exists()) {
                    fileSaveDir.mkdir();
                }
                Part part = request.getPart("fileAvatar");
                String timeStamp = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
                String fileName = "user-avatar-" + request.getParameter("txtUsername") + "_" + timeStamp + ".jpg";
                part.write(savePath + File.separator + fileName);
                boolean update = dao.update_patient_avatar(username, fileName);
                if (update) {
                    Account account = dao.get_patient_by_id(id);
                    session.setAttribute("ACCOUNT", account);
                    
                    try {
                        Thread.sleep(1500);
                    } catch (Exception e) {
                    }
                    
                    response.sendRedirect("Account");

//                    request.setAttribute("UPDATE_VALID", "Updated Successfully");
//                    RequestDispatcher rd = request.getRequestDispatcher("Profile_inner.jsp");
//                    rd.forward(request, response);
                } else {
                    Account account = dao.get_patient_by_id(id);
                    request.setAttribute("ACCOUNT", account);
                    RequestDispatcher rd = request.getRequestDispatcher("Profile_inner.jsp");
                    rd.forward(request, response);
                }
                
            } else if (updateType.equalsIgnoreCase("information")) {
                int id = Integer.parseInt(request.getParameter("txtID"));
                String phone = request.getParameter("txtPhone");
                String name = request.getParameter("txtName");
                String firstPhone = request.getParameter("txtPhone1");
                String address = request.getParameter("txtAddress");
                
                boolean gender = false;
                String txtGender = request.getParameter("txtGender");
                if (txtGender != null && txtGender.equals("Male")) {
                    gender = true;
                } else if (txtGender != null && txtGender.equals("Female")) {
                    gender = false;
                }
                
                boolean check = false;
                
                if (firstPhone.equalsIgnoreCase(phone)) {
                    check = true;
                } else {
                    if (valid.valid_phone(phone)) {
                        if (!valid.exist_phone(phone)) {
                            check = true;
                        } else {
                            request.setAttribute("UPDATE_VALID", "Phone number is existed.");
                        }
                    } else {
                        request.setAttribute("UPDATE_VALID", "Phone number is wrong format.");
                    }
                }
                
                if (check) {
                    boolean update = dao.update_patient(id, name, phone, gender, address);
                    if (update) {
                        Account account = dao.get_patient_by_id(id);
                        session.setAttribute("ACCOUNT", account);
                        
                        request.setAttribute("UPDATE_VALID", "Updated Successfully");
                        RequestDispatcher rd = request.getRequestDispatcher("Profile_inner.jsp");
                        rd.forward(request, response);
                    }
                } else {
                    Account account = dao.get_patient_by_id(id);
                    request.setAttribute("ACCOUNT", account);
                    RequestDispatcher rd = request.getRequestDispatcher("Profile_inner.jsp");
                    rd.forward(request, response);
                }
                
            } else if (updateType.equalsIgnoreCase("password")) {
//              update password
            } else {
                request.setAttribute("IMG", "error.gif");
                request.setAttribute("MESSAGE", "Invalid Request");
                request.setAttribute("MESSAGE2", "<a href='Home'> Back</a> to Homepage.");
                RequestDispatcher rd = request.getRequestDispatcher("Notification_inner.jsp");
                rd.forward(request, response);
            }
        } else {
            request.setAttribute("IMG", "error.gif");
            request.setAttribute("MESSAGE", "Invalid Request");
            request.setAttribute("MESSAGE2", "<a href='Home'> Back</a> to Homepage.");
            RequestDispatcher rd = request.getRequestDispatcher("Notification_inner.jsp");
            rd.forward(request, response);
        }
        
    }
    
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
