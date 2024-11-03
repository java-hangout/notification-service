package com.kt.ts.notificationservice.repository;

import com.kt.ts.notificationservice.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification, String> {
    // You can define custom query methods if needed
    Notification getNotificationById(String id);
}
