package dz.deepwork.gamemn02.presenceregister.data;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import dz.deepwork.gamemn02.presenceregister.data.members.Member;
import dz.deepwork.gamemn02.presenceregister.data.members.MemberDao;
import dz.deepwork.gamemn02.presenceregister.data.sessions.Session;
import dz.deepwork.gamemn02.presenceregister.data.sessions.SessionDao;
import dz.deepwork.gamemn02.presenceregister.data.signins.SignIn;
import dz.deepwork.gamemn02.presenceregister.data.signins.SignInDao;
import dz.deepwork.gamemn02.presenceregister.data.signs.Sign;
import dz.deepwork.gamemn02.presenceregister.data.signs.SignDao;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RealSignsRepoTest {

    @Mock
    MemberDao memberDao;
    @Mock
    SessionDao sessionDao;
    @Mock
    SignInDao signInDao;
    @Mock
    SignDao signDao;

    Executor mDbExecutor = Executors.newSingleThreadExecutor();
    @InjectMocks
    RealSignsRepo realSignsRepo =
            new RealSignsRepo(memberDao, sessionDao, signInDao, signDao, mDbExecutor);

    @Test
    public void signInCallsSignInDaoInsert() throws InterruptedException {

        //when
        realSignsRepo.signIn(TestData.SIGN_INS[0]);
        Thread.sleep(100);

        //then
        verify(signInDao).insert(TestData.SIGN_INS[0]);
    }

    @Test
    public void findSignInCallsFind() throws InterruptedException {

        //when
        when(signInDao.find(TestData.SIGN_INS[0].sessionId)).thenReturn(TestData.SIGN_INS[0]);
        SignIn returnedSignIn = realSignsRepo.findSignIn(TestData.SIGN_INS[0].sessionId);
        Thread.sleep(100);

        //then
        verify(signInDao).find(TestData.SIGN_INS[0].sessionId);
        Assert.assertEquals(TestData.SIGN_INS[0], returnedSignIn);
    }

    @Test
    public void signOutCallsSignInDaoDeleteAndSignDaoInsert() throws InterruptedException {

        //when
        when(memberDao.get(TestData.SESSIONS[0].memberId)).thenReturn(TestData.MEMBERS[0]);
        when(sessionDao.get(TestData.SIGN_INS[0].sessionId)).thenReturn(TestData.SESSIONS[0]);
        realSignsRepo.signOut(TestData.SIGN_INS[0]);
        Thread.sleep(100);

        //then
        verify(signInDao).delete(TestData.SIGN_INS[0]);
        verify(signDao).insert(TestData.SIGNS[0]);

    }


}
