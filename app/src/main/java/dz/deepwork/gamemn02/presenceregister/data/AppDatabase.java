package dz.deepwork.gamemn02.presenceregister.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import dz.deepwork.gamemn02.presenceregister.data.members.Member;
import dz.deepwork.gamemn02.presenceregister.data.members.MemberDao;
import dz.deepwork.gamemn02.presenceregister.data.sessions.Session;
import dz.deepwork.gamemn02.presenceregister.data.sessions.SessionDao;

@Database(entities = {Member.class, Session.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MemberDao getMemberDao();
    public abstract SessionDao getSessionDao();
}