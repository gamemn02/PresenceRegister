package dz.deepwork.gamemn02.presenceregister;

import android.app.Application;
import android.content.Context;

import dz.deepwork.gamemn02.presenceregister.data.AppDatabaseModule;
import dz.deepwork.gamemn02.presenceregister.sign.DaggerSignComponent;
import dz.deepwork.gamemn02.presenceregister.sign.SignComponent;
import dz.deepwork.gamemn02.presenceregister.data.members.MembersModule;

public class PresenceRegisterApplication extends Application {

    public static PresenceRegisterApplication get(Context context) {
        return (PresenceRegisterApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        SignComponent daggerSignComponent = DaggerSignComponent
                .builder()
                .applicationContextModule(new ApplicationContextModule(getApplicationContext()))
                .appDatabaseModule(new AppDatabaseModule())
                .membersModule(new MembersModule())
                .build();
        SignComponent.Singleton.set(daggerSignComponent);
    }

}
