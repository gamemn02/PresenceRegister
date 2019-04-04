package dz.deepwork.gamemn02.presenceregister.main;

import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import dz.deepwork.gamemn02.presenceregister.R;
import dz.deepwork.gamemn02.presenceregister.login.LoginActivity;
import dz.deepwork.gamemn02.presenceregister.sign.SignActivity;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.Espresso.onIdle;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public IntentsTestRule<MainActivity> mainActivityTestRule =
            new IntentsTestRule<>(MainActivity.class);

    @Test
    public void navigatingTheApp() throws InterruptedException {
        // On portrait
        mainActivityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Thread.sleep(500);
        // Check register fragment
        onView(withId(R.id.layout_register)).check(matches(isDisplayed()));
        onView(withId(R.id.layout_register)).check(matches(withParent(withId(R.id.frame_register))));
        // Change to landscape
        mainActivityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        Thread.sleep(500);
        // Check login and register fragments
        onView(withId(R.id.layout_login)).check(matches(isDisplayed()));
        onView(withId(R.id.layout_login)).check(matches(withParent(withId(R.id.frame_login))));
        onView(withId(R.id.layout_sign)).check(doesNotExist());
        onView(withId(R.id.layout_register)).check(matches(isDisplayed()));
        onView(withId(R.id.layout_register)).check(matches(withParent(withId(R.id.frame_register))));
        // Check fab
        onView(withId(R.id.fab_sign)).check(doesNotExist());

        // Enter correct pass number
        onView(withId(R.id.btn_digit_1)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.btn_digit_2)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.btn_digit_3)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.btn_digit_4)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.btn_digit_5)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.btn_digit_6)).check(matches(isDisplayed())).perform(click());
        // Check sign and login fragments
        onView(withId(R.id.layout_login)).check(doesNotExist());
        onView(withId(R.id.layout_sign)).check(matches(isDisplayed()));
        onView(withId(R.id.layout_sign)).check(matches(withParent(withId(R.id.frame_login))));

        // Change to portrait
        mainActivityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Thread.sleep(500);
        // Check sign activity
        intended(hasComponent(new ComponentName(getTargetContext(), SignActivity.class)));

        // Return back
        pressBack();
        // Check register fragment
        onView(withId(R.id.layout_register)).check(matches(isDisplayed()));

        // Press sign fab
        onView(withId(R.id.fab_sign)).check(matches(isDisplayed())).perform(click());
        // Check login activity
        intended(hasComponent(new ComponentName(getTargetContext(), LoginActivity.class)));

        // Change to landscape
        mainActivityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        Thread.sleep(500);
        // Press back
        pressBack();
        // Check login and register and sign fragments
        onView(withId(R.id.layout_login)).check(matches(isDisplayed()));
        onView(withId(R.id.layout_sign)).check(doesNotExist());

    }


}