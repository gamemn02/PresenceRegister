package dz.deepwork.gamemn02.presenceregister;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppExecutorsModule {

    @Singleton
    @Provides
    public Executor DbExecutor() {
        return Executors.newSingleThreadExecutor();
    }
}
