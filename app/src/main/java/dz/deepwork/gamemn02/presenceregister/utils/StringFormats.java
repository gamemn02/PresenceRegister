package dz.deepwork.gamemn02.presenceregister.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class StringFormats {

    static public String composeName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    static public String calendarToString(Calendar calendar) {
        return new SimpleDateFormat("hh:mm   dd-mm-yyyy").format(calendar.getTime());
    }
}
