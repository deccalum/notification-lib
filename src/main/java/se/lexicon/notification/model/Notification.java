package se.lexicon.notification.model;

import java.time.LocalDateTime;

public class Notification {
    private String id;
    private String recipient;
    private String message;
    private LocalDateTime sentAt;

    public Notification(String id, String recipient, String message, LocalDateTime sentAt) {
        this.id = id;
        this.recipient = recipient;
        this.message = message;
        this.sentAt = sentAt;
    }

    public String getId() { return id; }
    public String getRecipient() { return recipient; }
    public String getMessage() { return message; }
    public LocalDateTime getSentAt() { return sentAt; }

    @Override
    public String toString() {
        return "Notification{" +
                "id='" + id + '\'' +
                ", recipient='" + recipient + '\'' +
                ", sentAt=" + sentAt +
                '}';
    }
}
