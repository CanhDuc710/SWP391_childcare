/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Model.Account;
import Model.EmailVerify;
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

                String savePath = "C:\\Users\\BlackZ36\\Desktop\\SWP391_childcare\\Child Care Project\\web\\assets\\img\\" + File.separator + user_avatar_folder + username; //specify your path here
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
                        Thread.sleep(3500);
                    } catch (Exception e) {
                    }

                    response.sendRedirect("Account");

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

                String password = request.getParameter("txtPassword");
                String confirm = request.getParameter("txtConfirm");
                String resetEmail = request.getParameter("txtEmail");
                String id = request.getParameter("txtID");

                boolean change = false;
                if (password.equals(confirm)) {
                    if (valid.valid_password(password)) {
                        EmailVerify check = dao.Get_Verify_Email_DateTime(resetEmail, Integer.parseInt(id));
                        if (check != null && check.getStatus() != 0) {
                            boolean ok = dao.reset_password(resetEmail, password);
                            if (ok) {
                                dao.update_emailVerify_status(resetEmail, Integer.parseInt(id));
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
                        } else {
                            request.setAttribute("IMG", "error.gif");
                            request.setAttribute("MESSAGE", "Failed. Please Try Again");
                            request.setAttribute("MESSAGE2", "<a href='Login'> Back</a> to Login.");
                            RequestDispatcher rd = request.getRequestDispatcher("Notification_inner.jsp");
                            rd.forward(request, response);
                        }
                    } else {
                        request.setAttribute("USER_EMAIL", resetEmail);
                        request.setAttribute("MESSAGE", "Invalid Password Format: both letter and number (6-20)");
                        RequestDispatcher rd = request.getRequestDispatcher("include/reset_password_include.jsp");
                        rd.forward(request, response);
                    }
                } else {
                    request.setAttribute("USER_EMAIL", resetEmail);
                    request.setAttribute("MESSAGE", "Passwords do not match");
                    RequestDispatcher rd = request.getRequestDispatcher("include/reset_password_include.jsp");
                    rd.forward(request, response);
                }

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
