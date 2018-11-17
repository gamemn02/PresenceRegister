package dz.deepwork.gamemn02.presenceregister;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> loginActivityTestRule =
            new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void viewIt() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void typingPassNumber() {
        //when
        onView(withId(R.id.btn_digit_0)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.btn_digit_1)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.btn_digit_2)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.btn_digit_3)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.btn_digit_4)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.btn_digit_5)).check(matches(isDisplayed())).perform(click());

        //then
        onView(withId(R.id.et_pass_number)).check(matches(isDisplayed())).check(matches(withText("012345")));
    }

    @Test
    public void typingAnotherPassNumber() {
        //when
        onView(withId(R.id.btn_digit_9)).perform(click());
        onView(withId(R.id.btn_digit_8)).perform(click());
        onView(withId(R.id.btn_digit_7)).perform(click());
        onView(withId(R.id.btn_digit_4)).perform(click());
        onView(withId(R.id.btn_digit_5)).perform(click());
        onView(withId(R.id.btn_digit_2)).perform(click());

        //then
        onView(withId(R.id.et_pass_number)).check(matches(withText("987452")));
    }

    @Test
    public void clickClearClearsPassNumberField() {
        //when
        onView(withId(R.id.btn_digit_9)).perform(click());
        onView(withId(R.id.btn_digit_8)).perform(click());
        onView(withId(R.id.btn_digit_7)).perform(click());
        onView(withId(R.id.btn_digit_4)).perform(click());
        onView(withId(R.id.btn_digit_5)).perform(click());

        //then
        onView(withId(R.id.et_pass_number)).check(matches(withText("98745")));

        //when
        onView(withId(R.id.btn_clear)).check(matches(isDisplayed())).perform(click());

        //then
        onView(withId(R.id.et_pass_number)).check(matches(withText("")));
    }

}