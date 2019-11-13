package ICTProject.CistPortal.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class MessageView implements Serializable {
    private int id;
    private String title;
    private String contents;
    private LocalDateTime deadLine;
    private LocalDateTime updateDate;
    private String userId;


}
