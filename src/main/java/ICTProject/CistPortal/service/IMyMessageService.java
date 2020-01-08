package ICTProject.CistPortal.service;

import ICTProject.CistPortal.bean.ChoseTarget;
import ICTProject.CistPortal.bean.MessageEdit;
import ICTProject.CistPortal.bean.MessageView;
import ICTProject.CistPortal.bean.UserIdCheckBox;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public interface IMyMessageService {

    public List<MessageView> getMyMessageList(String userId);

    public void deleteMessage(long messageId);

    public MessageEdit getEditMessageList(long id);

    public List<ChoseTarget> getChoseTarget(long id);

    public void update(String title, String contents, Timestamp deadline, Timestamp updateDate, String userId, List<String> userIdList, long messageId);

}
