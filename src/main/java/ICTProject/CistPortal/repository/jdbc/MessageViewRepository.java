package ICTProject.CistPortal.repository.jdbc;

import ICTProject.CistPortal.model.MessageView;
import ICTProject.CistPortal.repository.IMessageViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageViewRepository implements IMessageViewRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MessageViewRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    @Override
    public List<MessageView> selectMany() {
        var sql = "select * from message";

        var messageViewList = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(MessageView.class),
                new Object[]{}
        );
        //System.out.println(messageViewList.get(0).getId());
        return messageViewList;
    }

    @Override
    public List<MessageView> selectOne(int messageId) {
        var sql = "select * from message where id = ?";

        var messageViewDetail = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(MessageView.class),
                messageId);
        //System.out.println(messageViewDetail.get(0).getId());

        return messageViewDetail;
    }
}
