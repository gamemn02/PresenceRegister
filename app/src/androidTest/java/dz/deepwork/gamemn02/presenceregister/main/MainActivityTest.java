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

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public IntentsTestRule<MainActivity> mainActivityTestRule =
            new IntentsTestRule<>(MainActivity.class);

    @Test
    public void showRegisterOnPortrait() {
        mainActivityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        onView(withId(R.id.layout_register)).check(matches(isDisplayed()));
        onView(withId(R.id.layout_register)).check(matches(withParent(withId(R.id.frame_register))));
    }

    @Test
    public void showLoginAndRegisterOnLandscape() {
        mainActivityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        onView(withId(R.id.layout_login)).check(matches(isDisplayed()));
        onView(withId(R.id.layout_login)).check(matches(withParent(withId(R.id.frame_login))));
        onView(withId(R.id.layout_register)).check(matches(isDisplayed()));
        onView(withId(R.id.layout_register)).check(matches(withParent(withId(R.id.frame_register))));

    }

    @Test
    public void fabLaunchLoginActivityOnPortrait() {
        mainActivityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        onView(withId(R.id.fab_sign)).check(matches(isDisplayed())).perform(click());

        intended(hasComponent(new ComponentName(getTargetContext(), LoginActivity.class)));
    }

    @Test
    public void fabIsHidedOnLandscape() {
        mainActivityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        onView(withId(R.id.fab_sign)).check(doesNotExist());
    }


}