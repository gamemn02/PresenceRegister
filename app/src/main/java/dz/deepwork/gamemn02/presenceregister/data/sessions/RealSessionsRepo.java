package dz.deepwork.gamemn02.presenceregister.data.sessions;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RealSessionsRepo implements SessionsRepo{

    private SessionDao mSessionDao;

    public RealSessionsRepo(SessionDao sessionDao) {
        this.mSessionDao = sessionDao;
    }

    public Session findSession(long memberId) {
        return mSessionDao.find(memberId);
    }

    public void addSessions(final Session... sessions) {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mSessionDao.insert(sessions);
            }
        });
    }
}
