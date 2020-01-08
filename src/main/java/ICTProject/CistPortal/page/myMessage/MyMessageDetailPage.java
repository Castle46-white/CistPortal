package ICTProject.CistPortal.page.myMessage;


import ICTProject.CistPortal.bean.MessageView;
import ICTProject.CistPortal.page.TemplatePage;
import ICTProject.CistPortal.page.editMessage.MessageEditPage;
import ICTProject.CistPortal.page.viewMessage.MessageViewListPage;
import ICTProject.CistPortal.service.IMessageViewService;
import ICTProject.CistPortal.service.IMyMessageService;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

@AuthorizeInstantiation({"ADMIN" , "TEACHER" , "STUDENT"})
@MountPath("MyMessageDetail")
public class MyMessageDetailPage extends TemplatePage {

    @SpringBean
    IMyMessageService myMessageService;


    @SpringBean
    private IMessageViewService iMessageViewService;


    MyMessageDetailPage(long id){
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


        add(new Link<>("deleteMessageLink") {
            @Override
            public void onClick() {
                myMessageService.deleteMessage(id);
                setResponsePage(new MessageDeleteCompPage());
            }
        });

        add(new Link<>("editMessageLink") {
            @Override
            public void onClick() {
                setResponsePage(new MessageEditPage(id));
            }
        });

    }


}
