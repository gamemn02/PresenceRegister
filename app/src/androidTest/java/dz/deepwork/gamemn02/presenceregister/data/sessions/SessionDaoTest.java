package dz.deepwork.gamemn02.presenceregister.data.sessions;

import android.arch.lifecycle.LiveData;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import dz.deepwork.gamemn02.presenceregister.TestApplicationContextModule;
import dz.deepwork.gamemn02.presenceregister.data.AppDatabase;
import dz.deepwork.gamemn02.presenceregister.data.DaggerAppDatabaseComponent;
import dz.deepwork.gamemn02.presenceregister.data.LiveDataTestUtils;
import dz.deepwork.gamemn02.presenceregister.data.TestAppDatabaseModule;
import dz.deepwork.gamemn02.presenceregister.data.TestData;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
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
    public void insertAndFind() throws InterruptedException {
//        //when
//        sessionDao.insert(TestData.SESSIONS);
//        LiveData<Session> actualSessionLiveData = sessionDao.find(TestData.SESSIONS[1].memberId);
//        Session actualSession = LiveDataTestUtils.getValue(actualSessionLiveData);
//        Session expectedSession = TestData.SESSIONS[1];
//        Session wrongSession = TestData.SESSIONS[2];
//
//        //then
//        assertEquals("actual session does't match the expected session", expectedSession, actualSession);
//        assertNotEquals("actual session matches the wrong session", wrongSession, actualSession);
    }

    @Test
    public void insertAndFindCurrentSession() throws InterruptedException {
        //when
        sessionDao.insert(TestData.SESSIONS);
        LiveData<Session> actualSessionLiveData =
                sessionDao.find(TestData.SESSION1_MEMBER_ID, TestData.SESSION1_TIME);
        LiveData<Session> actualSessionLiveData2 =
                sessionDao.find(TestData.SESSION2_MEMBER_ID, SessionTime.toSessionTime(TestData.SESSION2_TIME_SESSION_NUMBER+1));
        Session actualSession = LiveDataTestUtils.getValue(actualSessionLiveData);
        Session actualSession2 = LiveDataTestUtils.getValue(actualSessionLiveData2);
        Session expectedSession = TestData.SESSIONS[0];
        Session expectedSession2 = TestData.SESSIONS[1];

        //then
        assertEquals(expectedSession, actualSession);
        assertEquals(expectedSession2, actualSession2);
    }

    @Test
    public void get() {
        //when
        long[] ids = sessionDao.insert(TestData.SESSIONS);
        Session actualSession = sessionDao.get(ids[1]);
        Session expectedSession = TestData.SESSIONS[1];
        Session wrongSession = TestData.SESSIONS[2];

        //then
        assertEquals("actual session does't match the expected session", expectedSession, actualSession);
        assertNotEquals("actual session matches the wrong session", wrongSession, actualSession);
    }

    @After
    public void after() {
        appDatabase.close();
    }
}
