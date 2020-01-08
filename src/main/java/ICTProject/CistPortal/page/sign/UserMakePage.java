package ICTProject.CistPortal.page.sign;

import ICTProject.CistPortal.page.TemplatePage;
import ICTProject.CistPortal.service.ICsvToStringsService;
import ICTProject.CistPortal.service.IUserService;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.validation.validator.StringValidator;
import org.wicketstuff.annotation.mount.MountPath;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@AuthorizeInstantiation("ADMIN")
@MountPath("UserMake")
public class UserMakePage extends TemplatePage {
    @SpringBean
    private IUserService userService;

    @SpringBean
    private ICsvToStringsService csvToStringsService;

    public UserMakePage() {
        super();

        IModel<String> userIdModel = Model.of("");
        IModel<String> lastNameModel = Model.of("");
        IModel<String> firstNameModel = Model.of("");
        IModel<String> gradeModel = Model.of("");
        IModel<String> roleModel = Model.of();
        IModel<String> userPassModel = Model.of("");
        IModel<List<FileUpload>> fileModel = Model.ofList(new ArrayList<>());
        List<String> list = new ArrayList<>();
        list.add("ADMIN");
        list.add("TEACHER");
        list.add("STUDENT");

        //　手入力用のフォーム
        Form<Void> userInfoForm = new Form<>("userInfo");
        add(userInfoForm);
        userInfoForm.add(new Button("button1") {
            @Override
            public void onSubmit() {
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
        });

        TextField<String> userIdField = new TextField<>("userId",userIdModel) {
            @Override
            protected void onInitialize() {
                super.onInitialize();
                add(StringValidator.lengthBetween(8, 8));
            }
        };
        userInfoForm.add(userIdField);

        TextField<String> lastNameField = new TextField<>("lastName",lastNameModel) {
            @Override
            protected void onInitialize() {
                super.onInitialize();
                add(StringValidator.lengthBetween(1, 32));
            }
        };
        userInfoForm.add(lastNameField);

        TextField<String> firstNameField = new TextField<>("firstName",firstNameModel) {
            @Override
            protected void onInitialize() {
                super.onInitialize();
                add(StringValidator.lengthBetween(1, 32));
            }
        };
        userInfoForm.add(firstNameField);

        TextField<String> gradeField = new TextField<>("grade",gradeModel) {
            @Override
            protected void onInitialize() {
                super.onInitialize();
                add(StringValidator.lengthBetween(2, 2));
            }
        };
        userInfoForm.add(gradeField);

        DropDownChoice<String> roleField = new DropDownChoice<String>("role",roleModel,list);
        userInfoForm.add(roleField);

        PasswordTextField userPassField = new PasswordTextField("userPass",userPassModel) {
            @Override
            protected void onInitialize() {
                super.onInitialize();
                add(StringValidator.lengthBetween(6,32));
            }
        };
        userInfoForm.add(userPassField);

        FileUploadField fileField = new FileUploadField("file",fileModel);

        // ファイルアップロード用のフォーム
        Form<Void> userInfoFile = new Form<>("userInfoFile");
        add(userInfoFile);
        userInfoFile.setMultiPart(true);
        userInfoFile.add(new Button("button2") {
            @Override
            public void onSubmit() {
                var file = fileField.getFileUpload();
                try {
                    var lines = csvToStringsService.convert(file,Charset.forName("UTF-8"));
                    if(userService.registerUser(lines)) {
                        System.out.println("csvを登録しました。");
                        error("全件正常に登録できました。");
                    } else {
                        error("正常に登録できませんでした。");
                    }
                } catch (IOException e) {
                    error(e.getMessage());
                }
                setResponsePage(new UserMakedFilePage());
            }
        });

        userInfoFile.add(fileField);
    }
}
