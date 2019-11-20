package ICTProject.CistPortal.Repository;

import org.apache.wicket.markup.html.link.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthUserRepository implements IAuthUserRepository {
    private JdbcTemplate jdbc;

    @Autowired
    public AuthUserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public int getRoleId(String role) {
        String sql = "select id from roles Where role_name = ?";
        List<Integer> roleId = jdbc.query(sql,new SingleColumnRowMapper(Integer.class),new Object[]{role});
        return roleId.get(0);
    }

    @Override
    public void insert(String userId,String lastName,String firstName,String grade,int role,String userPass) {
        String sql = "BEGIN ; insert into user_account values (?,?,?,?,?)";
        jdbc.update(sql,userId,lastName,firstName,grade,role);
        String pass = "insert into user_pass values (?,crypt(?, gen_salt('bf'))) COMMIT ;";
        jdbc.update(pass,userId,userPass);
    }

    @Override
    public boolean exists(String userId) {
        String sql = "select true from  user_account Where id = ?";
        List<Boolean> booles = jdbc.query(sql,new SingleColumnRowMapper(Boolean.class),new Object[]{userId});

        return !booles.isEmpty();
    }

    @Override
    public boolean exists(String userId,String userPass) {
        String sql = "select true from  user_account inner join user_pass on user_account.id = user_pass.user_id Where id = ? and password = crypt(?, password)";
        List<Boolean> booles = jdbc.query(sql,new SingleColumnRowMapper(Boolean.class),new Object[]{userId,userPass});

        return !booles.isEmpty();
    }
}
