/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

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
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author BlackZ36
 */
@WebServlet(name = "AddServiceServlet", urlPatterns = {"/AddService"})
public class AddServiceServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddServiceServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddServiceServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        HttpSession session = request.getSession();

        String txtID = request.getParameter("serviceId");
        String remove = request.getParameter("remove");

        // Lấy danh sách đã chọn từ session
        ArrayList<Services> chosenServices = (ArrayList<Services>) session.getAttribute("CHOSEN_SERVICE_LIST");
        if (chosenServices == null) {
            chosenServices = new ArrayList<>();
        }

        if (remove != null) {
            int removeId = Integer.parseInt(remove);
            Iterator<Services> iterator = chosenServices.iterator();
            while (iterator.hasNext()) {
                Services service = iterator.next();
                if (service.getServiceId() == removeId) {
                    iterator.remove();
                }
            }
            session.setAttribute("CHOSEN_SERVICE_LIST", chosenServices);
            response.sendRedirect("ReservationDetail");
        } else if (txtID == null) {
            response.sendRedirect("Services?show=0");
        } else {
            int id = Integer.parseInt(request.getParameter("serviceId"));
            Services service = dao.get_service_by_id(id);

            // Kiểm tra xem dịch vụ đã tồn tại trong danh sách chưa
            boolean serviceExists = false;
            for (Services chosenService : chosenServices) {
                if (chosenService.getServiceId() == service.getServiceId()) {
                    serviceExists = true;
                    break;
                }
            }

            // Nếu dịch vụ đã tồn tại, hiển thị thông báo và không thêm vào danh sách
            if (serviceExists) {
                request.setAttribute("NOTIBOX", true);
                request.setAttribute("NOTICONTENT", "Service " + service.getName() + " Is Already In Your Service List.");
                RequestDispatcher rd = request.getRequestDispatcher("Services");
                rd.forward(request, response);
            } else {
                // Nếu dịch vụ chưa tồn tại, thêm vào danh sách và cập nhật session
                chosenServices.add(service);
                session.setAttribute("CHOSEN_SERVICE_LIST", chosenServices);

                request.setAttribute("NOTIBOX", true);
                request.setAttribute("NOTICONTENT", "Added Service " + service.getName() + " Successfully.");
                RequestDispatcher rd = request.getRequestDispatcher("Services");
                rd.forward(request, response);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("txtID"));
        response.getWriter().write("day la add service voi service id = " + id);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
