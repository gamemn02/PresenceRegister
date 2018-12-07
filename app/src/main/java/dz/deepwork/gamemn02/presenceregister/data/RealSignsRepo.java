package dz.deepwork.gamemn02.presenceregister.data;

import dz.deepwork.gamemn02.presenceregister.data.signins.SignIn;
import dz.deepwork.gamemn02.presenceregister.data.signins.SignInDao;

public class RealSignsRepo {

    private SignInDao mSignInDao;

    public RealSignsRepo(SignInDao signInDao) {
        mSignInDao = signInDao;
    }

    public void signIn(SignIn signIn) {
        mSignInDao.insert(signIn);
    }

    public SignIn findSignIn(long sessionId) {
        return mSignInDao.find(sessionId);
    }
}
