package ICTProject.CistPortal.page.createMessage;

import ICTProject.CistPortal.bean.Message;
import ICTProject.CistPortal.page.TemplatePage;
import ICTProject.CistPortal.service.IDateTimeFormatService;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.validation.validator.StringValidator;
import org.wicketstuff.annotation.mount.MountPath;
import org.wicketstuff.datetime.StyleDateConverter;
import org.wicketstuff.datetime.extensions.yui.calendar.DatePicker;
import org.wicketstuff.datetime.markup.html.form.DateTextField;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@AuthorizeInstantiation({"ADMIN" , "TEACHER" , "STUDENT"})
@MountPath("MessageCreate")
public class MessageCreatePage extends TemplatePage {

    @SpringBean
    private IDateTimeFormatService dateTimeFormatService;

    public MessageCreatePage() {
        super();



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

                deadlineModel.setObject(deadline);

                IModel<Message> messageModel = Model.of(new Message(messageTitleModel.getObject(),
                        messageContentsModel.getObject(),
                        Timestamp.valueOf(deadline.toString())));

                if(!deadline.after(new Date())) {
                    System.out.println(new Date());
                    error("現在時刻以降の日時を設定してください。");
                    return;
                }

                setResponsePage(new ChooseTargetPage(messageModel));
            }
        };
        add(messageForm);


        //タイトルフィールド
        TextField<String> messageTitleField = new TextField<>("messageTitle",messageTitleModel) {
            @Override
            protected void onInitialize() {
                super.onInitialize();
                var validator = StringValidator.lengthBetween(1,64);
                add(validator);
            }
        };
        messageTitleField.setRequired(true);
        messageForm.add(messageTitleField);

        //内容フィールド
        TextArea<String> messageContentsField = new TextArea<>("messageContents",messageContentsModel) {
            @Override
            protected void onInitialize() {
                super.onInitialize();
                var validator = StringValidator.lengthBetween(1,2000);
                add(validator);
            }
        };
        messageContentsField.setRequired(true);
        messageForm.add(messageContentsField);

        //掲示期限フィールド
        //日付
        //TODO datePickerのアイコン変更されない問題
        DateTextField deadlineField = new DateTextField("deadline",deadlineModel,new StyleDateConverter("M-", true));
        deadlineField.setRequired(true);
        messageForm.add(deadlineField);
        deadlineField.add(new DatePicker(){
//            @Override
//            protected CharSequence getIconUrl() {
//                return "../img/datePicker_icon.png";
//            }
        });


        //TODO Listにベタ書きは直したい

        //時
        List<Integer> hourList = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23);
        DropDownChoice<Integer> hourChoice = new DropDownChoice<>("hourChoice",hourModel,hourList);
        hourChoice.setRequired(true);
        messageForm.add(hourChoice);


        //分
        List<Integer> minuteList = Arrays.asList(00,15,30,45);
        DropDownChoice<Integer> minuteChoice = new DropDownChoice<>("minuteChoice",minuteModel,minuteList);
        minuteChoice.setRequired(true);
        messageForm.add(minuteChoice);

        var fbMsgPanel = new FeedbackPanel("fbMsg");
        messageForm.add(fbMsgPanel);


    }
}
