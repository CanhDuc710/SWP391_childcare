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
            String sql = "Select username, password, displayname from Patient\n"
                    + "where username = ?\n"
                    + "and password = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                String displayname = rs.getString("displayname");
                Patient patient = new Patient();
                patient.setUsername(username);
                patient.setPassword(password);
                patient.setUsername(displayname);
                return patient;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PatientDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
