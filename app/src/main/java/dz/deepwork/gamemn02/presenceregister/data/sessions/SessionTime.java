package dz.deepwork.gamemn02.presenceregister.data.sessions;

import android.arch.persistence.room.TypeConverter;

import java.util.Calendar;
import java.util.TimeZone;

public class SessionTime {

    public static final int SESSIONS_PER_DAY = 6;
    public static final int DAYS_PER_WEEK = 6;
    public static final int STARTING_MINUTE = 8 * 60 - 10;
    private static final int MINUTES_IN_HOUR = 60;

    private int mHourNumber;
    private int mDay;

    public SessionTime(int hourNumber, int day) {
        mHourNumber = hourNumber;
        mDay = day;
    }

    public int getHourNumber() {
        return mHourNumber;
    }

    public int getDay() {
        return mDay;
    }

    @Override
    public boolean equals(Object obj) {
        SessionTime sessionTime = (SessionTime) obj;
        return mDay == sessionTime.getDay() &&
                mHourNumber == sessionTime.getHourNumber();
    }

    @TypeConverter
    public static int toSessionNumber(SessionTime sessionTime) {
        return sessionTime.getDay() * SESSIONS_PER_DAY + sessionTime.getHourNumber();
    }

    @TypeConverter
    public static SessionTime toSessionTime(int sessionNumber) {
        int day = sessionNumber / DAYS_PER_WEEK;
        int hourNumber = sessionNumber - (day * SESSIONS_PER_DAY);
        return new SessionTime(hourNumber, day);
    }

    public static SessionTime getCurrentSessionTime(Calendar calendar) {
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int totalMinutes = (hour * MINUTES_IN_HOUR) + minute;
        int hourNumber = (totalMinutes - STARTING_MINUTE) / 100;
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        return new SessionTime(hourNumber, day);
    }

}
