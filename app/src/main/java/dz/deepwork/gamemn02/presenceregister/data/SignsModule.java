package dz.deepwork.gamemn02.presenceregister.data;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dz.deepwork.gamemn02.presenceregister.data.members.MemberDao;
import dz.deepwork.gamemn02.presenceregister.data.sessions.SessionDao;
import dz.deepwork.gamemn02.presenceregister.data.signins.SignInDao;
import dz.deepwork.gamemn02.presenceregister.data.signs.SignDao;

@Module
public class SignsModule {

    @Singleton
    @Provides
    public SignInDao provideSignInDao(AppDatabase appDatabase) {
        return appDatabase.getSignInDao();
    }

    @Singleton
    @Provides
    public SignDao provideSignDao(AppDatabase appDatabase) {
        return appDatabase.getSignDao();
    }

    @Singleton
    @Provides
    public SignsRepo provideSignsRepo(MemberDao memberDao, SessionDao sessionDao,
                                      SignInDao signInDao, SignDao signDao, Executor dbExecutor) {
        return new RealSignsRepo(memberDao, sessionDao, signInDao, signDao, dbExecutor);
    }
}
