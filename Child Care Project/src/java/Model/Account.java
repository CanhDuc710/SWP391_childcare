/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author BlackZ36
 */
public class Account {

    private int accountId;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String name;
    private String gender;
    private String avatar;
    private int roleId;
    private int statusId;

    //constructor
    public Account() {
    }

    public Account(int accountId, String username, String password, String email, String phone, String name, String gender, String avatar, int roleId, int statusId) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.name = name;
        this.gender = gender;
        this.avatar = avatar;
        this.roleId = roleId;
        this.statusId = statusId;
    }

    //getter and setter
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    //other logic method
    @Override
    public String toString() {
        return "Account{" + "accountId=" + accountId + ", username=" + username + ", password=" + password + ", email=" + email + ", phone=" + phone + ", name=" + name + ", gender=" + gender + ", avatar=" + avatar + ", roleId=" + roleId + ", statusId=" + statusId + '}';
    }

}
