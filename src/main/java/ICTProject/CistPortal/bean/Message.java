package ICTProject.CistPortal.bean;


import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Setter
@Getter
public class Message {
    private long id;
    private String title;
    private String contents;
    private Timestamp deadline;

}
