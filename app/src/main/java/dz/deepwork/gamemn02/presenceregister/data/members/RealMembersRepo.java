package dz.deepwork.gamemn02.presenceregister.data.members;

import android.arch.lifecycle.LiveData;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Inject;

public class RealMembersRepo implements MembersRepo{
    private MemberDao mMemberDao;
    private Executor mDbExecutor;

    @Inject
    public RealMembersRepo(MemberDao memberDao, Executor dbExecutor) {
        this.mMemberDao = memberDao;
        this.mDbExecutor = dbExecutor;
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
}
