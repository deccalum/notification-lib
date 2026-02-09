package se.lexicon.notification.service;

import se.lexicon.notification.model.Notification;

import java.util.List;

public interface NotificationService {
    void sendNotification(String recipient, String message);

    List<Notification> getNotificationHistory();
}
