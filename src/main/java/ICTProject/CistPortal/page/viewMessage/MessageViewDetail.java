package ICTProject.CistPortal.page.viewMessage;

import ICTProject.CistPortal.bean.MessageView;
import ICTProject.CistPortal.page.TemplatePage;
import ICTProject.CistPortal.service.IMessageViewService;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;
import org.apache.wicket.markup.html.basic.Label;


@AuthorizeInstantiation({"ADMIN" , "TEACHER" , "STUDENT"})
@MountPath("MessageViewDetail")
public class MessageViewDetail extends TemplatePage {

    @SpringBean
    private  IMessageViewService iMessageViewService;

    MessageViewDetail(){

    }

    MessageViewDetail(long id,String userId){
        super();
        int result = iMessageViewService.insertOne(id,userId);
        result = iMessageViewService.updateRead(id,userId);
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

    MessageViewDetail(long id){
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
}
