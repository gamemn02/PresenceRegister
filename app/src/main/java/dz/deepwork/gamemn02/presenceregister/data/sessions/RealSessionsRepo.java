package dz.deepwork.gamemn02.presenceregister.data.sessions;

import android.arch.lifecycle.LiveData;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RealSessionsRepo implements SessionsRepo{

    private SessionDao mSessionDao;
    private Executor mDbExecutor;

    public RealSessionsRepo(SessionDao sessionDao, Executor dbExecutor) {
        this.mSessionDao = sessionDao;
        this.mDbExecutor = dbExecutor;
    }

    public LiveData<Session> findSession(long memberId, SessionTime sessionTime) {
        return mSessionDao.find(memberId, sessionTime);
    }

    public void addSessions(final Session... sessions) {
        mDbExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mSessionDao.insert(sessions);
            }
        });
    }
}
