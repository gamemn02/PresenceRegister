package dz.deepwork.gamemn02.presenceregister.data.members;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MembersRepoModule {

    public MembersRepoModule() { }

    @Singleton
    @Provides
    public MemberDao provideMemberDao() {
        return new MemberDao() {
        };
    }

    @Singleton
    @Provides
    public MembersRepo provideMembersRepo() {
        return new MembersDbRepo();
    }
}
