package se.lexicon.notification.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import se.lexicon.notification.dao.NotificationDao;

@Service("smsNotificationService")
public class SmsNotificationServiceImpl extends AbstractNotificationService {

    public SmsNotificationServiceImpl(@Qualifier("jdbcNotificationDaoImpl") NotificationDao notificationDao) {
        super(notificationDao);
    }

    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("[SMS] Sending to " + recipient + ": " + message);
        notificationDao.save(createNotification(recipient, message));
    }
}