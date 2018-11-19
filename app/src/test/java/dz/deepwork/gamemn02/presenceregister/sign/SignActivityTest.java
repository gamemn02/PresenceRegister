package dz.deepwork.gamemn02.presenceregister.sign;

import android.content.Intent;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.android.controller.ActivityController;

import dz.deepwork.gamemn02.presenceregister.PresenceRegisterApplication;
import dz.deepwork.gamemn02.presenceregister.R;
import dz.deepwork.gamemn02.presenceregister.data.Member;
import dz.deepwork.gamemn02.presenceregister.data.MembersRepo;
import dz.deepwork.gamemn02.presenceregister.utils.StringFormats;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
public class SignActivityTest {

    // EXAMPLE MEMBER INFO
    private static final String MEMBER_PASS_NUMBER_EXAMPLE = "123456";
    private static final long MEMBER_ID_EXAMPLE = 1;
    private static final String MEMBER_FIRST_NAME_EXAMPLE = "first";
    private static final String MEMBER_LAST_NAME_EXAMPLE = "last";
    private static final boolean MEMBER_IS_ADMIN_EXAMPLE = false;
    // CORRESPONDING MEMBER
    private static final Member sTestedMember = new Member(
            MEMBER_ID_EXAMPLE,
            MEMBER_FIRST_NAME_EXAMPLE,
            MEMBER_LAST_NAME_EXAMPLE,
            MEMBER_PASS_NUMBER_EXAMPLE,
            MEMBER_IS_ADMIN_EXAMPLE);

    private ActivityController<SignActivity> mSignActivityController;

    @Before
    public void before() {

        MembersRepo mockedMembersRepo = mock(MembersRepo.class);
        when(mockedMembersRepo.findCorrespondingMember(MEMBER_ID_EXAMPLE)).thenReturn(sTestedMember);
        ((PresenceRegisterApplication) RuntimeEnvironment.application).setMemberRepo(mockedMembersRepo);

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.putExtra(SignActivity.EXTRA_PASS_NUMBER, MEMBER_PASS_NUMBER_EXAMPLE);
        intent.putExtra(SignActivity.EXTRA_ID, MEMBER_ID_EXAMPLE);
        mSignActivityController = Robolectric.buildActivity(SignActivity.class, intent).create();
    }

    @Test
    public void showMemberNameBasedOnIntent() {
        SignActivity signActivity = mSignActivityController.get();
        TextView memberNameText = (TextView) signActivity.findViewById(R.id.tv_member_name);

        String expectedMemberName = StringFormats.composeName(sTestedMember.getFirstName(), sTestedMember.getLastName());

        String actualMemberName = memberNameText.getText().toString();
        assertEquals(expectedMemberName, actualMemberName);
    }

    @After
    public void after() {
        mSignActivityController.destroy();
    }
}