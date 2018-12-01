package dz.deepwork.gamemn02.presenceregister.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import dz.deepwork.gamemn02.presenceregister.data.members.Member;

@Database(entities = {Member.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
}
