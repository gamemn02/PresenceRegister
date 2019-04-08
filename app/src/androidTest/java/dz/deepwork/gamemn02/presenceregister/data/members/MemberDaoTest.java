package dz.deepwork.gamemn02.presenceregister.data.members;

import android.arch.lifecycle.LiveData;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import dz.deepwork.gamemn02.presenceregister.TestApplicationContextModule;
import dz.deepwork.gamemn02.presenceregister.data.AppDatabase;
import dz.deepwork.gamemn02.presenceregister.data.DaggerAppDatabaseComponent;
import dz.deepwork.gamemn02.presenceregister.data.LiveDataTestUtils;
import dz.deepwork.gamemn02.presenceregister.data.TestAppDatabaseModule;
import dz.deepwork.gamemn02.presenceregister.data.TestData;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertNotEquals;

@RunWith(AndroidJUnit4.class)
public class MemberDaoTest {

    AppDatabase appDatabase;
    MemberDao memberDao;

    @Before
    public void before() {
        appDatabase = DaggerAppDatabaseComponent.Singleton
                .getAppDatabase(new TestApplicationContextModule(), new TestAppDatabaseModule());
        memberDao = appDatabase.getMemberDao();
    }


    @Test
    public void insertAndFind() throws InterruptedException {
        //when
        memberDao.insert(TestData.MEMBERS);
        LiveData<Member> actualMemberLiveData = memberDao.find(TestData.MEMBERS[1].passNumber);
        Member actualMember = LiveDataTestUtils.getValue(actualMemberLiveData);
        Member expectedMember = TestData.MEMBERS[1];
        Member wrongMember = TestData.MEMBERS[2];

        //then
        assertEquals("actual member does't match the expected member", expectedMember, actualMember);
        assertNotEquals("actual member matches the wrong member", wrongMember, actualMember);

    }

    private CountDownLatch countDownLatch;

    @Test
    public void delete() throws InterruptedException {
        //when
        memberDao.insert(TestData.MEMBERS);
        memberDao.deleteAll();

        //then
        for (Member expectedMember : TestData.MEMBERS) {
            countDownLatch = new CountDownLatch(1);
            LiveData<Member> actualMemberLiveData = memberDao.find(expectedMember.passNumber);
            actualMemberLiveData.observeForever(member -> countDownLatch.countDown());
            countDownLatch.await();
            assertNull(actualMemberLiveData.getValue());
        }
    }

    @After
    public void after() {
        appDatabase.close();
    }

}
