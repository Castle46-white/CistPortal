package ICTProject.CistPortal.service;

import ICTProject.CistPortal.model.MessageView;

import java.sql.Timestamp;
import java.util.List;

public interface IMessageViewService {
    public List<MessageView> selectMany(String userId, Timestamp dateTime);

    public MessageView selectOne(int messageId);


}
