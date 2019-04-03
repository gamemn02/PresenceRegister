package dz.deepwork.gamemn02.presenceregister.login;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import dz.deepwork.gamemn02.presenceregister.R;
import dz.deepwork.gamemn02.presenceregister.data.TestData;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> loginActivityTestRule =
            new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void showLoginFragment() {

        onView(withId(R.id.layout_login)).check(matches(isDisplayed()));
        onView(withId(R.id.layout_login)).check(matches(withParent(withId(R.id.frame_login))));
    }

    @Test
    public void typingPassNumber() {
        //when
        onView(withId(R.id.btn_digit_1)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.btn_digit_2)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.btn_digit_3)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.btn_digit_4)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.btn_digit_5)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.btn_digit_6)).check(matches(isDisplayed())).perform(click());

        //then
        onView(withId(R.id.et_pass_number)).check(matches(isDisplayed())).check(matches(withText(TestData.PASS_NUMBER_1)));

        //when
        onView(withId(R.id.btn_clear)).check(matches(isDisplayed())).perform(click());

        //then
        onView(withId(R.id.et_pass_number)).check(matches(withText("")));
    }

}