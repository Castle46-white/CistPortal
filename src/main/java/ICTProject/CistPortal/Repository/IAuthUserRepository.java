package ICTProject.CistPortal.Repository;

public interface IAuthUserRepository {

    /**
     * ロール名からロールIDを検索する
     *
     * @param role　ロール名
     * @return
     */
    public int getRoleId(String role);

    /**
     * アカウント情報をuser_account,user_passテーブルに記録する
     *
     * @param userId ユーザーId
     * @param lastName 姓
     * @param firstName 名
     * @param grade 学年
     * @param role 権限
     * @param userPass パスワード
     */
    public void insert(String userId,String lastName,String firstName,String grade,int role,String userPass);

    /**
     * ユーザ名とパスワードが一致するレコードがAuthUserテーブルにあるか検索する
     *
     * @param userId ユーザーId
     * @param userPass パスワード
     * @return レコードの有無, 存在すれば<code>true</code>, それ以外は <code>false</code>
     */
    public boolean exists(String userId, String userPass);

}
