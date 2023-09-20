/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuthenticationController;

import Model.Patient;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author GL
 */
public abstract class BasePatientAuthenticationController extends HttpServlet{
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
    public Patient isAuthenticated(HttpServletRequest request) {
        if (request.getSession().getAttribute("patient")!= null) {
            Patient patient = (Patient) request.getSession().getAttribute("patient");
            return patient;
        }
        return null;
    }
    
    protected abstract void doGet(HttpServletRequest request, HttpServletResponse response, Patient patient) 
            throws ServletException, IOException;
    protected abstract void doPost(HttpServletRequest request, HttpServletResponse response, Patient patient) 
            throws ServletException, IOException;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Patient patient = isAuthenticated(request);
        if(patient!= null) {
            doGet(request, response, patient);
        }
        else {
            response.getWriter().print("Access Denied!");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Patient patient = isAuthenticated(request);
        if(patient!= null) {
            doGet(request, response, patient);
        }
        else {
            response.getWriter().print("Access Denied!");
        }
    }
    
}
