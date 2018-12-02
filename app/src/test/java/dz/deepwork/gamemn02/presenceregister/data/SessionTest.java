package dz.deepwork.gamemn02.presenceregister.data;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import dz.deepwork.gamemn02.presenceregister.data.members.Member;
import dz.deepwork.gamemn02.presenceregister.data.sessions.Session;

import static junit.framework.Assert.assertEquals;
import static org.bouncycastle.asn1.x500.style.RFC4519Style.member;
import static org.junit.Assert.assertNotEquals;

@RunWith(JUnit4.class)
public class SessionTest {

    private static final int TEST_SESSION1_BEGIN_TIME = 0;
    private static final int TEST_SESSION1_END_TIME = 2;
    private static final int TEST_SESSION1_MEMBER_ID = 0;
    private static final String TEST_SESSION1_ROOM = "B007";
    private static final String TEST_SESSION1_DETAILS = "Recitation E415";
    private static final int TEST_SESSION2_BEGIN_TIME = 0;
    private static final int TEST_SESSION2_END_TIME = 2;
    private static final int TEST_SESSION2_MEMBER_ID = 0;
    private static final String TEST_SESSION2_ROOM = "B007";
    private static final String TEST_SESSION2_DETAILS = "Recitation E415";
    private static final int TEST_SESSION3_BEGIN_TIME = 0;
    private static final int TEST_SESSION3_END_TIME = 2;
    private static final int TEST_SESSION3_MEMBER_ID = 0;
    private static final String TEST_SESSION3_ROOM = "C101";
    private static final String TEST_SESSION3_DETAILS = "Recitation E411";

    @Test
    public void createSession() {
        //when
        Session session = new Session(TEST_SESSION1_BEGIN_TIME, TEST_SESSION1_END_TIME,
                TEST_SESSION1_MEMBER_ID, TEST_SESSION1_ROOM, TEST_SESSION1_DETAILS);

        //then
        assertEquals(session.beginTime, TEST_SESSION1_BEGIN_TIME);
        assertEquals(session.endTime, TEST_SESSION1_END_TIME);
        assertEquals(session.memberId, TEST_SESSION1_MEMBER_ID);
        assertEquals(session.room, TEST_SESSION1_ROOM);
        assertEquals(session.details, TEST_SESSION1_DETAILS);
    }

    @Test
    public void equals() {
        //when
        Session session = new Session(TEST_SESSION1_BEGIN_TIME, TEST_SESSION1_END_TIME,
                TEST_SESSION1_MEMBER_ID, TEST_SESSION1_ROOM, TEST_SESSION1_DETAILS);
        Session session2 = new Session(TEST_SESSION2_BEGIN_TIME, TEST_SESSION2_END_TIME,
                TEST_SESSION2_MEMBER_ID, TEST_SESSION2_ROOM, TEST_SESSION2_DETAILS);
        Session session3 = new Session(TEST_SESSION3_BEGIN_TIME, TEST_SESSION3_END_TIME,
                TEST_SESSION3_MEMBER_ID, TEST_SESSION3_ROOM, TEST_SESSION3_DETAILS);
        session.uId = 1;
        session2.uId = 1;
        session3.uId = 2;

        //then
        assertEquals(session, session2);
        assertNotEquals(session, session3);
        assertNotEquals(session2, session3);

    }
}
