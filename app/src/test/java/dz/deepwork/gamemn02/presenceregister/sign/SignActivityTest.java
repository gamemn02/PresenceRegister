package dz.deepwork.gamemn02.presenceregister.sign;

import android.content.Intent;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.android.controller.ActivityController;

import dz.deepwork.gamemn02.presenceregister.PresenceRegisterApplication;
import dz.deepwork.gamemn02.presenceregister.R;
import dz.deepwork.gamemn02.presenceregister.data.members.Member;
import dz.deepwork.gamemn02.presenceregister.data.members.MembersRepo;
import dz.deepwork.gamemn02.presenceregister.utils.StringFormats;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
public class SignActivityTest {

    // EXAMPLE MEMBER INFO
    private static final String MEMBER_PASS_NUMBER_EXAMPLE = "123456";
    private static final String MEMBER_NAME_EXAMPLE = "FirstName LastName";
    private static final boolean MEMBER_IS_ADMIN_EXAMPLE = false;
    // CORRESPONDING MEMBER
    private static final Member sTestedMember = new Member(
            MEMBER_NAME_EXAMPLE,
            MEMBER_PASS_NUMBER_EXAMPLE,
            MEMBER_IS_ADMIN_EXAMPLE);

    private ActivityController<SignActivity> mSignActivityController;

    @Before
    public void before() {

        MembersRepo mockedMembersRepo = mock(MembersRepo.class);
        when(mockedMembersRepo.findMember(MEMBER_PASS_NUMBER_EXAMPLE)).thenReturn(sTestedMember);
        ((PresenceRegisterApplication) RuntimeEnvironment.application).setMemberRepo(mockedMembersRepo);

        System.out.print("expected name:" + mockedMembersRepo.findMember(MEMBER_PASS_NUMBER_EXAMPLE).name);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.putExtra(SignActivity.EXTRA_PASS_NUMBER, MEMBER_PASS_NUMBER_EXAMPLE);
        mSignActivityController = Robolectric.buildActivity(SignActivity.class, intent).create();
    }

    @Test
    public void showMemberNameBasedOnIntent() {

        SignActivity signActivity = mSignActivityController.get();
        TextView memberNameText = (TextView) signActivity.findViewById(R.id.tv_member_name);

        String expectedMemberName = sTestedMember.name;
        String actualMemberName = memberNameText.getText().toString();
        assertEquals(expectedMemberName, actualMemberName);
    }

    @After
    public void after() {
        mSignActivityController.destroy();
    }
}