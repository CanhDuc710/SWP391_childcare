/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Model.Account;
import Model.Services;
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
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author duchi
 */
@WebServlet(name = "CheckAvailableServlet", urlPatterns = {"/CheckAvailable"})
public class CheckAvailableServlet extends HttpServlet {

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
            out.println("<title>Servlet CheckAvailableServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckAvailableServlet at " + request.getContextPath() + "</h1>");
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
        String type = request.getParameter("btnType");
        DAO dao = new DAO();
        HttpSession session = request.getSession();

        if (type == null) {
            response.sendRedirect("ReservationContact");
        } else {
            if (type.equals("check")) {

                String childExist = request.getParameter("txtChildren");
                if (childExist == null) {
                    response.sendRedirect("ReservationContact?childrenExist=denied");
                }

                String dateString = request.getParameter("txtDate");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                try {
                    java.util.Date parsedDate = sdf.parse(dateString);
                    java.sql.Date selectedDate = new java.sql.Date(parsedDate.getTime());
                    java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(currentDate);
                    calendar.add(Calendar.MONTH, 1);
                    java.util.Date oneMonthLater = calendar.getTime();

                    if (selectedDate.compareTo(currentDate) <= 0 || selectedDate.compareTo(oneMonthLater) > 0) {
                        int slot = Integer.parseInt(request.getParameter("txtSlot"));
                        int doctorId = Integer.parseInt(request.getParameter("txtDoctor"));
                        int childId = Integer.parseInt(request.getParameter("txtChildren"));

                        response.sendRedirect("ReservationContact?Date=old&doctorId=" + doctorId + "&slotId=" + slot + "&DateSelect=" + selectedDate + "&ChildrenId=" + childId);

                    } else {
                        int slot = Integer.parseInt(request.getParameter("txtSlot"));
                        int doctorId = Integer.parseInt(request.getParameter("txtDoctor"));
                        int childId = Integer.parseInt(request.getParameter("txtChildren"));
                        boolean available = dao.check_slot_available(doctorId, slot, selectedDate);

                        if (available) {
                            //response.getWriter().write(dateString);
                            response.sendRedirect("ReservationContact?Date=ok&doctorId=" + doctorId + "&slotId=" + slot + "&DateSelect=" + selectedDate + "&ChildrenId=" + childId);
                        } else {
                            response.sendRedirect("ReservationContact?Date=unavailable&doctorId=" + doctorId + "&slotId=" + slot + "&DateSelect=" + selectedDate + "&ChildrenId=" + childId);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (type.equals("add")) {
                //kiem tra child
                String childExist = request.getParameter("txtChildren");
                if (childExist == null) {
                    response.sendRedirect("ReservationContact?childrenExist=denied");
                }

                //lay ra account tu session
                Account patient = (Account) session.getAttribute("ACCOUNT");

                //lay ra service list tu session
                ArrayList<Services> service_list = (ArrayList<Services>) session.getAttribute("CHOSEN_SERVICE_LIST");

                //tinh total
                double total = 0;
                for (Services service : service_list) {
                    total += service.getPrice() - (service.getPrice() * (service.getDiscount() / 100));
                }

                //lay ra parameter
                int patientId = patient.getAccountId();
                int slotId = Integer.parseInt(request.getParameter("txtSlot"));
                int staffId = Integer.parseInt(request.getParameter("txtDoctor"));
                String dateString = request.getParameter("txtDate");
                int childId = Integer.parseInt(request.getParameter("txtChildren"));

                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date parsedDate = sdf.parse(dateString);
                    java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());

                    //them vao bang Reservation
                    int add = dao.add_reservation(slotId, patientId, childId, staffId, sqlDate, total);

                    //them vao bang detail
                    boolean detail = false;
                    for (Services service : service_list) {
                        double price = service.getPrice() - (service.getPrice() * (service.getDiscount() / 100));
                        detail = dao.add_reservation_detail(add, service.getServiceId(), price);
                    }

                    if (add != 0 && detail) {
                        session.removeAttribute("CHOSEN_SERVICE_LIST");
                        //response.getWriter().write("id: " + add);
                        response.sendRedirect("MyReservation");
                    } else {
                        response.getWriter().write("failed");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                //response.getWriter().write("patientid:" + patientId + "- slotid:" + slotId + " - childId:" + childId + " - staffId:" + staffId + " - Date:" + dateString + " - total: " + total);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
