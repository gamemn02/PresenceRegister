package dz.deepwork.gamemn02.presenceregister.sign;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import dz.deepwork.gamemn02.presenceregister.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;

@RunWith(AndroidJUnit4.class)
public class SignActivityTest {

    @Rule
    public ActivityTestRule<SignActivity> signActivityTestRule =
            new ActivityTestRule<>(SignActivity.class);

    @Test
    public void showSign() {

        onView(withId(R.id.layout_sign)).check(matches(isDisplayed()));
        onView(withId(R.id.layout_sign)).check(matches(withParent(withId(R.id.frame_sign))));
    }

}