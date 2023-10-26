/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import Model.Feature;
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
public class FeatureDBContext extends DBHelper{
    public ArrayList<Feature> get(String username, String password) {
        ArrayList<Feature> features = new ArrayList<>();
        try {
            String sql = "(select f.feature_id, f.name, f.url from Staff s "
                    + "inner join RoleFeature rf on s.role_id = rf.role_id "
                    + "inner join Feature f on rf.feature_id = f.feature_id "
                    + "where username = ? and password = ?)\n"
                    + "Union "
                    + "(select f.feature_id, f.name, f.url from Patient p "
                    + "inner join RoleFeature rf on p.role_id = rf.role_id "
                    + "inner join Feature f on rf.feature_id = f.feature_id "
                    + "where username = ? and password = ?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            stm.setString(3, username);
            stm.setString(4, password);
            ResultSet rs = stm.executeQuery();
            while(rs.next()) {
                Feature f = new Feature();
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String url = rs.getString(3);
                f.setFeature_id(id);
                f.setName(name);
                f.setUrl(url);
                features.add(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FeatureDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return features;
    }
}
