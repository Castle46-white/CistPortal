package ICTProject.CistPortal.page;

import ICTProject.CistPortal.model.MessageView;
import ICTProject.CistPortal.service.IMessageViewService;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;
import org.apache.wicket.markup.html.basic.Label;
import java.awt.*;
import java.util.List;

@MountPath("MessageViewList")
public class MessageViewListPage extends WebPage {

    @SpringBean
    private IMessageViewService iMessageViewService;

    public MessageViewListPage(){

        IModel<List<MessageView>> messageViewModel = Model.ofList(iMessageViewService.selectMany());

        ListView<MessageView> MessageViewLV = new ListView<MessageView>("MessageView",messageViewModel) {
            @Override
            protected void populateItem(ListItem<MessageView> listItem) {
                IModel<MessageView> itemModel = listItem.getModel();
                MessageView messageView = itemModel.getObject();

                IModel<Integer> idModel = Model.of(messageView.getMessageId());
                Label idLabel = new Label("id",idModel);
                listItem.add(idLabel);

                IModel<String> titleModel = Model.of(messageView.getTitle());
                Label titleLabel = new Label("title",titleModel);
                listItem.add(titleLabel);

                var label = new Link<>("toMessageViewDetail"){
                    @Override
                    public void onClick(){
                        setResponsePage(new MessageViewDetail(1));
                    }
                };
                listItem.add(label);

            }
        };

        add(MessageViewLV);



    }
}
