package dz.deepwork.gamemn02.presenceregister.data.members;

import android.arch.lifecycle.LiveData;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import dz.deepwork.gamemn02.presenceregister.ApplicationContextModule;
import dz.deepwork.gamemn02.presenceregister.TestApplicationContextModule;
import dz.deepwork.gamemn02.presenceregister.data.AppDatabase;
import dz.deepwork.gamemn02.presenceregister.data.AppDatabaseModule;
import dz.deepwork.gamemn02.presenceregister.data.DaggerAppDatabaseComponent;
import dz.deepwork.gamemn02.presenceregister.data.LiveDataTestUtils;
import dz.deepwork.gamemn02.presenceregister.data.TestAppDatabaseModule;
import dz.deepwork.gamemn02.presenceregister.data.TestData;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
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
        long[] ids = memberDao.insert(TestData.MEMBERS);
        LiveData<Member> actualMemberLiveData = memberDao.find(TestData.MEMBERS[1].passNumber);
        Member actualMember = LiveDataTestUtils.getValue(actualMemberLiveData);
        Member expectedMember = TestData.MEMBERS[1];
        Member wrongMember = TestData.MEMBERS[2];
        expectedMember.uId = ids[1];
        wrongMember.uId = ids[2];

        //then
        assertEquals("actual member does't match the expected member", expectedMember, actualMember);
        assertNotEquals("actual member matches the wrong member", wrongMember, actualMember);

    }

    @Test
    public void get() {
        //when
        long[] ids = memberDao.insert(TestData.MEMBERS);
        Member actualMember = memberDao.get(ids[1]);
        Member expectedMember = TestData.MEMBERS[1];
        Member wrongMember = TestData.MEMBERS[2];
        expectedMember.uId = ids[1];
        wrongMember.uId = ids[2];

        //then
        assertEquals("actual member does't match the expected member", expectedMember, actualMember);
        assertNotEquals("actual member matches the wrong member", wrongMember, actualMember);
    }

    @After
    public void after() {
        appDatabase.close();
    }

}
