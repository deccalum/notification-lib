package se.lexicon.notification.dao;

import org.springframework.stereotype.Repository;
import se.lexicon.notification.model.Notification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class InMemoryNotificationDaoImpl implements NotificationDao {

    private final List<Notification> notifications = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void save(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Notification cannot be null");
        }
        notifications.add(notification);
    }

    @Override
    public List<Notification> findAll() {
        return new ArrayList<>(notifications);
    }
}
