package ICTProject.CistPortal.service;

import ICTProject.CistPortal.bean.MessageView;

import java.sql.Timestamp;
import java.util.List;

public interface IMessageViewService {
    public List<MessageView> selectMany(String userId, Timestamp dateTime);

    public List<MessageView> alreadyReadSelectMany(String userId,Timestamp dateTime);

    public MessageView selectOne(int messageId);

    public int insertOne(int messageId,String userId);

    public int updateRead(long messageId,String userId);

    public int updateUnread(long messageId,String userId);

}
