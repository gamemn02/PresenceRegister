package dz.deepwork.gamemn02.presenceregister;

import android.app.Application;
import android.content.Context;

import dagger.Component;
import dz.deepwork.gamemn02.presenceregister.data.DaggerMembersRepoComponent;
import dz.deepwork.gamemn02.presenceregister.data.MembersRepo;
import dz.deepwork.gamemn02.presenceregister.data.MembersRepoComponent;
import dz.deepwork.gamemn02.presenceregister.data.MembersRepoModule;

public class PresenceRegisterApplication extends Application {

    private MembersRepoComponent mMembersRepoComponent;

    public static PresenceRegisterApplication get(Context context) {
        return (PresenceRegisterApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public void setMemberRepo(MembersRepo memberRepo) {
        mMembersRepoComponent = DaggerMembersRepoComponent
                .builder()
                .membersRepoModule(new MembersRepoModule(memberRepo))
                .build();
    }

    public MembersRepoComponent getMemberRepo() {
        return mMembersRepoComponent;
    }
}
