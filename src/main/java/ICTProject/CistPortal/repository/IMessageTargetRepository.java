package ICTProject.CistPortal.repository;


import ICTProject.CistPortal.bean.ChoseTarget;
import ICTProject.CistPortal.bean.UserIdCheckBox;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMessageTargetRepository {


    /**
     *
     * @return 全ユーザのuserIdのList
     */
    public List<UserIdCheckBox> selectUserId();


    /**
     *
     * @param userId targetのuserId
     * @param messageId 対象のmessageId
     * @return 更新行数
     */
    public int insertTarget(String userId,long messageId);

    /**
     *
     * @param messageId メッセージID
     * @return ユーザID
     */
    public List<ChoseTarget> choseTarget(long messageId);
}
