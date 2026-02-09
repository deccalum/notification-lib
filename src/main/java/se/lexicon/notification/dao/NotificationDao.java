package se.lexicon.notification.dao;

import se.lexicon.notification.model.Notification;
import java.util.List;

public interface NotificationDao {
    void save(Notification notification);
    List<Notification> findAll();
}
