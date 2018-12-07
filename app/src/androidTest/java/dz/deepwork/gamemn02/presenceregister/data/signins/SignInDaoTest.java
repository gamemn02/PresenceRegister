package dz.deepwork.gamemn02.presenceregister.data.signins;

import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import dz.deepwork.gamemn02.presenceregister.TestApplicationContextModule;
import dz.deepwork.gamemn02.presenceregister.data.AppDatabase;
import dz.deepwork.gamemn02.presenceregister.data.DaggerAppDatabaseComponent;
import dz.deepwork.gamemn02.presenceregister.data.TestAppDatabaseModule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(AndroidJUnit4.class)
public class SignInDaoTest {

    private static final SignIn[] TEST_SIGN_INS = {
            new SignIn(1, 2, "B007"),
            new SignIn(2, 3, "C101"),
            new SignIn(3, 4, "B007")};

    AppDatabase appDatabase;
    SignInDao signInDao;

    @Before
    public void before() {
        appDatabase = DaggerAppDatabaseComponent.Singleton
                .getAppDatabase(new TestApplicationContextModule(), new TestAppDatabaseModule());
        signInDao = appDatabase.getSignInDao();
        assertNotNull(signInDao);
    }

    @Test
    public void insertAndFind() {
        //when
        long ids[] = signInDao.insert(TEST_SIGN_INS);
        SignIn actualSignIn = signInDao.find(TEST_SIGN_INS[1].sessionId);
        SignIn expectedSignIn = TEST_SIGN_INS[1];
        SignIn wrongSignIn = TEST_SIGN_INS[2];
        expectedSignIn.uId = ids[1];
        wrongSignIn.uId = ids[2];

        //then
        assertEquals("actual signIn does't match the expected signIn", expectedSignIn, actualSignIn);
        assertNotEquals("actual signIn matches the wrong signIn", wrongSignIn, actualSignIn);
    }

    @Test
    public void delete() {
        //when
        long ids[] = signInDao.insert(TEST_SIGN_INS);
        SignIn signInToDelete = new SignIn(0, 0, "");
        signInToDelete.uId = ids[1];
        signInDao.delete(signInToDelete);
        SignIn actualSignIn = signInDao.find(TEST_SIGN_INS[1].sessionId);

        //then
        assertNull("deleted sign in row still exists", actualSignIn);
    }

    @After
    public void after() {
        appDatabase.close();
    }
}
