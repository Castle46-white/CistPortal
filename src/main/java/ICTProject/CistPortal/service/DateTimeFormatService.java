package ICTProject.CistPortal.service;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DateTimeFormatService implements IDateTimeFormatService{

    public Timestamp format(Date date, int hour, int minute) {

        Timestamp parsedDateTime;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy'-'MM'-'dd' 'HH':'mm':'ss");

        String dateTime = dateFormat.format(date)
                + " "
                + hour
                + ":"
                + minute
                + ":00";

        parsedDateTime = Timestamp.valueOf(dateTime);

        return parsedDateTime;

    }
}
