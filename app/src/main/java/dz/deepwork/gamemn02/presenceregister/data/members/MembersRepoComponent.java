package dz.deepwork.gamemn02.presenceregister.data.members;

import javax.inject.Singleton;

import dagger.Component;
import dagger.internal.Preconditions;
import dz.deepwork.gamemn02.presenceregister.sign.SignActivity;

@Singleton
@Component(modules = MembersRepoModule.class)
public interface MembersRepoComponent {

    void inject(SignActivity signActivity);

    class Singleton {
        private static MembersRepoComponent sInstance;

        public static void set(MembersRepoComponent component) {
            Singleton.sInstance = component;
        }

        public static MembersRepoComponent getInstance() {
            return Preconditions.checkNotNull(sInstance);
        }
    }
}
