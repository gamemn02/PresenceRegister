package dz.deepwork.gamemn02.presenceregister.data.sessions;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RealSessionsRepoTest {

    private static final long TEST_MEMBER_ID = 0;
    private RealSessionsRepo realSessionsRepo;
    @Mock
    private SessionDao sessionDao;

    @Before
    public void beforeTest() {
        realSessionsRepo = new RealSessionsRepo(sessionDao);
    }

    @Test
    public void findSessionCallsSessionDaoFind() {

        //when
        realSessionsRepo.findSession(TEST_MEMBER_ID);

        //then
        verify(sessionDao).find(TEST_MEMBER_ID);
    }
}
