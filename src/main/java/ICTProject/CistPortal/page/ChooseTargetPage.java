package ICTProject.CistPortal.page;

import ICTProject.CistPortal.bean.Message;
import ICTProject.CistPortal.bean.UserIdCheckBox;
import ICTProject.CistPortal.service.IMessageCreateService;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxCheckBox;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@MountPath("ChooseTarget")
public class ChooseTargetPage extends WebPage {

    @SpringBean
    private IMessageCreateService messageCreateService;

    public ChooseTargetPage(IModel<Message> messageModel) {

        //TODO コードの整理

        IModel<List<UserIdCheckBox>> userIdListModel = Model.ofList(messageCreateService.getUserIdList());
        var targetMarkupContainer = new WebMarkupContainer("targetMarkupContainer");
        targetMarkupContainer.setOutputMarkupId(true);
        add(targetMarkupContainer);
        var targetUserIdList = new ArrayList<String>();
        IModel<Boolean> booleModel = Model.of();
        IModel<List<String>> targetUserIdListModel = Model.ofList(targetUserIdList);


        //checkBox表示用LV
        var userIdLV = new ListView<>("userIdLV", userIdListModel) {
            @Override
            protected void populateItem(ListItem<UserIdCheckBox> listItem) {
                IModel<String> userIdModel = Model.of(listItem.getModelObject().getId());
                Label userIdLabel = new Label("userId", userIdModel);
                listItem.add(userIdLabel);

                listItem.getModelObject().setCheckBox(new AjaxCheckBox("userIdCheckBox", booleModel) {
                    @Override
                    protected void onUpdate(AjaxRequestTarget ajaxRequestTarget) {
                        if (booleModel.getObject()) {
                            targetUserIdList.add(listItem.getModelObject().getId());
                        } else {
                            targetUserIdList.remove(targetUserIdList.indexOf(listItem.getModelObject().getId()));
                        }
                        ajaxRequestTarget.add(targetMarkupContainer);

                    }
                });
                listItem.add(listItem.getModelObject().getCheckBox());
                listItem.getModelObject().getCheckBox().setOutputMarkupId(true);
            }
        };
        add(userIdLV);


        //選択済みuserId表示用LV
        var targetListView = new ListView<>("targetListView", targetUserIdListModel) {
            @Override
            protected void populateItem(ListItem<String> listItem) {
                IModel<String> userIdModel = Model.of(listItem.getModelObject());
                Label userIdLabel = new Label("targetUserId", userIdModel);
                listItem.add(userIdLabel);
            }
        };
        targetListView.setOutputMarkupId(true);
        targetMarkupContainer.add(targetListView);

        add(new Link<Void>("toMessageConfirmPage") {
            @Override
            public void onClick() {
                setResponsePage(new ConfirmMessagePage(messageModel,targetUserIdListModel));
            }
        });

    }
}
