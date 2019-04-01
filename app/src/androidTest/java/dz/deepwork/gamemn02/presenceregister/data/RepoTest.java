package dz.deepwork.gamemn02.presenceregister.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import dz.deepwork.gamemn02.presenceregister.AppExecutorsModule;
import dz.deepwork.gamemn02.presenceregister.TestApplicationContextModule;
import dz.deepwork.gamemn02.presenceregister.data.AppDatabase;
import dz.deepwork.gamemn02.presenceregister.data.AppDatabaseModule;
import dz.deepwork.gamemn02.presenceregister.data.DaggerAppDatabaseComponent;
import dz.deepwork.gamemn02.presenceregister.data.TestAppDatabaseModule;
import dz.deepwork.gamemn02.presenceregister.data.members.Member;
import dz.deepwork.gamemn02.presenceregister.data.members.MemberDao;
import dz.deepwork.gamemn02.presenceregister.data.members.MembersModule;
import dz.deepwork.gamemn02.presenceregister.data.members.MembersRepo;
import dz.deepwork.gamemn02.presenceregister.data.members.RealMembersRepo;
import dz.deepwork.gamemn02.presenceregister.data.sessions.RealSessionsRepo;
import dz.deepwork.gamemn02.presenceregister.data.sessions.Session;
import dz.deepwork.gamemn02.presenceregister.data.sessions.SessionDao;
import dz.deepwork.gamemn02.presenceregister.data.sessions.SessionsRepo;
import dz.deepwork.gamemn02.presenceregister.data.signins.SignIn;
import dz.deepwork.gamemn02.presenceregister.data.signins.SignInDao;
import dz.deepwork.gamemn02.presenceregister.data.signs.SignDao;
import dz.deepwork.gamemn02.presenceregister.login.LoginActivity;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.*;

public class RepoTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<>(
            LoginActivity.class);

    AppDatabase appDatabase;
    MembersRepo membersRepo;
    SessionsRepo sessionsRepo;
    SignsRepo signsRepo;

    @Before
    public void setUpDatabase() {
        //when
        RepoComponent repoComponent = DaggerRepoComponent
                .builder()
                .membersModule(new MembersModule())
                .appExecutorsModule(new AppExecutorsModule())
                .applicationContextModule(new TestApplicationContextModule())
                .appDatabaseModule(new AppDatabaseModule())
                .build();
        appDatabase = repoComponent.appDatabase();
        membersRepo = repoComponent.membersRepo();
        sessionsRepo = repoComponent.sessionsRepo();
        signsRepo = repoComponent.signRepo();
    }

    @Test
    public void runMembersRepoAddMemberInUIThreadWithoutThrowing() {

        final CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            mActivityRule.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    membersRepo.addMembers(TestData.MEMBERS);
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await(1, TimeUnit.MINUTES);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            fail();
        }
    }

    @Test
    public void runMembersRepoFindMemberInUIThreadWithoutThrowing() {

        final CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            mActivityRule.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    membersRepo.findMember(TestData.MEMBER1_PASS_NUMBER);
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await(1, TimeUnit.MINUTES);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            fail();
        }
    }

    @Test
    public void runSessionsRepoAddSessionInUIThreadWithoutThrowing() {

        final CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            mActivityRule.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    sessionsRepo.addSessions(TestData.SESSIONS);
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await(1, TimeUnit.MINUTES);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            fail();
        }
    }

    @Test
    public void runSessionsRepoFindSessionInUIThreadWithoutThrowing() {

        final CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            mActivityRule.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    sessionsRepo.findSession(TestData.SESSION1_MEMBER_ID);
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await(1, TimeUnit.MINUTES);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            fail();
        }
    }

    @Test
    public void runSignsRepoSignInInUIThreadWithoutThrowing() {

        final CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            mActivityRule.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    signsRepo.signIn(TestData.SIGN_INS[0]);
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await(1, TimeUnit.MINUTES);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            fail();
        }
    }

    @Test
    public void runSignsRepoSignOutInUIThreadWithoutThrowing() {

        final CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            mActivityRule.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    signsRepo.signOut(TestData.SIGN_INS[0]);
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await(1, TimeUnit.MINUTES);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            fail();
        }
    }

    private CountDownLatch countDownLatch;

    @Test
    public void fetchMembersInsertsToDatabase() throws InterruptedException {
        //when
        membersRepo.fetchMembers();
        Thread.sleep(100);

        //then
        for (Member expectedMember : TestData.MEMBERS) {
            countDownLatch = new CountDownLatch(1);
            LiveData<Member> actualMemberLiveData = membersRepo.findMember(TestData.PASS_NUMBER_1);
            actualMemberLiveData.observeForever(member -> countDownLatch.countDown());
            countDownLatch.await();
            Member actualMember = actualMemberLiveData.getValue();
            actualMember.uId = 0;
            System.out.println(actualMember.name);
            assertEquals(TestData.MEMBERS[0], actualMemberLiveData.getValue());
        }
    }

    @After
    public void closeDatabase() {
        appDatabase.close();
    }
}