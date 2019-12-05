package ICTProject.CistPortal.page.panel;

import ICTProject.CistPortal.page.HomePage;
import ICTProject.CistPortal.page.createMessage.MessageCreatePage;
import ICTProject.CistPortal.page.viewMessage.MessageViewListPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;

public class StudentMenuPanel extends Panel {

    public StudentMenuPanel(String id) {
        super(id);

        add(new BookmarkablePageLink<>("toHomePage", HomePage.class));
        add(new BookmarkablePageLink<>("toMessageViewListPage", MessageViewListPage.class));
        add(new BookmarkablePageLink<>("toMessageCreatePage", MessageCreatePage.class));
    }
}
