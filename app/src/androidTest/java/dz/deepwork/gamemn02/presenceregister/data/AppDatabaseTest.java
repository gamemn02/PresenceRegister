package dz.deepwork.gamemn02.presenceregister.data;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import dz.deepwork.gamemn02.presenceregister.TestApplicationContextModule;

import static junit.framework.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class AppDatabaseTest {

    Context context;
    AppDatabase appDatabase;

    @Test
    public void buildAppDatabase() {
        //when
        context = InstrumentationRegistry.getTargetContext();
        AppDatabase appDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();

        //then
        assertNotNull("app database object built using room builder is null", appDatabase);

        //after
        appDatabase.close();

    }

    @Test
    public void provideAppDatabaseUsingDagger() {
        //when
        appDatabase = DaggerAppDatabaseComponent.Singleton
                .getAppDatabase(new TestApplicationContextModule(), new TestAppDatabaseModule());

        //then
        assertNotNull("app database object provided via dagger is null", appDatabase);

        appDatabase.close();
    }
}
