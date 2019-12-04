package ICTProject.CistPortal.page.viewMessage;

import ICTProject.CistPortal.bean.MessageView;
import ICTProject.CistPortal.service.IMessageViewService;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;


import java.time.LocalDateTime;
import java.util.List;

@MountPath("alreadyReadMessageViewListPage")
public class alreadyReadMessageViewListPage extends WebPage {

    @SpringBean
    public IMessageViewService iMessageViewService;

    public alreadyReadMessageViewListPage(){

        IModel<List<MessageView>> messageViewModel = Model.ofList(iMessageViewService.alreadyReadSelectMany("b2171530"));

        ListView<MessageView> messageViewLV = new ListView<MessageView>("messageView",messageViewModel) {
            @Override
            protected void populateItem(ListItem<MessageView> listItem) {

                IModel<MessageView> itemModel = listItem.getModel();
                MessageView messageView = itemModel.getObject();

                IModel<String> titleModel = Model.of(messageView.getTitle());
                Label titleLabel = new Label("title", titleModel);
                listItem.add(titleLabel);

                IModel<LocalDateTime> deadLineModel = Model.of(messageView.getDeadLine());
                Label deadlineLabel = new Label("deadLine", deadLineModel);
                listItem.add(deadlineLabel);

                IModel<LocalDateTime> updateDateModel = Model.of(messageView.getUpdateDate());
                Label updateDateLabel = new Label("updateDate", updateDateModel);
                listItem.add(updateDateLabel);

                var label = new Link<>("toMessageViewDetail") {
                    @Override
                    public void onClick() {
                        setResponsePage(new MessageViewDetail(messageView.getId()));
                    }
                };
                listItem.add(label);


            }
        };

        add(messageViewLV);
    }
}
