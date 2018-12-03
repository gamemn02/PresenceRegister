package dz.deepwork.gamemn02.presenceregister.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import dz.deepwork.gamemn02.presenceregister.data.signins.SignIn;
import dz.deepwork.gamemn02.presenceregister.data.signs.Sign;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(JUnit4.class)
public class SignTest {

    private static final String TEST_SIGN_1_MEMBER_NAME = "name1";
    private static final int TEST_SIGN_1_SIGN_IN_TIME = 1;
    private static final int TEST_SIGN_1_SIGN_OUT_TIME = 2;
    private static final String TEST_SIGN_1_ROOM = "B007";
    private static final String TEST_SIGN_1_DETAILS = "Rec E115";

    private static final String TEST_SIGN_2_MEMBER_NAME = "name1";
    private static final int TEST_SIGN_2_SIGN_IN_TIME = 1;
    private static final int TEST_SIGN_2_SIGN_OUT_TIME = 2;
    private static final String TEST_SIGN_2_ROOM = "B007";
    private static final String TEST_SIGN_2_DETAILS = "Rec E115";

    private static final String TEST_SIGN_3_MEMBER_NAME = "name3";
    private static final int TEST_SIGN_3_SIGN_IN_TIME = 0;
    private static final int TEST_SIGN_3_SIGN_OUT_TIME = 4;
    private static final String TEST_SIGN_3_ROOM = "C101";
    private static final String TEST_SIGN_3_DETAILS = "Rec E215";

    @Test
    public void createSign() {
        //when
        Sign sign = new Sign(TEST_SIGN_1_MEMBER_NAME, TEST_SIGN_1_SIGN_IN_TIME,
                TEST_SIGN_1_SIGN_OUT_TIME, TEST_SIGN_1_ROOM, TEST_SIGN_1_DETAILS);

        //then
        assertEquals(sign.memberName, TEST_SIGN_1_MEMBER_NAME);
        assertEquals(sign.signInTime, TEST_SIGN_1_SIGN_IN_TIME);
        assertEquals(sign.signOutTime, TEST_SIGN_1_SIGN_OUT_TIME);
        assertEquals(sign.room, TEST_SIGN_1_ROOM);
        assertEquals(sign.details, TEST_SIGN_1_DETAILS);
    }

    @Test
    public void equals() {
        //when
        Sign sign = new Sign(TEST_SIGN_1_MEMBER_NAME, TEST_SIGN_1_SIGN_IN_TIME,
                TEST_SIGN_1_SIGN_OUT_TIME, TEST_SIGN_1_ROOM, TEST_SIGN_1_DETAILS);
        Sign sign2 = new Sign(TEST_SIGN_2_MEMBER_NAME, TEST_SIGN_2_SIGN_IN_TIME,
                TEST_SIGN_2_SIGN_OUT_TIME, TEST_SIGN_2_ROOM, TEST_SIGN_2_DETAILS);
        Sign sign3 = new Sign(TEST_SIGN_3_MEMBER_NAME, TEST_SIGN_3_SIGN_IN_TIME,
                TEST_SIGN_3_SIGN_OUT_TIME, TEST_SIGN_3_ROOM, TEST_SIGN_3_DETAILS);
        sign.uId = 1;
        sign2.uId = 1;
        sign3.uId = 2;

        //then
        assertEquals(sign, sign2);
        assertNotEquals(sign, sign3);
        assertNotEquals(sign2, sign3);

    }
}
