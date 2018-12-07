package dz.deepwork.gamemn02.presenceregister.data.members;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import dz.deepwork.gamemn02.presenceregister.data.members.Member;
import dz.deepwork.gamemn02.presenceregister.data.members.MemberDao;
import dz.deepwork.gamemn02.presenceregister.data.members.RealMembersRepo;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(JUnit4.class)
public class RealMembersRepoTest {


    private static final String TEST_PASS_NUMBER = "123456";
    public static final Member TEST_MEMBER = new Member("name1", "123456", true);
    private RealMembersRepo realMembersRepo;
    private MemberDao memberDao;

    @Before
    public void beforeTest() {
        memberDao = mock(MemberDao.class);
        realMembersRepo = new RealMembersRepo(memberDao);
    }

    @Test
    public void addMemberCallsMemberDaoInsert() {

        //when
        realMembersRepo.addMember(TEST_MEMBER);

        //then
        verify(memberDao).insert(TEST_MEMBER);
    }

    @Test
    public void findMemberCallsMemberDaoFind() {

        //when
        realMembersRepo.findMember(TEST_PASS_NUMBER);

        //then
        verify(memberDao).find(TEST_PASS_NUMBER);
    }
}
