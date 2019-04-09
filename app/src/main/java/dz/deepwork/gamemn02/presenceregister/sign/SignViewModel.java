package dz.deepwork.gamemn02.presenceregister.sign;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
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

    public LiveData<Member> findMember(String passNumber) {
        return mMembersRepo.findMember(passNumber);
    }

    public LiveData<Session> findCurSession(String passNumber) {
        return mSessionRepo.findSession(passNumber, SessionTime.fromCalendar(mCurCalendar));
    }

    public LiveData<String> getCurrentDate() {
        return mCurDateLiveData;
    }
}
