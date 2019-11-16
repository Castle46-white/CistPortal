package ICTProject.CistPortal.Service;

public interface IUserService {

    /**
     * ロール名を用いてデータベースからロールIDを取得する
     *
     * @param role ロール名
     * @return
     */
    public int convRoleId(String role);

    /**
     * @param userId ユーザーId
     * @param lastName 姓
     * @param firstName 名
     * @param grade 学年
     * @param role 権限
     * @param userPass パスワード
     */
    public void registerUser(String userId,String lastName,String firstName,String grade,int role,String userPass);

    /**
     * ユーザ名とパスワードをデータベースに照合する
     *
     * @param userId ユーザーId
     * @param userPass パスワード
     * @return 照合成功であれば<code>true</code>, 照合失敗は<code>false</code>
     */
    public boolean existsUser(String userId,String userPass);
}
