package dz.deepwork.gamemn02.presenceregister.data.sessions;

public interface SessionsRepo {
    public Session findSession(long memberId);
    public void addSessions(final Session... sessions);
}
