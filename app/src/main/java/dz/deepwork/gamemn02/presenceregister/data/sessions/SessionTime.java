package dz.deepwork.gamemn02.presenceregister.data.sessions;

import android.arch.persistence.room.TypeConverter;

import java.util.Calendar;

public class SessionTime {

    public static final int SESSIONS_PER_DAY = 6;
    public static final int DAYS_PER_WEEK = 6;

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


}
