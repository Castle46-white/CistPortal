package ICTProject.CistPortal.service;


import ICTProject.CistPortal.bean.ChoseTarget;
import ICTProject.CistPortal.bean.MessageEdit;
import ICTProject.CistPortal.bean.MessageView;
import ICTProject.CistPortal.bean.UserIdCheckBox;
import ICTProject.CistPortal.repository.IMessageTargetRepository;
import ICTProject.CistPortal.repository.IMyMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class MyMessageService implements IMyMessageService {

    @Autowired
    IMyMessageRepository myMessageRepository;
    @Autowired
    IMessageTargetRepository messageTargetRepository;

    @Override
    public List<MessageView> getMyMessageList(String userId) {
        return myMessageRepository.selectMyMessageList(userId);
    }

    @Override
    public void deleteMessage(long messageId) {
        myMessageRepository.insertDeletedMessage(messageId);
    }

    @Override
    public MessageEdit getEditMessageList(long id) {
        return myMessageRepository.editMessage(id).get(0);
    }

    @Override
    public List<ChoseTarget> getChoseTarget(long id) {
        return messageTargetRepository.choseTarget(id);
    }

    @Override
    public void update(String title, String contents, Timestamp deadline, Timestamp updateDate, String userId, List<String> userIdList, long messageId) {
        var n = myMessageRepository.updateMessageInfo(title,contents,deadline,updateDate, userId,messageId);

        var m = myMessageRepository.deleteTarget(messageId);
        userIdList.stream().forEach(i -> messageTargetRepository.insertTarget(i,messageId));

    }
}
