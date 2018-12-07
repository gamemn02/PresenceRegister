package dz.deepwork.gamemn02.presenceregister.data.members;

import javax.inject.Inject;

public class RealMembersRepo implements MembersRepo{
    private MemberDao mMemberDao;

    @Inject
    public RealMembersRepo(MemberDao memberDao) {
        this.mMemberDao = memberDao;
    }

    @Override
    public Member findMember(String passNumber) {
        return mMemberDao.find(passNumber);
    }
}
