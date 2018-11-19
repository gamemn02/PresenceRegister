package dz.deepwork.gamemn02.presenceregister.data;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dz.deepwork.gamemn02.presenceregister.data.MembersRepo;

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
