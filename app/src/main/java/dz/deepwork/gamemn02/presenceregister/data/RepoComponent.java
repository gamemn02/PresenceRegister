package dz.deepwork.gamemn02.presenceregister.data;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Component;
import dagger.internal.Preconditions;
import dz.deepwork.gamemn02.presenceregister.AppExecutorsModule;
import dz.deepwork.gamemn02.presenceregister.ApplicationContextModule;
import dz.deepwork.gamemn02.presenceregister.data.members.MembersModule;
import dz.deepwork.gamemn02.presenceregister.data.members.MembersRepo;
import dz.deepwork.gamemn02.presenceregister.data.sessions.SessionsModule;
import dz.deepwork.gamemn02.presenceregister.data.sessions.SessionsRepo;
import dz.deepwork.gamemn02.presenceregister.login.LoginFragment;
import dz.deepwork.gamemn02.presenceregister.login.LoginViewModel;
import dz.deepwork.gamemn02.presenceregister.sign.SignActivity;

@Singleton
@Component(modules = {
        MembersModule.class,
        SessionsModule.class,
        SignsModule.class,
        AppExecutorsModule.class,
        ApplicationContextModule.class,
        AppDatabaseModule.class})
public interface RepoComponent {

    void inject(LoginViewModel loginViewModel);
    void inject(SignActivity signActivity);
    MembersRepo membersRepo();
    SessionsRepo sessionsRepo();
    SignsRepo signRepo();
    AppDatabase appDatabase();

    class Singleton {
        private static RepoComponent sInstance;

        public static void set(RepoComponent component) {
            Singleton.sInstance = component;
        }

        public static RepoComponent getInstance() {
            return Preconditions.checkNotNull(sInstance);
        }
    }
}
