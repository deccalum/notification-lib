package se.lexicon.notification.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import se.lexicon.notification.dao.NotificationDao;
import se.lexicon.notification.config.EmailClient;

@Service("emailNotificationService")
@Scope("prototype")
public class EmailNotificationServiceImpl extends AbstractNotificationService {

    private final EmailClient emailClient;

    public EmailNotificationServiceImpl(
            @Qualifier("jdbcNotificationDaoImpl") NotificationDao notificationDao,
            EmailClient emailClient
    ) {
        super(notificationDao);
        this.emailClient = emailClient;
    }


    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("[EMAIL] Sending to " + recipient + ": " + message);
        emailClient.send(recipient, "Notification", message);   // <-- real email send

        notificationDao.save(createNotification(recipient, message));
    }
}