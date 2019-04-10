package dz.deepwork.gamemn02.presenceregister.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FormatUtil {

    static public String calendarToString(Calendar calendar) {
        return new SimpleDateFormat("hh:mm   dd-MM-yyyy").format(calendar.getTime());
    }

    public static String roomToString(String room) {
        return "in room " + room;
    }

    public static String intervalToString(String start, String end) {
        return "from " + start + " to " + end;
    }
}
