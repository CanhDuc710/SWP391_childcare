/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuthenticationController;

import Model.Account;
import Model.Feature;
import dal.AdminDBContext;
import dal.FeatureDBContext;
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
public abstract class BaseAccountAuthorizationController extends BaseStaffAuthenticationController{
    
    private boolean isAuthorized(HttpServletRequest request, Account acc) {
        boolean flag;
        
        AdminDBContext adb = new AdminDBContext();
        flag = adb.isAdmin(acc.getUsername(), acc.getPassword());
        
        String accessURL = request.getServletPath();
        FeatureDBContext fdb = new FeatureDBContext();
        ArrayList<Feature> features = fdb.get(acc.getUsername(), acc.getPassword());
        for (Feature f : features) {
            if(f.getUrl().equals(accessURL)) flag = true;
        }
        return flag;
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, Account staff) throws ServletException, IOException {
       if(isAuthorized(request, staff)) {
            doAuthGet(request, response, staff);
        }
        else {
            response.getWriter().println("Access Denied");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, Account staff) throws ServletException, IOException {
        
        if(isAuthorized(request, staff)) {
            doAuthPost(request, response, staff);
        }
        else {
            response.getWriter().println("Access Denied");
        }
    }
    
    protected abstract void doAuthGet(HttpServletRequest request, HttpServletResponse response, Account staff)
            throws ServletException, IOException;
    
    protected abstract void doAuthPost(HttpServletRequest request, HttpServletResponse response, Account staff) 
            throws ServletException, IOException;
}
