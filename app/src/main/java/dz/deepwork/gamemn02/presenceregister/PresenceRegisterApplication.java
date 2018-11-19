package dz.deepwork.gamemn02.presenceregister;

import android.app.Application;
import android.content.Context;


public class PresenceRegisterApplication extends Application {

    public static PresenceRegisterApplication get(Context context) {
        return (PresenceRegisterApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
