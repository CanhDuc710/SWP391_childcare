/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.*;
import Model.*;

/**
 *
 * @author duchi
 */
public class VALID {

    public boolean valid_email(String email) {

        DAO dao = new DAO();
        ArrayList<Patient> patient_list = dao.get_patient_list();

        for (Patient patient : patient_list) {
            if (patient.getEmail().equals(email)) {
                return true;
            }
        }

        return false;
    }

    public boolean valid_phone(String phone) {

        DAO dao = new DAO();
        ArrayList<Patient> patient_list = dao.get_patient_list();

        for (Patient patient : patient_list) {
            if (patient.getPhone().equals(phone)) {
                return true;
            }
        }

        if (phone.length() != 10) {
            return true;
        }

        if (!phone.matches("\\d+")) {
            return true;
        }

        return false;
    }
    
    public boolean valid_password(String password){
        
        if(password.length() < 6 || password.length() >30){
            return false;
        }else if (!password.matches("^(?=.*[a-zA-Z])(?=.*[0-9]).+$")) {
            return false;
        }
        
        return true;
    }
    
}
