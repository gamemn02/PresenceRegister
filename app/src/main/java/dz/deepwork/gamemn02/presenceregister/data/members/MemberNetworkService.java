package dz.deepwork.gamemn02.presenceregister.data.members;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;

public class MemberNetworkService {

    private static final List<Member> MEMBERS_EXAMPLE = Arrays.asList(
            new Member("name1", "123456", false),
            new Member("name2", "012345", false),
            new Member("name3", "987456", true),
            new Member("name4", "547126", false));

    private Executor mNetworkExecutor;

    public MemberNetworkService(Executor networkExecutor) {
        mNetworkExecutor = networkExecutor;
    }

    public LiveData<List<Member>> fetchMembers() {
        final MutableLiveData<List<Member>> fetchedMembers = new MutableLiveData<>();
        mNetworkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                fetchedMembers.postValue(getExampleMembers());
            }
        });
        return fetchedMembers;
    }

    public List<Member> getExampleMembers() {
        return MEMBERS_EXAMPLE;
    }
}
