package com.kt.ts.notificationservice.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notifications")
public class Notification {
    @Id
    private String id;
    private String ticketNumber;
    // emailId of the user to notify
    private String senderEmailId;
    private String body;
    // e.g., EMAIL, SMS
    private String emailType;
    // Status of the notification
    private boolean isSent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getSenderEmailId() {
        return senderEmailId;
    }

    public void setSenderEmailId(String senderEmailId) {
        this.senderEmailId = senderEmailId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    public boolean isSent() {
        return isSent;
    }

    public void setSent(boolean sent) {
        isSent = sent;
    }
}