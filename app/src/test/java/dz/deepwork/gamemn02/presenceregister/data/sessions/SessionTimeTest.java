package dz.deepwork.gamemn02.presenceregister.data.sessions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import dz.deepwork.gamemn02.presenceregister.data.TestData;

import static junit.framework.Assert.assertEquals;


@RunWith(JUnit4.class)
public class SessionTimeTest {

    @Test
    public void testToSessionNumberMethod() {
        // when
        int actualSessionNumber1 = SessionTime.toSessionNumber(TestData.SESSION_TIME1);
        int expectedSessionNumber1 = TestData.SESSION_TIME1_SESSION_NUMBER;
        int actualSessionNumber2 = SessionTime.toSessionNumber(TestData.SESSION_TIME2);
        int expectedSessionNumber2 = TestData.SESSION_TIME2_SESSION_NUMBER;

        // then
        assertEquals(expectedSessionNumber1, actualSessionNumber1);
        assertEquals(expectedSessionNumber2, actualSessionNumber2);
    }

    @Test
    public void testToSessionTimeMethod() {
        // when
        SessionTime actualSessionTime1 = SessionTime.toSessionTime(TestData.SESSION_TIME1_SESSION_NUMBER);
        SessionTime expectedSessionTime1 = TestData.SESSION_TIME1;
        SessionTime actualSessionTime2 = SessionTime.toSessionTime(TestData.SESSION_TIME2_SESSION_NUMBER);
        SessionTime expectedSessionTime2 = TestData.SESSION_TIME2;

        // then
        assertEquals(expectedSessionTime1, actualSessionTime1);
        assertEquals(expectedSessionTime2, actualSessionTime2);
    }

}
