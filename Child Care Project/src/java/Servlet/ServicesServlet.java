/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Model.*;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@WebServlet(name = "ServicesServlet", urlPatterns = {"/Services"})
public class ServicesServlet extends HttpServlet {

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
        VALID valid = new VALID();

        //get services list
        ArrayList<Services> service_list = dao.get_service_list();
        ArrayList<ServicesCategory> service_category_list = dao.get_service_category_list();

        //get feedback list
        ArrayList<AverageRate> average_rate = dao.get_average_rate_list();

        // Lấy tham số từ URL
        try {
            String show = request.getParameter("show");
            if (show == null || show.equals("0")) {
                request.setAttribute("SHOW", "0");

                //set attribute
                request.setAttribute("SERVICE_LIST", service_list);
                request.setAttribute("SERVICE_CATEGORY_LIST", service_category_list);
                request.setAttribute("AVERAGE_RATE", average_rate);
                //redirect
                RequestDispatcher rd = request.getRequestDispatcher("ServiceList_inner.jsp");
                rd.forward(request, response);

            } else if (show != null && !show.equals("0")) {
                ArrayList<Services> categoryService = new ArrayList<>();
                for (Services service : service_list) {
                    if (service.getCategoryId() == Integer.parseInt(show)) {
                        categoryService.add(service);
                    }
                }
                //set attribute
                request.setAttribute("SERVICE_LIST", categoryService);
                request.setAttribute("SERVICE_CATEGORY_LIST", service_category_list);
                request.setAttribute("AVERAGE_RATE", average_rate);
                //redirect
                RequestDispatcher rd = request.getRequestDispatcher("ServiceList_inner.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
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
        HttpSession session = request.getSession();
        DAO dao = new DAO();

        //get filter parameter
        String filter = request.getParameter("filter");
        String search = request.getParameter("search");

        //get services list
        ArrayList<Services> service_list = dao.get_service_list();
        ArrayList<ServicesCategory> service_category_list = dao.get_service_category_list();

        //get feedback list
        ArrayList<AverageRate> average_rate = dao.get_average_rate_list();

        if (search != null) {
            // Danh sách chứa các dịch vụ thỏa mãn điều kiện search
            ArrayList<Services> searchResult = new ArrayList<>();
            for (Services service : service_list) {
                if (service.getName().toLowerCase().contains(search.toLowerCase())) {
                    searchResult.add(service);
                }
            }
            request.setAttribute("SERVICE_LIST", searchResult);
            request.setAttribute("SERVICE_CATEGORY_LIST", service_category_list);
            request.setAttribute("AVERAGE_RATE", average_rate);
            //redirect
            RequestDispatcher rd = request.getRequestDispatcher("ServiceList_inner.jsp");
            rd.forward(request, response);
            return;
        } else if (filter == null || filter.equals("None")) {
            //set attribute
            request.setAttribute("SERVICE_LIST", service_list);
            request.setAttribute("SERVICE_CATEGORY_LIST", service_category_list);
            request.setAttribute("AVERAGE_RATE", average_rate);
            //redirect
            RequestDispatcher rd = request.getRequestDispatcher("ServiceList_inner.jsp");
            rd.forward(request, response);
            return;
        } else {
            if (filter.equalsIgnoreCase("Price: Low To High")) {
                // Sắp xếp theo giá tăng dần (asc)
                Collections.sort(service_list, new Comparator<Services>() {
                    @Override
                    public int compare(Services service1, Services service2) {
                        return Double.compare(service1.getPrice(), service2.getPrice());
                    }
                });
            } else if (filter.equalsIgnoreCase("Price: High To Low")) {
                // Sắp xếp theo giá giảm dần (desc)
                Collections.sort(service_list, new Comparator<Services>() {
                    @Override
                    public int compare(Services service1, Services service2) {
                        return Double.compare(service2.getPrice(), service1.getPrice());
                    }
                });
            }
        }
        //set attribute
        request.setAttribute("SERVICE_LIST", service_list);
        request.setAttribute("SERVICE_CATEGORY_LIST", service_category_list);
        request.setAttribute("AVERAGE_RATE", average_rate);

        //redirect
        RequestDispatcher rd = request.getRequestDispatcher("ServiceList_inner.jsp");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
