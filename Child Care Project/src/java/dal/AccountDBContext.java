/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import Model.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GL
 */
public class AccountDBContext extends DBHelper{
    public Account getInfo(Account acc) {
        try {
            String url = "select name, phone, email, gender, avatar, address, role_id from Patient where username = ? and password = ? "
                    + "UNION select name, phone, email, gender, avatar, address, role_id from Staff where username = ? and password = ? "
                    + "UNION select name, phone, email, gender, avatar, address, role_id from Admin where username = ? and password = ?";
            PreparedStatement stm = connection.prepareStatement(url);
            ResultSet rs = stm.executeQuery();
            if(rs.next()) {
                acc.setName(rs.getString(1));
                acc.setPhone(rs.getString(2));
                acc.setEmail(rs.getString(3));
                acc.setGender(rs.getBoolean(4));
                acc.setRoleId(rs.getInt(7));
            }
                    } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return acc;
    }
    
    public boolean isPatient() {
        return false;
    }
}
