package dz.deepwork.gamemn02.presenceregister.data.sessions;

public class RealSessionsRepo {

    private SessionDao mSessionDao;

    public RealSessionsRepo(SessionDao sessionDao) {
        this.mSessionDao = sessionDao;
    }

    public Session findSession(long memberId) {
        return mSessionDao.find(memberId);
    }

    public void addSession(Session... sessions) {
        mSessionDao.insert(sessions);
    }
}
