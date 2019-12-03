package ICTProject.CistPortal.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public class MessageRepository implements IMessageRepository {

    private final JdbcTemplate jdbc;

    //TODO トランザクションのcommitのタイミング見直し

    @Autowired
    public MessageRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public int insertMessageInfo(String title, String contents, Timestamp deadline,Timestamp updateDate,String userId) {
        String sql = "BEGIN insert into message (title, contents, deadline, update_date, user_id) "
                + "values (?,?,?,?,?) ";
        return jdbc.update(sql,title,contents,deadline,updateDate,userId);
    }

    @Override
    public long selectMessageId() {
        String sql = "select max(id) from message commit ";
        var id = jdbc.query(sql,new SingleColumnRowMapper<>(Long.class),new Object[]{});
        return id.get(0);
    }
}
