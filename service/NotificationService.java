package com.NammaMetro.NotificationService.service;

import com.NammaMetro.NotificationService.dto.NotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private JavaMailSender mailSender;

    /**
     * Sends an email notification based on the provided request.
     */
    public void sendNotification(NotificationRequest request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(request.getToEmail());
        message.setSubject(request.getSubject());
        message.setText(request.getMessage());
        // Optionally, set the sender's email address
        // message.setFrom("yourEmail@gmail.com");
        mailSender.send(message);
    }
}
