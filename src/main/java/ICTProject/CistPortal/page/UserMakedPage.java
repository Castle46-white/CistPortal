package ICTProject.CistPortal.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.wicketstuff.annotation.mount.MountPath;

@MountPath("UserMaked")
public class UserMakedPage extends WebPage {
    public UserMakedPage(IModel<String> userIdModel,
                         IModel<String> lastNameModel,
                         IModel<String> firstNameModel,
                         IModel<String> gradeModel,
                         IModel<String> roleModel) {

        Label userIdLabel = new Label("userId",userIdModel);
        add(userIdLabel);
        Label lastNameLabel = new Label("lastName",lastNameModel);
        add(lastNameLabel);
        Label firstNameLabel = new Label("firstName",firstNameModel);
        add(firstNameLabel);
        Label gradeLabel = new Label("grade",gradeModel);
        add(gradeLabel);
        Label roleLabel = new Label("role",roleModel);
        add(roleLabel);

        Link<Void> toHomeLink = new BookmarkablePageLink<Void>("toHome",HomePage.class);
        add(toHomeLink);
    }
}
