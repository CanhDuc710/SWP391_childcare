/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuthenticationController;

import Model.Account;
import Model.Patient;
import Model.Staff;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author GL
 */
public abstract class BaseAuthenticationController extends HttpServlet {

    private Account isAuthenticated(HttpServletRequest request) {
        if (request.getSession().getAttribute("staff")!= null) {
            Patient patient = (Patient) request.getSession().getAttribute("patient");
            return patient;
        }
        else if (request.getSession().getAttribute("staff")!= null) {
            Staff staff = (Staff) request.getSession().getAttribute("staff");
            return staff;
        }
        return null;
    }
    
    protected abstract void doGet(HttpServletRequest request, HttpServletResponse response,Account acc)
    throws ServletException, IOException; 
    
    protected abstract void doPost(HttpServletRequest request, HttpServletResponse response,Account acc)
    throws ServletException, IOException; 
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Account acc = isAuthenticated(request);
        if(acc!= null) {
            doGet(request, response, acc);
        }
        else {
            response.getWriter().print("Access Denied!");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Account acc = isAuthenticated(request);
                if(acc != null) doPost(request, response, acc);

        else response.getWriter().print("Access Denied!");
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
