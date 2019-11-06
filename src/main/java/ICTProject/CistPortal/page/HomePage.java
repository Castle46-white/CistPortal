package ICTProject.CistPortal.page;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.wicketstuff.annotation.mount.MountPath;

@WicketHomePage
@MountPath("Home")
public class HomePage extends TemplatePage {

    public HomePage() {
        super();
    }
}
