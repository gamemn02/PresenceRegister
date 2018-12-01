package dz.deepwork.gamemn02.presenceregister.data;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppDatabaseModule {

    @Singleton
    @Provides
    public AppDatabase provideAppDatabase(Context applicationContext) {
        return null;
    }
}
