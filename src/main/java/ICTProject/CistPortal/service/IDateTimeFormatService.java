package ICTProject.CistPortal.service;

import java.util.Date;

public interface IDateTimeFormatService {

    /**
     * 別々に取得した掲示期限用のデータをまとめてDate型で返す
     *
     * @param date 日付
     * @param hour 時
     * @param minute 分
     * @return Date型の情報
     */
    Date format(Date date,int hour,int minute);
}
