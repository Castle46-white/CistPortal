package ICTProject.CistPortal.service;

import ICTProject.CistPortal.model.MessageView;

import java.util.List;

public interface IMessageViewService {
    public List<MessageView> selectMany();

    public MessageView selectOne(int messageId);
}
