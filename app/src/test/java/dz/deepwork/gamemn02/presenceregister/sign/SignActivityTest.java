package dz.deepwork.gamemn02.presenceregister.sign;

import android.content.Intent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.android.controller.ActivityController;

import dz.deepwork.gamemn02.presenceregister.ApplicationContextModule;
import dz.deepwork.gamemn02.presenceregister.data.AppDatabaseModule;
import dz.deepwork.gamemn02.presenceregister.data.DaggerRepoComponent;
import dz.deepwork.gamemn02.presenceregister.data.RepoComponent;
import dz.deepwork.gamemn02.presenceregister.data.TestMembersModule;


@RunWith(RobolectricTestRunner.class)
public class SignActivityTest {

    private ActivityController<SignActivity> mSignActivityController;
    private SignActivity mSignActivity;

    @Before
    public void before() {
//        RepoComponent daggerRepoComponent = DaggerRepoComponent
//                .builder()
//                .applicationContextModule(new ApplicationContextModule(RuntimeEnvironment.application))
//                .appDatabaseModule(new AppDatabaseModule())
//                .membersModule(new TestMembersModule())
//                .build();
//        RepoComponent.Singleton.set(daggerRepoComponent);
//
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.putExtra(SignActivity.EXTRA_MEMBER_PASS_NUMBER, TestMembersModule.getTestedPassNumber());
//        mSignActivityController = Robolectric.buildActivity(SignActivity.class, intent).create();
//        mSignActivity = mSignActivityController.get();
//        mSignActivityController.start().resume();
    }

    @Test
    public void showMemberNameBasedOnIntent() {
//
//        // when
//        TextView memberNameText = (TextView) mSignActivity.findViewById(R.id.tv_member_name);
//        String expectedMemberName = TestMembersModule.getTestedMember().name;
//        String actualMemberName = memberNameText.getText().toString();
//        // then
//        assertEquals(expectedMemberName, actualMemberName);
    }

    @After
    public void after() {
//        mSignActivityController.pause().stop().destroy();
    }
}