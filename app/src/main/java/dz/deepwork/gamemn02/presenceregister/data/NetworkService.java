package dz.deepwork.gamemn02.presenceregister.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;

import dz.deepwork.gamemn02.presenceregister.data.TestData;
import dz.deepwork.gamemn02.presenceregister.data.members.Member;

public class NetworkService {

    private Executor mNetworkExecutor;

    public NetworkService(Executor networkExecutor) {
        mNetworkExecutor = networkExecutor;
    }

    public LiveData<List<Member>> fetchMembers() {
        final MutableLiveData<List<Member>> fetchedMembers = new MutableLiveData<>();
        mNetworkExecutor.execute(() -> fetchedMembers.postValue(getExampleMembers()));
        return fetchedMembers;
    }

    public List<Member> getExampleMembers() {
        return Arrays.asList(TestData.MEMBERS);
    }
}
