package ICTProject.CistPortal.page.myMessage;

import ICTProject.CistPortal.page.HomePage;
import ICTProject.CistPortal.page.TemplatePage;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.wicketstuff.annotation.mount.MountPath;

@AuthorizeInstantiation({"ADMIN" , "TEACHER" , "STUDENT"})
@MountPath("MessageDeleteCompPage")
public class MessageDeleteCompPage extends TemplatePage {

    MessageDeleteCompPage() {
        super();

        add(new BookmarkablePageLink<Void>("toHomePage", HomePage.class));
    }

}
