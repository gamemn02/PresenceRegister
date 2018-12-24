package dz.deepwork.gamemn02.presenceregister.data.members;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RealMembersRepoTest {


    private static final String TEST_PASS_NUMBER = "123456";
    public static final Member TEST_MEMBER =
            new Member("name1", "123456", true);

    @Mock
    MemberDao memberDao;

    Executor mDbExecutor = Executors.newSingleThreadExecutor();
    @InjectMocks
    RealMembersRepo realMembersRepo = new RealMembersRepo(memberDao, mDbExecutor);

    @Test
    public void addMembersCallsMemberDaoInsert() throws InterruptedException {

        //when
        realMembersRepo.addMembers(TEST_MEMBER);
        Thread.sleep(100);

        //then
        verify(memberDao).insert(TEST_MEMBER);
    }

    @Test
    public void findMemberCallsMemberDaoFind() throws InterruptedException {

        //when
        realMembersRepo.findMember(TEST_PASS_NUMBER);
        Thread.sleep(100);

        //then
        verify(memberDao).find(TEST_PASS_NUMBER);
    }
}
