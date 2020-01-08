package ICTProject.CistPortal.page.editMessage;

import ICTProject.CistPortal.page.HomePage;
import ICTProject.CistPortal.page.TemplatePage;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.wicketstuff.annotation.mount.MountPath;


@AuthorizeInstantiation({"ADMIN" , "TEACHER" , "STUDENT"})
@MountPath("MessageEditPage")
public class MessageEditCompPage extends TemplatePage {

    public MessageEditCompPage() {
        super();

        add(new BookmarkablePageLink<Void>("toHomePage", HomePage.class));

    }
}