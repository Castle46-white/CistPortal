package ICTProject.CistPortal.page;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.wicketstuff.annotation.mount.MountPath;

@AuthorizeInstantiation({"ADMIN" , "TEACHER" , "STUDENT"})
@MountPath("Home")
public class HomePage extends WebPage {

    public HomePage() {
        Link<Void> toUserMakeLink = new BookmarkablePageLink<Void>("toUserMake",UserMakePage.class);
        add(toUserMakeLink);
    }
}