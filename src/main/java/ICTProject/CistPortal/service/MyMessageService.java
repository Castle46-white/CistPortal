package ICTProject.CistPortal.service;


import ICTProject.CistPortal.bean.MessageView;
import ICTProject.CistPortal.repository.IMyMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyMessageService implements IMyMessageService {

    @Autowired
    IMyMessageRepository myMessageRepository;

    @Override
    public List<MessageView> getMyMessageList(String userId) {
        return myMessageRepository.selectMyMessageList(userId);
    }

    @Override
    public void deleteMessage(long messageId) {
        myMessageRepository.insertDeletedMessage(messageId);
    }
}
