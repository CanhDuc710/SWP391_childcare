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
                int accountId = rs.getInt("account_id");
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

    public boolean register(int id, String username, String password, String name, String address, String email, String phone, int role, Date date, int status) {
        String sql = "INSERT INTO Account (account_id, username, password, name, address, email, phone, role, created_at, status) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        java.sql.Date newDate = new java.sql.Date(date.getTime());
        try {
            st = connection.prepareStatement(sql);

            st.setInt(1, id);
            st.setString(2, username);
            st.setString(3, password);
            st.setString(4, name);
            st.setString(5, address);
            st.setString(6, email);
            st.setString(7, phone);
            st.setInt(8, role);
            st.setDate(9, newDate);
            st.setInt(10, status);

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
            message.setSubject("Account Verification FROM PRJ301 Assignment");

            // Tạo nội dung HTML cho email
            String originalLink = "http://localhost:8080/PRJ301-Assignment/Verify";

            // Mã hóa email
            String encodedEmail = Base64.getUrlEncoder().encodeToString(user_email.getBytes(StandardCharsets.UTF_8));

            // Tạo đường dẫn hoàn chỉnh chứa phần mã hóa
            String link = originalLink + "?encodedEmail=" + encodedEmail;

            String content = "<html>"
                    + "<body>"
                    + "<p>This is an automatic email for account activation.</p>"
                    + "<p>Please click the link below to verify your account.</p>"
                    + "<p>Link: <a href=\"" + link + "\">Verify Account</a></p>"
                    + "<p>or copy this: " + link + " </p>"
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

}
