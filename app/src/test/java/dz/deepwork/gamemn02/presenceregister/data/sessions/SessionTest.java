package dz.deepwork.gamemn02.presenceregister.data.sessions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import dz.deepwork.gamemn02.presenceregister.data.TestData;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(JUnit4.class)
public class SessionTest {


    @Test
    public void createSession() {
        //when
        Session session = new Session(TestData.SESSION1_TIME, TestData.SESSION1_SIZE,
                TestData.SESSION1_MEMBER_PASS_NUMBER, TestData.SESSION1_ROOM, TestData.SESSION1_DETAILS);

        //then
        assertEquals(session.time, TestData.SESSION1_TIME);
        assertEquals(session.size, TestData.SESSION1_SIZE);
        assertEquals(session.memberPassNumber, TestData.SESSION1_MEMBER_PASS_NUMBER);
        assertEquals(session.room, TestData.SESSION1_ROOM);
        assertEquals(session.details, TestData.SESSION1_DETAILS);
    }

    @Test
    public void equals() {
        //when
        Session session = new Session(TestData.SESSION1_TIME, TestData.SESSION1_SIZE,
                TestData.SESSION1_MEMBER_PASS_NUMBER, TestData.SESSION1_ROOM, TestData.SESSION1_DETAILS);
        Session equalSession = new Session(TestData.SESSION1_TIME, TestData.SESSION1_SIZE,
                TestData.SESSION1_MEMBER_PASS_NUMBER, TestData.SESSION1_ROOM, TestData.SESSION1_DETAILS);
        Session notEqualSession = new Session(TestData.SESSION2_TIME, TestData.SESSION2_SIZE,
                TestData.SESSION2_MEMBER_PASS_NUMBER, TestData.SESSION2_ROOM, TestData.SESSION2_DETAILS);

        //then
        assertEquals(session, equalSession);
        assertNotEquals(session, notEqualSession);
        assertNotEquals(equalSession, notEqualSession);

    }
}
