package ICTProject.CistPortal.service;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DateTimeFormatService implements IDateTimeFormatService{

    public Date format(Date date,int hour,int minute) {

        Date parsedDateTime = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        String dateTime = dateFormat.format(date)
                + " "
                + hour
                + ":"
                + minute;

        try {
             parsedDateTime = dateTimeFormat.parse(dateTime);
            return parsedDateTime;
        } catch (ParseException e) {
            e.printStackTrace();
            return parsedDateTime;
        }


    }
}
