/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author duchi
 */
public class TestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy đường dẫn tuyệt đối đến thư mục web của ứng dụng
        String realPath = getServletContext().getRealPath("/");

        // Tạo đường dẫn tuyệt đối đến tệp tin template
        String templateFilePath = realPath + "/email_verify_template.html";

        // Đọc nội dung từ tệp tin template
        StringBuilder contentBuilder = new StringBuilder();
        try ( InputStream inputStream = new FileInputStream(templateFilePath);  InputStreamReader inputStreamReader = new InputStreamReader(inputStream);  BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                contentBuilder.append(line);
            }
        }

        // Nội dung email từ tệp tin template
        String emailTemplate = contentBuilder.toString();

        // Gửi email
        DAO dao = new DAO();
        int type = 1;
        Boolean check = dao.Send_Verify_Email("duchinh0306@gmail.com", emailTemplate, type);

        // Xử lý kết quả (mess) tùy theo yêu cầu của bạn
        // Gửi kết quả về trình duyệt
        if (check) {
            response.getWriter().write("thanh cong");
        } else {
            response.getWriter().write("that bai");
        }
    }

    private String readTemplateFile(String filePath) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try ( BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                contentBuilder.append(line);
            }
        }
        return contentBuilder.toString();
    }
}
