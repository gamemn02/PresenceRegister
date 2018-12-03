package dz.deepwork.gamemn02.presenceregister.data;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import dz.deepwork.gamemn02.presenceregister.data.members.Member;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(JUnit4.class)
public class MemberTest {

    private static final String TEST_MEMBER1_NAME = "name";
    private static final String TEST_MEMBER1_PASS_NUMBER = "123456";
    private static final boolean TEST_MEMBER1_IS_ADMIN = false;
    private static final String TEST_MEMBER2_NAME = "name";
    private static final String TEST_MEMBER2_PASS_NUMBER = "123456";
    private static final boolean TEST_MEMBER2_IS_ADMIN = false;
    private static final String TEST_MEMBER3_NAME = "name3";
    private static final String TEST_MEMBER3_PASS_NUMBER = "654321";
    private static final boolean TEST_MEMBER3_IS_ADMIN = true;

    @Test
    public void createMember() {
        //when
        Member member = new Member(TEST_MEMBER1_NAME, TEST_MEMBER1_PASS_NUMBER, TEST_MEMBER1_IS_ADMIN);

        //then
        assertEquals(member.name, TEST_MEMBER1_NAME);
        assertEquals(member.passNumber, TEST_MEMBER1_PASS_NUMBER);
        assertEquals(member.isAdmin, TEST_MEMBER1_IS_ADMIN);
    }

    @Test
    public void equals() {
        //when
        Member member = new Member(TEST_MEMBER1_NAME, TEST_MEMBER1_PASS_NUMBER, TEST_MEMBER1_IS_ADMIN);
        Member member2 = new Member(TEST_MEMBER2_NAME, TEST_MEMBER2_PASS_NUMBER, TEST_MEMBER2_IS_ADMIN);
        Member member3 = new Member(TEST_MEMBER3_NAME, TEST_MEMBER3_PASS_NUMBER, TEST_MEMBER3_IS_ADMIN);
        member.uId = 1;
        member2.uId = 1;
        member3.uId = 2;

        //then
        assertEquals(member, member2);
        assertNotEquals(member, member3);
        assertNotEquals(member2, member3);

    }
}
