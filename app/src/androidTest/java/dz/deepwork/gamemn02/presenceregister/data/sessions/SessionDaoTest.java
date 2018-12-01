package dz.deepwork.gamemn02.presenceregister.data.sessions;

import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import dz.deepwork.gamemn02.presenceregister.TestApplicationContextModule;
import dz.deepwork.gamemn02.presenceregister.data.AppDatabase;
import dz.deepwork.gamemn02.presenceregister.data.DaggerAppDatabaseComponent;
import dz.deepwork.gamemn02.presenceregister.data.TestAppDatabaseModule;

import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class SessionDaoTest {

    AppDatabase appDatabase;
    SessionDao sessionDao;

    @Before
    public void before() {
        appDatabase = DaggerAppDatabaseComponent.Singleton
                .getAppDatabase(new TestApplicationContextModule(), new TestAppDatabaseModule());
        sessionDao = appDatabase.getSessionDao();
        assertNotNull(sessionDao);
    }

    @Test
    public void run() {

    }

    @After
    public void after() {
        appDatabase.close();
    }
}
