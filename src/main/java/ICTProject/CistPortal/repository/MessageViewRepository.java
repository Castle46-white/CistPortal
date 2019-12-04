package ICTProject.CistPortal.repository;

import ICTProject.CistPortal.bean.MessageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
        var sql = "select id,title,update_date,deadline,message.user_id from message_target " +
                "inner join message on message_target.message_id = message.id " +
                "where message_target.user_id = ? and deadline >= ?";

        var messageViewList = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(MessageView.class),
                new Object[]{userId,dateTime}
        );

        return messageViewList;
    }

    @Override
    public List<MessageView> alreadyReadSelectMany(String userId) {
        var sql = "select * from already_read inner  join message on already_read.message_id = message.id where already_read.user_id = ?";

        var messageViewList = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(MessageView.class),
                new Object[]{userId}
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

    @Override
    public int insertOne(int id, String userId) {
        var sql = "insert into already_read values (?,?)";

        var result = jdbcTemplate.update(sql,userId,id);

        return result;
    }

}
