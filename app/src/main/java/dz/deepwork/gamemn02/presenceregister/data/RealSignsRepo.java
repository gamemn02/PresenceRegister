package dz.deepwork.gamemn02.presenceregister.data;

import java.util.concurrent.Executor;

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

    public void signIn(final SignIn signIn) {
        mDbExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mSignInDao.insert(signIn);
            }
        });
    }

    public SignIn findSignIn(long sessionId) {
        return mSignInDao.find(sessionId);
    }

    public void signOut(SignIn signIn) {

        mSignInDao.delete(signIn);
        Session session = mSessionDao.get(signIn.sessionId);
        String memberName = mMemberDao.get(session.memberId).name;
        long signOutTime = signIn.time + 1;
        String details = session.details;
        Sign sign = new Sign(memberName, signIn.time, signOutTime, signIn.room, details);
        mSignDao.insert(sign);

    }
}
