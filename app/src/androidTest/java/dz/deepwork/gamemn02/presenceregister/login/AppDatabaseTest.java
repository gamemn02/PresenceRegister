package dz.deepwork.gamemn02.presenceregister.login;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


import dz.deepwork.gamemn02.presenceregister.data.AppDatabase;

import static junit.framework.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class AppDatabaseTest {

    Context context;

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
}
