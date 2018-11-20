package dz.deepwork.gamemn02.presenceregister.data.members;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MembersRepoModule {

    private MembersRepo mMembersRepo;

    public MembersRepoModule(MembersRepo membersRepo) {
        mMembersRepo = membersRepo;
    }

    @Singleton
    @Provides
    MembersRepo provideMembersRepo() {
        return mMembersRepo;
    }
}
