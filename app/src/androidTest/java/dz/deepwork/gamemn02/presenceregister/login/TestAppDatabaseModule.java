package dz.deepwork.gamemn02.presenceregister.login;

import android.arch.persistence.room.Room;
import android.content.Context;

import dz.deepwork.gamemn02.presenceregister.data.AppDatabase;
import dz.deepwork.gamemn02.presenceregister.data.AppDatabaseModule;

class TestAppDatabaseModule extends AppDatabaseModule {
    @Override
    public AppDatabase provideAppDatabase(Context applicationContext) {
        return Room.inMemoryDatabaseBuilder(applicationContext, AppDatabase.class).build();
    }
}
