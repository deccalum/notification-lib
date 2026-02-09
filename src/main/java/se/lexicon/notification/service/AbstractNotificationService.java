package se.lexicon.notification.service;

import se.lexicon.notification.dao.NotificationDao;
import se.lexicon.notification.model.Notification;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

abstract class AbstractNotificationService implements NotificationService {

    protected final NotificationDao notificationDao;

    protected AbstractNotificationService(NotificationDao notificationDao) {
        this.notificationDao = notificationDao;
    }

    protected Notification createNotification(String recipient, String message) {
        return new Notification(
                UUID.randomUUID().toString(),
                recipient,
                message,
                LocalDateTime.now()
        );
    }

    @Override
    public List<Notification> getNotificationHistory() {
        return notificationDao.findAll();
    }
}