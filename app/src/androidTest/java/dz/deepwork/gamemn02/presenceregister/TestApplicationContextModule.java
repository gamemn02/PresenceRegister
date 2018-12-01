package dz.deepwork.gamemn02.presenceregister;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

public class TestApplicationContextModule extends ApplicationContextModule {

    public TestApplicationContextModule() {
        super(InstrumentationRegistry.getTargetContext());
    }
}
