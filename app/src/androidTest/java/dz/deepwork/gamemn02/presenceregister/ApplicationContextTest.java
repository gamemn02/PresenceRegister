package dz.deepwork.gamemn02.presenceregister;

import android.content.Context;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class ApplicationContextTest {

    @Test
    public void provideApplicationContextUsingDagger() {
        //when
        Context applicationContext = ApplicationContextComponent.Singleton
                .getApplicationContext(new TestApplicationContextModule());

        //then
        assertNotNull("application context object provided via dagger is null", applicationContext);
    }
}
