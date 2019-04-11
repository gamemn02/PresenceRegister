package dz.deepwork.gamemn02.presenceregister.data;

import dz.deepwork.gamemn02.presenceregister.Notified;
import dz.deepwork.gamemn02.presenceregister.data.signins.SignIn;

public interface SignsRepo {
    public void signIn(final SignIn signIn, Notified notified);
    public SignIn findSignIn(long sessionId);
    public void signOut(SignIn signIn);
}
