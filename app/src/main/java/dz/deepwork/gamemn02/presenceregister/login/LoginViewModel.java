package dz.deepwork.gamemn02.presenceregister.login;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import dz.deepwork.gamemn02.presenceregister.data.RepoComponent;
import dz.deepwork.gamemn02.presenceregister.data.members.Member;
import dz.deepwork.gamemn02.presenceregister.data.members.MembersRepo;

public class LoginViewModel extends ViewModel {

    @Inject
    MembersRepo mMembersRepo;

    public LoginViewModel() {
        RepoComponent.Singleton.getInstance().inject(this);
    }

    public LiveData<Member> checkPassNumber(String passNumber) {
        return mMembersRepo.findMember(passNumber);
    }
}
