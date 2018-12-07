package dz.deepwork.gamemn02.presenceregister.data.sessions;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface SessionDao {

    @Insert
    long[] insert(Session... sessions);

    @Query("SELECT * FROM sessions WHERE member_Id = :memberId")
    Session find(long memberId);

    @Query("SELECT * FROM sessions WHERE uId = :sessionId")
    Session get(long sessionId);
}
