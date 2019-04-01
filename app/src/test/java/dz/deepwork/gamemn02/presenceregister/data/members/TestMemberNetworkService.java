package dz.deepwork.gamemn02.presenceregister.data.members;

import android.arch.lifecycle.LiveData;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;

import dz.deepwork.gamemn02.presenceregister.data.TestData;

public class TestMemberNetworkService extends MemberNetworkService {

    public TestMemberNetworkService(Executor networkExecutor) {
        super(networkExecutor);
    }

    @Override
    public List<Member> getExampleMembers() {
        return Arrays.asList(TestData.MEMBERS);
    }
}
