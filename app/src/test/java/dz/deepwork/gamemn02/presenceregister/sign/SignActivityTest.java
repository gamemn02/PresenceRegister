package dz.deepwork.gamemn02.presenceregister.sign;

import android.content.Intent;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.shadows.ShadowApplication;

import dz.deepwork.gamemn02.presenceregister.R;
import dz.deepwork.gamemn02.presenceregister.data.MemberRepo;
import dz.deepwork.gamemn02.presenceregister.login.LoginActivity;
import dz.deepwork.gamemn02.presenceregister.utils.StringFormats;

import static org.junit.Assert.*;
import static org.robolectric.Robolectric.setupActivity;

@RunWith(RobolectricTestRunner.class)
public class SignActivityTest {

    // EXAMPLE MEMBER PASS NUMBER AND ID
    public static final String MEMBER_PASS_NUMBER_EXAMPLE = "123456";
    private static final long MEMBER_ID_EXAMPLE = 1;
    private ActivityController<SignActivity> mSignActivityController;

    @Before
    public void before() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.putExtra(SignActivity.EXTRA_PASS_NUMBER, MEMBER_PASS_NUMBER_EXAMPLE);
        intent.putExtra(SignActivity.EXTRA_ID, MEMBER_ID_EXAMPLE);
        mSignActivityController = Robolectric.buildActivity(SignActivity.class, intent).create();
    }

    @Test
    public void showMemberNameBasedOnIntent() {
        SignActivity signActivity = mSignActivityController.get();
        TextView memberNameText = (TextView) signActivity.findViewById(R.id.tv_member_name);
        String actualMemberName = memberNameText.getText().toString();
        String expectedMemberName = StringFormats.composeName(
                MemberRepo.MEMBER_FIRST_NAME_EXAMPLE,
                MemberRepo.MEMBER_LAST_NAME_EXAMPLE);
        assertEquals(expectedMemberName, actualMemberName);
    }

    @After
    public void after() {
        mSignActivityController.destroy();
    }
}