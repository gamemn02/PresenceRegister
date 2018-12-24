package dz.deepwork.gamemn02.presenceregister.data;

import dz.deepwork.gamemn02.presenceregister.data.signins.SignIn;

public interface SignsRepo {
    public void signIn(final SignIn signIn);
    public SignIn findSignIn(long sessionId);
    public void signOut(SignIn signIn);
}
