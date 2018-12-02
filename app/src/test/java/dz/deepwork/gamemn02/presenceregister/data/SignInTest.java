package dz.deepwork.gamemn02.presenceregister.data;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import dz.deepwork.gamemn02.presenceregister.data.members.Member;
import dz.deepwork.gamemn02.presenceregister.data.signins.SignIn;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(JUnit4.class)
public class SignInTest {

    private static final int TEST_SIGN_IN_1_SESSION_ID = 0;
    private static final long TEST_SIGN_IN_1_TIME = 1;
    private static final String TEST_SIGN_IN_1_ROOM = "B007";
    private static final int TEST_SIGN_IN_2_SESSION_ID = 0;
    private static final long TEST_SIGN_IN_2_TIME = 1;
    private static final String TEST_SIGN_IN_2_ROOM = "B007";
    private static final int TEST_SIGN_IN_3_SESSION_ID = 1;
    private static final long TEST_SIGN_IN_3_TIME = 0;
    private static final String TEST_SIGN_IN_3_ROOM = "C101";

    @Test
    public void createSignIn() {
        //when
        SignIn signIn = new SignIn(TEST_SIGN_IN_1_SESSION_ID, TEST_SIGN_IN_1_TIME, TEST_SIGN_IN_1_ROOM);

        //then
        assertEquals(signIn.sessionId, TEST_SIGN_IN_1_SESSION_ID);
        assertEquals(signIn.time, TEST_SIGN_IN_1_TIME);
        assertEquals(signIn.room, TEST_SIGN_IN_1_ROOM);
    }

    @Test
    public void equals() {
        //when
        SignIn signIn = new SignIn(TEST_SIGN_IN_1_SESSION_ID, TEST_SIGN_IN_1_TIME, TEST_SIGN_IN_1_ROOM);
        SignIn signIn2 = new SignIn(TEST_SIGN_IN_2_SESSION_ID, TEST_SIGN_IN_2_TIME, TEST_SIGN_IN_2_ROOM);
        SignIn signIn3 = new SignIn(TEST_SIGN_IN_3_SESSION_ID, TEST_SIGN_IN_3_TIME, TEST_SIGN_IN_3_ROOM);
        signIn.uId = 1;
        signIn2.uId = 1;
        signIn3.uId = 2;

        //then
        assertEquals(signIn, signIn2);
        assertNotEquals(signIn, signIn3);
        assertNotEquals(signIn2, signIn3);

    }
}
