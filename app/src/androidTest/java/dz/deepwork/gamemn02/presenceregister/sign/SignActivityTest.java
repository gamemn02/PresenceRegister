package dz.deepwork.gamemn02.presenceregister.sign;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class SignActivityTest {

    @Rule
    public ActivityTestRule<SignActivity> signActivityTestRule =
            new ActivityTestRule<>(SignActivity.class);

    @Test
    public void viewIt() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}