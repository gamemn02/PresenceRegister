package dz.deepwork.gamemn02.presenceregister.data.members;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Inject;

public class RealMembersRepo implements MembersRepo{
    private MemberDao mMemberDao;
    private Executor mDbExecutor;
    private MemberNetworkService mMemberNetworkService;

    @Inject
    public RealMembersRepo(MemberDao memberDao, Executor dbExecutor, MemberNetworkService memberNetworkService) {
        this.mMemberDao = memberDao;
        this.mDbExecutor = dbExecutor;
        this.mMemberNetworkService = memberNetworkService;
    }

    @Override
    public LiveData<Member> findMember(String passNumber) {
        return mMemberDao.find(passNumber);
    }

    @Override
    public void addMembers(final Member... members) {
        mDbExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mMemberDao.insert(members);
            }
        });
    }

    // TODO: change all to lambda

    @Override
    public void fetchMembers() {
        mMemberNetworkService.fetchMembers().observeForever(new Observer<List<Member>>() {
            @Override
            public void onChanged(@Nullable List<Member> members) {
                mDbExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        mMemberDao.deleteAll();
                        mMemberDao.insert((Member[]) members.toArray());
                    }
                });
            }
        });
    }
}
