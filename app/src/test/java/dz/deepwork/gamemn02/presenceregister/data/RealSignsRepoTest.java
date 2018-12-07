package dz.deepwork.gamemn02.presenceregister.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import dz.deepwork.gamemn02.presenceregister.data.members.Member;
import dz.deepwork.gamemn02.presenceregister.data.members.MemberDao;
import dz.deepwork.gamemn02.presenceregister.data.sessions.Session;
import dz.deepwork.gamemn02.presenceregister.data.sessions.SessionDao;
import dz.deepwork.gamemn02.presenceregister.data.signins.SignIn;
import dz.deepwork.gamemn02.presenceregister.data.signins.SignInDao;
import dz.deepwork.gamemn02.presenceregister.data.signs.Sign;
import dz.deepwork.gamemn02.presenceregister.data.signs.SignDao;

@RunWith(MockitoJUnitRunner.class)
public class RealSignsRepoTest {

    private static final Member TEST_MEMBER =
            new Member("name1", "123456", false);
    private static final Session TEST_SESSION =
            new Session(0, 0, TEST_MEMBER.uId, "B007", "Rec E114");
    private static final SignIn TEST_SIGN_IN =
            new SignIn(1, 4, "B007");
    private static final Sign TEST_SIGN =
            new Sign("name1", 4, 5, "B007", "Rec E114");

    @Mock
    MemberDao memberDao;
    @Mock
    SessionDao sessionDao;
    @Mock
    SignInDao signInDao;
    @Mock
    SignDao signDao;
    @InjectMocks
    RealSignsRepo realSignsRepo;

    @Test
    public void signInCallsSignInDaoInsert() {

        //when
        realSignsRepo.signIn(TEST_SIGN_IN);

        //then
        Mockito.verify(signInDao).insert(TEST_SIGN_IN);
    }

    @Test
    public void findSignInCallsFind() {

        //when
        Mockito.when(signInDao.find(TEST_SIGN_IN.sessionId)).thenReturn(TEST_SIGN_IN);
        SignIn returnedSignIn = realSignsRepo.findSignIn(TEST_SIGN_IN.sessionId);

        //then
        Mockito.verify(signInDao).find(TEST_SIGN_IN.sessionId);
        Assert.assertEquals(TEST_SIGN_IN, returnedSignIn);
    }

    @Test
    public void signOutCallsSignInDaoDeleteAndSignDaoInsert() {

        // TODO use static import when possible
        //when
        Mockito.when(memberDao.get(TEST_SESSION.memberId)).thenReturn(TEST_MEMBER);
        Mockito.when(sessionDao.get(TEST_SIGN_IN.sessionId)).thenReturn(TEST_SESSION);
        realSignsRepo.signOut(TEST_SIGN_IN);

        //then
        Mockito.verify(signInDao).delete(TEST_SIGN_IN);
        Mockito.verify(signDao).insert(TEST_SIGN);

    }


}
