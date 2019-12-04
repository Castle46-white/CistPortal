package ICTProject.CistPortal.page.sign;

import ICTProject.CistPortal.page.HomePage;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.wicketstuff.annotation.mount.MountPath;

@AuthorizeInstantiation("ADMIN")
@MountPath("UserMakedFile")
public class UserMakedFilePage extends WebPage {
    public UserMakedFilePage() {
        Link<Void> toHomeLink = new BookmarkablePageLink<Void>("toHome", HomePage.class);
        add(toHomeLink);
    }
}