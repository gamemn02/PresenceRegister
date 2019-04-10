package dz.deepwork.gamemn02.presenceregister.data.sessions;

import android.arch.persistence.room.TypeConverter;

import java.util.Calendar;

public class SessionTime {

    private static final int SESSIONS_PER_DAY = 6;
    private static final int STARTING_MINUTE = 8 * 60 - 10;
    private static final int MINUTES_PER_HOUR = 60;
    private static final int MINUTES_PER_SESSION = 100;

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
        int day = sessionNumber / SESSIONS_PER_DAY;
        int hourNumber = sessionNumber - (day * SESSIONS_PER_DAY);
        return new SessionTime(hourNumber, day);
    }

    public static SessionTime fromCalendar(Calendar calendar) {
        int h = calendar.get(Calendar.HOUR_OF_DAY);
        int m = calendar.get(Calendar.MINUTE);
        int totalMinutes = (h * MINUTES_PER_HOUR) + m;
        int hourNumber = (totalMinutes - STARTING_MINUTE) / MINUTES_PER_SESSION;
        if(totalMinutes - STARTING_MINUTE < 0) hourNumber--;
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        return new SessionTime(hourNumber, day);
    }

     public String startToString() {
        int startMinutes = mHourNumber * MINUTES_PER_SESSION + STARTING_MINUTE;
        int hStart = startMinutes / MINUTES_PER_HOUR;
        int mStart = startMinutes - hStart * MINUTES_PER_HOUR;
        return hStart + ":" + mStart;
    }

     public String endToString(int size) {
        int startMinutes = mHourNumber * MINUTES_PER_SESSION + STARTING_MINUTE;
        int endMinutes = startMinutes + size * MINUTES_PER_SESSION;
        int hEnd = endMinutes / MINUTES_PER_HOUR;
        int mEnd = endMinutes - hEnd * MINUTES_PER_HOUR;
        return hEnd + ":" + mEnd;
    }
}
