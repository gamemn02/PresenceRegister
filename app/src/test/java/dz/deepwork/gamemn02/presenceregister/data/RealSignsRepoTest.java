package dz.deepwork.gamemn02.presenceregister.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import dz.deepwork.gamemn02.presenceregister.data.signins.SignIn;
import dz.deepwork.gamemn02.presenceregister.data.signins.SignInDao;
import dz.deepwork.gamemn02.presenceregister.data.signs.SignDao;

@RunWith(MockitoJUnitRunner.class)
public class RealSignsRepoTest {

    private static final SignIn TEST_SIGN_IN = new SignIn(1, 4, "B007");
    private static final long TEST_SESSION_ID = 1;
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
        Mockito.when(signInDao.find(TEST_SESSION_ID)).thenReturn(TEST_SIGN_IN);
        SignIn returnedSignIn = realSignsRepo.findSignIn(TEST_SESSION_ID);

        //then
        Mockito.verify(signInDao).find(TEST_SESSION_ID);
        Assert.assertEquals(TEST_SIGN_IN, returnedSignIn);
    }


}
