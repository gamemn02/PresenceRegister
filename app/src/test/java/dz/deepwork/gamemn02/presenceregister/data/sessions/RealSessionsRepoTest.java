package dz.deepwork.gamemn02.presenceregister.data.sessions;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RealSessionsRepoTest {

    private static final long TEST_MEMBER_ID = 0;
    private static final Session TEST_SESSION =
            new Session(0, 1, 2, "B007", "Rec E114");

    @Mock
    SessionDao sessionDao;
    @InjectMocks
    RealSessionsRepo realSessionsRepo;

    @Test
    public void findSessionCallsSessionDaoFind() {

        //when
        realSessionsRepo.findSession(TEST_MEMBER_ID);

        //then
        verify(sessionDao).find(TEST_MEMBER_ID);
    }

    @Test
    public void addSessionsCallsSessionDaoInsert() {
        //when
        realSessionsRepo.addSessions(TEST_SESSION);

        //then
        verify(sessionDao).insert(TEST_SESSION);
    }
}
