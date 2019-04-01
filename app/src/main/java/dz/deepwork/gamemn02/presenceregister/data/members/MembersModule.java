package dz.deepwork.gamemn02.presenceregister.data.members;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dz.deepwork.gamemn02.presenceregister.data.AppDatabase;

@Module
public class MembersModule {

    @Singleton
    @Provides
    public MemberDao provideMemberDao(AppDatabase appDatabase) {
        return appDatabase.getMemberDao();
    }

    @Singleton
    @Provides
    public MemberNetworkService provideMemberNetworkService(Executor networkExecutor) {
        return new MemberNetworkService(networkExecutor);
    }

    @Singleton
    @Provides
    public MembersRepo provideMembersRepo(MemberDao memberDao, Executor dbExecutor, MemberNetworkService memberNetworkService) {
        return new RealMembersRepo(memberDao, dbExecutor, memberNetworkService);
    }
}
