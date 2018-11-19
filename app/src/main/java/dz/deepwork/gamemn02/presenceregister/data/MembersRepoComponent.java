package dz.deepwork.gamemn02.presenceregister.data;

import javax.inject.Singleton;

import dagger.Component;
import dz.deepwork.gamemn02.presenceregister.sign.SignActivity;

@Singleton
@Component(modules = MembersRepoModule.class)
public interface MembersRepoComponent {
    void inject(SignActivity signActivity);
}
