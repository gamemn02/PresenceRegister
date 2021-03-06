package dz.deepwork.gamemn02.presenceregister.data;

import javax.inject.Singleton;

import dagger.Component;
import dagger.internal.Preconditions;
import dz.deepwork.gamemn02.presenceregister.AppExecutorsModule;
import dz.deepwork.gamemn02.presenceregister.ApplicationContextModule;
import dz.deepwork.gamemn02.presenceregister.data.members.MembersModule;
import dz.deepwork.gamemn02.presenceregister.data.members.MembersRepo;
import dz.deepwork.gamemn02.presenceregister.data.sessions.SessionsModule;
import dz.deepwork.gamemn02.presenceregister.data.sessions.SessionsRepo;
import dz.deepwork.gamemn02.presenceregister.login.LoginViewModel;
import dz.deepwork.gamemn02.presenceregister.sign.SignViewModel;

@Singleton
@Component(modules = {
        MembersModule.class,
        SessionsModule.class,
        SignsModule.class,
        AppExecutorsModule.class,
        ApplicationContextModule.class,
        AppDatabaseModule.class,
        NetworkServiceModule.class})
public interface RepoComponent {

    void inject(LoginViewModel loginViewModel);
    void inject(SignViewModel signViewModel);
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
