package dz.deepwork.gamemn02.presenceregister;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationContextModule {

    private Context applicationContext;

    public ApplicationContextModule(Context applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Provides
    public Context provideApplicationContext() {
        return applicationContext;
    }
}
