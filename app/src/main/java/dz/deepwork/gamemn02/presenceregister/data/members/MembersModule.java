package dz.deepwork.gamemn02.presenceregister.data.members;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dz.deepwork.gamemn02.presenceregister.data.AppDatabase;

@Module
public class MembersModule {

    public MembersModule() { }

    @Singleton
    @Provides
    public MemberDao provideMemberDao(AppDatabase appDatabase) {
        return appDatabase.getMemberDao();
    }

    @Singleton
    @Provides
    public MembersRepo provideMembersRepo(MemberDao memberDao) {
        return new RealMembersRepo(memberDao);
    }
}
