# Notification Library

This library provides notification services for the Wallet Application. It supports sending notifications via Email and SMS, and stores notification history in a database.

## Features

- **Email Notifications**: Send emails using JavaMail with Spring integration.
- **SMS Notifications**: Not Completed yet.
- **Data Persistence**: Store notifications in H2 database using Spring JDBC or in-memory.
- **Spring Configuration**: Easy integration with Spring-based applications.

## Technologies

- Java 25
- Spring Context 7.0.1
- Spring JDBC
- H2 Database
- Jakarta Mail (Eclipse Angus) 2.0.3

## Configuration

The library uses `application.properties` for configuration.

### Gmail Setup
To run the email notification service with a Gmail account, you should use an **App Password** rather than your regular account password for security.
search to find out how to create an App Password.

### Key Properties
- `db.url`: Database connection URL.
- `mail.username`: Your Gmail address (e.g., `your.email@gmail.com`).
- `mail.password`: Your Gmail **App Password**.
- `mail.smtp.host`: `smtp.gmail.com`
- `mail.smtp.port`: `587`

> **Tip**: Instead of hardcoding your password in the file, you can set environment variables `EMAIL_USERNAME` and `EMAIL_PASSWORD`. The application is configured to read these first!

## Tasks

### 1. Review Code and Explain
Review the following components and explain their role in the application:
- **`AppConfig`**: How does it initialize the application context? What is the role of `@ComponentScan` and `@PropertySource`?
- **`EmailClient`**: How does it handle the connection to the SMTP server?
- **`JdbcNotificationDaoImpl`**: How does it interact with the H2 database using `JdbcTemplate`?
- **`NotificationService` (and its implementations)**: Why do we use an interface and an abstract class here? What are the benefits of this design?

### 2. Explain Spring Core Annotations
Provide a brief explanation for each of the following annotations used in the project:
- `@Configuration`:
- `@Bean`:
- `@ComponentScan`:
- `@PropertySource`:
- `@Value`:
- `@Service`:
- `@Repository`:
- `@Qualifier`:
- `@Autowired`: (Explain why it's used in constructors)

### 3. Suggestions for Improvement
