package dz.deepwork.gamemn02.presenceregister;

import android.app.Application;
import android.content.Context;

import dz.deepwork.gamemn02.presenceregister.data.AppDatabaseModule;
import dz.deepwork.gamemn02.presenceregister.data.DaggerRepoComponent;
import dz.deepwork.gamemn02.presenceregister.data.RepoComponent;
import dz.deepwork.gamemn02.presenceregister.data.members.MembersModule;

public class PresenceRegisterApplication extends Application {

    public static PresenceRegisterApplication get(Context context) {
        return (PresenceRegisterApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        RepoComponent daggerRepoComponent = DaggerRepoComponent
                .builder()
                .applicationContextModule(new ApplicationContextModule(getApplicationContext()))
                .appDatabaseModule(new AppDatabaseModule())
                .membersModule(new MembersModule())
                .build();
        RepoComponent.Singleton.set(daggerRepoComponent);

        daggerRepoComponent.membersRepo().fetchMembers();
    }

}
