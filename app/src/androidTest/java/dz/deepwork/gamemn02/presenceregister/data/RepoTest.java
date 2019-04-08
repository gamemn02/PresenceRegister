package dz.deepwork.gamemn02.presenceregister.data;

import android.arch.lifecycle.LiveData;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import dz.deepwork.gamemn02.presenceregister.AppExecutorsModule;
import dz.deepwork.gamemn02.presenceregister.TestApplicationContextModule;
import dz.deepwork.gamemn02.presenceregister.data.members.Member;
import dz.deepwork.gamemn02.presenceregister.data.members.MembersModule;
import dz.deepwork.gamemn02.presenceregister.data.members.MembersRepo;
import dz.deepwork.gamemn02.presenceregister.data.sessions.Session;
import dz.deepwork.gamemn02.presenceregister.data.sessions.SessionsRepo;
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
            mActivityRule.runOnUiThread(() -> {
                membersRepo.addMembers(TestData.MEMBERS);
                countDownLatch.countDown();
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
            mActivityRule.runOnUiThread(() -> {
                membersRepo.findMember(TestData.MEMBER1_PASS_NUMBER);
                countDownLatch.countDown();
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
            mActivityRule.runOnUiThread(() -> {
                sessionsRepo.addSessions(TestData.SESSIONS);
                countDownLatch.countDown();
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
            mActivityRule.runOnUiThread(() -> {
                sessionsRepo.findSession(TestData.SESSION1_MEMBER_PASS_NUMBER, TestData.SESSION1_TIME);
                countDownLatch.countDown();
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
            mActivityRule.runOnUiThread(() -> {
                signsRepo.signIn(TestData.SIGN_INS[0]);
                countDownLatch.countDown();
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
            mActivityRule.runOnUiThread(() -> {
                signsRepo.signOut(TestData.SIGN_INS[0]);
                countDownLatch.countDown();
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

        for (Member expectedMember : TestData.MEMBERS) {
            countDownLatch = new CountDownLatch(1);
            LiveData<Member> actualMemberLiveData =
                    membersRepo.findMember(expectedMember.passNumber);
            actualMemberLiveData.observeForever(member -> countDownLatch.countDown());
            countDownLatch.await();

            //then
            assertEquals(expectedMember, actualMemberLiveData.getValue());
        }
    }

    @Test
    public void fetchSessionsInsertsToDatabase() throws InterruptedException {
        //when
        sessionsRepo.fetchSessions();
        Thread.sleep(100);

        for (Session expectedSession : TestData.SESSIONS) {
            countDownLatch = new CountDownLatch(1);
            LiveData<Session> actualSessionLiveData =
                    sessionsRepo.findSession(expectedSession.memberPassNumber, expectedSession.time);
            actualSessionLiveData.observeForever(session -> countDownLatch.countDown());
            countDownLatch.await();

            //then
            assertEquals(expectedSession, actualSessionLiveData.getValue());
        }
    }

    @After
    public void closeDatabase() {
        appDatabase.close();
    }
}