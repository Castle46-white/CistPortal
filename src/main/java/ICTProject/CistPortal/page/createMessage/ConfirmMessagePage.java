package ICTProject.CistPortal.page.createMessage;

import ICTProject.CistPortal.bean.Message;
import ICTProject.CistPortal.page.TemplatePage;
import ICTProject.CistPortal.service.IMessageCreateService;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@MountPath("ConfirmMessagePage")
public class ConfirmMessagePage extends TemplatePage {

    @SpringBean
    IMessageCreateService messageCreateService;

    public ConfirmMessagePage(IModel<Message> messageModel, IModel<List<String>> targetUserIdListModel) {
        super();

        add(new Label("messageTitle",messageModel.getObject().getTitle()));
        add(new Label("messageContents",messageModel.getObject().getContents()));
        add(new Label("deadline",messageModel.getObject().getDeadline()));
        add(new ListView<>("targetUserIdLV",targetUserIdListModel) {
            @Override
            public void populateItem(ListItem<String> listItem) {
                IModel<String> userIdModel = Model.of(listItem.getModelObject());
                Label userIdLabel = new Label("targetUserId", userIdModel);
                listItem.add(userIdLabel);
            }
        });

        add(new Link<Void>("toMessageCreateCompPage") {
            @Override
            public void onClick() {
                //TODO session実装後にuserIdを取得できるように
                messageCreateService.create(messageModel.getObject().getTitle(),
                        messageModel.getObject().getContents(),
                        messageModel.getObject().getDeadline(),
                        Timestamp.valueOf(LocalDateTime.now()),
                        "b2170000",
                        targetUserIdListModel.getObject());
                setResponsePage(new MessageCreateCompPage());
            }
        });


    }
}
