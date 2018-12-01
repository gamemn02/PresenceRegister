package dz.deepwork.gamemn02.presenceregister.data;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import dz.deepwork.gamemn02.presenceregister.ApplicationContextModule;

@Singleton
@Component(modules = {ApplicationContextModule.class, AppDatabaseModule.class})
public interface AppDatabaseComponent {
    AppDatabase appDatabase();

    class Singleton {
        public static AppDatabase getAppDatabase(ApplicationContextModule applicationContextModule,
                                                 AppDatabaseModule appDatabaseModule) {
            return DaggerAppDatabaseComponent
                    .builder()
                    .applicationContextModule(applicationContextModule)
                    .appDatabaseModule(appDatabaseModule)
                    .build()
                    .appDatabase();
        }
    }
}
