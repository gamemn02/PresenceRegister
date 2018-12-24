package dz.deepwork.gamemn02.presenceregister.data.members;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import dz.deepwork.gamemn02.presenceregister.data.TestData;
import dz.deepwork.gamemn02.presenceregister.data.members.Member;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(JUnit4.class)
public class MemberTest {

    @Test
    public void createMember() {
        //when
        Member member = new Member(TestData.MEMBER1_NAME, TestData.MEMBER1_PASS_NUMBER, TestData.MEMBER1_IS_ADMIN);

        //then
        assertEquals(member.name, TestData.MEMBER1_NAME);
        assertEquals(member.passNumber, TestData.MEMBER1_PASS_NUMBER);
        assertEquals(member.isAdmin, TestData.MEMBER1_IS_ADMIN);
    }

    @Test
    public void equals() {
        //when
        Member member = new Member(TestData.MEMBER1_NAME, TestData.MEMBER1_PASS_NUMBER, TestData.MEMBER1_IS_ADMIN);
        Member equalMember = new Member(TestData.MEMBER1_NAME, TestData.MEMBER1_PASS_NUMBER, TestData.MEMBER1_IS_ADMIN);
        Member NotEqualMember3 = new Member(TestData.MEMBER2_NAME, TestData.MEMBER2_PASS_NUMBER, TestData.MEMBER2_IS_ADMIN);
        member.uId = 1;
        equalMember.uId = 1;
        NotEqualMember3.uId = 2;

        //then
        assertEquals(member, equalMember);
        assertNotEquals(member, NotEqualMember3);
        assertNotEquals(equalMember, NotEqualMember3);

    }
}
