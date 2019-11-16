package ICTProject.CistPortal.page;

import ICTProject.CistPortal.MySession;
import ICTProject.CistPortal.Service.IUserService;
import com.giffing.wicket.spring.boot.context.scan.WicketSignInPage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.validation.validator.StringValidator;
import org.wicketstuff.annotation.mount.MountPath;

@WicketSignInPage
@MountPath("Sign")
public class SignPage extends WebPage {
    @SpringBean
    private IUserService service;
    public SignPage() {
        IModel<String> userIdModel = Model.of("");
        IModel<String> userPassModel = Model.of("");

        Form<Void> userInfoForm = new Form<Void>("userInfo") {
            @Override
            protected void onSubmit() {
                String userId = userIdModel.getObject();
                String userPass = userPassModel.getObject();
                if (service.existsUser(userId,userPass)) {
                    MySession.get().sign(userId);
                }
                setResponsePage(new HomePage());
            }
        };
        add(userInfoForm);

        TextField<String> userIdField = new TextField<String>("userId",userIdModel) {
            @Override
            protected void onInitialize() {
                super.onInitialize();
                add(StringValidator.lengthBetween(8,8));
            }
        };
        userInfoForm.add(userIdField);

        PasswordTextField userPassField = new PasswordTextField("userPass",userPassModel) {
            @Override
            protected void onInitialize() {
                super.onInitialize();
                add(StringValidator.lengthBetween(6,32));
            }
        };
        userInfoForm.add(userPassField);


    }
}
