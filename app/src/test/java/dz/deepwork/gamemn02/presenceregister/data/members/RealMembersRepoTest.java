package dz.deepwork.gamemn02.presenceregister.data.members;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RealMembersRepoTest {


    private static final String TEST_PASS_NUMBER = "123456";
    public static final Member TEST_MEMBER =
            new Member("name1", "123456", true);

    @Mock
    private MemberDao memberDao;
    @InjectMocks
    private RealMembersRepo realMembersRepo;

    @Test
    public void addMembersCallsMemberDaoInsert() {

        //when
        realMembersRepo.addMembers(TEST_MEMBER);

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
