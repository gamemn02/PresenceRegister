package dz.deepwork.gamemn02.presenceregister.data.signs;

import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import dz.deepwork.gamemn02.presenceregister.TestApplicationContextModule;
import dz.deepwork.gamemn02.presenceregister.data.AppDatabase;
import dz.deepwork.gamemn02.presenceregister.data.DaggerAppDatabaseComponent;
import dz.deepwork.gamemn02.presenceregister.data.TestAppDatabaseModule;
import dz.deepwork.gamemn02.presenceregister.data.signins.SignInDao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class SignDaoTest {

    AppDatabase appDatabase;
    SignDao signDao;

    @Before
    public void before() {
        appDatabase = DaggerAppDatabaseComponent.Singleton
                .getAppDatabase(new TestApplicationContextModule(), new TestAppDatabaseModule());
        signDao = appDatabase.getSignDao();
        assertNotNull(signDao);
    }

    @Test
    public void test() {

    }

    @After
    public void after() {
        appDatabase.close();
    }
}
