package dz.deepwork.gamemn02.presenceregister.sign;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;

import java.util.Calendar;

import javax.inject.Inject;

import dz.deepwork.gamemn02.presenceregister.data.RepoComponent;
import dz.deepwork.gamemn02.presenceregister.data.members.Member;
import dz.deepwork.gamemn02.presenceregister.data.members.MembersRepo;
import dz.deepwork.gamemn02.presenceregister.data.sessions.Session;
import dz.deepwork.gamemn02.presenceregister.data.sessions.SessionTime;
import dz.deepwork.gamemn02.presenceregister.data.sessions.SessionsRepo;
import dz.deepwork.gamemn02.presenceregister.utils.DateUtils;
import dz.deepwork.gamemn02.presenceregister.utils.StringFormats;

public class SignViewModel extends ViewModel {
    @Inject
    MembersRepo mMembersRepo;
    @Inject
    SessionsRepo mSessionRepo;
    @Inject
    Calendar mCurCalendar;
    // TODO: remove calendar injection and use DateUtils instead
    private LiveData<Member> mLoginMember;
    private LiveData<Session> mCurSession;
    private MutableLiveData<String> mCurDateLiveData;

    public SignViewModel() {
        RepoComponent.Singleton.getInstance().inject(this);
        mCurDateLiveData = new MutableLiveData<>();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Calendar calendar = DateUtils.getCurrentCalendar();
                String currentDate = StringFormats.calendarToString(calendar);
                mCurDateLiveData.postValue(currentDate);
                handler.postDelayed(this, 1000);
            }
        }, 1000);
    }

    public void init(String passNumber) {
        mLoginMember = mMembersRepo.findMember(passNumber);
        mCurSession = mSessionRepo.findSession(passNumber, SessionTime.fromCalendar(mCurCalendar));
    }

    public LiveData<String> getCurrentDate() {
        return mCurDateLiveData;
    }

    public LiveData<String> getMemberName() {
        return Transformations.map(mLoginMember, member -> member != null ? member.name : null);
    }

    public LiveData<String> getSessionRoom() {
        return Transformations.map(mCurSession, session -> session != null ? session.room : null);
    }

    public LiveData<String> getSessionInterval() {
        return Transformations.map(mCurSession,
                session -> session != null ? SessionTime.toIntervalString(session.time, session.size) : null);
    }

    public LiveData<String> getSessionDetails() {
        return Transformations.map(mCurSession, session -> session != null ? session.details : null);
    }
}
