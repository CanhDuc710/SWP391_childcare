/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.io.UnsupportedEncodingException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

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

    public Account PatientLogin(String txtUsername, String txtPassword) {
        Account account = new Account();
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
                int account_id = rs.getInt("patient_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String avatar = rs.getString("avatar");
                String address = rs.getString("address");
                int status = rs.getInt("status_id");
                int role = rs.getInt("role_id");

                account = new Account(account_id, username, password, email, phone, name, gender, avatar, address, role, status);
                return account;
            }

        } catch (SQLException e) {
        }

        return null;
    }

    public Account StaffLogin(String txtUsername, String txtPassword) {
        Account account = new Account();
        sql = "SELECT * "
                + "FROM Staff "
                + "WHERE username = ? "
                + "AND password = ?";

        try {
            st = connection.prepareStatement(sql);
            st.setString(1, txtUsername);
            st.setString(2, txtPassword);
            rs = st.executeQuery();

            while (rs.next()) {
                int account_id = rs.getInt("staff_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String avatar = rs.getString("avatar");
                String address = rs.getString("address");
                int status = rs.getInt("status_id");
                int role = rs.getInt("role_id");

                account = new Account(account_id, username, password, email, phone, name, gender, avatar, address, role, status);
                return account;
            }

        } catch (SQLException e) {
        }

        return null;
    }

    public boolean PatientRegister(int id, String username, String password, String name, String email, String phone) {
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

    public boolean set_status_patient(String email, int status) {

        sql = "UPDATE Patient "
                + "SET status = ? "
                + "WHERE email = ?";

        try {
            st = connection.prepareStatement(sql);
            st.setInt(1, status);
            st.setString(2, email);
            int row = st.executeUpdate();

            if (row > 0) {
                return true;
            }

        } catch (SQLException e) {
        }

        return false;
    }

    public boolean change_patient_password(int id, String password) {

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

    public boolean change_staff_password(int id, String password) {

        sql = "UPDATE Staff "
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

    public boolean update_patient(int id, String name, String phone, String gender, String avatar) {

        sql = "UPDATE Patient SET name = ?, phone = ?, gender = ?, avatar = ? WHERE patient_id = ?";

        try {
            st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, phone);
            st.setString(3, gender);
            st.setString(4, avatar);
            st.setInt(5, id);

            int row = st.executeUpdate();

            if (row > 0) {
                return true;
            }

        } catch (SQLException e) {
        }

        return false;
    }

    public boolean update_staff(int id, String name, String phone, String gender, String avatar) {

        sql = "UPDATE Staff SET name = ?, phone = ?, gender = ?, avatar = ? WHERE staff_id = ?";

        try {
            st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, phone);
            st.setString(3, gender);
            st.setString(4, avatar);
            st.setInt(5, id);

            int row = st.executeUpdate();

            if (row > 0) {
                return true;
            }

        } catch (SQLException e) {
        }

        return false;
    }

    public Account get_patient_by_id(int id) {
        Account patient = new Account();
        sql = "SELECT * "
                + "FROM Patient "
                + "WHERE patient_id = ?";

        try {
            st = connection.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();

            while (rs.next()) {
                int account_id = rs.getInt("staff_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String avatar = rs.getString("avatar");
                String address = rs.getString("address");
                int status = rs.getInt("status_id");
                int role = rs.getInt("role_id");

                Account account = new Account(account_id, username, password, email, phone, name, gender, avatar, address, role, status);
                return patient;
            }

        } catch (SQLException e) {
        }

        return null;
    }

    public Account get_staff_by_id(int id) {
        Account staff = new Account();
        sql = "SELECT * "
                + "FROM Staff "
                + "WHERE patient_id = ?";

        try {
            st = connection.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();

            while (rs.next()) {
                int account_id = rs.getInt("staff_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String avatar = rs.getString("avatar");
                String address = rs.getString("address");
                int status = rs.getInt("status_id");
                int role = rs.getInt("role_id");

                Account account = new Account(account_id, username, password, email, phone, name, gender, avatar, address, role, status);
                return staff;
            }

        } catch (SQLException e) {
        }

        return null;
    }

    public boolean checkExistEmail(String email) {
        return false;
    }

    public ArrayList<Account> get_account_list() {
        ArrayList<Account> list = new ArrayList<>();
        String sql = "SELECT  staff_id AS id, username, password, email, phone, name, gender, avatar, address, role_id, status_id "
                + "FROM Staff "
                + "UNION ALL "
                + "SELECT patient_id AS id, username, password, email, phone, name, gender, avatar, address, role_id, status_id "
                + "FROM Patient";
        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {

                int account_id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String avatar = rs.getString("avatar");
                String address = rs.getString("address");
                int status = rs.getInt("status_id");
                int role = rs.getInt("role_id");

                Account account = new Account(account_id, username, password, email, phone, name, gender, avatar, address, role, status);
                list.add(account);
            }
        } catch (SQLException e) {

        }
        return list;
    }

    public ArrayList<Services> get_service_list() {
        ArrayList<Services> list = new ArrayList<>();
        String sql = "SELECT * FROM Service WHERE status_id = 1";

        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("service_id");
                int cate = rs.getInt("category_id");
                String image = rs.getString("image");
                String name = rs.getString("name");
                String detail = rs.getString("detail");
                double price = rs.getDouble("price");
                double discount = rs.getDouble("discount");
                int status = rs.getInt("status_id");

                Services service = new Services(id, cate, image, name, detail, price, discount, status);
                list.add(service);

            }

        } catch (SQLException e) {

        }

        return list;
    }

    public ArrayList<Account> get_doctor_list() {
        ArrayList<Account> list = new ArrayList<>();
        String sql = "SELECT * "
                + "FROM Staff "
                + "WHERE role_id = 3 ";
        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {

                int account_id = rs.getInt("staff_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String avatar = rs.getString("avatar");
                String address = rs.getString("address");
                int status = rs.getInt("status_id");
                int role = rs.getInt("role_id");

                Account account = new Account(account_id, username, password, email, phone, name, gender, avatar, address, role, status);
                list.add(account);
            }
        } catch (SQLException e) {

        }
        return list;
    }

    public ArrayList<ServicesCategory> get_service_category_list() {

        ArrayList<ServicesCategory> list = new ArrayList<>();

        String sql = "SELECT * "
                + "FROM Service_category";
        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {

                int category_id = rs.getInt("category_id");
                String name = rs.getString("name");
                String detail = rs.getString("detail");

                ServicesCategory sc = new ServicesCategory(category_id, name, detail);
                list.add(sc);

            }
        } catch (SQLException e) {

        }

        return list;
    }

    public boolean register_patient(Account patient) {
        String sql = "INSERT INTO patients (username, password, email, phone, name, gender, avatar, address, role_id, status_id) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            st = connection.prepareStatement(sql);
            // Đặt giá trị cho các tham số trong câu lệnh SQL
            st.setString(1, patient.getUsername());
            st.setString(2, patient.getPassword());
            st.setString(3, patient.getEmail());
            st.setString(4, patient.getPhone());
            st.setString(5, patient.getName());
            st.setString(6, patient.getGender());
            st.setString(7, patient.getAvatar());
            st.setString(8, "default address");
            st.setInt(9, 1); // role_id luôn = 1 cho bệnh nhân
            st.setInt(10, 1); // status_id  = 1 cho register

            // Thực hiện câu lệnh SQL
            int rowsAffected = st.executeUpdate();

            // Trả về true nếu có ít nhất một dòng bị ảnh hưởng (thêm thành công)
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý lỗi SQL
            return false;
        }
    }

    public String Send_Verify_Email(String email, String template) throws UnsupportedEncodingException {
        // Đọc nội dung từ file template
        String templateContent = template;

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
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

            // Thiết lập tiêu đề email
            message.setSubject("Verification Email FROM SWP391 Project");

            // Mã hóa email
            // String encodedEmail = Base64.getUrlEncoder().encodeToString(email.getBytes(StandardCharsets.UTF_8));
            // Thay thế các placeholder trong template bằng dữ liệu thực tế
            String emailContent = templateContent.replace("{{username}}", "Tên Người Dùng")
                    .replace("{{email}}", email)
                    .replace("{{phone}}", "Số Điện Thoại")
                    .replace("{{link}}", "google.com")
                    .replace("{{link}}", "google.com");

            // Thiết lập nội dung email dưới dạng HTML với encoding UTF-8
            message.setContent(emailContent, "text/html; charset=UTF-8");

            // Gửi email
            Transport.send(message);
            return "Email has been sent successfully";
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Email sent failed: " + e.getMessage();
        }
    }
}
