package ICTProject.CistPortal.service;

import ICTProject.CistPortal.bean.MessageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IMyMessageService {

    public List<MessageView> getMyMessageList(String userId);

    public void deleteMessage(long messageId);

}
