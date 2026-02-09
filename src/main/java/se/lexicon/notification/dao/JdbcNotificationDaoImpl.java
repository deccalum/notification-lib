package se.lexicon.notification.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import se.lexicon.notification.model.Notification;

import java.util.List;

@Repository
public class JdbcNotificationDaoImpl implements NotificationDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcNotificationDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Notification notification) {
        String sql = "INSERT INTO notifications (id, recipient, message, sent_at) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, notification.getId(), notification.getRecipient(), notification.getMessage(), notification.getSentAt());
    }

    @Override
    public List<Notification> findAll() {
        String sql = "SELECT * FROM notifications";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Notification(
                rs.getString("id"),
                rs.getString("recipient"),
                rs.getString("message"),
                rs.getTimestamp("sent_at").toLocalDateTime()
        ));
    }
}
