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
public abstract class BaseAuthorizationController extends BaseAuthenticationController{
    private ArrayList<Feature> isAuthorized(HttpServletRequest request) {
        String accessURL = request.getServletPath();
        StaffDBContext sdb = new StaffDBContext();
        Staff staff = (Staff)request.getServletContext().getAttribute("staff");
        staff.setRoles(sdb.getRole());
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, Account acc) throws ServletException, IOException {
        
       doAuthGet(HttpServletRequest request, HttpServletResponse response, Staff staff);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, Account acc) throws ServletException, IOException {
        doAuthPost();
    }
    
    
}
