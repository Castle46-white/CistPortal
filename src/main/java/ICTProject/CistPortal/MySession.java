package ICTProject.CistPortal;

import org.apache.wicket.Session;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

import java.util.Objects;

public class MySession extends AbstractAuthenticatedWebSession {
    private String userId;
    private Roles role;

    public MySession (Request request) {
        super(request);
        this.userId = null;
    }

    public void sign(String userId) {
        replaceSession();
        this.userId = userId;
    }

    @Override
    public Roles getRoles() {
        if(isSignedIn()) {
            return new Roles(Roles.USER);
        }
        return new Roles();
    }

    @Override
    public boolean isSignedIn() {
        return Objects.nonNull(this.userId);
    }

    public String getUserId() {
        return this.userId;
    }

    public static MySession get() {
        return (MySession) Session.get();
    }
}
