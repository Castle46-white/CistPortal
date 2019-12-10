package ICTProject.CistPortal.page.createMessage;

import ICTProject.CistPortal.page.HomePage;
import ICTProject.CistPortal.page.TemplatePage;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.wicketstuff.annotation.mount.MountPath;


@AuthorizeInstantiation({"ADMIN" , "TEACHER" , "STUDENT"})
@MountPath("MessageCreatePage")
public class MessageCreateCompPage extends TemplatePage {

    public MessageCreateCompPage() {
        super();

        add(new BookmarkablePageLink<Void>("toHomePage", HomePage.class));

    }
}
