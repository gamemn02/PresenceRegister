package dz.deepwork.gamemn02.presenceregister.utils;

import java.util.Calendar;
import java.util.TimeZone;

public class DateUtils {
    public static Calendar getCurrentCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getDefault());
        return calendar;
    }
}
