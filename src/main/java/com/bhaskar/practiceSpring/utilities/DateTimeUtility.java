package com.bhaskar.practiceSpring.utilities;
import java.text.*;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtility {

    public static String generateDateTimeId() {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(date);
        return strDate;
    }
}
