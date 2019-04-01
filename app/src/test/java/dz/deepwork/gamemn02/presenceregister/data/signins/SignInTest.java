package dz.deepwork.gamemn02.presenceregister.data.signins;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import dz.deepwork.gamemn02.presenceregister.data.TestData;
import dz.deepwork.gamemn02.presenceregister.data.members.Member;
import dz.deepwork.gamemn02.presenceregister.data.signins.SignIn;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(JUnit4.class)
public class SignInTest {

    @Test
    public void createSignIn() {
        //when
        SignIn signIn = new SignIn(TestData.SIGN_IN_1_SESSION_ID, TestData.SIGN_IN_1_TIME, TestData.SIGN_IN_1_ROOM);

        //then
        assertEquals(signIn.sessionId, TestData.SIGN_IN_1_SESSION_ID);
        assertEquals(signIn.time, TestData.SIGN_IN_1_TIME);
        assertEquals(signIn.room, TestData.SIGN_IN_1_ROOM);
    }

    @Test
    public void equals() {
        //when
        SignIn signIn = new SignIn(TestData.SIGN_IN_1_SESSION_ID, TestData.SIGN_IN_1_TIME, TestData.SIGN_IN_1_ROOM);
        SignIn equalSignIn = new SignIn(TestData.SIGN_IN_1_SESSION_ID, TestData.SIGN_IN_1_TIME, TestData.SIGN_IN_1_ROOM);
        SignIn notEqualSignIn = new SignIn(TestData.SIGN_IN_2_SESSION_ID, TestData.SIGN_IN_2_TIME, TestData.SIGN_IN_2_ROOM);

        //then
        assertEquals(signIn, equalSignIn);
        assertNotEquals(signIn, notEqualSignIn);
        assertNotEquals(equalSignIn, notEqualSignIn);

    }
}
