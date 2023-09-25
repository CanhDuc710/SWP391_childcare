/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.io.UnsupportedEncodingException;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.mail.*;
import javax.mail.internet.*;

import Model.*;

/**
 *
 * @author duchi
 */
public class DAO extends DBHelper {

    private PreparedStatement st;
    private ResultSet rs;
    private String sql;

    public Patient PatientLogin(String txtUsername, String txtPassword) {
        Patient patient = new Patient();
        sql = "SELECT * "
                + "FROM Patient "
                + "WHERE username = ? "
                + "AND password = ?";

        try {
            st = connection.prepareStatement(sql);
            st.setString(1, txtUsername);
            st.setString(2, txtPassword);
            rs = st.executeQuery();

            while (rs.next()) {
                int patient_id = rs.getInt("patient_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String name = rs.getString("name");

                patient = new Patient(patient_id, username, password, email, phone, name);
                return patient;
            }

        } catch (SQLException e) {
        }

        return null;
    }

    public boolean register(int id, String username, String password, String name, String email, String phone) {
        String sql = "INSERT INTO Patient (account_id, username, password, email, phone, name) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            st = connection.prepareStatement(sql);

            st.setInt(1, id);
            st.setString(2, username);
            st.setString(3, password);
            st.setString(4, email);
            st.setString(5, phone);
            st.setString(6, name);

            int rowsUpdated = st.executeUpdate();
            if (rowsUpdated > 0) {
                return true;
            }

        } catch (SQLException e) {
        }

        return false;
    }

    public String Send(String user_email) throws UnsupportedEncodingException {

        // Thông tin tài khoản email
        String username = "duchinh03061@gmail.com";
        String password = "ygdiuklubcwheyur";

        // Cấu hình SMTP server và thông tin cổng
        String host = "smtp.gmail.com";
        int port = 587;

        // Cấu hình các thuộc tính kết nối
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        // Tạo đối tượng Session để xác thực truy cập SMTP server
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Tạo đối tượng MimeMessage
            MimeMessage message = new MimeMessage(session);

            // Thiết lập thông tin người gửi
            message.setFrom(new InternetAddress(username));

            // Thiết lập thông tin người nhận
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(user_email));

            // Thiết lập tiêu đề email
            message.setSubject("Password Reset FROM SWP391 Project");

            // Tạo nội dung HTML cho email
            String originalLink = "http://localhost:8080/Child_Care_Project/Reset";

            // Mã hóa email
            String encodedEmail = Base64.getUrlEncoder().encodeToString(user_email.getBytes(StandardCharsets.UTF_8));

            // Tạo đường dẫn hoàn chỉnh chứa phần mã hóa
            String link = originalLink + "?encodedEmail=" + encodedEmail;

            String content = "<html>"
                    + "<body>"
                    + "<p>This is an automatic email for password reset.</p>"
                    + "<p>Please click the link below to reset your account password.</p>"
                    + "<p>Link: <a href=\"" + link + "\">Reset Password</a></p>"
                    + "</body>"
                    + "</html>";

            // Thiết lập nội dung email dưới dạng HTML với encoding UTF-8
            message.setContent(content, "text/html; charset=UTF-8");

            // Gửi email
            Transport.send(message);
            return "Email has been sent successfully";
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "Email sent failed ";
    }

    public boolean verify(String email) {

        sql = "UPDATE Account "
                + "SET status = 1 "
                + "WHERE email = ?";

        try {
            st = connection.prepareStatement(sql);
            st.setString(1, email);
            int row = st.executeUpdate();

            if (row > 0) {
                return true;
            }

        } catch (SQLException e) {
        }

        return false;
    }

    public ArrayList<Patient> get_patient_list() {
        ArrayList<Patient> list = new ArrayList<>();
        sql = "SELECT * FROM Patient";

        try {

            st = connection.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                int accountId = rs.getInt("patient_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String name = rs.getString("name");

                Patient patient = new Patient(accountId, username, password, email, phone, name);
                list.add(patient);
            }

        } catch (SQLException e) {
        }

        return list;
    }

    public boolean change_password(int id, String password) {

        sql = "UPDATE Patient "
                + "SET password = ? "
                + "WHERE patient_id = ?";

        try {
            st = connection.prepareStatement(sql);
            st.setString(1, password);
            st.setInt(2, id);
            int row = st.executeUpdate();

            if (row > 0) {
                return true;
            }

        } catch (SQLException e) {
        }

        return false;
    }

    public boolean updateInfor(int id, String name, String email, String phone) {

        sql = "UPDATE Patient SET name = ?, email = ?, phone = ? WHERE patient_id = ?";

        try {
            st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, email);
            st.setString(3, phone);
            st.setInt(4, id);

            int row = st.executeUpdate();

            if (row > 0) {
                return true;
            }

        } catch (SQLException e) {
        }

        return false;
    }

    public Account get_patient_by_id(int id) {
        Patient patient = new Patient();
        sql = "SELECT * "
                + "FROM Patient "
                + "WHERE patient_id = ?";

        try {
            st = connection.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();

            while (rs.next()) {
                int accountId = rs.getInt("patient_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");

                patient = new Patient(accountId, username, password, email, phone, name);
                return patient;
            }

        } catch (SQLException e) {
        }

        return null;
    }
}
