package com.kt.ts.notificationservice.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notifications")
public class Notification {
    @Id
    private String id;
    private String userId; // ID of the user to notify
    private String message;
    private String type; // e.g., EMAIL, SMS
    private boolean isSent; // Status of the notification

    // Constructors, Getters, and Setters
   /* public Notification(String userId, String message, String type) {
        this.userId = userId;
        this.message = message;
        this.type = type;
        this.isSent = false; // Initially, it is not sent
    }*/

    // Getters and Setters...

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isSent() {
        return isSent;
    }

    public void setSent(boolean sent) {
        isSent = sent;
    }
}