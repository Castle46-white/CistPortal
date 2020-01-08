package ICTProject.CistPortal.bean;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class MessageView implements Serializable {
    private long id;
    private String title;
    private String contents;
    private LocalDateTime deadLine;
    private LocalDateTime updateDate;
    private String userId;

}
