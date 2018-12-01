package dz.deepwork.gamemn02.presenceregister.data;

import javax.inject.Singleton;

import dagger.Component;
import dz.deepwork.gamemn02.presenceregister.ApplicationContextModule;

@Singleton
@Component(modules = {AppDatabaseModule.class, ApplicationContextModule.class})
public interface AppDatabaseComponent {
    AppDatabase getAppDatabase();
}
