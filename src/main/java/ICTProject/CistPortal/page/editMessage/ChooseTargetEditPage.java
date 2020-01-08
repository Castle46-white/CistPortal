package ICTProject.CistPortal.page.editMessage;

import ICTProject.CistPortal.bean.ChoseTarget;
import ICTProject.CistPortal.bean.Message;
import ICTProject.CistPortal.bean.UserIdCheckBox;
import ICTProject.CistPortal.page.TemplatePage;
import ICTProject.CistPortal.service.IMessageCreateService;
import ICTProject.CistPortal.service.IMyMessageService;
import ICTProject.CistPortal.service.TargetCheckService;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxCheckBox;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

import java.util.ArrayList;
import java.util.List;


@AuthorizeInstantiation({"ADMIN" , "TEACHER" , "STUDENT"})
@MountPath("ChooseTargetEdit")
public class ChooseTargetEditPage extends TemplatePage {

    @SpringBean
    private IMessageCreateService messageCreateService;

    @SpringBean
    private IMyMessageService myMessageService;

    @SpringBean
    private TargetCheckService targetCheckService;

    public ChooseTargetEditPage(long messageId,IModel<Message> messageModel) {
        super();

        //TODO コードの整理

        IModel<List<UserIdCheckBox>> userIdListModel = Model.ofList(targetCheckService.getUserIdList(messageId));
        var targetMarkupContainer = new WebMarkupContainer("targetMarkupContainer");
        targetMarkupContainer.setOutputMarkupId(true);
        add(targetMarkupContainer);
        var targetUserIdList = new ArrayList<String>();
        for (ChoseTarget choseTarget : myMessageService.getChoseTarget(messageId)) {
            targetUserIdList.add(choseTarget.getUserId());
        }
        IModel<List<String>> targetUserIdListModel = Model.ofList(targetUserIdList);


        //checkBox表示用LV
        var userIdLV = new ListView<>("userIdLV", userIdListModel) {
            @Override
            protected void populateItem(ListItem<UserIdCheckBox> listItem) {
                IModel<String> userIdModel = Model.of(listItem.getModelObject().getId());
                Label userIdLabel = new Label("userId", userIdModel);
                listItem.add(userIdLabel);
                IModel<Boolean> booleModel = Model.of(listItem.getModelObject().isTarget());

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
                if(targetUserIdListModel.getObject().size() >= 1) {
                    setResponsePage(new ConfirmMessageEditPage(messageModel,targetUserIdListModel,messageId));
                }else {
                    error("１人以上の相手を選択してください。");
                }

            }
        });

    }
}
