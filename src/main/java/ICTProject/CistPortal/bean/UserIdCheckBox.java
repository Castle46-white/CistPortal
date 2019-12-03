package ICTProject.CistPortal.bean;

import lombok.Data;
import org.apache.wicket.ajax.markup.html.form.AjaxCheckBox;

import java.io.Serializable;


//TODO beanとしてこれはありなのか？

@Data
public class UserIdCheckBox implements Serializable {

    private String id;
    private AjaxCheckBox checkBox;

}
