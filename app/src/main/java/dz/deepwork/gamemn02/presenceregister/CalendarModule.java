package dz.deepwork.gamemn02.presenceregister;

import java.util.Calendar;
import java.util.TimeZone;

import dagger.Module;
import dagger.Provides;

@Module
public class CalendarModule {

    @Provides
    public Calendar provideCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getDefault());
        return calendar;
    }
}
