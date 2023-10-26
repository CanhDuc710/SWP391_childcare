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
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Base64;

/**
 *
 * @author duchi
 */
public class DAO extends DBHelper {

    private PreparedStatement st;
    private PreparedStatement st1;
    private PreparedStatement st2;
    private ResultSet rs;
    private ResultSet rs1;
    private ResultSet rs2;
    private String sql;
    private String sql1;
    private String sql2;

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
                boolean gender = rs.getBoolean("gender");
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
                boolean gender = rs.getBoolean("gender");
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

    public boolean PatientRegister(String txtUsername, String txtPassword, String txtEmail,
            String txtPhone, String txtName, boolean txtGender) {

        sql = "INSERT INTO Patient (username, password, email, phone, name, gender, avatar, address, role_id, status_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            st = connection.prepareStatement(sql);
            st = connection.prepareStatement(sql);
            st.setString(1, txtUsername);
            st.setString(2, txtPassword);
            st.setString(3, txtEmail);
            st.setString(4, txtPhone);
            st.setString(5, txtName);
            st.setBoolean(6, txtGender);
            st.setString(7, "default.jpg");
            st.setString(8, "default address");
            st.setInt(9, 1);
            st.setInt(10, 1);
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

    public boolean update_patient_password(int id, String password) {

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

    public boolean update_staff_password(int id, String password) {

        sql = "UPDATE Staff "
                + "SET password = ? "
                + "WHERE staff_id = ?";

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

    public boolean update_patient(int id, String name, String phone, boolean gender, String address) {

        sql = "UPDATE Patient SET name = ?, phone = ?, gender = ?, address = ? WHERE patient_id = ?";

        try {
            st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, phone);
            st.setBoolean(3, gender);
            st.setString(4, address);
            st.setInt(5, id);

            int row = st.executeUpdate();

            if (row > 0) {
                return true;
            }

        } catch (SQLException e) {
        }

        return false;
    }

    public boolean update_staff(int id, String name, String phone, boolean gender, String address) {

        sql = "UPDATE Staff SET name = ?, phone = ?, gender = ?, address = ? WHERE staff_id = ?";

        try {
            st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, phone);
            st.setBoolean(3, gender);
            st.setString(4, address);
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
        Account account = new Account();
        sql = "SELECT * "
                + "FROM Patient "
                + "WHERE patient_id = ?";

        try {
            st = connection.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();

            while (rs.next()) {
                int account_id = rs.getInt("patient_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String name = rs.getString("name");
                boolean gender = rs.getBoolean("gender");
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

    public Account get_patient_by_email(String Enteremail) {
        Account account = new Account();
        sql = "SELECT * "
                + "FROM Patient "
                + "WHERE email = ?";

        try {
            st = connection.prepareStatement(sql);
            st.setString(1, Enteremail);
            rs = st.executeQuery();

            while (rs.next()) {
                int account_id = rs.getInt("patient_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String name = rs.getString("name");
                boolean gender = rs.getBoolean("gender");
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

    public Account get_staff_by_id(int id) {
        Account staff = new Account();
        sql = "SELECT * "
                + "FROM Staff "
                + "WHERE staff_id = ?";

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
                boolean gender = rs.getBoolean("gender");
                String avatar = rs.getString("avatar");
                String address = rs.getString("address");
                int status = rs.getInt("status_id");
                int role = rs.getInt("role_id");

                staff = new Account(account_id, username, password, email, phone, name, gender, avatar, address, role, status);
                return staff;
            }

        } catch (SQLException e) {
        }

        return null;
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
                boolean gender = rs.getBoolean("gender");
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
                boolean gender = rs.getBoolean("gender");
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
            st.setBoolean(6, patient.getGender());
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

    public int add_email_verify_valid(String email, int type) {
        int rowsAffected = 0;
        String sql = "INSERT INTO EmailVerification ( email, beginTime, endTime, type,  status) VALUES (?, ?, ?, ?, ?)";
        int id = 0;
        try {
            st = connection.prepareStatement(sql);
            //begin
            Timestamp beginTime = new Timestamp(System.currentTimeMillis());
            //end
            Timestamp endTime = new Timestamp(System.currentTimeMillis() + 15 * 60 * 1000);

            st.setString(1, email);
            st.setTimestamp(2, beginTime);
            st.setTimestamp(3, endTime);
            st.setInt(4, type);
            st.setInt(5, 1);

            // Thực hiện truy vấn
            rowsAffected = st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý lỗi nếu cần thiết
        }
        if (rowsAffected > 0) {
            id = getRowCount("EmailVerification");
            return id;
        } else {
            return -1;
        }
    }

    public int getRowCount(String tableName) {
        String sql = "SELECT COUNT(*) FROM " + tableName;
        int count = -1;
        try {
            // Thực hiện truy vấn và trả về số lượng dòng
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            if (rs.next()) { // Di chuyển con trỏ đến dòng đầu tiên
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public boolean Send_Verify_Email(String email, String template, int type, String messageSend) throws UnsupportedEncodingException {

        if (type == 1) {
            // Đọc nội dung từ file template
            String templateContent = template;
            int id = -1;
            // Tạo nội dung HTML cho email
            String originalLink = "http://localhost:8080/Child_Care_Project/Verify";

            // Mã hóa email
            String encodedEmail = Base64.getUrlEncoder().encodeToString(email.getBytes(StandardCharsets.UTF_8));

            //Lay Account
            Account user = null;
            ArrayList<Account> list = get_account_list();
            for (Account account : list) {
                if (account.getEmail().equals(email)) {
                    user = account;
                    break; // Đã tìm thấy tài khoản, thoát khỏi vòng lặp
                }
            }
            String encodedID = "";
            if (user != null) {
                //Ma hoa ID
                id = add_email_verify_valid(email, type);
                encodedID = Base64.getUrlEncoder().encodeToString(String.valueOf(id).getBytes(StandardCharsets.UTF_8));
            }

            String userN = "";
            String userP = "";
            String link = "http://localhost:8080/Child_Care_Project/";
            boolean send = false;
            if (user != null) {

                send = true;
                userN = user.getUsername();
                userP = user.getPhone();
                link = originalLink + "?encodedEmail=" + encodedEmail + "&encodedID=" + encodedID;
            }

            // Thông tin tài khoản email
            String username = "duchinh0306drive@gmail.com";
            // old:duchinh03061 String password = "ygdiuklubcwheyur";
            String password = "wcjtcfowhrwqzhto";
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
                message.setSubject("[SWP391] Confirm your account on SWP391");

                // Mã hóa email
                // String encodedEmail = Base64.getUrlEncoder().encodeToString(email.getBytes(StandardCharsets.UTF_8));
                // Thay thế các placeholder trong template bằng dữ liệu thực tế
                String emailContent = templateContent.replace("{{username}}", userN)
                        .replace("{{email}}", email)
                        .replace("{{message}}", messageSend)
                        .replace("{{link}}", link)
                        .replace("{{link}}", link)
                        .replace("{{Title}}", "Please Verify Your Email.");

                // Thiết lập nội dung email dưới dạng HTML với encoding UTF-8
                message.setContent(emailContent, "text/html; charset=UTF-8");

                // Gửi email
                if (send && id != -1) {
                    Transport.send(message);
                    return true;
                } else {
                    throw new MessageRemovedException("The Email Didn't Exists.");
                }

            } catch (MessagingException e) {
                e.printStackTrace();
            }
        } else if (type == 2) {
            // Đọc nội dung từ file template
            String templateContent = template;
            int id = -1;
            // Tạo nội dung HTML cho email
            String originalLink = "http://localhost:8080/Child_Care_Project/Verify";

            // Mã hóa email
            String encodedEmail = Base64.getUrlEncoder().encodeToString(email.getBytes(StandardCharsets.UTF_8));

            //Lay Account
            Account user = null;
            ArrayList<Account> list = get_account_list();
            for (Account account : list) {
                if (account.getEmail().equals(email)) {
                    user = account;
                    break; // Đã tìm thấy tài khoản, thoát khỏi vòng lặp
                }
            }
            String encodedID = "";
            if (user != null) {
                //Ma hoa ID
                id = add_email_verify_valid(email, type);
                encodedID = Base64.getUrlEncoder().encodeToString(String.valueOf(id).getBytes(StandardCharsets.UTF_8));
            }

            String userN = "";
            String userP = "";
            String link = "http://localhost:8080/Child_Care_Project/";
            boolean send = false;
            if (user != null) {

                send = true;
                userN = user.getUsername();
                userP = user.getPhone();
                link = originalLink + "?encodedEmail=" + encodedEmail + "&encodedID=" + encodedID;
            }

            // Thông tin tài khoản email
            String username = "duchinh0306drive@gmail.com";
            String password = "wcjtcfowhrwqzhto";

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
                message.setSubject("[SWP391] Please reset your password");

                // Mã hóa email
                // String encodedEmail = Base64.getUrlEncoder().encodeToString(email.getBytes(StandardCharsets.UTF_8));
                // Thay thế các placeholder trong template bằng dữ liệu thực tế
                String emailContent = templateContent.replace("{{username}}", userN)
                        .replace("{{email}}", email)
                        .replace("{{message}}", messageSend)
                        .replace("{{link}}", link)
                        .replace("{{link}}", link)
                        .replace("{{Title}}", "Email For Reset Password.");

                // Thiết lập nội dung email dưới dạng HTML với encoding UTF-8
                message.setContent(emailContent, "text/html; charset=UTF-8");

                // Gửi email
                if (send && id != -1) {
                    Transport.send(message);
                    return true;
                } else {
                    throw new MessageRemovedException("The Email Didn't Exists.");
                }

            } catch (MessagingException e) {
                e.printStackTrace();
            }
        } else {
            // Đọc nội dung từ file template
            String templateContent = template;
            int id = -1;
            // Tạo nội dung HTML cho email
            String originalLink = "http://localhost:8080/Child_Care_Project/Login?type=staff";

            // Mã hóa email
            String encodedEmail = Base64.getUrlEncoder().encodeToString(email.getBytes(StandardCharsets.UTF_8));

            //Lay Account
            Account user = null;
            ArrayList<Account> list = get_account_list();
            for (Account account : list) {
                if (account.getEmail().equals(email)) {
                    user = account;
                    break; // Đã tìm thấy tài khoản, thoát khỏi vòng lặp
                }
            }
            String encodedID = "";
            if (user != null) {
                //Ma hoa ID
                id = add_email_verify_valid(email, type);
                encodedID = Base64.getUrlEncoder().encodeToString(String.valueOf(id).getBytes(StandardCharsets.UTF_8));
            }

            String userN = "";
            String userP = "";
            String link = "http://localhost:8080/Child_Care_Project/";
            boolean send = false;
            if (user != null) {

                send = true;
                userN = user.getUsername();
                userP = user.getPhone();
                link = originalLink;
            }

            // Thông tin tài khoản email
            String username = "duchinh0306drive@gmail.com";
            String password = "wcjtcfowhrwqzhto";

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
                message.setSubject("[SWP391] Please Check Your New Account Information");

                // Mã hóa email
                // String encodedEmail = Base64.getUrlEncoder().encodeToString(email.getBytes(StandardCharsets.UTF_8));
                // Thay thế các placeholder trong template bằng dữ liệu thực tế
                String emailContent = templateContent.replace("{{username}}", userN)
                        .replace("{{email}}", email)
                        .replace("{{message}}", messageSend)
                        .replace("{{link}}", link)
                        .replace("{{link}}", link)
                        .replace("{{Title}}", "Email For Staff Registration.");

                // Thiết lập nội dung email dưới dạng HTML với encoding UTF-8
                message.setContent(emailContent, "text/html; charset=UTF-8");

                // Gửi email
                if (send && id != -1) {
                    Transport.send(message);
                    return true;
                } else {
                    throw new MessageRemovedException("The Email Didn't Exists.");
                }

            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    public EmailVerify Get_Verify_Email_DateTime(String email, int id) {
        sql = "SELECT * FROM EmailVerification "
                + "WHERE email = ? "
                + "AND activation_id = ?";
        EmailVerify object = null;
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, email);
            st.setInt(2, id);

            rs = st.executeQuery();

            if (rs.next()) {
                id = rs.getInt("activation_id");
                email = rs.getString("email");
                Timestamp begin = rs.getTimestamp("beginTime");
                Timestamp end = rs.getTimestamp("endTime");
                int type = rs.getInt("type");
                int status = rs.getInt("status");

                object = new EmailVerify(id, email, begin, end, type, status);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return object;
    }

    public boolean Change_status_account(String email, int status) {
        sql = "UPDATE Patient "
                + "SET status_id = ? WHERE email = ?";
        try {
            st = connection.prepareStatement(sql);
            st.setInt(1, status);
            st.setString(2, email);

            int rowsUpdated = st.executeUpdate();
            if (rowsUpdated > 0) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update_emailVerify_status(String email, int id) {
        sql = "UPDATE EmailVerification "
                + "SET status = 0 "
                + "WHERE email = ? "
                + "AND activation_id = ?";
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, email);
            st.setInt(2, id);

            int rowsUpdated = st.executeUpdate();
            if (rowsUpdated > 0) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update_patient_avatar(String username, String avatar) {
        sql = "UPDATE Patient "
                + "SET avatar = ? "
                + "WHERE username = ?";
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, avatar);
            st.setString(2, username);

            int rowsUpdated = st.executeUpdate();
            if (rowsUpdated > 0) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update_staff_avatar(String username, String avatar) {
        sql = "UPDATE Staff "
                + "SET avatar = ? "
                + "WHERE username = ?";
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, avatar);
            st.setString(2, username);

            int rowsUpdated = st.executeUpdate();
            if (rowsUpdated > 0) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean reset_password(String email, String password) {
        sql1 = "UPDATE Patient "
                + "SET password = ? "
                + "WHERE email = ? ";
        sql2 = "UPDATE Patient "
                + "SET password = ? "
                + "WHERE email = ? ";
        try {
            st1 = connection.prepareStatement(sql1);
            st1.setString(1, password);
            st1.setString(2, email);
            st2 = connection.prepareStatement(sql2);
            st2.setString(1, password);
            st2.setString(2, email);

            int rowsUpdated1 = st1.executeUpdate();
            int rowsUpdated2 = st2.executeUpdate();
            if (rowsUpdated1 > 0 || rowsUpdated2 > 0) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Feedback> get_feedback_list() {
        ArrayList<Feedback> list = new ArrayList<>();

        sql = "SELECT * FROM Feedback";

        try {
            st = connection.prepareCall(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                int feedbackId = rs.getInt("feedback_id");
                int serviceId = rs.getInt("service_id");
                int patientId = rs.getInt("patient_id");
                int rate = rs.getInt("rate");
                String title = rs.getString("title");
                String detail = rs.getString("detail");
                Timestamp update = rs.getTimestamp("update_date");

                Feedback feedback = new Feedback(feedbackId, serviceId, patientId, rate, title, detail, update);
                list.add(feedback);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<AverageRate> get_average_rate_list() {
        ArrayList<AverageRate> list = new ArrayList<>();

        sql = "SELECT service_id, AVG(rate) AS averageRate FROM Feedback GROUP BY service_id";

        try {
            st = connection.prepareCall(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                int serviceId = rs.getInt("service_id");
                double averageRate = rs.getDouble("averageRate");

                AverageRate avgRate = new AverageRate(serviceId, averageRate);
                list.add(avgRate);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Post> get_post_list() {
        ArrayList<Post> list = new ArrayList<>();
        String sql = "SELECT  * From Post";
        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {

                int post_id = rs.getInt("post_id");
                int category = rs.getInt("post_category_id");
                String title = rs.getString("title");
                int author_id = rs.getInt("author_id");
                Timestamp date = rs.getTimestamp("updated_date");
                String detail = rs.getString("detail");
                String image = rs.getString("image");

                Post post = new Post(post_id, category, title, author_id, date, detail, image);
                list.add(post);
            }
        } catch (SQLException e) {

        }
        return list;
    }

    public ArrayList<Account> get_staff_list() {
        ArrayList<Account> list = new ArrayList<>();
        String sql = "SELECT * "
                + "FROM Staff";
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
                boolean gender = rs.getBoolean("gender");
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

    public Services get_service_by_id(int txtId) {
        String sql = "SELECT * FROM Service WHERE service_id = ? AND status_id = 1";
        Services service = new Services();

        try {
            st = connection.prepareStatement(sql);
            st.setInt(1, txtId);
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

                service = new Services(id, cate, image, name, detail, price, discount, status);
            }

        } catch (SQLException e) {

        }

        return service;
    }

    public ArrayList<Children> get_children_by_parentID(int id) {
        ArrayList<Children> list = new ArrayList<>();
        sql = "SELECT * FROM Children WHERE parent_id = ?";

        try {
            st = connection.prepareCall(sql);
            st.setInt(1, id);
            rs = st.executeQuery();
            while (rs.next()) {
                int childrenId = rs.getInt("children_id");
                int parentId = rs.getInt("parent_id");
                String name = rs.getString("name");
                boolean gender = rs.getBoolean("gender");
                Date dob = rs.getDate("dob");
                int relation = rs.getInt("Relation");

                Children child = new Children(childrenId, parentId, name, gender, dob, relation);
                list.add(child);

            }
        } catch (Exception e) {
        }

        return list;
    }

    public ArrayList<Reservation2> get_reservation_by_patientId(int id) {
        sql = "SELECT * FROM Reservation WHERE patient_id = ?";
        ArrayList<Reservation2> list = new ArrayList<>();

        try {
            st = connection.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();

            while (rs.next()) {
                int reservationId = rs.getInt("reservation_id");
                int slotId = rs.getInt("slot_id");
                int patientId = rs.getInt("patient_id");
                int childId = rs.getInt("children_id");
                int staffId = rs.getInt("staff_id");
                int statusId = rs.getInt("status_id");
                Date bookDate = rs.getDate("book_date");
                Date date = rs.getDate("date");
                double total = rs.getDouble("total");

                Reservation2 rs = new Reservation2(reservationId, slotId, patientId, childId, staffId, statusId, bookDate, date, total);
                list.add(rs);

            }

        } catch (Exception ex) {

        }
        return list;
    }

    public ArrayList<ReservationDetail2> get_reservation_detail_by_id(int id) {
        sql = "SELECT * FROM Reservation_detail WHERE reservation_id = ?";
        ArrayList<ReservationDetail2> list = new ArrayList<>();

        try {
            st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeQuery();

            while (rs.next()) {

                int detail_id = rs.getInt("reservation_detail_id");
                int reservation_id = rs.getInt("reservation_id");
                int service_id = rs.getInt("service_id");
                double price = rs.getDouble("price");

                ReservationDetail2 rs = new ReservationDetail2(detail_id, reservation_id, service_id, price);

                list.add(rs);

            }

        } catch (Exception ex) {

        }
        return list;

    }

    public ArrayList<Slot> get_slot_list() {
        sql = "SELECT * FROM Slot";
        ArrayList<Slot> list = new ArrayList<>();

        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("slot_id");
                String start = rs.getString("start_time");
                String end = rs.getString("end_time");

                Slot slot = new Slot(id, start, end);
                list.add(slot);

            }

        } catch (Exception ex) {

        }
        return list;
    }

    public boolean check_slot_available(int doctorId, int slotId, Date date) {
        String sql = "SELECT * FROM Reservation WHERE staff_id = ? AND slot_id = ? AND date = ?";

        try {
            st = connection.prepareStatement(sql);
            st.setInt(1, doctorId);
            st.setInt(2, slotId);
            st.setDate(3, date);

            try ( ResultSet rs = st.executeQuery()) {
                return !rs.next();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public int add_reservation(int slot_id, int patient_id, int children_id, int staff_id, Date date, double total) {
        String sql = "INSERT INTO Reservation (slot_id, patient_id, children_id, staff_id, status_id, book_date, date, total) VALUES (?, ?, ?, ?, 1, GETDATE(), ?, ?)";

        try {
            st = connection.prepareStatement(sql, st.RETURN_GENERATED_KEYS);
            st.setInt(1, slot_id);
            st.setInt(2, patient_id);
            st.setInt(3, children_id);
            st.setInt(4, staff_id);
            st.setDate(5, date);
            st.setDouble(6, total);

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet generatedKeys = st.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public boolean add_reservation_detail(int reservation_id, int serviceId, double price) {
        sql = "INSERT INTO Reservation_detail (reservation_id, service_id, price) "
                + "VALUES (?,?,?)";

        try {
            st = connection.prepareStatement(sql);
            st.setInt(1, reservation_id);
            st.setInt(2, serviceId);
            st.setDouble(3, price);

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean add_children(int parentId, String name, boolean gender, Date dob, int relation) {
        sql = "INSERT INTO Children (parent_id, name, gender, dob, Relation) VALUES (?,?,?,?,?)";

        try {

            st = connection.prepareStatement(sql);
            st.setInt(1, parentId);
            st.setString(2, name);
            st.setBoolean(3, gender);
            st.setDate(4, dob);
            st.setInt(5, relation);

            int row = st.executeUpdate();

            if (row > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            return false;
        }
    }

    public boolean update_children(int childrenId, int parentId, String name, boolean gender, Date dob, int relation) {
        sql = "UPDATE Children SET parent_id=?, name=?, gender=?, dob=?, Relation=? WHERE children_id=?";

        try {
            st = connection.prepareStatement(sql);
            st.setInt(1, parentId);
            st.setString(2, name);
            st.setBoolean(3, gender);
            st.setDate(4, dob);
            st.setInt(5, relation);
            st.setInt(6, childrenId);

            int row = st.executeUpdate();

            if (row > 0) {
                return true; // Cập nhật thành công
            } else {
                return false; // Cập nhật không thành công
            }
        } catch (SQLException e) {
            return false; // Lỗi SQL khi thực hiện cập nhật
        }
    }

    public boolean remove_children(int childId) {
        String sql = "DELETE FROM Children WHERE children_id = ?";

        try {
            st = connection.prepareStatement(sql);
            st.setInt(1, childId);

            int rowsAffected = st.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    //admin servlet
    public Admin AdminLogin(String txtUsername, String txtPassword) {
        Admin admin = new Admin();
        sql = "SELECT * "
                + "FROM Admin "
                + "WHERE username = ? "
                + "AND password = ?";
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, txtUsername);
            st.setString(2, txtPassword);
            rs = st.executeQuery();

            while (rs.next()) {
                int account_id = rs.getInt("admin_id");
                String username = rs.getString("username");
                String password = rs.getString("password");

                admin = new Admin(account_id, username, password);
                return admin;
            }

        } catch (SQLException e) {
        }

        return null;
    }

    public ArrayList<Account> admin_get_patients() {
        ArrayList<Account> list = new ArrayList<>();
        String sql = "SELECT  * "
                + "FROM Patient";
        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {

                int account_id = rs.getInt("patient_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String name = rs.getString("name");
                boolean gender = rs.getBoolean("gender");
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

    public ArrayList<Account> admin_get_staffs() {
        ArrayList<Account> list = new ArrayList<>();
        String sql = "SELECT  * "
                + "FROM Staff";
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
                boolean gender = rs.getBoolean("gender");
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

    public boolean admin_patient_register(String txtUsername, String txtPassword, String txtEmail,
            String txtPhone, String txtName, boolean txtGender) {
        sql = "INSERT INTO Patient (username, password, email, phone, name, gender, avatar, address, role_id, status_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            st = connection.prepareStatement(sql);
            st = connection.prepareStatement(sql);
            st.setString(1, txtUsername);
            st.setString(2, txtPassword);
            st.setString(3, txtEmail);
            st.setString(4, txtPhone);
            st.setString(5, txtName);
            st.setBoolean(6, txtGender);
            st.setString(7, "default.jpg");
            st.setString(8, "default address");
            st.setInt(9, 1);
            st.setInt(10, 1);
            int rowsUpdated = st.executeUpdate();
            if (rowsUpdated > 0) {
                return true;
            }

        } catch (SQLException e) {
        }

        return false;
    }

    public boolean admin_staff_register(String txtUsername, String txtPassword, String txtEmail,
            String txtPhone, String txtName, boolean txtGender, int txtRole) {
        sql = "INSERT INTO Staff (username, password, email, phone, name, gender, avatar, address, role_id, status_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            st = connection.prepareStatement(sql);
            st = connection.prepareStatement(sql);
            st.setString(1, txtUsername);
            st.setString(2, txtPassword);
            st.setString(3, txtEmail);
            st.setString(4, txtPhone);
            st.setString(5, txtName);
            st.setBoolean(6, txtGender);
            st.setString(7, "default.jpg");
            st.setString(8, "default address");
            st.setInt(9, txtRole);
            st.setInt(10, 2);
            int rowsUpdated = st.executeUpdate();
            if (rowsUpdated > 0) {
                return true;
            }

        } catch (SQLException e) {
        }

        return false;
    }

    public boolean admin_delete_patient(int patient_id) {
        String sql = "DELETE FROM Patient WHERE patient_id = ?";
        try {
            st = connection.prepareStatement(sql);
            st.setInt(1, patient_id);
            int rowsDeleted = st.executeUpdate();
            if (rowsDeleted > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý lỗi nếu cần
        }
        return false;
    }

    public boolean admin_delete_staff(int staff_id) {
        String sql = "DELETE FROM Staff  WHERE staff_id = ?";
        try {
            st = connection.prepareStatement(sql);
            st.setInt(1, staff_id);
            int rowsDeleted = st.executeUpdate();
            if (rowsDeleted > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý lỗi nếu cần
        }
        return false;
    }

    public boolean admin_update_patient(int patientId, String txtUsername, String txtPassword, String txtEmail,
            String txtPhone, String txtName, String txtAddress, boolean txtGender, int status) {
        String sql = "UPDATE Patient SET username = ?, password = ?, email = ?, phone = ?, name = ?, gender = ?, status_id = ?, address = ? WHERE patient_id = ?";
        try {
            st = connection.prepareStatement(sql);

            st.setString(1, txtUsername);
            st.setString(2, txtPassword);
            st.setString(3, txtEmail);
            st.setString(4, txtPhone);
            st.setString(5, txtName);
            st.setBoolean(6, txtGender);
            st.setInt(7, status);
            st.setString(8, txtAddress);
            st.setInt(9, patientId);

            int rowsDeleted = st.executeUpdate();
            if (rowsDeleted > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý lỗi nếu cần
        }
        return false;
    }

    public boolean admin_update_staff(int id, String txtUsername, String txtPassword, String txtEmail,
            String txtPhone, String txtName, String txtAddress, boolean txtGender, int status, int role) {
        String sql = "UPDATE Staff SET username = ?, password = ?, email = ?, phone = ?, name = ?, gender = ?, status_id = ?, address = ?, role_id = ? WHERE staff_id = ?";
        try {
            st = connection.prepareStatement(sql);

            st.setString(1, txtUsername);
            st.setString(2, txtPassword);
            st.setString(3, txtEmail);
            st.setString(4, txtPhone);
            st.setString(5, txtName);
            st.setBoolean(6, txtGender);
            st.setInt(7, status);
            st.setString(8, txtAddress);
            st.setInt(9, role);
            st.setInt(10, id);

            int rowsDeleted = st.executeUpdate();
            if (rowsDeleted > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý lỗi nếu cần
        }
        return false;
    }

    public static void main(String[] args) {
        DAO dao = new DAO();

        int doctorId = 4;  // Thay thế bằng ID của bác sĩ cần kiểm tra
        int slot = 2;  // Thay thế bằng ID của slot cần kiểm tra
        java.sql.Date selectedDate = java.sql.Date.valueOf("2023-10-27");  // Thay thế bằng ngày cần kiểm tra (yyyy-MM-dd)

        boolean available = dao.check_slot_available(doctorId, slot, selectedDate);

        if (available) {
            System.out.println("Slot is available.");
        } else {
            System.out.println("Slot is not available.");
        }

    }

}
