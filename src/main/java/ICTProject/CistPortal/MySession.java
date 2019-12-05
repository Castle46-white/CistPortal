package ICTProject.CistPortal;

import ICTProject.CistPortal.bean.UserAccount;
import org.apache.wicket.Session;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

public class MySession extends AbstractAuthenticatedWebSession {
    private String userId;
    private String lastName;
    private String firstName;
    private String grade;
    private Roles role;

    public MySession (Request request) {
        super(request);
        role = new Roles();
    }

    public void sign(UserAccount userAccount) {
//        replaceSession();
        role.clear();
        this.userId = userAccount.getId();
        this.lastName = userAccount.getLastName();
        this.firstName = userAccount.getFirstName();
        this.grade = userAccount.getGrade();
        role.add(MyRole.getById(userAccount.getRoleId()).toString());
    }

    @Override
    public Roles getRoles() {
        if(isSignedIn()) {
            return role;
        }else{
            return new Roles();
        }

    }

    //ToDo Enumで比較できないか改善の余地あり
    @Override
    public boolean isSignedIn() {
        return role.hasRole(MyRole.ADMIN.toString()) ||
               role.hasRole(MyRole.TEACHER.toString()) ||
               role.hasRole(MyRole.STUDENT.toString());
    }

    public String getUserId() {
        return this.userId;
    }

    public static MySession get() {
        return (MySession) Session.get();
    }
}
