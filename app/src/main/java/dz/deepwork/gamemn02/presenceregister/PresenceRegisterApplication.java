package dz.deepwork.gamemn02.presenceregister;

import android.app.Application;
import android.content.Context;

import dz.deepwork.gamemn02.presenceregister.data.members.DaggerMembersRepoComponent;
import dz.deepwork.gamemn02.presenceregister.data.members.MembersRepo;
import dz.deepwork.gamemn02.presenceregister.data.members.MembersRepoComponent;
import dz.deepwork.gamemn02.presenceregister.data.members.MembersRepoModule;

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