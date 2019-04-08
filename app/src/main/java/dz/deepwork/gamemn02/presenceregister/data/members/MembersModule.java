package dz.deepwork.gamemn02.presenceregister.data.members;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dz.deepwork.gamemn02.presenceregister.data.AppDatabase;
import dz.deepwork.gamemn02.presenceregister.data.NetworkService;

@Module
public class MembersModule {

    @Singleton
    @Provides
    public MemberDao provideMemberDao(AppDatabase appDatabase) {
        return appDatabase.getMemberDao();
    }

    @Singleton
    @Provides
    public MembersRepo provideMembersRepo(MemberDao memberDao, Executor dbExecutor, NetworkService networkService) {
        return new RealMembersRepo(memberDao, dbExecutor, networkService);
    }
}
