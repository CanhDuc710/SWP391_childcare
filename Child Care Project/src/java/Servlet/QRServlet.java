/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorConfig;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import com.warrenstrange.googleauth.GoogleAuthenticatorQRGenerator;

/**
 *
 * @author duchi
 */
@WebServlet(name = "QRServlet", urlPatterns = {"/QR"})
public class QRServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String secretKey = "nguyenduyduchinhprojectkey";
        String otpAuthURL = "otpauth://totp/Admin?secret=" + secretKey + "&issuer=SWP391";

        int width = 300;
        int height = 300;

        // Tạo mã QR bằng ZXing
        BitMatrix bitMatrix;
        try {
            bitMatrix = new MultiFormatWriter().encode(otpAuthURL, BarcodeFormat.QR_CODE, width, height);
            // Ghi mã QR vào response output stream
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
            // Xử lý lỗi
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userEnteredOTP = request.getParameter("otp"); // Lấy mã OTP từ người dùng
        String secretKey = "nguyenduyduchinhprojectkey"; // Lấy secret key từ cơ sở dữ liệu hoặc nơi lưu trữ của bạn

        GoogleAuthenticatorConfig config = new GoogleAuthenticatorConfig.GoogleAuthenticatorConfigBuilder().build();
        GoogleAuthenticator gAuth = new GoogleAuthenticator(config);

        boolean isCodeValid = gAuth.authorize(secretKey, Integer.parseInt(userEnteredOTP));

        if (isCodeValid) {
            // Mã OTP hợp lệ
            response.getWriter().write("dung cmnrrrrrrrrrrrrrrr");
        } else {
            // Mã OTP không hợp lệ
            response.getWriter().write("Sai");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
