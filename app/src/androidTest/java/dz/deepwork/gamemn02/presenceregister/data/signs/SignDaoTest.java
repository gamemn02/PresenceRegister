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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class SignDaoTest {

    private static final Sign[] TEST_SIGNS = {
            new Sign("name1", 0, 1, "B007", ""),
            new Sign("name2", 1, 3, "C101", "Rec E114"),
            new Sign("name3", 2, 4, "A302", "Lab E404")};

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
    public void insertAndFindSignIn() {
        //when
        int i = 0;
        long ids[] = signDao.insert(TEST_SIGNS);
        Sign[] actualSigns = signDao.queryAll();
        Sign[] expectedSigns = TEST_SIGNS;
        for(i = 0; i < actualSigns.length; i++) {
            expectedSigns[i].uId = ids[i];
        }

        //then
        for(i = 0; i < TEST_SIGNS.length; i++) {
            assertEquals("actual signs does't match the expected signs", expectedSigns[i], actualSigns[i]);
        }
    }

    @After
    public void after() {
        appDatabase.close();
    }
}
