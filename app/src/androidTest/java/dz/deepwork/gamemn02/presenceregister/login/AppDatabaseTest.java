package dz.deepwork.gamemn02.presenceregister.login;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import dz.deepwork.gamemn02.presenceregister.data.AppDatabase;
import dz.deepwork.gamemn02.presenceregister.data.DaggerAppDatabaseComponent;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class AppDatabaseTest {

    Context context;
    AppDatabase appDatabase;

    @Before
    public void beforeTest() {
        context = InstrumentationRegistry.getTargetContext();
    }

    @Test
    public void appDatabaseIsBuildingSuccessfully() {
        //when
        AppDatabase appDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();

        //then
        assertNotNull(appDatabase);

        //after
        appDatabase.close();
    }

    @Test
    public void provideAppDatabaseUsingDagger() {
        //when
        appDatabase = DaggerAppDatabaseComponent
                .builder()
                .applicationContextModule(new TestApplicationContextModule())
                .appDatabaseModule(new TestAppDatabaseModule())
                .build()
                .getAppDatabase();

        //then
        assertNotNull(appDatabase);

        appDatabase.close();
    }
}
