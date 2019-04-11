package dz.deepwork.gamemn02.presenceregister.sign;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;

import java.util.Calendar;

import javax.inject.Inject;

import dz.deepwork.gamemn02.presenceregister.Notified;
import dz.deepwork.gamemn02.presenceregister.data.RepoComponent;
import dz.deepwork.gamemn02.presenceregister.data.SignsRepo;
import dz.deepwork.gamemn02.presenceregister.data.members.Member;
import dz.deepwork.gamemn02.presenceregister.data.members.MembersRepo;
import dz.deepwork.gamemn02.presenceregister.data.sessions.Session;
import dz.deepwork.gamemn02.presenceregister.data.sessions.SessionTime;
import dz.deepwork.gamemn02.presenceregister.data.sessions.SessionsRepo;
import dz.deepwork.gamemn02.presenceregister.data.signins.SignIn;
import dz.deepwork.gamemn02.presenceregister.utils.DateUtils;

public class SignViewModel extends ViewModel {
    @Inject
    MembersRepo mMembersRepo;
    @Inject
    SessionsRepo mSessionRepo;
    @Inject
    SignsRepo mSignsRepo;

    private LiveData<Member> mLoginMember;
    private LiveData<Session> mCurSession;
    private MutableLiveData<Calendar> mCurDateLiveData;
    private Notified mSignInNotified;


    public SignViewModel() {
        RepoComponent.Singleton.getInstance().inject(this);
        mCurDateLiveData = new MutableLiveData<>();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mCurDateLiveData.postValue(DateUtils.getCurrentCalendar());
                handler.postDelayed(this, 1000);
            }
        }, 1000);
    }

    public void init(String passNumber) {
        mLoginMember = mMembersRepo.findMember(passNumber);
        mCurSession = mSessionRepo.findSession(passNumber, SessionTime.fromCalendar(DateUtils.getCurrentCalendar()));
    }

    public LiveData<Calendar> getCurrentDate() {
        return mCurDateLiveData;
    }

    public LiveData<String> getMemberName() {
        return Transformations.map(mLoginMember, member -> member != null ? member.name : null);
    }

    public LiveData<String> getSessionRoom() {
        return Transformations.map(mCurSession, session -> session != null ? session.room : null);
    }

    public LiveData<SessionTime> getSessionTime() {
        return Transformations.map(mCurSession,
                session -> session != null ? session.time : null);
    }

    public LiveData<Integer> getSessionSize() {
        return Transformations.map(mCurSession,
                session -> session != null ? session.size : null);
    }

    public LiveData<String> getSessionDetails() {
        return Transformations.map(mCurSession, session -> session != null ? session.details : null);
    }

    public LiveData<Boolean> getIsSessionExist() {
        return Transformations.map(mCurSession, session -> session != null);
    }

    public void setSignInNotified(Notified notified) {
        mSignInNotified = notified;
    }

    public void onSignInClick() {
        long utcTime = DateUtils.getCurrentCalendar().getTimeInMillis();
        Session session = mCurSession.getValue();
        SignIn signIn = new SignIn(session.uId, utcTime, session.room);
        mSignsRepo.signIn(signIn, mSignInNotified);
    }
}
