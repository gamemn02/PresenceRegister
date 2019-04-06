package dz.deepwork.gamemn02.presenceregister.login;

import android.content.ComponentName;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import dz.deepwork.gamemn02.presenceregister.R;
import dz.deepwork.gamemn02.presenceregister.sign.SignActivity;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public IntentsTestRule<LoginActivity> loginActivityTestRule =
            new IntentsTestRule<>(LoginActivity.class);

    @Test
    public void typingPassNumber() {
        // Check login fragment
        onView(withId(R.id.layout_login)).check(matches(isDisplayed()));
        onView(withId(R.id.layout_login)).check(matches(withParent(withId(R.id.frame_login))));

        // Enter incomplete pass number
        onView(withId(R.id.btn_digit_9)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.btn_digit_8)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.btn_digit_7)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.btn_digit_4)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.btn_digit_5)).check(matches(isDisplayed())).perform(click());
        // Check pass number field
        onView(withId(R.id.et_pass_number)).check(matches(isDisplayed())).check(matches(withText("98745")));

        // Press clear button
        onView(withId(R.id.btn_clear)).check(matches(isDisplayed())).perform(click());
        // Check pass number field
        onView(withId(R.id.et_pass_number)).check(matches(withText("")));

        // Enter Wrong pass number
        onView(withId(R.id.btn_digit_1)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.btn_digit_2)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.btn_digit_6)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.btn_digit_5)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.btn_digit_4)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.btn_digit_3)).check(matches(isDisplayed())).perform(click());
        // Check pass number field
        onView(withId(R.id.et_pass_number)).check(matches(withText("")));

        // Enter Correct pass number
        onView(withId(R.id.btn_digit_1)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.btn_digit_2)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.btn_digit_3)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.btn_digit_4)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.btn_digit_5)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.btn_digit_6)).check(matches(isDisplayed())).perform(click());
        // Check sign activity
        intended(hasComponent(new ComponentName(getTargetContext(), SignActivity.class)));
    }

}