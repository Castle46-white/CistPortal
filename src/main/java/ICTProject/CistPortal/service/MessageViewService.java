package ICTProject.CistPortal.service;

import ICTProject.CistPortal.model.MessageView;
import ICTProject.CistPortal.repository.IMessageViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageViewService implements IMessageViewService{

    private IMessageViewRepository iMessageViewRepository;

    @Autowired
    public MessageViewService(IMessageViewRepository iMessageViewRepository) {
        this.iMessageViewRepository=iMessageViewRepository;
    }

    @Override
    public List<MessageView> selectMany() {
        List<MessageView> messageViewList = iMessageViewRepository.selectMany();
        return messageViewList;
    }

    @Override
    public MessageView selectOne(int messageId) {
        var messageViewDetail = iMessageViewRepository.selectOne(messageId);
        return messageViewDetail.get(0);
    }


}
