package ICTProject.CistPortal.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.wicketstuff.annotation.mount.MountPath;
import org.wicketstuff.datetime.StyleDateConverter;
import org.wicketstuff.datetime.extensions.yui.calendar.DatePicker;
import org.wicketstuff.datetime.markup.html.form.DateTextField;

import java.text.SimpleDateFormat;
import java.util.Date;

@MountPath("MessageCreate")
public class MessageCreatePage extends WebPage {

    public MessageCreatePage() {

        IModel<String> messageTitleModel = Model.of("");
        IModel<String> messageContentsModel = Model.of("");
        IModel<Date> deadlineModel = new Model<Date>(new Date());


        Form<Void> messageForm = new Form<>("messageForm") {
            @Override
            public void onSubmit() {
                String messageTitile = messageTitleModel.getObject();
                String messageContents = messageContentsModel.getObject();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date deadline = deadlineModel.getObject();

//                setResponsePage(new );
            }
        };


        //タイトルフィールド
        TextField<String> messageTitleField = new TextField<>("messageTitle",messageTitleModel);
        messageTitleField.setRequired(true);
        messageForm.add(messageTitleField);

        //内容フィールド
        TextArea<String> messageContentsField = new TextArea<>("messageContents",messageContentsModel);
        messageContentsField.setRequired(true);
        messageForm.add(messageContentsField);

        //掲示期限フィールド
        DateTextField deadlineField = new DateTextField("deadline",deadlineModel,new StyleDateConverter("M-", true));
        deadlineField.setRequired(true);
        messageForm.add(deadlineField);
        deadlineField.add(new DatePicker());



    }
}
