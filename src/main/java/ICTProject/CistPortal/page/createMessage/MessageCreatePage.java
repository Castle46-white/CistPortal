package ICTProject.CistPortal.page.createMessage;

import ICTProject.CistPortal.bean.Message;
import ICTProject.CistPortal.service.IDateTimeFormatService;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;
import org.wicketstuff.datetime.StyleDateConverter;
import org.wicketstuff.datetime.extensions.yui.calendar.DatePicker;
import org.wicketstuff.datetime.markup.html.form.DateTextField;


import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@MountPath("MessageCreate")
public class MessageCreatePage extends WebPage {

    @SpringBean
    private IDateTimeFormatService dateTimeFormatService;

    public MessageCreatePage() {

        //TODO バリデーションの追加

        IModel<String> messageTitleModel = Model.of("");
        IModel<String> messageContentsModel = Model.of("");
        IModel<Date> deadlineModel = new Model<Date>(new Date());
        IModel<Integer> hourModel = Model.of();
        IModel<Integer> minuteModel = Model.of();
        ;

        Form<Void> messageForm = new Form<>("massageForm") {
            @Override
            public void onSubmit() {
                Date deadline = dateTimeFormatService.format(deadlineModel.getObject(),
                        hourModel.getObject(),
                        minuteModel.getObject());

                System.out.println(deadline);

                deadlineModel.setObject(deadline);

                IModel<Message> messageModel = Model.of(new Message(messageTitleModel.getObject(),
                        messageContentsModel.getObject(),
                        Timestamp.valueOf(deadline.toString())));

                setResponsePage(new ChooseTargetPage(messageModel));
            }
        };
        add(messageForm);


        //タイトルフィールド
        TextField<String> messageTitleField = new TextField<>("messageTitle",messageTitleModel);
        messageTitleField.setRequired(true);
        messageForm.add(messageTitleField);

        //内容フィールド
        TextArea<String> messageContentsField = new TextArea<>("messageContents",messageContentsModel);
        messageContentsField.setRequired(true);
        messageForm.add(messageContentsField);

        //掲示期限フィールド
        //日付
        DateTextField deadlineField = new DateTextField("deadline",deadlineModel,new StyleDateConverter("M-", true));
        deadlineField.setRequired(true);
        messageForm.add(deadlineField);
        deadlineField.add(new DatePicker());


        //TODO Listにベタ書きは直したい

        //時
        List<Integer> hourList = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23);
        DropDownChoice<Integer> hourChoice = new DropDownChoice<>("hourChoice",hourModel,hourList);
        messageForm.add(hourChoice);


        //分
        List<Integer> minuteList = Arrays.asList(00,15,30,45);
        DropDownChoice<Integer> minuteChoice = new DropDownChoice<>("minuteChoice",minuteModel,minuteList);
        messageForm.add(minuteChoice);


    }
}
