package dz.deepwork.gamemn02.presenceregister.sign;

import javax.inject.Singleton;

import dagger.Component;
import dagger.internal.Preconditions;
import dz.deepwork.gamemn02.presenceregister.ApplicationContextModule;
import dz.deepwork.gamemn02.presenceregister.data.AppDatabaseModule;
import dz.deepwork.gamemn02.presenceregister.data.members.MembersModule;

@Singleton
@Component(modules = {MembersModule.class, ApplicationContextModule.class, AppDatabaseModule.class})
public interface SignComponent {

    void inject(SignActivity signActivity);

    class Singleton {
        private static SignComponent sInstance;

        public static void set(SignComponent component) {
            Singleton.sInstance = component;
        }

        public static SignComponent getInstance() {
            return Preconditions.checkNotNull(sInstance);
        }
    }
}
