package dz.deepwork.gamemn02.presenceregister.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import dz.deepwork.gamemn02.presenceregister.data.members.Member;
import dz.deepwork.gamemn02.presenceregister.data.members.MemberDao;
import dz.deepwork.gamemn02.presenceregister.data.sessions.Session;
import dz.deepwork.gamemn02.presenceregister.data.sessions.SessionDao;
import dz.deepwork.gamemn02.presenceregister.data.sessions.SessionTime;
import dz.deepwork.gamemn02.presenceregister.data.signins.SignIn;
import dz.deepwork.gamemn02.presenceregister.data.signins.SignInDao;
import dz.deepwork.gamemn02.presenceregister.data.signs.Sign;
import dz.deepwork.gamemn02.presenceregister.data.signs.SignDao;

@Database(entities = {Member.class, Session.class, SignIn.class, Sign.class}, version = 1)
@TypeConverters({SessionTime.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract MemberDao getMemberDao();
    public abstract SessionDao getSessionDao();
    public abstract SignInDao getSignInDao();
    public abstract SignDao getSignDao();
}
