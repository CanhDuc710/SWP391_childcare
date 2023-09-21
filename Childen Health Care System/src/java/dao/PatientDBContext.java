/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Model.Patient;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GL
 */
public class PatientDBContext extends DBContext{
    public Patient getAccount(String username, String password) {
        try {
            String sql = "Select * "
                    + "where username = ? "
                    + "and password = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {

                Patient patient = new Patient();
                patient.setAccount_id(rs.getInt("patient_id"));
                patient.setUsername(username);
                patient.setPassword(password);
                patient.setEmail(rs.getString("email"));
                patient.setPhone(rs.getString("phone"));
                patient.setName(rs.getString("name"));
                
                
                return patient;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PatientDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
