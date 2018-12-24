package dz.deepwork.gamemn02.presenceregister.data.sessions;

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
public class RealSessionsRepoTest {

    private static final long TEST_MEMBER_ID = 0;
    private static final Session TEST_SESSION =
            new Session(0, 1, 2, "B007", "Rec E114");

    @Mock
    SessionDao sessionDao;

    Executor mDbExecutor = Executors.newSingleThreadExecutor();
    @InjectMocks
    RealSessionsRepo realSessionsRepo = new RealSessionsRepo(sessionDao, mDbExecutor);

    @Test
    public void findSessionCallsSessionDaoFind() throws InterruptedException {

        //when
        realSessionsRepo.findSession(TEST_MEMBER_ID);
        Thread.sleep(100);

        //then
        verify(sessionDao).find(TEST_MEMBER_ID);
    }

    @Test
    public void addSessionsCallsSessionDaoInsert() throws InterruptedException {
        //when
        realSessionsRepo.addSessions(TEST_SESSION);
        Thread.sleep(100);

        //then
        verify(sessionDao).insert(TEST_SESSION);
    }
}
