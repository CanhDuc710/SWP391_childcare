/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.*;
import Model.*;
import java.util.regex.Pattern;

/**
 *
 * @author duchi
 */
public class VALID {

    public boolean exist_email(String email) {

        DAO dao = new DAO();
        ArrayList<Account> account_list = dao.get_account_list();

        for (Account account : account_list) {
            if (account.getEmail().equals(email)) {
                return true;
            }
        }

        return false;
    }

    public boolean exist_phone(String phone) {

        DAO dao = new DAO();
        ArrayList<Account> account_list = dao.get_account_list();

        for (Account account : account_list) {
            if (account.getPhone().equals(phone)) {
                return true;
            }
        }
        return false;
    }

    public boolean exist_username(String username) {

        DAO dao = new DAO();
        ArrayList<Account> account_list = dao.get_account_list();

        for (Account account : account_list) {
            if (account.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean valid_password(String password) {

        String regex = "^(?=.*[0-9])(?=.*[a-zA-Z]).{6,15}$";
        return password.matches(regex);
    }

    public boolean valid_username(String username) {
        String regex = "^[a-zA-Z0-9]{6,20}$";
        return Pattern.matches(regex, username);
    }

    public boolean valid_phone(String phone) {
        if (phone.matches("\\d{10}")) {
            return true;
        }
        return false;
    }

    public boolean confirm_password(String password, String confirm) {
        if (password.equals(confirm)) {
            return true;
        }

        return false;
    }

}
