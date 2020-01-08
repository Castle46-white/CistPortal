package ICTProject.CistPortal.bean;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class MessageEdit implements Serializable {
    private long id;
    private String title;
    private String contents;
    private Timestamp deadLine;
    private Timestamp updateDate;
    private String userId;
}
