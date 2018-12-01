package dz.deepwork.gamemn02.presenceregister.login;

import android.content.Context;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import dz.deepwork.gamemn02.presenceregister.ApplicationContextComponent;

import static junit.framework.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class ApplicationContextTest {

    @Test
    public void provideApplicationContextUsingDagger() {
        //when
        Context applicationContext = ApplicationContextComponent.Singleton
                .getApplicationContext(new TestApplicationContextModule());

        //then
        assertNotNull(applicationContext);
    }
}
