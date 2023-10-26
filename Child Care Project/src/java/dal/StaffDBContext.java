/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import Model.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GL
 */
public class StaffDBContext extends DBHelper{
    public ArrayList<Account> getDoctor() {
        ArrayList<Account> doctors = new ArrayList<>();
        try {
            String sql = "Select f.staff_id, f.name from Staff f inner join Role r on f.role_id = r.role_id where r.role_name = 'doctor'";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                Account doctor = new Account();
                doctor.setAccountId(id);
                doctor.setName(name);
                doctors.add(doctor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doctors;
    }
}
