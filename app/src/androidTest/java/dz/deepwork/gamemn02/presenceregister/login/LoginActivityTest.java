package dz.deepwork.gamemn02.presenceregister.login;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

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

//    @Test
//    public void typingPassNumber() {
//        //when
//        onView(withId(R.id.btn_digit_1)).check(matches(isDisplayed())).perform(click());
//        onView(withId(R.id.btn_digit_2)).check(matches(isDisplayed())).perform(click());
//        onView(withId(R.id.btn_digit_3)).check(matches(isDisplayed())).perform(click());
//        onView(withId(R.id.btn_digit_4)).check(matches(isDisplayed())).perform(click());
//        onView(withId(R.id.btn_digit_5)).check(matches(isDisplayed())).perform(click());
//        onView(withId(R.id.btn_digit_6)).check(matches(isDisplayed())).perform(click());
//
//        //then
//        onView(withId(R.id.et_pass_number)).check(matches(isDisplayed())).check(matches(withText(TestData.PASS_NUMBER_1)));
//    }
//
//    @Test
//    public void clickClearClearsPassNumberField() {
//        //when
//        onView(withId(R.id.btn_digit_9)).perform(click());
//        onView(withId(R.id.btn_digit_8)).perform(click());
//        onView(withId(R.id.btn_digit_7)).perform(click());
//        onView(withId(R.id.btn_digit_4)).perform(click());
//        onView(withId(R.id.btn_digit_5)).perform(click());
//
//        //then
//        onView(withId(R.id.et_pass_number)).check(matches(withText(TestData.PASS_NUMBER_4)));
//
//        //when
//        onView(withId(R.id.btn_clear)).check(matches(isDisplayed())).perform(click());
//
//        //then
//        onView(withId(R.id.et_pass_number)).check(matches(withText("")));
//    }

}