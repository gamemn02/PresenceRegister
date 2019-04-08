package dz.deepwork.gamemn02.presenceregister.data.members;

import android.arch.lifecycle.LiveData;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import dz.deepwork.gamemn02.presenceregister.data.NetworkService;

public class RealMembersRepo implements MembersRepo{
    private MemberDao mMemberDao;
    private Executor mDbExecutor;
    private NetworkService mNetworkService;

    @Inject
    public RealMembersRepo(MemberDao memberDao, Executor dbExecutor, NetworkService networkService) {
        this.mMemberDao = memberDao;
        this.mDbExecutor = dbExecutor;
        this.mNetworkService = networkService;
    }

    @Override
    public LiveData<Member> findMember(String passNumber) {
        return mMemberDao.find(passNumber);
    }

    @Override
    public void addMembers(final Member... members) {
        mDbExecutor.execute(() -> mMemberDao.insert(members));
    }

    @Override
    public void fetchMembers() {
        mNetworkService.fetchMembers().observeForever(members -> mDbExecutor.execute(() -> {
            mMemberDao.deleteAll();
            mMemberDao.insert((Member[]) members.toArray());
        }));
    }
}
