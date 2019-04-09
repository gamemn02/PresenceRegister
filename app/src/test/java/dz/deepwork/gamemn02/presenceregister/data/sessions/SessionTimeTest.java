package dz.deepwork.gamemn02.presenceregister.data.sessions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Calendar;

import dz.deepwork.gamemn02.presenceregister.data.TestData;

import static junit.framework.Assert.assertEquals;


@RunWith(JUnit4.class)
public class SessionTimeTest {

    @Test
    public void testToSessionNumberMethod() {
        // when
        int actualSessionNumber1 = SessionTime.toSessionNumber(TestData.SESSION1_TIME);
        int expectedSessionNumber1 = TestData.SESSION1_TIME_SESSION_NUMBER;
        int actualSessionNumber2 = SessionTime.toSessionNumber(TestData.SESSION2_TIME);
        int expectedSessionNumber2 = TestData.SESSION2_TIME_SESSION_NUMBER;

        // then
        assertEquals(expectedSessionNumber1, actualSessionNumber1);
        assertEquals(expectedSessionNumber2, actualSessionNumber2);
    }

    @Test
    public void testToSessionTimeMethod() {
        // when
        SessionTime actualSessionTime1 = SessionTime.toSessionTime(TestData.SESSION1_TIME_SESSION_NUMBER);
        SessionTime expectedSessionTime1 = TestData.SESSION1_TIME;
        SessionTime actualSessionTime2 = SessionTime.toSessionTime(TestData.SESSION2_TIME_SESSION_NUMBER);
        SessionTime expectedSessionTime2 = TestData.SESSION2_TIME;

        // then
        assertEquals(expectedSessionTime1, actualSessionTime1);
        assertEquals(expectedSessionTime2, actualSessionTime2);
    }

    @Test
    public void testFromCalendarMethod() {
        //when
        Calendar calendar1 = new Calendar.Builder()
                .setWeekDate(0, 0, Calendar.SUNDAY)
                .setTimeOfDay(12, 49, 0)
                .build();
        Calendar calendar2 = new Calendar.Builder()
                .setWeekDate(0, 0, Calendar.SATURDAY)
                .setTimeOfDay(12, 50, 0)
                .build();
        SessionTime sessionTime1 = SessionTime.fromCalendar(calendar1);
        SessionTime sessionTime2 = SessionTime.fromCalendar(calendar2);

        //then
        assertEquals(sessionTime1.getDay(), Calendar.SUNDAY);
        assertEquals(sessionTime2.getDay(), Calendar.SATURDAY);
        assertEquals(sessionTime1.getHourNumber(), 2);
        assertEquals(sessionTime2.getHourNumber(), 3);
        // TODO: use TestData to store constants
    }

    @Test
    public void testToIntervalStringMethod() {
        //when
        SessionTime sessionTime = TestData.INTERVAL_SESSION_TIME;
        String actualString = SessionTime.toIntervalString(sessionTime, TestData.INTERVAL_SIZE);
        String expectedString = TestData.INTERVAL_STRING;

        //then
        assertEquals(expectedString, actualString);
    }
}
