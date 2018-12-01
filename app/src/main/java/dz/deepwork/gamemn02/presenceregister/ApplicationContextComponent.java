package dz.deepwork.gamemn02.presenceregister;

import android.content.Context;

import dagger.Component;

@Component(modules = ApplicationContextModule.class)
public interface ApplicationContextComponent {
    Context applicationContext();

    class Singleton {
        public static Context getApplicationContext(ApplicationContextModule applicationContextModule) {
            return DaggerApplicationContextComponent
                    .builder()
                    .applicationContextModule(applicationContextModule)
                    .build()
                    .applicationContext();
        }
    }
}
