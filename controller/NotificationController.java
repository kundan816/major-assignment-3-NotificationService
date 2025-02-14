package com.NammaMetro.NotificationService.controller;

import com.NammaMetro.NotificationService.dto.NotificationRequest;
import com.NammaMetro.NotificationService.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    /**
     * Endpoint to notify payment success.
     * Example: POST /notifications/payment-success
     */
    @PostMapping("/payment-success")
    public String notifyPaymentSuccess(@RequestBody NotificationRequest request) {
        // Customize subject and message if desired.
        request.setSubject("Ticket Purchase Receipt");
        request.setMessage("Your ticket purchase was successful. " + request.getMessage());
        notificationService.sendNotification(request);
        return "Payment success notification sent!";
    }

    /**
     * Endpoint to notify penalty.
     * Example: POST /notifications/penalty
     */
    @PostMapping("/penalty")
    public String notifyPenalty(@RequestBody NotificationRequest request) {
        request.setSubject("Penalty Alert");
        request.setMessage("A penalty has been charged to your account. " + request.getMessage());
        notificationService.sendNotification(request);
        return "Penalty notification sent!";
    }

    /**
     * Endpoint to notify SOS alert.
     * Example: POST /notifications/sos
     */
    @PostMapping("/sos")
    public String notifySos(@RequestBody NotificationRequest request) {
        request.setSubject("SOS Alert from Station Manager");
        request.setMessage("An SOS alert has been triggered. " + request.getMessage());
        notificationService.sendNotification(request);
        return "SOS notification sent!";
    }
}
