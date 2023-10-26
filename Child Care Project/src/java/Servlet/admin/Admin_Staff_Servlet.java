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
                dao.Send_Verify_Email(email, emailTemplate, 3, passMess);

            }
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

        } else if (type.equals("search")) {
            String searchType = request.getParameter("txtSearchType");
            String search = request.getParameter("txtSearch");
            ArrayList<Account> staff_list = dao.admin_get_staffs();
            ArrayList<Account> searchResults = new ArrayList<>();

            if (searchType.equals("id")) {
                for (Account staff : staff_list) {
                    if (String.valueOf(staff.getAccountId()).toLowerCase().contains(search)) {
                        searchResults.add(staff);
                    }
                }
            } else if (searchType.equals("name")) {
                for (Account staff : staff_list) {
                    if (staff.getName().toLowerCase().contains(search)) {
                        searchResults.add(staff);
                    }
                }
            } else if (searchType.equals("email")) {
                for (Account staff : staff_list) {
                    if (staff.getEmail().toLowerCase().contains(search)) {
                        searchResults.add(staff);
                    }
                }
            } else if (searchType.equals("phone")) {
                for (Account staff : staff_list) {
                    if (staff.getPhone().toLowerCase().contains(search)) {
                        searchResults.add(staff);
                    }
                }
            }

            request.setAttribute("STAFF_LIST", searchResults);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Staff_inner.jsp");
            dispatcher.forward(request, response);

        } else if (type.equals("sort")) {
            String sort = request.getParameter("txtSort");
            ArrayList<Account> staff_list = dao.admin_get_staffs();
            ArrayList<Account> sortResults = new ArrayList<>(staff_list);

            if (sort.equals("ascendingId")) {
                // Sắp xếp theo ID tăng dần
                Collections.sort(sortResults, new Comparator<Account>() {
                    @Override
                    public int compare(Account staff1, Account staff2) {
                        return Integer.compare(staff1.getAccountId(), staff2.getAccountId());
                    }
                });
            } else if (sort.equals("descendingId")) {
                // Sắp xếp theo ID giảm dần
                Collections.sort(sortResults, new Comparator<Account>() {
                    @Override
                    public int compare(Account staff1, Account staff2) {
                        return Integer.compare(staff2.getAccountId(), staff1.getAccountId());
                    }
                });
            } else if (sort.equals("femaleFirstGender")) {
                // Sắp xếp theo giới tính nam trước
                Collections.sort(sortResults, new Comparator<Account>() {
                    @Override
                    public int compare(Account staff1, Account staff2) {
                        return Boolean.compare(staff1.getGender(), staff2.getGender());
                    }
                });
            } else if (sort.equals("maleFirstGender")) {
                // Sắp xếp theo giới tính nữ trước
                Collections.sort(sortResults, new Comparator<Account>() {
                    @Override
                    public int compare(Account staff1, Account staff2) {
                        return Boolean.compare(staff2.getGender(), staff1.getGender());
                    }
                });
            } else if (sort.equals("status")) {
                // Sắp xếp theo trạng thái
                Collections.sort(sortResults, new Comparator<Account>() {
                    @Override
                    public int compare(Account staff1, Account staff2) {
                        return Integer.compare(staff1.getStatusId(), staff2.getStatusId());
                    }
                });
            }

            request.setAttribute("STAFF_LIST", sortResults);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Staff_inner.jsp");
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
