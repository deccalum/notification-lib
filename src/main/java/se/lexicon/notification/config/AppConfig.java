package se.lexicon.notification.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"se.lexicon"})
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Value("${db.driver}")
    private String driverClassName;

    @Value("${db.url}")
    private String url;

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public Object databaseSchemaInitializer(JdbcTemplate jdbcTemplate) {
        jdbcTemplate.execute("""
            CREATE TABLE IF NOT EXISTS notifications (
                id VARCHAR(36) PRIMARY KEY,
                recipient VARCHAR(255) NOT NULL,
                message VARCHAR(2000) NOT NULL,
                sent_at TIMESTAMP NOT NULL
            )
            """);
        return new Object();
    }



    @Bean
    public EmailClient emailClient(
            @Value("${mail.username}") String user,
            @Value("${mail.password}") String pass,
            @Value("${mail.smtp.host}") String host,
            @Value("${mail.smtp.port}") int port,
            @Value("${mail.smtp.starttls}") boolean startTls
    ) {
        return new EmailClient(user, pass, host, port, startTls);
    }
}