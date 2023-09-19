/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuthenticationController;

import Model.Account;
import Model.Feature;
import Model.Staff;
import dao.StaffDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author GL
 */
public abstract class BaseStaffAuthorizationController extends BaseStaffAuthenticationController{
    
    private boolean isAuthorized(HttpServletRequest request, Staff staff) {
        String accessURL = request.getServletPath();
        StaffDBContext sdb = new StaffDBContext();
        staff.setRoles(sdb.getRoles(staff.getUsername()));
        ArrayList<Feature> features = sdb.getFeatures(staff.getUsername());
        for (Feature f : features) {
            if(f.getUrl().equals(accessURL)) return true;
        }
        return false;
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, Staff staff) throws ServletException, IOException {
       if(isAuthorized(request, staff)) {
            doAuthGet(request, response, staff);
        }
        else {
            response.getWriter().println("Access Denied");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, Staff staff) throws ServletException, IOException {
        
        if(isAuthorized(request, staff)) {
            doAuthPost(request, response, staff);
        }
        else {
            response.getWriter().println("Access Denied");
        }
    }
    
    protected abstract void doAuthGet(HttpServletRequest request, HttpServletResponse response, Staff staff)
            throws ServletException, IOException;
    
    protected abstract void doAuthPost(HttpServletRequest request, HttpServletResponse response, Staff staff) 
            throws ServletException, IOException;
}
