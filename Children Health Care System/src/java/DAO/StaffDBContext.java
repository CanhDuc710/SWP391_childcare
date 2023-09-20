/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Model.Feature;
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
public class StaffDBContext extends DBContext {

    public ArrayList<Role> getRoles(String username) {
        ArrayList<Role> roles = new ArrayList<>();
        try{
            String sql = "?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Role r = new Role();
                
            }
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
