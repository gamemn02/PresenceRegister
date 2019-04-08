package dz.deepwork.gamemn02.presenceregister.data.sessions;

import android.arch.lifecycle.LiveData;

public interface SessionsRepo {
    LiveData<Session> findSession(String memberPassNumber, SessionTime sessionTime);

    void addSessions(final Session... sessions);

    void fetchSessions();
}
