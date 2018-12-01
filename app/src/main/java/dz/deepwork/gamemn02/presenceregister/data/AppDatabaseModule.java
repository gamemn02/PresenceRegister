package dz.deepwork.gamemn02.presenceregister.data;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppDatabaseModule {

    @Singleton
    @Provides
    public AppDatabase provideAppDatabase(Context applicationContext) {
        return Room.databaseBuilder(applicationContext, AppDatabase.class, "database_name").build();
    }
}
