package dz.deepwork.gamemn02.presenceregister.data.members;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.LiveData;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import dz.deepwork.gamemn02.presenceregister.data.TestData;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RealMembersRepoTest {


    @Mock
    MemberDao memberDao;

    Executor mDbExecutor = Executors.newSingleThreadExecutor();
    TestMemberNetworkService memberNetworkService = new TestMemberNetworkService(mDbExecutor);
    @InjectMocks
    RealMembersRepo realMembersRepo = new RealMembersRepo(memberDao, mDbExecutor, memberNetworkService);

    @Test
    public void addMembersCallsMemberDaoInsert() throws InterruptedException {

        //when
        realMembersRepo.addMembers(TestData.MEMBERS[0]);
        Thread.sleep(100);

        //then
        verify(memberDao).insert(TestData.MEMBERS[0]);
    }

    @Test
    public void findMemberCallsMemberDaoFind() throws InterruptedException {

        //when
        realMembersRepo.findMember(TestData.MEMBER1_PASS_NUMBER);
        Thread.sleep(100);

        //then
        verify(memberDao).find(TestData.MEMBER1_PASS_NUMBER);
    }

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Test
    public void fetchMembersCallsMemberDaoInsert() throws InterruptedException {
        //when
        realMembersRepo.fetchMembers();
        Thread.sleep(100);

        //then
        verify(memberDao).insert(TestData.MEMBERS);
    }
}
