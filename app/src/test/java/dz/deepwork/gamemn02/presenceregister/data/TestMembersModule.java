package dz.deepwork.gamemn02.presenceregister.data;

import android.arch.lifecycle.MutableLiveData;

import java.util.concurrent.Executor;

import dz.deepwork.gamemn02.presenceregister.data.members.Member;
import dz.deepwork.gamemn02.presenceregister.data.members.MemberDao;
import dz.deepwork.gamemn02.presenceregister.data.members.MembersRepo;
import dz.deepwork.gamemn02.presenceregister.data.members.MembersModule;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestMembersModule extends MembersModule {

    @Override
    public MembersRepo provideMembersRepo(MemberDao memberDao, Executor dbExecutor, NetworkService networkService) {
        MembersRepo mockedMembersRepo = mock(MembersRepo.class);
        final MutableLiveData<Member> testedMemberLiveData = new MutableLiveData<>();
        testedMemberLiveData.postValue(getTestedMember());
        when(mockedMembersRepo.findMember(getTestedPassNumber())).thenReturn(testedMemberLiveData);
        return mockedMembersRepo;
    }

    static public String getTestedPassNumber() {
        return TestData.MEMBERS[0].passNumber;
    }

    static public Member getTestedMember() {
        return TestData.MEMBERS[0];
    }
}
