package ICTProject.CistPortal.page;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxCheckBox;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.CheckBoxMultipleChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.wicketstuff.annotation.mount.MountPath;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@MountPath("ChooseTarget")
public class ChooseTargetPage extends WebPage {

    public ChooseTargetPage() {

        IModel<List<String>> targetModel = Model.ofList(new ArrayList<>());
        List<String> targetList = new ArrayList<>();
        targetList.add("aaa");
        targetList.add("bbb");
        targetList.add("ccc");

        Form<Void> targetForm = new Form<>("targetForm") {
            @Override
            public void onSubmit() {
                System.out.println("送信");
            }

        };
        add(targetForm);

        targetForm.add(new CheckBoxMultipleChoice<String>("target",targetModel,targetList) {

        });

        targetForm.add(new AjaxCheckBox("ajaxTargetCheckBox") {
            @Override
            protected void onUpdate(AjaxRequestTarget ajaxRequestTarget) {

            }
        });







    }
}
