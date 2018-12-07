package dz.deepwork.gamemn02.presenceregister.data;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import dz.deepwork.gamemn02.presenceregister.data.members.MemberDao;
import dz.deepwork.gamemn02.presenceregister.data.members.RealMembersRepo;

@RunWith(JUnit4.class)
public class RealMembersRepoTest {


    private static final String TEST_PASS_NUMBER = "123456";
    private RealMembersRepo realMembersRepo;
    private MemberDao memberDao;

    @Before
    public void beforeTest() {
        memberDao = Mockito.mock(MemberDao.class);
        realMembersRepo = new RealMembersRepo(memberDao);
    }

    @Test
    public void findMemberCallsMemberDaoFind() {

        //when
        realMembersRepo.findMember(TEST_PASS_NUMBER);

        //then
        Mockito.verify(memberDao).find(TEST_PASS_NUMBER);
    }
}
