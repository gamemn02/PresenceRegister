package dz.deepwork.gamemn02.presenceregister.data.sessions;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dz.deepwork.gamemn02.presenceregister.data.AppDatabase;

@Module
public class SessionsModule {

    @Singleton
    @Provides
    public SessionDao provideMemberDao(AppDatabase appDatabase) {
        return appDatabase.getSessionDao();
    }

    @Singleton
    @Provides
    public SessionsRepo provideMembersRepo(SessionDao sessionDao, Executor dbExecutor) {
        return new RealSessionsRepo(sessionDao, dbExecutor);
    }
}
