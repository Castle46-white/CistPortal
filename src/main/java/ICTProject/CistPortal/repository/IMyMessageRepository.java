package ICTProject.CistPortal.repository;

import ICTProject.CistPortal.bean.MessageEdit;
import ICTProject.CistPortal.bean.MessageView;

import java.sql.Timestamp;
import java.util.List;

public interface IMyMessageRepository {

    //TODO docを書く

    public List<MessageView> selectMyMessageList(String userId);

    public int insertDeletedMessage(long messageId);

    public List<MessageEdit> editMessage(long messageId);

    public int updateMessageInfo(String title, String contents, Timestamp deadline, Timestamp updateDate, String userId, long messageId);

    public int deleteTarget(long messageId);

}
