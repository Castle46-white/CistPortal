package ICTProject.CistPortal.page;

import ICTProject.CistPortal.Service.IUserService;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

import java.util.ArrayList;
import java.util.List;

@MountPath("UserMake")
public class UserMakePage extends WebPage {
    @SpringBean
    private IUserService userService;

    public UserMakePage() {
        IModel<String> userIdModel = Model.of("");
        IModel<String> lastNameModel = Model.of("");
        IModel<String> firstNameModel = Model.of("");
        IModel<String> gradeModel = Model.of("");
        IModel<String> roleModel = Model.of();
        IModel<String> userPassModel = Model.of("");
        List<String> list = new ArrayList<>();
        list.add("ADMIN");
        list.add("TEACHER");
        list.add("STUDENT");

        Form<Void> userInfoForm = new Form<>("userInfo") {
            @Override
            protected void onSubmit() {
                String userId = userIdModel.getObject();
                String lastName = lastNameModel.getObject();
                String firstName = firstNameModel.getObject();
                String grade = gradeModel.getObject();
                String roleName = roleModel.getObject();
                int role = userService.convRoleId(roleName);
                String userPass = userPassModel.getObject();
                String msg = "送信データ:"
                    + userId
                    + ","
                    + lastName
                    + ","
                    + firstName
                    + ","
                    + grade
                    + ","
                    + role
                    + ","
                    + userPass;
                System.out.println(msg);
                userService.registerUser(userId,lastName,firstName,grade,role,userPass);
                setResponsePage(new UserMakedPage(userIdModel,
                                                  lastNameModel,
                                                  firstNameModel,
                                                  gradeModel,
                                                  roleModel));
            }
        };
        add(userInfoForm);

        TextField<String> userIdField = new TextField<>("userId",userIdModel);
        userInfoForm.add(userIdField);

        TextField<String> lastNameField = new TextField<>("lastName",lastNameModel);
        userInfoForm.add(lastNameField);

        TextField<String> firstNameField = new TextField<>("firstName",firstNameModel);
        userInfoForm.add(firstNameField);

        TextField<String> gradeField = new TextField<>("grade",gradeModel);
        userInfoForm.add(gradeField);

        DropDownChoice<String> roleField = new DropDownChoice<String>("role",roleModel,list);
        userInfoForm.add(roleField);

        PasswordTextField userPassField = new PasswordTextField("userPass",userPassModel);
        userInfoForm.add(userPassField);
    }
}
