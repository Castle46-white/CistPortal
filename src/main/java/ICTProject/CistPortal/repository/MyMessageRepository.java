package ICTProject.CistPortal.repository;

import ICTProject.CistPortal.bean.MessageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class MyMessageRepository implements IMyMessageRepository {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<MessageView> selectMyMessageList(String userId) {
        var sql = "select * from message " +
                "where not exists (select * from deleted_message where message.id = deleted_message.message_id) " +
                " and user_id = ? " +
                "and deadline >= ?";

        var MyMessageList = jdbc.query(sql,
                new BeanPropertyRowMapper<>(MessageView.class),
                new Object[]{userId, Timestamp.valueOf(LocalDateTime.now())});

        return MyMessageList;
    }

    @Override
    public int insertDeletedMessage(long messageId) {
        var sql = "insert into deleted_message values (?)";
        return jdbc.update(sql,messageId);
    }
}
