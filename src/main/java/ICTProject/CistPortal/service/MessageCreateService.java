package ICTProject.CistPortal.service;


import ICTProject.CistPortal.bean.UserIdCheckBox;
import ICTProject.CistPortal.repository.IMessageRepository;
import ICTProject.CistPortal.repository.IMessageTargetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class MessageCreateService implements IMessageCreateService{


    private IMessageTargetRepository messageTargetRepository;
    private IMessageRepository messageRepository;

    @Autowired
    public MessageCreateService(IMessageTargetRepository messageTargetRepository,IMessageRepository messageRepository) {
        this.messageTargetRepository = messageTargetRepository;
        this.messageRepository = messageRepository;
    }

    @Override
    public List<UserIdCheckBox> getUserIdList() {
        return messageTargetRepository.selectUserId();
    }

    @Override
    public void create(String title, String contents, Timestamp deadline, Timestamp updateDate, String userId, List<String> userIdList) {
        var n = messageRepository.insertMessageInfo(title,contents,deadline,updateDate, userId);
        var messageId = messageRepository.selectMessageId();
        userIdList.stream()
                .forEach(i -> messageTargetRepository.insertTarget(i,messageId));

    }
}
