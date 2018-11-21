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

import dz.deepwork.gamemn02.presenceregister.R;
import dz.deepwork.gamemn02.presenceregister.data.TestMembersRepoModule;
import dz.deepwork.gamemn02.presenceregister.data.members.DaggerMembersRepoComponent;
import dz.deepwork.gamemn02.presenceregister.data.members.MembersRepoComponent;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(RobolectricTestRunner.class)
public class SignActivityTest {

    private ActivityController<SignActivity> mSignActivityController;

    @Before
    public void before() {
        MembersRepoComponent daggerMembersRepoComponent = DaggerMembersRepoComponent
                .builder()
                .membersRepoModule(new TestMembersRepoModule())
                .build();
        MembersRepoComponent.Singleton.set(daggerMembersRepoComponent);

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.putExtra(SignActivity.EXTRA_PASS_NUMBER, TestMembersRepoModule.getTestedPassNumber());
        mSignActivityController = Robolectric.buildActivity(SignActivity.class, intent).create();
    }

    @Test
    public void showMemberNameBasedOnIntent() {

        SignActivity signActivity = mSignActivityController.get();
        TextView memberNameText = (TextView) signActivity.findViewById(R.id.tv_member_name);

        String expectedMemberName = TestMembersRepoModule.getTestedMember().name;
        String actualMemberName = memberNameText.getText().toString();
        assertEquals(expectedMemberName, actualMemberName);
    }

    @After
    public void after() {
        mSignActivityController.destroy();
    }
}