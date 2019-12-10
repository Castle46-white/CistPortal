package ICTProject.CistPortal.repository;

import ICTProject.CistPortal.bean.MessageView;

import java.util.List;

public interface IMyMessageRepository {

    //TODO docを書く

    public List<MessageView> selectMyMessageList(String userId);

    public int insertDeletedMessage(long messageId);

}
