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
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author BlackZ36
 */
@WebServlet(name = "ReservationContactServlet", urlPatterns = {"/ReservationContact"})
public class ReservationContactServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServicesServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServicesServlet at " + request.getContextPath() + "</h1>");
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
        ArrayList<Services> chosen_service_list = (ArrayList<Services>) session.getAttribute("CHOSEN_SERVICE_LIST");

        String dateStatus = request.getParameter("Date");
        String childStatus = request.getParameter("childrenExist");

        if (childStatus != null && childStatus.equals("denied")) {
            request.setAttribute("NOTIBOX", true);
            request.setAttribute("NOTICONTENT", "Please Add At Least 1 Children");
            RequestDispatcher rd = request.getRequestDispatcher("MyChildren");
            rd.forward(request, response);
            return;
        } else if (childStatus != null) {
            response.sendRedirect("MyChildren");
            return;
        }

        if (dateStatus != null && dateStatus.equals("old")) {
            String selectedDoctorId = request.getParameter("doctorId");
            String selectedSlotId = request.getParameter("slotId");
            String selectedDate = request.getParameter("Date");
            String selectedChild = request.getParameter("ChildrenId");
            request.setAttribute("selectedDoctorId", selectedDoctorId);
            request.setAttribute("selectedDate", selectedDate);
            request.setAttribute("selectedSlotId", selectedSlotId);
            request.setAttribute("selectedChildId", selectedChild);

            request.setAttribute("NOTIBOX", true);
            request.setAttribute("NOTICONTENT", "Please Check Doctor Chosen Status");
            request.setAttribute("STATUS", "Please Choose A Future Date Within One Month.");
            request.setAttribute("color", "red");
            request.setAttribute("button", "disabled");
        } else if (dateStatus != null && dateStatus.equals("ok")) {
            String selectedDoctorId = request.getParameter("doctorId");
            String selectedSlotId = request.getParameter("slotId");
            String selectedDate = request.getParameter("Date");
            String selectedChild = request.getParameter("ChildrenId");
            request.setAttribute("selectedDoctorId", selectedDoctorId);
            request.setAttribute("selectedDate", selectedDate);
            request.setAttribute("selectedSlotId", selectedSlotId);
            request.setAttribute("selectedChildId", selectedChild);

            request.setAttribute("NOTIBOX", true);
            request.setAttribute("NOTICONTENT", "Available");
            request.setAttribute("STATUS", "Ready to book.");
            request.setAttribute("color", "green");
            request.setAttribute("button", "");

        } else if (dateStatus != null && dateStatus.equals("unavailable")) {
            String selectedDoctorId = request.getParameter("doctorId");
            String selectedSlotId = request.getParameter("slotId");
            String selectedDate = request.getParameter("Date");
            String selectedChild = request.getParameter("ChildrenId");
            request.setAttribute("selectedDoctorId", selectedDoctorId);
            request.setAttribute("selectedDate", selectedDate);
            request.setAttribute("selectedSlotId", selectedSlotId);
            request.setAttribute("selectedChildId", selectedChild);

            request.setAttribute("NOTIBOX", true);
            request.setAttribute("NOTICONTENT", "This Slot Is Not Available. Please Choose Other.");
            request.setAttribute("STATUS", "Choose Another Slot Or Date.");
            request.setAttribute("color", "red");
            request.setAttribute("button", "disabled");
        } else {
            request.setAttribute("button", "disabled");
        }

        if (account != null) {

            if (chosen_service_list != null) {

                ArrayList<ServicesCategory> category_list = dao.get_service_category_list();
                ArrayList<Children> children_list = dao.get_children_by_parentID(account.getAccountId());
                LocalDate today = LocalDate.now();
                ArrayList<Account> doctor_list = dao.get_doctor_list();
                ArrayList<Slot> slot_list = dao.get_slot_list();
                double total = 0;
                for (Services service : chosen_service_list) {
                    total += service.getPrice() - (service.getPrice() * (service.getDiscount() / 100));
                }

                request.setAttribute("TOTAL", total);
                request.setAttribute("DATE", today);
                request.setAttribute("SLOT_LIST", slot_list);
                request.setAttribute("CATEGORY_LIST", category_list);
                request.setAttribute("DOCTOR_LIST", doctor_list);
                request.setAttribute("CHOSEN_SERVICE_LIST", chosen_service_list);
                request.setAttribute("CHILDREN_LIST", children_list);
                request.setAttribute("ACCOUNT", account);
                RequestDispatcher rd = request.getRequestDispatcher("ReservationContact_inner.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("NOTIBOX", true);
                request.setAttribute("NOTICONTENT", "Please Add One Or More Service(s)");
                RequestDispatcher rd = request.getRequestDispatcher("Services");
                rd.forward(request, response);
            }

        } else {
            request.setAttribute("LOGIN_VALID", "Please Login First");
            RequestDispatcher rd = request.getRequestDispatcher("Login_inner.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().write("submit sau khi chon bac si");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
