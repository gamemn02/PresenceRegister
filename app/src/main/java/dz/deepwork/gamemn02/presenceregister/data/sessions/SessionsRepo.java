package dz.deepwork.gamemn02.presenceregister.data.sessions;

import android.arch.lifecycle.LiveData;

public interface SessionsRepo {
    public LiveData<Session> findSession(String memberPassNumber, SessionTime sessionTime);
    public void addSessions(final Session... sessions);
}
