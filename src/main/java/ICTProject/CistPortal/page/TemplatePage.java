package ICTProject.CistPortal.page;

import ICTProject.CistPortal.page.panel.FooterPanel;
import ICTProject.CistPortal.page.panel.HeaderPanel;
import ICTProject.CistPortal.page.panel.StudentMenuPanel;
import org.apache.wicket.markup.html.WebPage;
import org.wicketstuff.annotation.mount.MountPath;

@MountPath("TemplatePage")
public class TemplatePage extends WebPage {

    public TemplatePage() {
        add(new HeaderPanel("headerPanel"));
        add(new StudentMenuPanel("menuPanel"));
        add(new FooterPanel("footerPanel"));
    }
}
