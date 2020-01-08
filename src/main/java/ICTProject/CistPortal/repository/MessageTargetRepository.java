package ICTProject.CistPortal.repository;

import ICTProject.CistPortal.bean.ChoseTarget;
import ICTProject.CistPortal.bean.UserIdCheckBox;
import org.apache.wicket.markup.html.form.CheckGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageTargetRepository implements IMessageTargetRepository{

    private final JdbcTemplate jdbc;

    @Autowired
    public MessageTargetRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }


    @Override
    public List<UserIdCheckBox> selectUserId() {
        String sql = "select id from user_account";
        return jdbc.query(sql,new BeanPropertyRowMapper<>(UserIdCheckBox.class),new Object[]{});
    }

    @Override
    public int insertTarget(String userId,long messageId) {
        String sql = "insert into message_target values (?,?,?)";
        return jdbc.update(sql,userId,messageId,false);
    }

    @Override
    public List<ChoseTarget> choseTarget(long messageId) {
        String sql = "select user_id from message_target where message_id=?";
        return jdbc.query(sql,new BeanPropertyRowMapper<>(ChoseTarget.class),new Object[]{messageId});
    }
}
