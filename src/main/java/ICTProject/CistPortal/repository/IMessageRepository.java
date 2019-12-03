package ICTProject.CistPortal.repository;

import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface IMessageRepository {

    /**
     *
     * @param title messageのタイトル
     * @param contents messageの内容
     * @param deadline messageの掲示期限
     * @param updateDate messageの更新日時
     * @param userId messageの作成者のuserId
     * @return 更新行数
     */
    public int insertMessageInfo(String title, String contents, Timestamp deadline,Timestamp updateDate,String userId);


    /**
     *
     * @return 最新のmessageIdを取得
     */
    public long selectMessageId();
}
