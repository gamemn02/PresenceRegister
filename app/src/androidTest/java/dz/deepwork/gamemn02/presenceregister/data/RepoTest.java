package dz.deepwork.gamemn02.presenceregister.data;

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
import dz.deepwork.gamemn02.presenceregister.data.signins.SignInDao;
import dz.deepwork.gamemn02.presenceregister.data.signs.SignDao;
import dz.deepwork.gamemn02.presenceregister.login.LoginActivity;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.*;

public class RepoTest {

    private static final Member[] TEST_MEMBERS = {
            new Member("name1", "123456", false)
    };
    private static final Session[] TEST_SESSIONS = {
            new Session(1, 2, 1, "B001", "Rec E147")
    };
    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<>(
            LoginActivity.class);


    AppDatabase appDatabase;
    MembersRepo membersRepo;
    RealSessionsRepo sessionsRepo;

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
        sessionsRepo = new RealSessionsRepo(appDatabase.getSessionDao());
    }

    @Test
    public void runMembersRepoAddMemberInUIThread() {

        final CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            mActivityRule.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    membersRepo.addMembers(TEST_MEMBERS);
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
    public void runSessionsRepoAddSessionInUIThread() {

        final CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            mActivityRule.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    sessionsRepo.addSessions(TEST_SESSIONS);
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await(1, TimeUnit.MINUTES);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            fail();
        }
    }

    @After
    public void closeDatabase() {
        appDatabase.close();
    }
}

// TODO: make all constant test fields in public class