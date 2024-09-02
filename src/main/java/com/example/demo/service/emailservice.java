package com.example.demo.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;




@Service
public class emailservice {

	@Autowired
	private JavaMailSender mailSender;

	public void sendEmail(String toEmail, String visitorName, String numberOfVisitors, String date,
						  String timeSlot, String ticketNumber, byte[] qrCode) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setFrom("yashjain200502@gmail.com");
			helper.setTo(toEmail);
			helper.setSubject("Your NCSM Visit Awaits – Booking Confirmation");

			// Construct the email body using the provided parameters
			String body = String.format(
					"Dear %s,\n\n" +
							"Congratulations on booking your visit to [Name of NCSM Museum/Centre]! Get ready for an exciting journey through science, innovation, and discovery.\n\n" +
							"Your Visit Details:\n" +
							"- Visitor Name: %s\n" +
							"- Number of visitors: %s\n" +
							"- Date: %s\n" +
							"- Time Slot: %s\n" +
							"- Ticket Number: %s\n\n" +
							"We can't wait to welcome you! Simply present the attached QR code at the entrance, and let the adventure begin. See you soon for an unforgettable experience!\n\n" +
							"Warm regards,\n" +
							"NCSM Team",
					visitorName, visitorName, numberOfVisitors, date, timeSlot, ticketNumber
			);

			helper.setText(body);

			// Add the QR code as an attachment
			helper.addAttachment("EntryQr.png", new ByteArrayResource(qrCode));

			mailSender.send(mimeMessage);
			System.out.println("Mail sent successfully to " + toEmail);
		} catch (MessagingException e) {
			e.printStackTrace();
			System.out.println("Failed to send email to " + toEmail);
		}
	}
}
