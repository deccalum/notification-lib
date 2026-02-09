package se.lexicon.notification;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.notification.config.AppConfig;
import se.lexicon.notification.service.NotificationService;

public class Main {
    void main() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Choose which implementation you want:
        //NotificationService notificationService = context.getBean("smsNotificationService", NotificationService.class);
        NotificationService notificationService = context.getBean("emailNotificationService", NotificationService.class);

        notificationService.sendNotification("mehrdad.javan@lexicon.se", "Welcome to our service!");
        notificationService.sendNotification("mehrdad.javan@lexicon.se", "Your order has been confirmed.");
        notificationService.sendNotification("mehrdad.javan@lexicon.se", "System maintenance scheduled.");

        System.out.println("\n--- Notification History ---");
        notificationService.getNotificationHistory().forEach(notification -> {
            System.out.println("ID: " + notification.getId());
            System.out.println("Recipient: " + notification.getRecipient());
            System.out.println("Message: " + notification.getMessage());
            System.out.println("Sent At: " + notification.getSentAt());
            System.out.println("----------------------------");
        });

        context.close();
    }
}