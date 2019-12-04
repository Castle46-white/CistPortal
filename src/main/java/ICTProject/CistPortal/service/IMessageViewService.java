package ICTProject.CistPortal.service;

import ICTProject.CistPortal.bean.MessageView;

import java.sql.Timestamp;
import java.util.List;

public interface IMessageViewService {
    public List<MessageView> selectMany(String userId, Timestamp dateTime);

    public List<MessageView> alreadyReadSelectMany(String userId);

    public MessageView selectOne(int messageId);

    public int insertOne(int messageId,String userId);

}
