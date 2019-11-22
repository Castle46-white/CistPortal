package ICTProject.CistPortal.Service;

import ICTProject.CistPortal.bean.UserAccount;

import java.util.List;

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
     * @param lines csvのデータ
     */
    public boolean registerUser(List<String> lines);

    /**
     * ユーザ名とパスワードをデータベースに照合する
     *
     * @param userId ユーザーId
     * @param userPass パスワード
     * @return 照合成功であれば<code>true</code>, 照合失敗は<code>false</code>
     */
    public UserAccount signInUser(String userId, String userPass);
}
