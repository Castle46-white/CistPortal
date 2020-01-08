package ICTProject.CistPortal.page;

import ICTProject.CistPortal.MySession;
import ICTProject.CistPortal.page.panel.*;
import org.apache.wicket.markup.html.WebPage;

public class TemplatePage extends WebPage {

    public TemplatePage() {
        add(new HeaderPanel("headerPanel"));
        switch (MySession.get().getRoles().toString()){
            case "ADMIN":
                addOrReplace(new MasterMenuPanel("menuPanel"));
                break;
            case "TEACHER":
                addOrReplace(new TeacherMenuPanel("menuPanel"));
                break;
            case "STUDENT":
                addOrReplace(new StudentMenuPanel("menuPanel"));
                break;
        }
        add(new FooterPanel("footerPanel"));
    }
}
