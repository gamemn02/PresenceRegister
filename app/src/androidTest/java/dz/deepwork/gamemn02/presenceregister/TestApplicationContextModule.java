package dz.deepwork.gamemn02.presenceregister;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import dz.deepwork.gamemn02.presenceregister.ApplicationContextModule;

public class TestApplicationContextModule extends ApplicationContextModule {
    @Override
    public Context provideApplicationContext() {
        return InstrumentationRegistry.getTargetContext();
    }
}
