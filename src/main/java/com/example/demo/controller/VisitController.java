package com.example.demo.controller;


import com.example.demo.model.Booking;
import com.example.demo.model.User;
import com.example.demo.service.emailservice;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;


@CrossOrigin
@RestController
@RequestMapping("/api/visit")
public class VisitController {
    @Autowired
    UserController usercont;
    @Autowired
    MuseumController museumcont;
    @Autowired
    BookingController bookingcont;

    @Autowired
    private emailservice emailservice;

    @GetMapping("/send-email")
    public String sendVisitDetailsEmail() throws IOException, WriterException {
        User u=usercont.getCurrentUser();
        Booking b=bookingcont.getcurrentbooking();
        String sessionid=bookingcont.sesssion_id;
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(sessionid, BarcodeFormat.QR_CODE, 200, 200);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        byte[] qrCode = pngOutputStream.toByteArray();


            emailservice.sendEmail(u.getEmail(), u.getName(),b.getTotal_people(), b.getVisit_date(), b.getVisit_time(), "126743", qrCode);
            return "Visit details email sent successfully!";

    }
}
