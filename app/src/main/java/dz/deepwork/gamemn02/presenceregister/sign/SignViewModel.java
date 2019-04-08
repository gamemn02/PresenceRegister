package dz.deepwork.gamemn02.presenceregister.sign;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.Calendar;

import javax.inject.Inject;

import dz.deepwork.gamemn02.presenceregister.data.RepoComponent;
import dz.deepwork.gamemn02.presenceregister.data.members.Member;
import dz.deepwork.gamemn02.presenceregister.data.members.MembersRepo;
import dz.deepwork.gamemn02.presenceregister.data.sessions.Session;
import dz.deepwork.gamemn02.presenceregister.data.sessions.SessionTime;
import dz.deepwork.gamemn02.presenceregister.data.sessions.SessionsRepo;

public class SignViewModel extends ViewModel {
    @Inject
    MembersRepo mMembersRepo;
    @Inject
    SessionsRepo mSessionRepo;
    @Inject
    Calendar mCurCalendar;

    public SignViewModel() {
        RepoComponent.Singleton.getInstance().inject(this);
    }

    public LiveData<Member> findMember(String passNumber) {
        return mMembersRepo.findMember(passNumber);
    }

    public LiveData<Session> findCurSession(Member member) {
        return mSessionRepo.findSession(member.uId, SessionTime.fromCalendar(mCurCalendar));
    }
}
