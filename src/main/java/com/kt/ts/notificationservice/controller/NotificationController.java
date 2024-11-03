package com.kt.ts.notificationservice.controller;

import com.kt.ts.notificationservice.model.Notification;
import com.kt.ts.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        Notification createdNotification = notificationService.createNotification(notification);
        return ResponseEntity.ok(createdNotification);
    }

    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications() {
        List<Notification> notifications = notificationService.getAllNotifications();
        return ResponseEntity.ok(notifications);
    }

    @PostMapping("/send/{id}")
    public ResponseEntity<Void> sendNotification(@PathVariable String id) {
        Notification notification = notificationService.getNotificationById(id);
        notificationService.sendNotification(notification);
        return ResponseEntity.ok().build();
    }
}
