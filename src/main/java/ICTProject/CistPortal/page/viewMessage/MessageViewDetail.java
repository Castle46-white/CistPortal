package ICTProject.CistPortal.page.viewMessage;

import ICTProject.CistPortal.bean.MessageView;
import ICTProject.CistPortal.service.IMessageViewService;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
//import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;
import org.apache.wicket.markup.html.basic.Label;


@MountPath("MessageViewDetail")
public class MessageViewDetail extends WebPage {

    @SpringBean
    private  IMessageViewService iMessageViewService;

    MessageViewDetail(){

    }

    MessageViewDetail(int id,String userId){
        int result = iMessageViewService.insertOne(id,userId);
        IModel<MessageView> messageViewIModel = Model.of(iMessageViewService.selectOne(id));
        Label messageViewTitle = new Label("title", messageViewIModel.getObject().getTitle());
        add(messageViewTitle);

        Label messageViewContents = new Label("message", messageViewIModel.getObject().getContents());
        add(messageViewContents);

        Label messageViewDeadLine = new Label("deadLine", messageViewIModel.getObject().getDeadLine());
        add(messageViewDeadLine);

        Label messageViewUpdatedate = new Label("updateDate", messageViewIModel.getObject().getUpdateDate());
        add(messageViewUpdatedate);

        Link<Void> toMessageViewListPage = new BookmarkablePageLink<>("toMessageViewListPage", MessageViewListPage.class);
        add(toMessageViewListPage);


    }

    MessageViewDetail(int id){
        IModel<MessageView> messageViewIModel = Model.of(iMessageViewService.selectOne(id));
        Label messageViewTitle = new Label("title", messageViewIModel.getObject().getTitle());
        add(messageViewTitle);

        Label messageViewContents = new Label("message", messageViewIModel.getObject().getContents());
        add(messageViewContents);

        Label messageViewDeadLine = new Label("deadLine", messageViewIModel.getObject().getDeadLine());
        add(messageViewDeadLine);

        Label messageViewUpdatedate = new Label("updateDate", messageViewIModel.getObject().getUpdateDate());
        add(messageViewUpdatedate);

        Link<Void> toMessageViewListPage = new BookmarkablePageLink<>("toMessageViewListPage", MessageViewListPage.class);
        add(toMessageViewListPage);
    }

//    private MessageView messageView;
//
//    private int messageId;
//
//
//    public MessageViewDetail(){
//
//        this.messageView = iMessageViewService.selectOne(1);
//        System.out.println(messageView);
//    }

 //   IModel<MessageView> messageViewIModel = Model.of(iMessageViewService.selectOne(id));
//    IModel<MessageView> messageViewIModel = Model.of(iMessageViewService.selectOne(id));
}
