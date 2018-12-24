package dz.deepwork.gamemn02.presenceregister.data.sessions;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import dz.deepwork.gamemn02.presenceregister.data.TestData;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RealSessionsRepoTest {

    @Mock
    SessionDao sessionDao;

    Executor mDbExecutor = Executors.newSingleThreadExecutor();
    @InjectMocks
    RealSessionsRepo realSessionsRepo = new RealSessionsRepo(sessionDao, mDbExecutor);

    @Test
    public void findSessionCallsSessionDaoFind() throws InterruptedException {

        //when
        realSessionsRepo.findSession(TestData.SESSIONS[0].memberId);
        Thread.sleep(100);

        //then
        verify(sessionDao).find(TestData.SESSIONS[0].memberId);
    }

    @Test
    public void addSessionsCallsSessionDaoInsert() throws InterruptedException {
        //when
        realSessionsRepo.addSessions(TestData.SESSIONS);
        Thread.sleep(100);

        //then
        verify(sessionDao).insert(TestData.SESSIONS);
    }
}
