package dz.deepwork.gamemn02.presenceregister;

import android.widget.Button;
import android.widget.EditText;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadow.api.Shadow;
import org.robolectric.shadows.ShadowApplication;

import static org.junit.Assert.*;
import static org.robolectric.Robolectric.setupActivity;

@RunWith(RobolectricTestRunner.class)
public class LoginActivityTest {

    @Test
    public void maxPassNumberLengthIsCorrect() {
        // when
        LoginActivity loginActivity = setupActivity(LoginActivity.class);
        int maxLength = 6;
        ((Button) loginActivity.findViewById(R.id.btn_digit_0)).performClick();
        ((Button) loginActivity.findViewById(R.id.btn_digit_2)).performClick();
        ((Button) loginActivity.findViewById(R.id.btn_digit_1)).performClick();
        ((Button) loginActivity.findViewById(R.id.btn_digit_4)).performClick();
        ((Button) loginActivity.findViewById(R.id.btn_digit_5)).performClick();
        ((Button) loginActivity.findViewById(R.id.btn_digit_4)).performClick();
        ((Button) loginActivity.findViewById(R.id.btn_digit_8)).performClick();
        ((Button) loginActivity.findViewById(R.id.btn_digit_6)).performClick();

        // than
        assertEquals("021454", ((EditText) loginActivity.findViewById(R.id.et_pass_number))
                .getText().toString());
    }

}