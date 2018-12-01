package dz.deepwork.gamemn02.presenceregister;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationContextModule {

    // TODO: make it singleton
    @Provides
    public Context provideApplicationContext() {
        return null;
    }
}
