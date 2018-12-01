package dz.deepwork.gamemn02.presenceregister.data.sessions;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface SessionDao {

    @Insert
    void insert(Session... sessions);

    @Query("SELECT * FROM session WHERE memberId = :memberId")
    Session findSession(int memberId);
}
