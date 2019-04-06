package dz.deepwork.gamemn02.presenceregister.sign;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import dz.deepwork.gamemn02.presenceregister.data.RepoComponent;
import dz.deepwork.gamemn02.presenceregister.data.SignsRepo;
import dz.deepwork.gamemn02.presenceregister.data.members.Member;
import dz.deepwork.gamemn02.presenceregister.data.members.MembersRepo;
import dz.deepwork.gamemn02.presenceregister.data.sessions.Session;

public class SignViewModel extends ViewModel {
    LiveData<Member> mLoginMember;
    LiveData<Session> mMemberSession;

    @Inject
    MembersRepo mMembersRepo;
    @Inject
    SignsRepo mSignsRepo;

    public SignViewModel() {
        RepoComponent.Singleton.getInstance().inject(this);
    }

}
