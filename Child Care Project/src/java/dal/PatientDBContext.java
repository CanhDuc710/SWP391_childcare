/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

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
public class PatientDBContext extends DBHelper {
    public Patient getAccount(String username, String password) {
        try {
            String sql = "SELECT * FROM Patient "
                    + "WHERE username = ? "
                    + "AND password = ?";
            
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
            
        }
        return null;
    }
    
}
