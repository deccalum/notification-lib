# Notification Library

This library provides notification services for the Application. It supports sending notifications, and stores notification history in a database.

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
- Jakarta Mail 2.0.3

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

    Main Spring config. Creates the DataSource and JdbcTemplate beans. @ComponentScan tells Spring which packages to scan for components. @PropertySource loads application.properties so @Value can read values.

---

- **`EmailClient`**: How does it handle the connection to the SMTP server?

    Builds a Jakarta Mail Session from SMTP properties and uses Transport.send(...) to send messages. Properties are just in-memory config for the session.

---

- **`JdbcNotificationDaoImpl`**: How does it interact with the H2 database using `JdbcTemplate`?

    Uses JdbcTemplate to run SQL (INSERT, SELECT, etc.). Query results are mapped into Notification objects.

---


- **`NotificationService` (and its implementations)**: Why do we use an interface and an abstract class here? What are the benefits of this design?

    NotificationService: Interface defines the contract; abstract class provides shared logic (and possibly shared dependencies). Implementations only handle channel-specific behavior.

---


### 2. Explain Spring Core Annotations
Provide a brief explanation for each of the following annotations used in the project:
- `@Configuration`: Marks a class that defines Spring beans.

- `@Bean`: Registers the returned object as a Spring bean.

- `@ComponentScan`: Scans packages for @Component/@Service/@Repository classes.

- `@PropertySource`: Loads external properties files for use with @Value.

- `@Value`: Injects property values (supports defaults like ${key:default}).

- `@Service`: Service-layer stereotype.

- `@Repository`: DAO stereotype; also enables exception translation.

- `@Qualifier`: Chooses among multiple beans of the same type.

- `@Autowired`: Automatic dependency injection (constructor/field/setter).

---



### 3. Suggestions for Improvement