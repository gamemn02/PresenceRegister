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

    @Before
    public void beforeTest() {
        context = InstrumentationRegistry.getTargetContext();
    }

    @Test
    public void buildAppDatabase() {
        System.out.print("test building app database");
        //when
        AppDatabase appDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();

        //then
        assertNotNull(appDatabase);
        System.out.print("app database is successfully built");

        //after
        appDatabase.close();

    }

    @Test
    public void provideAppDatabaseUsingDagger() {
        //when
        appDatabase = DaggerAppDatabaseComponent.Singleton
                .getAppDatabase(new TestApplicationContextModule(), new TestAppDatabaseModule());

        //then
        assertNotNull(appDatabase);

        appDatabase.close();
    }
}
