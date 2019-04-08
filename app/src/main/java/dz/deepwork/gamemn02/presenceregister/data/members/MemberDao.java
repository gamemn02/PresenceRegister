package dz.deepwork.gamemn02.presenceregister.data.members;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import dz.deepwork.gamemn02.presenceregister.data.sessions.Session;

@Dao
public interface MemberDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insert(Member... members);

    @Query("SELECT * FROM members WHERE pass_number = :passNumber")
    LiveData<Member> find(String passNumber);

    @Query("DELETE FROM members")
    void deleteAll();
}
