package dz.deepwork.gamemn02.presenceregister.data;

import java.util.concurrent.Executor;

import dz.deepwork.gamemn02.presenceregister.Notified;
import dz.deepwork.gamemn02.presenceregister.data.members.MemberDao;
import dz.deepwork.gamemn02.presenceregister.data.sessions.Session;
import dz.deepwork.gamemn02.presenceregister.data.sessions.SessionDao;
import dz.deepwork.gamemn02.presenceregister.data.signins.SignIn;
import dz.deepwork.gamemn02.presenceregister.data.signins.SignInDao;
import dz.deepwork.gamemn02.presenceregister.data.signs.Sign;
import dz.deepwork.gamemn02.presenceregister.data.signs.SignDao;

public class RealSignsRepo implements SignsRepo {

    private MemberDao mMemberDao;
    private SessionDao mSessionDao;
    private SignInDao mSignInDao;
    private SignDao mSignDao;
    private Executor mDbExecutor;

    public RealSignsRepo(MemberDao memberDao, SessionDao sessionDao, SignInDao signInDao,
                         SignDao signDao, Executor dbExecutor) {
        mMemberDao = memberDao;
        mSessionDao = sessionDao;
        mSignInDao = signInDao;
        mSignDao = signDao;
        mDbExecutor = dbExecutor;
    }

    @Override
    public void signIn(final SignIn signIn, Notified notified) {
        mDbExecutor.execute(() -> {
            mSignInDao.insert(signIn);
            notified.onNotified();
        });
    }

    @Override
    public SignIn findSignIn(long sessionId) {
        return mSignInDao.find(sessionId);
    }

    @Override
    public void signOut(final SignIn signIn) {

        mDbExecutor.execute(() -> {
            mSignInDao.delete(signIn);
            Session session = mSessionDao.get(signIn.sessionId);
            if (session != null) {
                mMemberDao.find(session.memberPassNumber).observeForever(member -> {
                    if (member != null) {
                        String memberName = member.name;
                        long signOutTime = signIn.time + 1;
                        String details = session.details;
                        Sign sign = new Sign(memberName, signIn.time, signOutTime, signIn.room, details);
                        mSignDao.insert(sign);
                    }
                });
            }
        });
    }
}
