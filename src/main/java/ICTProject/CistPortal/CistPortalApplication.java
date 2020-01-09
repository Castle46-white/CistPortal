package ICTProject.CistPortal;

import ICTProject.CistPortal.page.sign.SignPage;
import com.giffing.wicket.spring.boot.starter.app.WicketBootSecuredWebApplication;
import org.apache.wicket.Page;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class CistPortalApplication extends WicketBootSecuredWebApplication {

	public static void main(String[] args) { SpringApplication.run(CistPortalApplication.class, args); }

	@Override
	protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
		return MySession.class;
	}

	@Override
	public Class<? extends Page> getHomePage() {
		return SignPage.class;
	}
}
