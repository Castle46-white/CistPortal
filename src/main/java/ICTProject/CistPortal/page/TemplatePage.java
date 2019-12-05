package ICTProject.CistPortal.page;

import ICTProject.CistPortal.MySession;
import ICTProject.CistPortal.page.panel.*;
import org.apache.wicket.markup.html.WebPage;


public class TemplatePage extends WebPage {

    public TemplatePage() {
        add(new HeaderPanel("headerPanel"));
        System.out.println(MySession.get().getRoles());
        switch (MySession.get().getRoles().toString()){
            case "ADMIN":
                addOrReplace(new MasterMenuPanel("menuPanel"));
            case "TEACHER":
                addOrReplace(new TeacherMenuPanel("menuPanel"));
            case "STUDENT":
                addOrReplace(new StudentMenuPanel("menuPanel"));
        }
        add(new FooterPanel("footerPanel"));
    }
}
