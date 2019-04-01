package dz.deepwork.gamemn02.presenceregister.data.sessions;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import dz.deepwork.gamemn02.presenceregister.data.TestData;
import dz.deepwork.gamemn02.presenceregister.data.members.Member;
import dz.deepwork.gamemn02.presenceregister.data.sessions.Session;

import static junit.framework.Assert.assertEquals;
import static org.bouncycastle.asn1.x500.style.RFC4519Style.member;
import static org.junit.Assert.assertNotEquals;

@RunWith(JUnit4.class)
public class SessionTest {


    @Test
    public void createSession() {
        //when
        Session session = new Session(TestData.SESSION1_BEGIN_TIME, TestData.SESSION1_END_TIME,
                TestData.SESSION1_MEMBER_ID, TestData.SESSION1_ROOM, TestData.SESSION1_DETAILS);

        //then
        assertEquals(session.beginTime, TestData.SESSION1_BEGIN_TIME);
        assertEquals(session.endTime, TestData.SESSION1_END_TIME);
        assertEquals(session.memberId, TestData.SESSION1_MEMBER_ID);
        assertEquals(session.room, TestData.SESSION1_ROOM);
        assertEquals(session.details, TestData.SESSION1_DETAILS);
    }

    @Test
    public void equals() {
        //when
        Session session = new Session(TestData.SESSION1_BEGIN_TIME, TestData.SESSION1_END_TIME,
                TestData.SESSION1_MEMBER_ID, TestData.SESSION1_ROOM, TestData.SESSION1_DETAILS);
        Session equalSession = new Session(TestData.SESSION1_BEGIN_TIME, TestData.SESSION1_END_TIME,
                TestData.SESSION1_MEMBER_ID, TestData.SESSION1_ROOM, TestData.SESSION1_DETAILS);
        Session notEqualSession = new Session(TestData.SESSION2_BEGIN_TIME, TestData.SESSION2_END_TIME,
                TestData.SESSION2_MEMBER_ID, TestData.SESSION2_ROOM, TestData.SESSION2_DETAILS);

        //then
        assertEquals(session, equalSession);
        assertNotEquals(session, notEqualSession);
        assertNotEquals(equalSession, notEqualSession);

    }
}
