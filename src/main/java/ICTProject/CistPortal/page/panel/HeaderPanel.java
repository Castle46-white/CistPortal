package ICTProject.CistPortal.page.panel;

import ICTProject.CistPortal.MySession;
import ICTProject.CistPortal.page.sign.SignPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

public class HeaderPanel extends Panel {

    public HeaderPanel(String id) {
        super(id);

        add(new Link<>("signOut") {
            @Override
            public void onClick() {
                MySession.get().signOut();
                setResponsePage(new SignPage());
            }
        });
    }
}
