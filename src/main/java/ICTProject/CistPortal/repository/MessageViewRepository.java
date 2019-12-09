package ICTProject.CistPortal.repository;

import ICTProject.CistPortal.bean.MessageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class MessageViewRepository implements IMessageViewRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MessageViewRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    @Override
    public List<MessageView> selectMany(String userId, Timestamp dateTime) {
        var sql = "select * from message_target inner  join message " +
                "on message_target.message_id = message.id " +
                "where message_target.user_id = ? " +
                "and message_target.read_unread = false " +
                "and deadline >= ?";

        var messageViewList = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(MessageView.class),
                new Object[]{userId,dateTime}
        );

        return messageViewList;
    }

    @Override
    public List<MessageView> alreadyReadSelectMany(String userId,Timestamp dateTime) {
        var sql = "select * from message_target inner  join message " +
                "on message_target.message_id = message.id " +
                "where message_target.user_id = ? " +
                "and message_target.read_unread = true " +
                "and deadline >= ?";

        var messageViewList = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(MessageView.class),
                new Object[]{userId,dateTime}
        );

        return messageViewList;
    }

    @Override
    public List<MessageView> selectOne(int messageId) {
        var sql = "select * from message where id = ?";

        var messageViewDetail = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(MessageView.class),
                messageId);

        return messageViewDetail;
    }


    //TODO このエラー処理でいいのか？
    @Override
    public int insertOne(int id, String userId) {
        var sql = "insert into already_read values (?,?)";

        try {
            var result = jdbcTemplate.update(sql,userId,id);
            return result;
        }catch (Exception e) {
            return 0;
        }

    }

    @Override
    public int updateRead(long messageId,String userId) {
        var sql = "update message_target set read_unread = true " +
                "where message_id = ? and user_id = ?";
        return jdbcTemplate.update(sql,messageId,userId);
    }

    @Override
    public int updateUnread(long messageId,String userId) {
        var sql = "update message_target set read_unread = false " +
                "where message_id = ? and user_id = ?";
        return jdbcTemplate.update(sql,messageId,userId);
    }

}
