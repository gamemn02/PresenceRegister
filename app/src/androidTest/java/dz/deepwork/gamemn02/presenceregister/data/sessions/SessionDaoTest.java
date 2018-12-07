package dz.deepwork.gamemn02.presenceregister.data.sessions;

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

@RunWith(AndroidJUnit4.class)
public class SessionDaoTest {

    private static final Session[] TEST_SESSIONS = {
            new Session(0, 0, 0, "B007", ""),
            new Session(0, 4, 1, "C101", ""),
            new Session(1, 3, 2, "B005", "")};
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
    public void insertAndFind() {
        //when
        long[] ids = sessionDao.insert(TEST_SESSIONS);
        Session actualSession = sessionDao.find(TEST_SESSIONS[1].memberId);
        Session expectedSession = TEST_SESSIONS[1];
        Session wrongSession = TEST_SESSIONS[2];
        expectedSession.uId = ids[1];
        wrongSession.uId = ids[2];

        //then
        assertEquals("actual session does't match the expected session", expectedSession, actualSession);
        assertNotEquals("actual session matches the wrong session", wrongSession, actualSession);
    }

    @Test
    public void get() {
        //when
        long[] ids = sessionDao.insert(TEST_SESSIONS);
        Session actualSession = sessionDao.get(ids[1]);
        Session expectedSession = TEST_SESSIONS[1];
        Session wrongSession = TEST_SESSIONS[2];
        expectedSession.uId = ids[1];
        wrongSession.uId = ids[2];

        //then
        assertEquals("actual session does't match the expected session", expectedSession, actualSession);
        assertNotEquals("actual session matches the wrong session", wrongSession, actualSession);
    }

    @After
    public void after() {
        appDatabase.close();
    }
}
