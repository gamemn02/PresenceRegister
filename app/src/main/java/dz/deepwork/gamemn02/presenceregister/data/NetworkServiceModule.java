package dz.deepwork.gamemn02.presenceregister.data;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkServiceModule {

    @Singleton
    @Provides
    public NetworkService provideNetworkService(Executor networkExecutor) {
        return new NetworkService(networkExecutor);
    }
}
