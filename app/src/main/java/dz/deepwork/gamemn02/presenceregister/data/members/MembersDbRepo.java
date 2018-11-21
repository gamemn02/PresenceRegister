package dz.deepwork.gamemn02.presenceregister.data.members;

import javax.inject.Inject;

public class MembersDbRepo implements MembersRepo{
    private MemberDao mMemberDao;

    @Inject
    public MembersDbRepo(MemberDao memberDao) {
        this.mMemberDao = memberDao;
    }

    @Override
    public Member findMember(String passNumber) {
        return null;
    }
}
