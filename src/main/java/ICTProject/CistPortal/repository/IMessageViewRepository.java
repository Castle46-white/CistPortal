package ICTProject.CistPortal.repository;

import ICTProject.CistPortal.model.MessageView;

import java.sql.Timestamp;
import java.util.List;

public interface IMessageViewRepository {
    public List<MessageView> selectMany(String userId, Timestamp dateTime);

    public List<MessageView> alreadyReadSelectMany(String userId);

    public List<MessageView> selectOne(int id);

    public int insertOne(int id, String userId);

}


