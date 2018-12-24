package dz.deepwork.gamemn02.presenceregister.data;

import dz.deepwork.gamemn02.presenceregister.data.signins.SignIn;

public interface SignsRepo {
    // TODO: remove this line space in all repos
    public void signIn(final SignIn signIn);
    public SignIn findSignIn(long sessionId);
    public void signOut(SignIn signIn);
}
