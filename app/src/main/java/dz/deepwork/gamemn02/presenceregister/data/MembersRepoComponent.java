package dz.deepwork.gamemn02.presenceregister.data;

import dagger.Component;
import dz.deepwork.gamemn02.presenceregister.sign.SignActivity;

@Component(modules = MembersRepoModule.class)
public interface MembersRepoComponent {
    void inject(SignActivity signActivity);
}
