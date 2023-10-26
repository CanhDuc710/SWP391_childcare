/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuthenticationController;

import Model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author GL
 */
public abstract class BaseAccountAuthenticationController extends HttpServlet{
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
    public Account isAuthenticated(HttpServletRequest request) {
        if (request.getSession().getAttribute("ADMIN")!= null) {
            Admin admin = (Admin) request.getSession().getAttribute("ADMIN");
            Account acc = new Account();
            acc.setAccountId(admin.getAdminId());
            acc.setUsername(admin.getUsername());
            acc.setPassword(admin.getPassword());
            return acc;
        }
        if (request.getSession().getAttribute("ACCOUNT")!= null) {
            Account acc = (Account) request.getSession().getAttribute("ACCOUNT");
            return acc;
        }
        return null;
    }
    
    protected abstract void doGet(HttpServletRequest request, HttpServletResponse response, Account acc) 
            throws ServletException, IOException;
    protected abstract void doPost(HttpServletRequest request, HttpServletResponse response, Account acc) 
            throws ServletException, IOException;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Account acc = isAuthenticated(request);
        if(acc!= null) {
            doGet(request, response, acc);
        }
        else {
            response.sendRedirect("../Error403");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Account acc = isAuthenticated(request);
        if(acc!= null) {
            doPost(request, response, acc);
        }
        else {
            response.sendRedirect("../Error403");
        }
    }
    
}
