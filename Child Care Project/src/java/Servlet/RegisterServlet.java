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
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author BlackZ36
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/Register"})
public class RegisterServlet extends HttpServlet {

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

                boolean register = dao.PatientRegister(username, password, email, phone, name, gender);
                if (register) {
                    String realPath = getServletContext().getRealPath("/");
                    // Tạo đường dẫn tuyệt đối đến tệp tin template
                    String templateFilePath = realPath + "/email_verify_template.html";
                    // Đọc nội dung từ tệp tin template
                    StringBuilder contentBuilder = new StringBuilder();
                    try ( InputStream inputStream = new FileInputStream(templateFilePath);  InputStreamReader inputStreamReader = new InputStreamReader(inputStream);  BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            contentBuilder.append(line);
                        }
                    }

                    // Nội dung email từ tệp tin template
                    String emailTemplate = contentBuilder.toString();
                    dao.Send_Verify_Email(email, emailTemplate, 1);
                    request.setAttribute("IMG", "success.gif");
                    request.setAttribute("MESSAGE", "<p style='color: green;'>Registration Successful</p>");
                    request.setAttribute("MESSAGE2", "Click <a href='Login'>here</a> to return to the login page.");
                    RequestDispatcher rd = request.getRequestDispatcher("Notification_inner.jsp");
                    rd.forward(request, response);
                } else {
                    request.setAttribute("MESSAGE", "<p style='color: red;'>Registration Failed</p>");
                    request.setAttribute("MESSAGE2", "Click <a href='Login'>here</a> to return to the login page.");
                    RequestDispatcher rd = request.getRequestDispatcher("Notification_inner.jsp");
                    rd.forward(request, response);
                }

            } else {
                request.setAttribute("regUsername", username);
                request.setAttribute("regName", name);
                request.setAttribute("regEmail", email);
                request.setAttribute("regPhone", phone);
                RequestDispatcher rd = request.getRequestDispatcher("Login_inner.jsp");
                rd.forward(request, response);
            }

        } else if (reg_type.equalsIgnoreCase("staff")) {

        }

    }

    private String readTemplateFile(String filePath) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try ( BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                contentBuilder.append(line);
            }
        }
        return contentBuilder.toString();
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
