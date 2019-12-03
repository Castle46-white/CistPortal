package ICTProject.CistPortal.service;


import ICTProject.CistPortal.bean.UserIdCheckBox;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public interface IMessageCreateService {

    /**
     * checkbox作成用のuserId一覧を取得
     *
     * @return userIdCheckBox型のリスト
     */
    public List<UserIdCheckBox> getUserIdList();


    /**
     * messageを作成する
     * @param title
     * @param contents
     * @param deadline
     * @param updateDate
     * @param userId
     */
    public void create(String title, String contents, Timestamp deadline,Timestamp updateDate,String userId,List<String> userIdList);
}
