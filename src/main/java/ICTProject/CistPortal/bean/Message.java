package ICTProject.CistPortal.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
public class Message implements Serializable {
    private long id;
    private String title;
    private String contents;
    private Timestamp deadline;

    public Message(String title, String contents, Timestamp deadline) {
        this.title = title;
        this.contents = contents;
        this.deadline = deadline;
    }
}
