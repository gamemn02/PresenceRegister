package dz.deepwork.gamemn02.presenceregister.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import dz.deepwork.gamemn02.presenceregister.data.members.Member;
import dz.deepwork.gamemn02.presenceregister.data.members.MemberDao;
import dz.deepwork.gamemn02.presenceregister.data.members.MembersRepo;
import dz.deepwork.gamemn02.presenceregister.data.members.MembersModule;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestMembersModule extends MembersModule {
    // EXAMPLE MEMBER INFO
    private static final String MEMBER_PASS_NUMBER_EXAMPLE = "123456";
    private static final String MEMBER_NAME_EXAMPLE = "FirstName LastName";
    private static final boolean MEMBER_IS_ADMIN_EXAMPLE = false;
    // CORRESPONDING MEMBER
    private static final Member sTestedMember = new Member(
            MEMBER_NAME_EXAMPLE,
            MEMBER_PASS_NUMBER_EXAMPLE,
            MEMBER_IS_ADMIN_EXAMPLE);


    @Override
    public MembersRepo provideMembersRepo(MemberDao memberDao, Executor dbExecutor) {
        MembersRepo mockedMembersRepo = mock(MembersRepo.class);
        final MutableLiveData<Member> testedMemberLiveData = new MutableLiveData<>();
        testedMemberLiveData.postValue(sTestedMember);
        when(mockedMembersRepo.findMember(MEMBER_PASS_NUMBER_EXAMPLE)).thenReturn(testedMemberLiveData);
        return mockedMembersRepo;
    }

    static public String getTestedPassNumber() {
        return MEMBER_PASS_NUMBER_EXAMPLE;
    }

    static public Member getTestedMember() {
        return sTestedMember;
    }
}
