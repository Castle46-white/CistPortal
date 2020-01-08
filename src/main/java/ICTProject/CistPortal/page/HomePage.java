package ICTProject.CistPortal.page;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.wicketstuff.annotation.mount.MountPath;

@AuthorizeInstantiation({"ADMIN" , "TEACHER" , "STUDENT"})
@MountPath("Home")
public class HomePage extends TemplatePage {

    public HomePage() {
        super();
    }
}