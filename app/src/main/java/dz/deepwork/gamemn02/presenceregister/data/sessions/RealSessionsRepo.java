package dz.deepwork.gamemn02.presenceregister.data.sessions;

import android.arch.lifecycle.LiveData;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import dz.deepwork.gamemn02.presenceregister.data.NetworkService;

public class RealSessionsRepo implements SessionsRepo{

    private SessionDao mSessionDao;
    private Executor mDbExecutor;
    private NetworkService mNetworkService;

    public RealSessionsRepo(SessionDao sessionDao, Executor dbExecutor, NetworkService networkService) {
        this.mSessionDao = sessionDao;
        this.mDbExecutor = dbExecutor;
        this.mNetworkService = networkService;
    }

    public LiveData<Session> findSession(String memberPassNumber, SessionTime sessionTime) {
        return mSessionDao.find(memberPassNumber, sessionTime);
    }

    public void addSessions(final Session... sessions) {
        mDbExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mSessionDao.insert(sessions);
            }
        });
    }

    @Override
    public void fetchSessions() {
        mNetworkService.fetchSessions().observeForever(members -> mDbExecutor.execute(() -> {
            mSessionDao.deleteAll();
            mSessionDao.insert((Session[]) members.toArray());
        }));
    }
}
