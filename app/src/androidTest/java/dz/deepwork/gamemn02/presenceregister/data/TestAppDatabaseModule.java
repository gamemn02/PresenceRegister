package dz.deepwork.gamemn02.presenceregister.data;

import android.arch.persistence.room.Room;
import android.content.Context;

public class TestAppDatabaseModule extends AppDatabaseModule {
    @Override
    public AppDatabase provideAppDatabase(Context applicationContext) {
        return Room.inMemoryDatabaseBuilder(applicationContext, AppDatabase.class).build();
    }
}
