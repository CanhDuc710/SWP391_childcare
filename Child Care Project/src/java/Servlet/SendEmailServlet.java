/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Model.Account;
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
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author duchi
 */
@WebServlet(name = "SendEmailServlet", urlPatterns = {"/SendEmail"})
public class SendEmailServlet extends HttpServlet {

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
            out.println("<title>Servlet SendEmailServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SendEmailServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String type = request.getParameter("sendType");
        if (type != null && type.equalsIgnoreCase("passwordchange")) {
            RequestDispatcher rd = request.getRequestDispatcher("EnterEmail_password_inner.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("username", request.getParameter("txtUsername"));
            RequestDispatcher rd = request.getRequestDispatcher("EnterEmail_inner.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DAO dao = new DAO();

        //lay ra attribute
        String type = request.getParameter("isPassword");
        String email = request.getParameter("txtEmail");
        Account account = dao.get_patient_by_email(email);

        if (account != null) {

            int status = account.getStatusId();

            if (type.equalsIgnoreCase("true")) {

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
                dao.Send_Verify_Email(email, emailTemplate, 2, "");
                request.setAttribute("MESSAGE", "If Email is available, please check your email inbox.");
                RequestDispatcher rd = request.getRequestDispatcher("EnterEmail_password_inner.jsp");
                rd.forward(request, response);

            } else {
                if (status == 1) {
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
                    dao.Send_Verify_Email(email, emailTemplate, 1, "");
                    request.setAttribute("MESSAGE", "If Email is available, please check your email inbox.");
                    RequestDispatcher rd = request.getRequestDispatcher("EnterEmail_inner.jsp");
                    rd.forward(request, response);
                } else {
                    request.setAttribute("MESSAGE", "If Email is available, please check your email inbox.");
                    RequestDispatcher rd = request.getRequestDispatcher("EnterEmail_inner.jsp");
                    rd.forward(request, response);
                }
            }

        } else {
            request.setAttribute("MESSAGE", "If Email is available, please check your email inbox.");
            RequestDispatcher rd = request.getRequestDispatcher("EnterEmail_inner.jsp");
            rd.forward(request, response);
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
