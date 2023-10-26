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
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author duchi
 */
@WebServlet(name = "Admin_Patient_Serlvet", urlPatterns = {"/Admin/Patient"})
public class Admin_Patient_Servlet extends HttpServlet {

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

            ArrayList<Account> patient_list = dao.admin_get_patients();

            request.setAttribute("ADMIN", admin);
            request.setAttribute("PATIENT_LIST", patient_list);

            RequestDispatcher rd = request.getRequestDispatcher("Patient_inner.jsp");
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
            boolean gender = false;
            if (request.getParameter("txtGender").equals("male")) {
                gender = true;
            }

            boolean register = dao.admin_patient_register(username, password, email, phone, name, gender);
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
                String passMess = "password: " + password; 
                String emailTemplate = contentBuilder.toString();
                dao.Send_Verify_Email(email, emailTemplate, 1, passMess);

            }
            response.sendRedirect("Patient");

        } else if (type.equals("Save")) {

            //lay tra parameter
            int id = Integer.parseInt(request.getParameter("txtID"));
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            String phone = request.getParameter("txtPhone");
            String email = request.getParameter("txtEmail");
            String name = request.getParameter("txtName");
            String address = request.getParameter("txtAddress");
            boolean gender = Boolean.parseBoolean(request.getParameter("txtGender"));
            int status = Integer.parseInt(request.getParameter("txtStatus"));

            //response.getWriter().write(id + " - " + username + " - " + password + " - " + phone + " - " + email + " - " + name + " - " + address + " - " + gender + " - " + status);
            boolean update = dao.admin_update_patient(id, username, password, email, phone, name, address, gender, status);
            response.sendRedirect("Patient");
        } else if (type.equals("Delete")) {

            int id = Integer.parseInt(request.getParameter("txtID"));
            boolean delete = dao.admin_delete_patient(id);
            response.sendRedirect("Patient");

        } else if (type.equals("search")) {
            String searchType = request.getParameter("txtSearchType");
            String search = request.getParameter("txtSearch");
            ArrayList<Account> patient_list = dao.admin_get_patients();
            ArrayList<Account> searchResults = new ArrayList<>();

            if (searchType.equals("id")) {
                for (Account patient : patient_list) {
                    if (String.valueOf(patient.getAccountId()).toLowerCase().contains(search)) {
                        searchResults.add(patient);
                    }
                }
            } else if (searchType.equals("name")) {
                for (Account patient : patient_list) {
                    if (patient.getName().toLowerCase().contains(search)) {
                        searchResults.add(patient);
                    }
                }
            } else if (searchType.equals("email")) {
                for (Account patient : patient_list) {
                    if (patient.getEmail().toLowerCase().contains(search)) {
                        searchResults.add(patient);
                    }
                }
            } else if (searchType.equals("phone")) {
                for (Account patient : patient_list) {
                    if (patient.getPhone().toLowerCase().contains(search)) {
                        searchResults.add(patient);
                    }
                }
            }

            request.setAttribute("PATIENT_LIST", searchResults);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Patient_inner.jsp");
            dispatcher.forward(request, response);

        } else if (type.equals("sort")) {
            String sort = request.getParameter("txtSort");
            ArrayList<Account> patient_list = dao.admin_get_patients();
            ArrayList<Account> sortResults = new ArrayList<>(patient_list);

            if (sort.equals("ascendingId")) {
                // Sắp xếp theo ID tăng dần
                Collections.sort(sortResults, new Comparator<Account>() {
                    @Override
                    public int compare(Account patient1, Account patient2) {
                        return Integer.compare(patient1.getAccountId(), patient2.getAccountId());
                    }
                });
            } else if (sort.equals("descendingId")) {
                // Sắp xếp theo ID giảm dần
                Collections.sort(sortResults, new Comparator<Account>() {
                    @Override
                    public int compare(Account patient1, Account patient2) {
                        return Integer.compare(patient2.getAccountId(), patient1.getAccountId());
                    }
                });
            } else if (sort.equals("femaleFirstGender")) {
                // Sắp xếp theo giới tính nam trước
                Collections.sort(sortResults, new Comparator<Account>() {
                    @Override
                    public int compare(Account patient1, Account patient2) {
                        return Boolean.compare(patient1.getGender(), patient2.getGender());
                    }
                });
            } else if (sort.equals("maleFirstGender")) {
                // Sắp xếp theo giới tính nữ trước
                Collections.sort(sortResults, new Comparator<Account>() {
                    @Override
                    public int compare(Account patient1, Account patient2) {
                        return Boolean.compare(patient2.getGender(), patient1.getGender());
                    }
                });
            } else if (sort.equals("status")) {
                // Sắp xếp theo trạng thái
                Collections.sort(sortResults, new Comparator<Account>() {
                    @Override
                    public int compare(Account patient1, Account patient2) {
                        return Integer.compare(patient1.getStatusId(), patient2.getStatusId());
                    }
                });
            }

            request.setAttribute("PATIENT_LIST", sortResults);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Patient_inner.jsp");
            dispatcher.forward(request, response);
        } else {
            response.getWriter().write(type);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
