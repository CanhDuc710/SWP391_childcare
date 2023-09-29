/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import Model.*;
import java.util.Scanner;

/**
 *
 * @author BlackZ36
 */
public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DAO dao = new DAO();
        System.out.println("enter username: ");
        String name = sc.next();
        System.out.println("enter password: ");
        String password = sc.next();
        
        Account account = dao.PatientLogin(name, password);
        
        account.toString();
        
    }
}
