package dz.deepwork.gamemn02.presenceregister.data.signs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import dz.deepwork.gamemn02.presenceregister.data.TestData;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(JUnit4.class)
public class SignTest {

    @Test
    public void createSign() {
        //when
        Sign sign = new Sign(TestData.SIGN_1_MEMBER_NAME, TestData.SIGN_1_SIGN_IN_TIME,
                TestData.SIGN_1_SIGN_OUT_TIME, TestData.SIGN_1_ROOM, TestData.SIGN_1_DETAILS);

        //then
        assertEquals(sign.memberName, TestData.SIGN_1_MEMBER_NAME);
        assertEquals(sign.signInTime, TestData.SIGN_1_SIGN_IN_TIME);
        assertEquals(sign.signOutTime, TestData.SIGN_1_SIGN_OUT_TIME);
        assertEquals(sign.room, TestData.SIGN_1_ROOM);
        assertEquals(sign.details, TestData.SIGN_1_DETAILS);
    }

    @Test
    public void equals() {
        //when
        Sign sign = new Sign(TestData.SIGN_1_MEMBER_NAME, TestData.SIGN_1_SIGN_IN_TIME,
                TestData.SIGN_1_SIGN_OUT_TIME, TestData.SIGN_1_ROOM, TestData.SIGN_1_DETAILS);
        Sign equalSign = new Sign(TestData.SIGN_1_MEMBER_NAME, TestData.SIGN_1_SIGN_IN_TIME,
                TestData.SIGN_1_SIGN_OUT_TIME, TestData.SIGN_1_ROOM, TestData.SIGN_1_DETAILS);
        Sign notEqualSign = new Sign(TestData.SIGN_2_MEMBER_NAME, TestData.SIGN_2_SIGN_IN_TIME,
                TestData.SIGN_2_SIGN_OUT_TIME, TestData.SIGN_2_ROOM, TestData.SIGN_2_DETAILS);

        //then
        assertEquals(sign, equalSign);
        assertNotEquals(sign, notEqualSign);
        assertNotEquals(equalSign, notEqualSign);

    }
}
