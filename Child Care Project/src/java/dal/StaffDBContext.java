/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import Model.Feature;
import Model.Staff;
import Model.Role;
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
public class StaffDBContext extends DBHelper {

    public Staff getAccount(String username, String password) {
        try {
            String sql = "Select username, password, name from Patient\n"
                    + "where username = ?\n"
                    + "and password = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                Staff staff = new Staff();
                staff.setUsername(username);
                staff.setPassword(password);
                return staff;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PatientDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Role> getRoles(String username) {
        ArrayList<Role> roles = new ArrayList<>();
        try {
            String sql = "select name from role where username = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Role r = new Role();
                String name = rs.getString(1);
                r.setName(name);
                roles.add(r);
            }
            return roles;
        } catch (SQLException ex) {
            Logger.getLogger(StaffDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return roles;
    }

    public ArrayList<Feature> getFeatures(String username) {
        ArrayList<Feature> features = new ArrayList<>();
        try {
            String sql = "ar.username, f.name as roleName, f.url from "
                    + "Account_Role ar inner join role_feature rf on ar.roleid = rf.roleid "
                    + "inner join feature f on f.id = rf.featureid"
                    + "where ar.username = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Feature f = new Feature();
                String name = rs.getString(2);
                String url = rs.getString(3);
                f.setName(name);
                f.setUrl(url);
                features.add(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return features;
    }

}
