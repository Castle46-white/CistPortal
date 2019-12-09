package ICTProject.CistPortal.service;

import ICTProject.CistPortal.bean.MessageView;
import ICTProject.CistPortal.repository.IMessageViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class MessageViewService implements IMessageViewService{

    private IMessageViewRepository iMessageViewRepository;

    @Autowired
    public MessageViewService(IMessageViewRepository iMessageViewRepository) {
        this.iMessageViewRepository=iMessageViewRepository;
    }

    @Override
    public List<MessageView> selectMany(String userId, Timestamp dateTime) {
        List<MessageView> messageViewList = iMessageViewRepository.selectMany(userId,dateTime);
        return messageViewList;
    }

    @Override
    public List<MessageView> alreadyReadSelectMany(String userId,Timestamp dateTime) {
        List<MessageView> messageViewList = iMessageViewRepository.alreadyReadSelectMany(userId,dateTime);
        return messageViewList;
    }

    @Override
    public MessageView selectOne(int messageId) {
        var messageViewDetail = iMessageViewRepository.selectOne(messageId);
        return messageViewDetail.get(0);
    }

    @Override
    public int insertOne(int id,String userId) {
        var result = iMessageViewRepository.insertOne(id,userId);
        return result;
    }

    @Override
    public int updateRead(long messageId,String userId) {
        var result = iMessageViewRepository.updateRead(messageId,userId);
        return result;
    }

    @Override
    public int updateUnread(long messageId,String userId) {
        var result = iMessageViewRepository.updateRead(messageId,userId);
        return result;
    }

}
