package com.kt.ts.notificationservice.service;

import com.kt.ts.notificationservice.model.Notification;
import com.kt.ts.notificationservice.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private JavaMailSender emailSender;

    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public void sendNotification(Notification notification) {
        if ("EMAIL".equals(notification.getType()) && !notification.isSent()) {
            String emailId = notification.getUserId();
            int index = emailId.indexOf('@');
            String modifiedEmail = (index != -1) ? emailId.substring(0, index) : emailId;
            String message = String.format(
                    "Dear %s,\n\n" +
                            "We hope this message finds you well. We would like to inform you about the following:\n\n" +
                            "*Notification Title:* SERVICE TICKET NOTIFICATION\n\n" +
                            "*Details:* A new service ticket has been created, and immediate action is required.\n\n" +
                            "*Action Required:* Please review and approve if the details are correct.\n\n" +
                            "Thank you for your attention to this matter. If you have any questions, please feel free to reach out.\n\n" +
                            "Regards,\n" +
                            "IT Service Desk\n",
                    modifiedEmail
            );
            sendEmail(notification.getUserId(), message);
            notification.setSent(true);
            notificationRepository.save(notification);
        }
        // Additional logic for other types (e.g., SMS)
    }

    private void sendEmail(String to, String message) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(to);
        email.setSubject("SERVICE TICKET");
        email.setText(message);
        emailSender.send(email);
    }

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Notification getNotificationById(String id){
        return notificationRepository.getNotificationById(id);
    }
}
