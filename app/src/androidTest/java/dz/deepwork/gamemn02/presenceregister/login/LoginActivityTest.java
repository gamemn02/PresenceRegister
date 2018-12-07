package dz.deepwork.gamemn02.presenceregister.login;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import dz.deepwork.gamemn02.presenceregister.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

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

    public static final String TEST_PASS_NUMBER_1 = "012345";

    @Test
    public void typingPassNumber() {
        //when
        onView(ViewMatchers.withId(R.id.btn_digit_0)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.btn_digit_1)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.btn_digit_2)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.btn_digit_3)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.btn_digit_4)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.btn_digit_5)).check(matches(isDisplayed())).perform(click());

        //then
        onView(withId(R.id.et_pass_number)).check(matches(isDisplayed())).check(matches(withText(TEST_PASS_NUMBER_1)));
    }

    public static final String TEST_PASS_NUMBER_2 = "987452";

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
        onView(withId(R.id.et_pass_number)).check(matches(withText(TEST_PASS_NUMBER_2)));
    }

    public static final String TEST_PASS_NUMBER_3 = "98745";

    @Test
    public void clickClearClearsPassNumberField() {
        //when
        onView(withId(R.id.btn_digit_9)).perform(click());
        onView(withId(R.id.btn_digit_8)).perform(click());
        onView(withId(R.id.btn_digit_7)).perform(click());
        onView(withId(R.id.btn_digit_4)).perform(click());
        onView(withId(R.id.btn_digit_5)).perform(click());

        //then
        onView(withId(R.id.et_pass_number)).check(matches(withText(TEST_PASS_NUMBER_3)));

        //when
        onView(withId(R.id.btn_clear)).check(matches(isDisplayed())).perform(click());

        //then
        onView(withId(R.id.et_pass_number)).check(matches(withText("")));
    }



}